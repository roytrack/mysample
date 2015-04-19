package com.roytrack;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.test.context.TestExecutionListeners;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by roytrack on 2015/4/20.
 */
public class ASimpleTest {

    @Test
    public  void seeProp() throws IOException {
        System.out.println( "Hello World!" );
        Resource resource = new ClassPathResource("jdbc.properties");
        Properties props = PropertiesLoaderUtils.loadProperties(resource);
        System.out.println(props.getProperty("jdbc.names"));
        System.out.println(props.getProperty("jdbc.password"));
    }

}
