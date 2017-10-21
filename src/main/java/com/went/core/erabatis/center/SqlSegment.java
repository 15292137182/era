package com.went.core.erabatis.center;

public class SqlSegment {

  private Object argument;

  public Object getSegment() {
    return argument;
  }

  public SqlSegment(Object argument) {
    this.argument = argument;
  }
}
