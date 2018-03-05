package com.went.core.resolvexml;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Shanghai Batchsight GMP Information of management platform, Inc. Copyright(c) 2017</p>
 *
 * @author Wen TieHu
 * @version 1.0
 *          <pre>History: 2017/11/5  Wen TieHu Create </pre>
 */
public class ParseXml {
  public static void main(String[] args) {
    SAXReader saxReader = new SAXReader();
    try {
      Document read = saxReader.read(new FileInputStream("emp.xml"));
      Element rootElement = read.getRootElement();
      List<Element> elements = rootElement.elements();
      List list = new ArrayList();
      for (Element emp : elements){
        Element name = emp.element("name");
        String nameText = name.getText();
        Element code = emp.element("code");
        String codeText = code.getText();

        Attribute rowId = emp.attribute("rowId");
        String rowIdText = rowId.getText();

        Element age = emp.element("age");
        String text = age.getText();

        list.add(new Emp(rowIdText,nameText,codeText,text));
      }
      System.out.println(list);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
