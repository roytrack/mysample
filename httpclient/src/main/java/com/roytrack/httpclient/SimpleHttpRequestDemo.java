package com.roytrack.httpclient;

import org.apache.http.*;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.message.BasicHttpRequest;
import org.apache.http.message.BasicHttpResponse;

/**
 * Created by ruanchangming on 2015/12/12.
 */
public class SimpleHttpRequestDemo {

    public static void main(String[] args) {
//    requestDemo();
        //responseDemo();
//        responseDemo2();
//        responseDemo3();
        responseDemo4();
    }

    static void requestDemo(){
        HttpRequest request=new BasicHttpRequest("GET","/", HttpVersion.HTTP_1_1);
        System.out.println(request.getRequestLine().getMethod());
        System.out.println(request.getRequestLine().getUri());
        System.out.println(request.getRequestLine().getProtocolVersion());
        System.out.println(request.getRequestLine().toString());
    }
    static void responseDemo(){
        HttpResponse response=new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK,"OK");
        System.out.println(response.getProtocolVersion());
        System.out.println(response.getStatusLine().getStatusCode());
        System.out.println(response.getStatusLine().getReasonPhrase());
        System.out.println(response.getStatusLine().toString());
    }
    static void responseDemo2(){
        HttpResponse response=new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK,"OK");
        response.addHeader("Set-Cookie","c1=a;path=/;domain=localhost");
        response.addHeader("Set-Cookie", "c2=b;path=\"/\",c3=c;domain=\"localhost\"");
        Header h1=response.getFirstHeader("Set-Cookie");
        System.out.println(h1);
        Header h2=response.getLastHeader("Set-Cookie");
        System.out.println(h2);
        Header[] hs=response.getHeaders("Set-Cookie");
        System.out.println(hs.length);
    }
    static void responseDemo3(){
        HttpResponse response=new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK,"OK");
        response.addHeader("Set-Cookie","c1=a;path=/;domain=localhost");
        response.addHeader("Set-Cookie", "c2=b;path=\"/\",c3=c;domain=\"localhost\"");
        HeaderIterator it=response.headerIterator("Set-Cookie");
        while (it.hasNext()){
            System.out.println(it.next());
            System.out.println("----------");
            System.out.println(it.nextHeader());
        }
    }
    static void responseDemo4() {
        HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK, "OK");
        response.addHeader("Set-Cookie", "c1=a;path=/;domain=localhost");
        response.addHeader("Set-Cookie", "c2=b;path=\"/\",c3=c;domain=\"localhost\"");
        HeaderElementIterator it=new BasicHeaderElementIterator(response.headerIterator());
        while (it.hasNext()){
            HeaderElement elem=it.nextElement();
            System.out.println(elem.getName()+"="+elem.getValue());
            NameValuePair [] params=elem.getParameters();
            for(int i=0;i<params.length;i++){
                System.out.println("  "+params[i]);
            }
        }
    }

}
