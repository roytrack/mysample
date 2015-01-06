package com.roytrack.dailytest.apache.commons;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * 读取 写入文件 采用common的fileutil
 * Created by ruanchangming on 2015/1/6.
 */
public class Fileuploads {
    private static Logger logger = LoggerFactory.getLogger(Fileuploads.class);

    public static void main(String[] args) throws IOException {
        Resource r = new DefaultResourceLoader().getResource("sample/excel/import_sample.xls");
        String path = r.getFile().getAbsolutePath().substring(0, r.getFile().getAbsolutePath().length() - r.getFilename().length());
        logger.info("全路径:{},不带文件的路径:{}", r.getFile().getAbsolutePath()
                , path);
        byte[] resource = FileUtils.readFileToByteArray(r.getFile());
        String toFile=path + (new Random()).nextInt() + ".xls";
        logger.info("写入文件：{}",toFile);
        FileUtils.writeByteArrayToFile(new File(toFile), resource);
        logger.info("写入结束");

    }
}
