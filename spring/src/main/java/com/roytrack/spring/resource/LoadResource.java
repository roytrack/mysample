package com.roytrack.spring.resource;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;


import java.io.IOException;

/**
 * Created by roytrack on 2015/4/28.
 */
public class LoadResource {

    @Test
    public  void load(){
        ResourcePatternResolver resolver=new PathMatchingResourcePatternResolver();
        String scriptContent;
        String filepath="classpath:org/springframework/web/servlet/config/spring-mvc-3.1.xsd";
        try {
            Resource resource=resolver.getResource(filepath);
            System.out.println(resource.contentLength()+"####"+resource.getFilename()+"###"+resource.getURL());
            //核心代码 就是resource不能从jar包获得文件 但是可以获得里面的内容
            scriptContent = IOUtils.toString(resource.getInputStream());
            System.out.println(scriptContent);
        } catch (IOException e) {
            throw new IllegalArgumentException(filepath + " is not exist.", e);
        }

    }


}
