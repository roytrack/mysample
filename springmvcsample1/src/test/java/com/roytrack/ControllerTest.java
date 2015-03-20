package com.roytrack;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.FlashMapManager;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URI;

/**
 * Created by roytrack on 2015/3/9.
 */
public class ControllerTest {

    @Test
    public void UrlTest() throws IOException {
        CloseableHttpClient client= HttpClients.createSystem();
        HttpGet get=new HttpGet("http://localhost:8080/learn/usr/ss/matrix/djdj;ss=222;p=dsd");
        try(CloseableHttpResponse response=client.execute(get)){
            HttpEntity entity =response.getEntity();
            if(entity!=null){
                System.out.println(EntityUtils.toString(entity));
            }
        }catch (Exception e){
            System.out.println("error occur :"+e.getMessage());
        }

    }

    @Test
    public void SpecifyParam(){
        CloseableHttpClient client= HttpClients.createSystem();
        HttpGet get=new HttpGet("http://localhost:8080/learn/usr/ss/param/rcm/china?rcm=rcm");
        try(CloseableHttpResponse response=client.execute(get)){
            HttpEntity entity =response.getEntity();
            if(entity!=null){
                System.out.println(EntityUtils.toString(entity));
            }
        }catch (Exception e){
            System.out.println("error occur :"+e.getMessage());
        }
        get=new HttpGet("http://localhost:8080/learn/usr/ss/param/roy/china");
        try(CloseableHttpResponse response=client.execute(get)){
            HttpEntity entity =response.getEntity();
            if(entity!=null){
                System.out.println(EntityUtils.toString(entity));
            }
        }catch (Exception e){
            System.out.println("error occur :"+e.getMessage());
        }
    }

    @Test
    public void headerTest() {
        CloseableHttpClient client = HttpClients.createSystem();
        HttpGet get = new HttpGet("http://localhost:8080/learn/usr/ss/requestEntity");
        get.setHeader("myHeaders", "the header");
        try (CloseableHttpResponse response = client.execute(get)) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                System.out.println(EntityUtils.toString(entity));
            }
        } catch (Exception e) {
            System.out.println("error occur :" + e.getMessage());
        }
    }


    @Test
    public void buildURI(){
        UriComponents uriComponents=
                UriComponentsBuilder.fromUriString("http://roytrack.com/tag/{tag}/theme/{theme}").build();
        URI uri=uriComponents.expand("html5","star").encode().toUri();
        System.out.println(uri.toString());
        uriComponents=UriComponentsBuilder.newInstance().scheme("https").host("blog.roytrack.com")
                .path("/apple/第一条").build().encode();
        System.out.println(uriComponents.toUri().toString());
    }



}
