package com.roytrack.springmvc.controller;


import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.support.UriComponentsContributor;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.FlashMapManager;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.DefaultRequestToViewNameTranslator;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.Map;

/**
 * Created by roytrack on 2015/3/3.
 */
@Controller
@RequestMapping(value="/usr/{roy}")
public class AnnotationController {

    @RequestMapping(value="/path/{cc}/{bc}")
    @ResponseBody
    public String PathVariableTest(@PathVariable String roy, @PathVariable("cc") String aaa,@PathVariable String bc){
        return new StringBuilder().append(roy).append("@").append(aaa).append("@").append(bc).toString();
    }

//定义Map类型的时候 看来需要自己去定义了
//    @RequestMapping(value="/path2/{cc}/{bc}")
//    @ResponseBody
//    public String PathVariableTest(@PathVariable Map<String ,String> pathVariables){
//        System.out.println(pathVariables.size());
//        return new StringBuilder().append(pathVariables.get("cc")).append("@").append(pathVariables.get("bc")).toString();
//    }
    @RequestMapping(value = "/ant/*/{var}")
    @ResponseBody
    public String PathVariableAntPath(@PathVariable String var){
        return var;
    }
    @RequestMapping(value="/re/{symbol:[a-z-]+}-{version:\\d\\.\\d\\.\\d}{extension:\\.[a-z]+}")
    @ResponseBody
    //:[a-z-]+]}-{version:\d\.\d\.\d}{extension:\.[a-z]+]
    public String PathVariableRegularExpression(
            @PathVariable String symbol
            , @PathVariable String version,@PathVariable String extension
    ){
        return new StringBuilder().append(symbol).append("@")
                .append(version).append("@").append(extension)
                .toString();
    }

    //  http://localhost:8080/learn/usr/ss/matrix/djdj;ss=222;p=dsd
    // 注意要把mvc:annotation-driven的属性为enable-matrix-variables="true"
    // RequestMappingHandlerMapping的 removeSemicolonContent属性为false
    @RequestMapping("/matrix/{sss}")
    @ResponseBody
    public String matrixVariable(@PathVariable String sss
            ,@MatrixVariable Map<String,String> matrixMap
    ){
        System.out.println(matrixMap.size()+"@"+matrixMap.keySet());

        return new StringBuilder().append(sss).append("@")
                .append(matrixMap.keySet())
                .toString();
    }

    @RequestMapping(value = "/param/{name}/{address}",params = "rcm=rcm")
    @ResponseBody
    public String requireParam(@PathVariable String name,@PathVariable String address){
        String returnStr=name+"@"+address;
        System.out.println(returnStr);
        return returnStr;
    }

    @RequestMapping("/requestEntity")
    public ResponseEntity<String>   handle(HttpEntity<byte[]> requestEntity){
        String requestHeader=requestEntity.getHeaders().getFirst("myHeaders");
        byte[] requestBody=requestEntity.getBody();
        System.out.println("the myHeaders is "+requestHeader);
        HttpHeaders responseHeaders=new HttpHeaders();
        responseHeaders.set("myResponseHeader","roytrack");
        return new ResponseEntity<String>("hello world",responseHeaders, HttpStatus.CREATED);

    }


    public void seeFlashMap(HttpServletRequest request){
        FlashMap map=new FlashMap();
        FlashMapManager manager= RequestContextUtils.getFlashMapManager(request);
        DefaultRequestToViewNameTranslator t=new DefaultRequestToViewNameTranslator();
    }





}
