package com.roytrack.dailytest.poi;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


/**
 * 记录poi读取一个excel文件是怎么进行的 并且研究一下他是怎么确定单元格格式的。
 *
 *org.apache.poi.hssf.usermodel.HSSFWorkbook#HSSFWorkbook(org.apache.poi.poifs.filesystem.DirectoryNode, boolean)
 *  List<Record> records = RecordFactory.createRecords(stream);
 * 在这些records里面就已经变成了NumberRecord了。。
 * org.apache.poi.hssf.record.RecordFactory#createRecords(java.io.InputStream)
 *  org.apache.poi.hssf.record.RecordFactoryInputStream#readNextRecord()
 * 就是在这个方法里面确定了是什么record 依据是sid
 *  InternalSheet sheet = InternalSheet.createSheet(rs);
 * RecordOrderer.isRowBlockRecord(recSid)
 * Created by roytrack on 2015/1/19.
 */
public class ReadExcelFile {

    @Test
    public void readExcel() throws IOException {
        DefaultResourceLoader drl=new DefaultResourceLoader();
        Resource r=drl.getResource("classpath:abc.xls");
        File f=r.getFile();
        FileInputStream fis=new FileInputStream(f);
        HSSFWorkbook book=new HSSFWorkbook(fis);
        HSSFSheet sheet=book.getSheetAt(0);
        HSSFRow row=sheet.getRow(0);
        System.out.println(row.getCell(0));
        System.out.println(row.getCell(1));
    }
}
