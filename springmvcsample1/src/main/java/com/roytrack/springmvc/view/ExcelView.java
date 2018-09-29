package com.roytrack.springmvc.view;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by roytrack on 2015/1/13.
 */
public class ExcelView extends AbstractExcelView {


  @Override
  protected void buildExcelDocument(Map<String, Object> map, HSSFWorkbook hssfWorkbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
    HSSFSheet hssfsheet = hssfWorkbook.createSheet();
    Map m = this.getAttributesMap();
    HSSFRow row = hssfsheet.createRow(0);
    HSSFCell cell = row.createCell(0);
    cell.setCellValue("foo");
    cell = row.createCell(1);
    cell.setCellValue((String) m.get("str"));
    cell = row.createCell(2);
    cell.setCellValue(((BigDecimal) m.get("bd")).toPlainString());

  }
}
