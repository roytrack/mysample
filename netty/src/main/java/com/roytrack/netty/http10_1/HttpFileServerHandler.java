package com.roytrack.netty.http10_1;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import javax.activation.MimetypesFileTypeMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by roytrack on 2017-03-21.
 */
public class HttpFileServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

    public static final String HTTP_DATE_FORMAT = "EEE, dd MMM yyyy HH:mm:ss zzz";
    public static final String HTTP_DATE_GMT_TIMEZONE = "GMT+8";
    public static final int HTTP_CACHE_SECONDS = 60;
    private final String url;

    public HttpFileServerHandler(String url){
        this.url=url;
    }






    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause){
        cause.printStackTrace();
        if(ctx.channel().isActive()){
            sendError(ctx,HttpResponseStatus.INTERNAL_SERVER_ERROR);
        }
    }



    private static final Pattern INSECURE_URI=Pattern.compile(".*[<>&\"].*");

    private String sanitizeUri(String uri) {
        try{
            uri= URLDecoder.decode(uri,"UTF-8");
        }catch (UnsupportedEncodingException e){
            try {
                uri=URLDecoder.decode(uri,"ISO-8859-1");
            } catch (UnsupportedEncodingException e1) {
             throw new Error();
            }
        }

        if(!uri.startsWith(url)){
            return null;
        }
        if(!uri.startsWith("/")){
            return null;
        }
        uri=uri.replace('/',File.separatorChar);
        if(uri.contains(File.separator+'.')
                ||uri.contains('.'+File.separator)
                ||uri.startsWith(".")
                ||uri.endsWith(".")
                ||INSECURE_URI.matcher(uri).matches()){
            return null;
        }

        return System.getProperty("user.dir")+"\\netty\\src\\main\\java"+File.separator+uri;
    }

    private static final Pattern ALLOWED_FILE_NAME=Pattern.compile("[A-Za-z0-9][-_A-Za-z0-9\\.]*");

    private static void sendListing(ChannelHandlerContext ctx,File dir){
        FullHttpResponse response=new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,HttpResponseStatus.OK);
        response.headers().set(HttpHeaderNames.CONTENT_TYPE,"text/html;charset=UTF-8");
        StringBuffer buf=new StringBuffer();
        String dirPath=dir.getPath();
        buf.append("<!DOCTYPE html>\r\n");
        buf.append("<html><head><title>");
        buf.append(dirPath);
        buf.append("目录");
        buf.append("</title></head><body>\r\n");
        buf.append("<h3>");
        buf.append(dirPath).append("目录");
        buf.append("</h3>\r\n");
        buf.append("<ul>");
        buf.append("<li>链接:<a href=\"../\">..</a></li>\r\n");
        for(File f:dir.listFiles()){
            if(f.isHidden()||!f.canRead()){
                continue;
            }
            String name=f.getName();
            if(!ALLOWED_FILE_NAME.matcher(name).matches()){
                continue;
            }
            buf.append("<li>链接<a href=\"");
            buf.append(name);
            buf.append("\">");
            buf.append(name);
            buf.append("</a></li>\r\n");
        }
        buf.append("</ul></body></html>\r\n");
        ByteBuf buffer= Unpooled.copiedBuffer(buf, CharsetUtil.UTF_8);
        response.content().writeBytes(buffer);
        buffer.release();
        ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
    }

    private static void sendRedirect(ChannelHandlerContext ctx,String newUri){

        FullHttpResponse response=new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,HttpResponseStatus.FOUND);
        response.headers().set(HttpHeaderNames.LOCATION,newUri);
        ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
    }

    private void sendError(ChannelHandlerContext ctx, HttpResponseStatus badRequest) {
        FullHttpResponse response=new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,badRequest,Unpooled.copiedBuffer("Failure" + badRequest.toString() + "\r\n", CharsetUtil.UTF_8));
        response.headers().set(HttpHeaderNames.CONTENT_TYPE,"text/plain; charset=UTF-8");
        ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
    }

    private static void setContentTypeHeader(HttpResponse response,File file){
        MimetypesFileTypeMap mimetypesFileTypeMap=new MimetypesFileTypeMap();
        response.headers().set(HttpHeaderNames.CONTENT_TYPE, mimetypesFileTypeMap.getContentType(file.getPath()));
    }

    /**
     * Sets the Date and Cache headers for the HTTP Response
     *
     * @param response
     *            HTTP response
     * @param fileToCache
     *            file to extract content type
     */
    private static void setDateAndCacheHeaders(HttpResponse response, File fileToCache) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat(HTTP_DATE_FORMAT, Locale.US);
        dateFormatter.setTimeZone(TimeZone.getTimeZone(HTTP_DATE_GMT_TIMEZONE));

        // Date header
        Calendar time = new GregorianCalendar();
        response.headers().set(HttpHeaderNames.DATE, dateFormatter.format(time.getTime()));

        // Add cache headers
        time.add(Calendar.SECOND, HTTP_CACHE_SECONDS);
        response.headers().set(HttpHeaderNames.EXPIRES, dateFormatter.format(time.getTime()));
        response.headers().set(HttpHeaderNames.CACHE_CONTROL, "private, max-age=" + HTTP_CACHE_SECONDS);
        response.headers().set(
                HttpHeaderNames.LAST_MODIFIED, dateFormatter.format(new Date(fileToCache.lastModified())));
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest msg) throws Exception {
        if(!msg.decoderResult().isSuccess()){
            sendError(ctx, HttpResponseStatus.BAD_REQUEST);
            return;
        }
        if(!msg.method().equals(HttpMethod.GET) ){
            sendError(ctx,HttpResponseStatus.METHOD_NOT_ALLOWED);
        }

        final String uri=msg.uri();
        final String path=sanitizeUri(uri);

        if(path==null){
            sendError(ctx,HttpResponseStatus.FORBIDDEN);
            return;
        }
        File file=new File(path);
        if(file.isHidden()||!file.exists()){
            sendError(ctx,HttpResponseStatus.NOT_FOUND);
            return;
        }
        if(file.isDirectory()){
            if(uri.endsWith("/")){
                sendListing(ctx,file);
            }else{
                sendRedirect(ctx,uri+'/');
            }
            return;
        }
        if(!file.isFile()){
            sendError(ctx,HttpResponseStatus.FORBIDDEN);
            return;
        }
        RandomAccessFile randomAccessFile=null;
        try {
            randomAccessFile=new RandomAccessFile(file,"r");
            long fileLength=randomAccessFile.length();
            HttpResponse response=new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,HttpResponseStatus.OK);
            HttpUtil.setContentLength(response, fileLength);
            setContentTypeHeader(response, file);
            setDateAndCacheHeaders(response,file);
            if(HttpUtil.isKeepAlive(msg)){
                response.headers().set(HttpHeaderNames.CONNECTION,HttpHeaderValues.KEEP_ALIVE);
            }
            ctx.write(response);

            ChannelFuture sendFileFuture;
            ChannelFuture lastContentFuture;
            sendFileFuture=ctx.write(new DefaultFileRegion(randomAccessFile.getChannel(),0,fileLength),ctx.newProgressivePromise());
//            sendFileFuture=ctx.write(new HttpChunkedInput(new ChunkedFile(randomAccessFile,0,fileLength,8192)),ctx.newProgressivePromise());
            sendFileFuture.addListener(new ChannelProgressiveFutureListener() {
                @Override
                public void operationProgressed(ChannelProgressiveFuture future, long progress, long total) throws Exception {
                    if(total<0){
                        System.err.println("Transfer progress :"+progress);
                    }else{
                        System.err.println("Transfer progress :"+progress+"/"+total);

                    }
                }

                @Override
                public void operationComplete(ChannelProgressiveFuture future) throws Exception {
                    System.out.println("Transfer complete");
                }
            });
            lastContentFuture=ctx.writeAndFlush(LastHttpContent.EMPTY_LAST_CONTENT);
            //lastContentFuture=sendFileFuture;
            if(!HttpUtil.isKeepAlive(msg)){
                lastContentFuture.addListener(ChannelFutureListener.CLOSE);
            }
            sendFileFuture.sync();
            lastContentFuture.sync();

        }catch (FileNotFoundException e){
            sendError(ctx,HttpResponseStatus.NOT_FOUND);
            return;
        }
    }
}
