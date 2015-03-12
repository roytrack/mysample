package com.roytrack.dailytest.poi;

import org.apache.poi.hssf.usermodel.*;
import org.junit.Test;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;


/**
 * 记录poi读取一个excel文件是怎么进行的 并且研究一下他是怎么确定单元格格式的。
 *
 *org.apache.poi.hssf.usermodel.HSSFWorkbook#HSSFWorkbook(org.apache.poi.poifs.filesystem.DirectoryNode, boolean)
 *  List<Record> records = RecordFactory.createRecords(stream);
 * 在这些records里面就已经变成了NumberRecord了。。
 * org.apache.poi.hssf.record.RecordFactory#createRecords(java.io.InputStream)
 *
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

    /**
     * 顺带着对poi取出浮点数的非科学计数法方式各派研究 一共有三派
     * 1.cell.setCellType(HSSFCell.CELL_TYPE_STRING) 直接设置单元格格式的 不能将浮点读出成正常的
     * 2. cellvalue = new BigDecimal(cell.getNumericCellValue()).toPlainString();  这种会出现不精确问题 ？ Bigdecimal反而不精确了？ 你没给精度啊
     * 3.创建一个样式
     HSSFCellStyle cellStyle = wb.createCellStyle();
     //创建一个DataFormat对象
     HSSFDataFormat format = wb.createDataFormat();
     //这样才能真正的控制单元格格式，@就是指文本型，具体格式的定义还是参考上面的原文吧
     cellStyle.setDataFormat(format.getFormat("@"));

     //具体如何创建cell就省略了，最后设置单元格的格式这样写
     下面写三个方法来实践一下
     * @throws java.io.IOException
     */
    //方法1 将其变为string 然后直接取 可行  org.apache.poi.hssf.usermodel.HSSFCell#convertCellValueToString()

@Test
public void changeCellType()  throws IOException{
        DefaultResourceLoader drl=new DefaultResourceLoader();
        Resource r=drl.getResource("classpath:abc.xls");
        File f=r.getFile();
        FileInputStream fis=new FileInputStream(f);
        HSSFWorkbook book=new HSSFWorkbook(fis);
        HSSFSheet sheet=book.getSheetAt(0);
        HSSFRow row=sheet.getRow(0);
    System.out.println(row.getCell(0));
    System.out.println(row.getCell(1));
    System.out.println(row.getCell(2));
    System.out.println("changed===============");
        HSSFCell cell=row.getCell(0);
        cell.setCellType(HSSFCell.CELL_TYPE_STRING);

        System.out.println(cell.getStringCellValue());
        cell=row.getCell(1);
        cell.setCellType(HSSFCell.CELL_TYPE_STRING);

        System.out.println(row.getCell(1));
    cell=row.getCell(2);
    cell.setCellType(HSSFCell.CELL_TYPE_STRING);

    System.out.println(row.getCell(2).getStringCellValue());
        }

    //方法2 变成bigdecimal 对于小数有精度问题
    @Test
    public void changeWithBigdecimal() throws IOException {
        DefaultResourceLoader drl=new DefaultResourceLoader();
        Resource r=drl.getResource("classpath:abc.xls");
        File f=r.getFile();
        FileInputStream fis=new FileInputStream(f);
        HSSFWorkbook book=new HSSFWorkbook(fis);
        HSSFSheet sheet=book.getSheetAt(0);
        HSSFRow row=sheet.getRow(0);
        System.out.println(row.getCell(0));
        System.out.println(row.getCell(1));
        System.out.println(row.getCell(2));
        System.out.println("changed===============");
        System.out.println(new BigDecimal(row.getCell(0).getNumericCellValue()).toPlainString());
        System.out.println(new BigDecimal(row.getCell(1).getNumericCellValue()).toPlainString());
        System.out.println(new BigDecimal(row.getCell(2).getNumericCellValue()).toPlainString());
    }


    //方法3 采用dataformat和cellstyle 第三种对于原来是科学计数法的没办法给转换好 这种就是所见即所得
    //但是对于 第二个单元格4343343 后面加上了个.0 不好哦

    @Test
    public void changeWithCellStyle() throws IOException {
        DefaultResourceLoader drl=new DefaultResourceLoader();
        Resource r=drl.getResource("classpath:abc.xls");
        File f=r.getFile();
        FileInputStream fis=new FileInputStream(f);
        HSSFWorkbook book=new HSSFWorkbook(fis);
        HSSFSheet sheet=book.getSheetAt(0);
        HSSFRow row=sheet.getRow(0);
        System.out.println(row.getCell(0));
        System.out.println(row.getCell(1));
        System.out.println(row.getCell(2));
        System.out.println("changed===============");
        HSSFCell cell=row.getCell(0);
        HSSFCellStyle hcs=cell.getRow().getSheet().getWorkbook().createCellStyle();
        HSSFDataFormat hdf=cell.getRow().getSheet().getWorkbook().createDataFormat();
        hcs.setDataFormat(hdf.getFormat("@"));
        cell.setCellStyle(hcs);
        System.out.println(cell);
        cell=row.getCell(1);
        cell.setCellStyle(hcs);
        System.out.println(cell);
        cell=row.getCell(2);
        cell.setCellStyle(hcs);
        System.out.println(cell);

    }
}
