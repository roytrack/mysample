package com.roytrack.springmvc.view;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.LocalizedResourceHelper;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import java.util.Map;

/**
 * 生成2007版excel的抽象类
 * Created by roytrack on 2015/9/2.
 */
public abstract class Abstract2007ExcelView extends AbstractView {
  /**
   * The content type for an Excel response
   */
  private static final String CONTENT_TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

  /**
   * The extension to look for existing templates
   */
  private static final String EXTENSION = ".xlsx";


  private String url;


  /**
   * Default Constructor.
   * Sets the content type of the view to "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet".
   */
  public Abstract2007ExcelView() {
    setContentType(CONTENT_TYPE);
  }

  /**
   * Set the URL of the Excel workbook source, without localization part nor extension.
   */
  public void setUrl(String url) {
    this.url = url;
  }


  @Override
  protected boolean generatesDownloadContent() {
    return true;
  }

  /**
   * Renders the Excel view, given the specified model.
   */
  @Override
  protected final void renderMergedOutputModel(
          Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {

    XSSFWorkbook workbook;
    if (this.url != null) {
      workbook = getTemplateSource(this.url, request);
    } else {
      workbook = new XSSFWorkbook();
      logger.debug("Created Excel Workbook from scratch");
    }

    buildExcelDocument(model, workbook, request, response);

    // Set the content type.
    response.setContentType(getContentType());

    // Should we set the content length here?
    // response.setContentLength(workbook.getBytes().length);

    // Flush byte array to servlet output stream.
    ServletOutputStream out = response.getOutputStream();
    workbook.write(out);
    out.flush();
  }

  /**
   * Creates the workbook from an existing XLSX document.
   *
   * @param url     the URL of the Excel template without localization part nor extension
   * @param request current HTTP request
   * @return the HSSFWorkbook
   * @throws Exception in case of failure
   */
  protected XSSFWorkbook getTemplateSource(String url, HttpServletRequest request) throws Exception {
    LocalizedResourceHelper helper = new LocalizedResourceHelper(getApplicationContext());
    Locale userLocale = RequestContextUtils.getLocale(request);
    Resource inputFile = helper.findLocalizedResource(url, EXTENSION, userLocale);

    // Create the Excel document from the source.
    if (logger.isDebugEnabled()) {
      logger.debug("Loading Excel workbook from " + inputFile);
    }
    return new XSSFWorkbook(inputFile.getInputStream());
  }

  /**
   * Subclasses must implement this method to create an Excel HSSFWorkbook document,
   * given the model.
   *
   * @param model    the model Map
   * @param workbook the Excel workbook to complete
   * @param request  in case we need locale etc. Shouldn't look at attributes.
   * @param response in case we need to set cookies. Shouldn't write to it.
   */
  abstract void buildExcelDocument(
          Map<String, Object> model, XSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response)
          throws Exception;


  /**
   * Convenient method to obtain the cell in the given sheet, row and column.
   * <p>Creates the row and the cell if they still doesn't already exist.
   * Thus, the column can be passed as an int, the method making the needed downcasts.
   *
   * @param sheet a sheet object. The first sheet is usually obtained by workbook.getSheetAt(0)
   * @param row   thr row number
   * @param col   the column number
   * @return the HSSFCell
   */
  protected XSSFCell getCell(XSSFSheet sheet, int row, int col) {
    XSSFRow sheetRow = sheet.getRow(row);
    if (sheetRow == null) {
      sheetRow = sheet.createRow(row);
    }
    XSSFCell cell = sheetRow.getCell((short) col);
    if (cell == null) {
      cell = sheetRow.createCell((short) col);
    }
    return cell;
  }

  /**
   * Convenient method to set a String as text content in a cell.
   *
   * @param cell the cell in which the text must be put
   * @param text the text to put in the cell
   */
  protected void setText(XSSFCell cell, String text) {
    cell.setCellType(XSSFCell.CELL_TYPE_STRING);
    cell.setCellValue(text);
  }
}
