package com.roytrack.httpclient;

import org.apache.http.*;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.RequestExpectContinue;
import org.apache.http.entity.*;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.nio.reactor.BaseIOReactor;
import org.apache.http.impl.nio.reactor.IOReactorConfig;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.message.BasicHttpRequest;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.nio.reactor.IOReactor;
import org.apache.http.protocol.*;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLHandshakeException;
import java.io.*;
import java.util.Date;
import java.util.Map;

/**
 * Created by roytrack on 2015/12/12.
 */
public class SimpleHttpRequestDemo {

  public static void main(String[] args) {
//    requestDemo();
    //responseDemo();
//        responseDemo2();
//        responseDemo3();
//        responseDemo4();
    try {
//            httpEntity();
//            httpProcessor();
//            httpProducer();
      httpHost();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  static void requestDemo() {
    HttpRequest request = new BasicHttpRequest("GET", "/", HttpVersion.HTTP_1_1);
    System.out.println(request.getRequestLine().getMethod());
    System.out.println(request.getRequestLine().getUri());
    System.out.println(request.getRequestLine().getProtocolVersion());
    System.out.println(request.getRequestLine().toString());
  }

  static void responseDemo() {
    HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK, "OK");
    System.out.println(response.getProtocolVersion());
    System.out.println(response.getStatusLine().getStatusCode());
    System.out.println(response.getStatusLine().getReasonPhrase());
    System.out.println(response.getStatusLine().toString());
  }

  static void responseDemo2() {
    HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK, "OK");
    response.addHeader("Set-Cookie", "c1=a;path=/;domain=localhost");
    response.addHeader("Set-Cookie", "c2=b;path=\"/\",c3=c;domain=\"localhost\"");
    Header h1 = response.getFirstHeader("Set-Cookie");
    System.out.println(h1);
    Header h2 = response.getLastHeader("Set-Cookie");
    System.out.println(h2);
    Header[] hs = response.getHeaders("Set-Cookie");
    System.out.println(hs.length);
  }

