package com.went.core.database;

/**
 * 数据源类型定义
 */
public enum DBTypeEnum {

  /**
   * MySQL 数据库切面
   */
  MySQL("dataSourceMySQL");

  private String value;

  DBTypeEnum(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
