package com.roytrack.dailytest;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springside.modules.nosql.redis.JedisScriptExecutor;
import org.springside.modules.nosql.redis.pool.JedisPool;


import java.io.IOException;

/**
 * Created by roytrack on 2015/1/5.
 */
public class MyJedisScriptExecutor extends JedisScriptExecutor {


    public MyJedisScriptExecutor(JedisPool jedisPool) {
        super(jedisPool);
    }

    /**
     * 从文件加载Lua Script, 文件路径格式为Spring Resource的格式.
     */
    public void loadFromFile(final String scriptPath)  {
//        StringBuilder scriptContent=new StringBuilder();
//        ResourcePatternResolver resolver=new PathMatchingResourcePatternResolver();
//
//        try {
////            InputStream resource = this.getClass().getResourceAsStream("/script/belum/import.lua");
////            BufferedReader br=new BufferedReader(new InputStreamReader(resource));
////            String s="";
////            while((s=br.readLine())!=null){
////                scriptContent.append(s);
////                System.out.println(s);
////            }
//            Resource resource=resolver.getResource("classpath:script/belum/import.lua");
//            System.out.println(resource.toString());
//
//        } catch (IOException e) {
//            throw new IllegalArgumentException(scriptPath + " is not exist.", e);
//        }
//
//        load(scriptContent.toString());
        ResourcePatternResolver resolver=new PathMatchingResourcePatternResolver();
        String scriptContent;
        try {
            Resource resource=resolver.getResource("classpath:script/belum/import.lua");
            System.out.println(resource.contentLength()+"####"+resource.getFilename()+"###"+resource.getURL());
            //核心代码 就是resource不能从jar包获得文件 但是可以获得里面的内容
            scriptContent = IOUtils.toString(resource.getInputStream());
//            FileUtils.readFileToString(resource.getFile());
        } catch (IOException e) {
            throw new IllegalArgumentException(scriptPath + " is not exist.", e);
        }

        load(scriptContent);
    }




}
