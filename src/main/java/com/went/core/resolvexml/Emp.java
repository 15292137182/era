package com.went.core.resolvexml;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Shanghai Batchsight GMP Information of management platform, Inc. Copyright(c) 2017</p>
 *
 * @author Wen TieHu
 * @version 1.0
 *          <pre>History: 2017/11/5  Wen TieHu Create </pre>
 */
public class Emp {
  private String rowId;
  private String name;
  private String code;
  private String age;

  public Emp(String rowId, String name, String code, String age) {
    this.rowId = rowId;
    this.name = name;
    this.code = code;
    this.age = age;
  }

  public String getRowId() {
    return rowId;
  }

  public void setRowId(String rowId) {
    this.rowId = rowId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "Emp{" +
        "rowId='" + rowId + '\'' +
        ", name='" + name + '\'' +
        ", code='" + code + '\'' +
        ", age='" + age + '\'' +
        '}';
  }
}

