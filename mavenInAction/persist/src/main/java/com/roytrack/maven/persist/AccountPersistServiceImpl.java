package com.roytrack.maven.persist;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;

/**
 * Created by roytrack on 2015/5/8.
 */
public class AccountPersistServiceImpl implements AccountPersistService {
  private static String ELEMENT_ROOT = "account-persist";
  private static Element ELEMENT_ACCOUNTS = DocumentHelper.createElement("accounts");
  private String file;
  private SAXReader reader = new SAXReader();

  private Document readDocument() throws AccountPersistException {
    File dataFile = new File(file);
    if (!dataFile.exists()) {
      dataFile.getParentFile().mkdirs();
      Document doc = DocumentFactory.getInstance().createDocument();
      Element rootEle = doc.addElement(ELEMENT_ROOT);
      rootEle.add(ELEMENT_ACCOUNTS);
      writeDocument(doc);
    }
    try {
      return reader.read(new File(file));
    } catch (DocumentException e) {
      throw new AccountPersistException("Unable to read persist data xml", e);
    }
  }

  private void writeDocument(Document doc) throws AccountPersistException {
    Writer out = null;
    try {
      out = new OutputStreamWriter(new FileOutputStream(file), "utf-8");
      XMLWriter writer = new XMLWriter(out, OutputFormat.createPrettyPrint());
      writer.write(doc);
    } catch (IOException e) {
      throw new AccountPersistException("Unable to write persist data xml", e);
    } finally {
      try {
        if (out != null) {
          out.close();
        }
      } catch (IOException e) {
        throw new AccountPersistException("Unable to write persist data xml", e);
      }
    }
  }

  public Account createAccount(Account account) throws AccountPersistException {
    return null;
  }

  public Account readAccount(String id) throws AccountPersistException {
    return null;
  }

  public Account updateAccount(Account account) throws AccountPersistException {
    return null;
  }

  public void deleteAccount(String id) throws AccountPersistException {

  }
}
