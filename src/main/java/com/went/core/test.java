package com.went.core;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Shanghai Batchsight GMP Information of management platform, Inc. Copyright(c) 2017</p>
 *
 * @author Wen TieHu
 * @version 1.0
 *          <pre>History: 2017/10/24  Wen TieHu Create </pre>
 */
public class test {


public void test(){
  System.out.println(toString());
}

  private String name;
  private String code;

  @Override
  public String toString() {
    return "test{" +
        "name='" + name + '\'' +
        ", code='" + code + '\'' +
        '}';
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
}