  static void responseDemo3() {
    HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK, "OK");
    response.addHeader("Set-Cookie", "c1=a;path=/;domain=localhost");
    response.addHeader("Set-Cookie", "c2=b;path=\"/\",c3=c;domain=\"localhost\"");
    HeaderIterator it = response.headerIterator("Set-Cookie");
    while (it.hasNext()) {
      System.out.println(it.next());
      System.out.println("----------");
      System.out.println(it.nextHeader());
    }
  }

  static void responseDemo4() {
    HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK, "OK");
    response.addHeader("Set-Cookie", "c1=a;path=/;domain=localhost");
    response.addHeader("Set-Cookie", "c2=b;path=\"/\",c3=c;domain=\"localhost\"");
    HeaderElementIterator it = new BasicHeaderElementIterator(response.headerIterator());
    while (it.hasNext()) {
      HeaderElement elem = it.nextElement();
      System.out.println(elem.getName() + "=" + elem.getValue());
      NameValuePair[] params = elem.getParameters();
      for (int i = 0; i < params.length; i++) {
        System.out.println("  " + params[i]);
      }
    }
  }

  static void httpEntity() throws IOException {
    StringEntity myEntity = new StringEntity("important message", Consts.UTF_8);
    System.out.println(myEntity.getContentType());
    System.out.println(myEntity.getContentLength());
    System.out.println(EntityUtils.toString(myEntity));
    System.out.println(EntityUtils.toByteArray(myEntity).length);
  }

  static void basicEntity() throws FileNotFoundException {
    BasicHttpEntity myEntity = new BasicHttpEntity();
//        myEntity.setContent(new BufferedInputStream());
    myEntity.setContentLength(222l);

    ByteArrayEntity byteArrayEntity = new ByteArrayEntity(new byte[]{1, 2, 3}, ContentType.APPLICATION_ATOM_XML);

    StringBuilder stringBuilder = new StringBuilder();
    Map<String, String> env = System.getenv();
    for (Map.Entry<String, String> entry : env.entrySet()) {
      stringBuilder.append(entry.getKey())
              .append(": ").append(entry.getValue())
              .append("\r\n");
      try {
        HttpEntity entity1 = new StringEntity(stringBuilder.toString());
      } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
      }
      HttpEntity entity2 = new StringEntity(stringBuilder.toString(), Consts.UTF_8);

      HttpEntity entity3 = new StringEntity(stringBuilder.toString(), ContentType.create("text/plain", Consts.UTF_8));

      InputStream stream = new FileInputStream("ss");
      InputStreamEntity entity4 = new InputStreamEntity(stream);

      HttpEntity entity5 = new FileEntity(new File("ss"), ContentType.create("application/java-archive"));


    }
  }

  static void httpProcessor() throws IOException, HttpException {
    HttpProcessor httpProcessor = HttpProcessorBuilder.create().add(new RequestContent())
            .add(new RequestTargetHost())
            .add(new RequestConnControl())
            .add(new RequestUserAgent("MyAgent-HTTP/1.1"))
            .add(new RequestExpectContinue()).build();

    HttpCoreContext context = HttpCoreContext.create();
    HttpRequest request = new BasicHttpRequest("GET", "http://baidu.com");
    httpProcessor.process(request, context);


  }

  static void httpContextShare() throws IOException, HttpException {
    HttpProcessor httpProc = HttpProcessorBuilder.create().add(new HttpRequestInterceptor() {
      @Override
      public void process(HttpRequest request, HttpContext context) throws HttpException, IOException {
        String id = (String) context.getAttribute("session-id");
        if (id != null) {
          request.addHeader("Session-ID", id);
        }
      }
    }).build();
    HttpCoreContext context = HttpCoreContext.create();
    HttpRequest request = new BasicHttpRequest("GET", "*/*");
    httpProc.process(request, context);
    IOReactor reactor = new BaseIOReactor(50000l);
    IOReactorConfig config = IOReactorConfig.DEFAULT;
  }

  static void httpProducer() throws IOException {
    ContentProducer myContentProducer = new ContentProducer() {
      @Override
      public void writeTo(OutputStream outstream) throws IOException {
        outstream.write("ContentProducer rocks !".getBytes());
        outstream.write(("Time requested :" + new Date()).getBytes());
      }
    };
    HttpEntity entity = new EntityTemplate(myContentProducer);
    entity.writeTo(System.out);
  }

  static void httpHost() throws IOException {
    HttpClientBuilder builder = HttpClientBuilder.create();
    CloseableHttpClient httpClient = builder.build();
    HttpContext localContext = new BasicHttpContext();
    HttpGet httpGet = new HttpGet("http://www.baidu.com");
    HttpResponse response = httpClient.execute(httpGet, localContext);
    //ExecutionContext.HTTP_TARGET_HOST
    HttpHost target = (HttpHost) localContext.getAttribute(HttpCoreContext.HTTP_TARGET_HOST);
    System.out.println("Final target :" + target);
    HttpEntity entity = response.getEntity();
    if (entity != null) {
      EntityUtils.consume(entity);
    }
  }

  static void RetryHandler() {
    HttpRequestRetryHandler myRetryHandler = new HttpRequestRetryHandler() {
      @Override
      public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
        if (executionCount > 5) {
          return false;
        }
        if (exception instanceof NoHttpResponseException) {
          return true;
        }
        if (exception instanceof SSLHandshakeException) {
          return false;
        }
        HttpRequest request = (HttpRequest) context.getAttribute(HttpCoreContext.HTTP_REQUEST);
        boolean idempotent = !(request instanceof HttpEntityEnclosingRequest);
        if (idempotent) {
          return true;
        }


        return false;
      }
    };
    CloseableHttpClient httpClient = HttpClients.custom().setRetryHandler(myRetryHandler).build();
  }
}


