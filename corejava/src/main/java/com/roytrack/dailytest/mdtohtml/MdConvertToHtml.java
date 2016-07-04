package com.roytrack.dailytest.mdtohtml;

import org.tautua.markdownpapers.Markdown;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

/**
 * Created by roytrack on 2016-07-04.
 */
public class MdConvertToHtml {

    public static void main(String[] args) throws Exception{
        Reader in = new FileReader("D:\\wp\\sample\\corejava\\src\\main\\java\\com\\roytrack\\dailytest\\mdtohtml\\142.md");
        Writer out = new FileWriter("D:\\wp\\sample\\corejava\\src\\main\\java\\com\\roytrack\\dailytest\\mdtohtml\\out.html");

        Markdown md = new Markdown();
        md.transform(in, out);
    }
}
