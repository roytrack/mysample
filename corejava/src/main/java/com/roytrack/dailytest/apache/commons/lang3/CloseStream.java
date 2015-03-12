package com.roytrack.dailytest.apache.commons.lang3;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 * Created by roytrack on 2015/1/14.
 */
public class CloseStream {

    @Test
    public void eleganceClose(){
        File f=new File("local.txt");
        FileWriter writer=null;
        try {
            writer=new FileWriter(f);
            writer.write("abcdefghighjklmn");
            writer.flush();
        } catch (IOException e) {
            IOUtils.closeQuietly(writer);
            e.printStackTrace();
        }finally {
            IOUtils.closeQuietly(writer);
        }
        System.out.println(f.getAbsolutePath());

    }
}
