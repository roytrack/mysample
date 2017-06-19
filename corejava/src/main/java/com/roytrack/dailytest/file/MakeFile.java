package com.roytrack.dailytest.file;

import java.io.File;
import java.io.IOException;

/**
 * Created by roytrack on 2015/11/18.
 */
public class MakeFile {
    public static void main(String[] args) throws IOException {
        String path="/roy/deployment/cj_file/export.txt";

        File f=new File(path);
        f.mkdirs();
        f=new File("/roy/deployment/cj_file/exporsst.txt");
        System.out.println(f.createNewFile());
        System.out.println(f.getAbsolutePath());
    }
}
