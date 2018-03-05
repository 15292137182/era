package com.went.core.resolvexml;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: WriteXml</p>
 * <p>Description:写入xml </p>
 * <p>Copyright: Shanghai Batchsight GMP Information of management platform, Inc. Copyright(c) 2017</p>
 *
 * @author Wen TieHu
 * @version 1.0
 *          <pre>History: 2017/11/5  Wen TieHu Create </pre>
 */
public class WriteXml {
  public static void main(String[] args) {
    List<Emp> list = new ArrayList<>();
    list.add(new Emp("1", "2", "3", "4"));
    list.add(new Emp("2", "22", "33", "44"));
    list.add(new Emp("3", "222", "333", "444"));
    list.add(new Emp("4", "2222", "3333", "4444"));
    list.add(new Emp("5", "22222", "33333", "44444"));

    Document document = DocumentHelper.createDocument();
    Element root = document.addElement("root");
    for (Emp e : list) {
      Element element = root.addElement("emp");
      element.addAttribute("rowId", e.getRowId());

      Element name = element.addElement("name");
      name.addText(e.getName());

      Element code = element.addElement("code");
      code.addText(e.getCode());

      Element age = element.addElement("age");
      age.addText(e.getAge());

      try {
        XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("emp.xml"), OutputFormat.createPrettyPrint());
        xmlWriter.write(document);
        xmlWriter.close();
      } catch (Exception e1) {
        e1.printStackTrace();
      }
    }
    System.out.println("写出完成");
  }
}
