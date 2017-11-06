package com.went.core.erabatis.component;

import com.went.core.erabatis.phantom.AliasedColumn;
import com.went.core.utils.UtilsTool;

/**
 * <p>Title: Field</p>
 * <p>Description: 字段值</p>
 * <p>Copyright: Shanghai era Information of management platform, Inc. Copyright(c) 2017</p>
 *
 * @author Wen TieHu
 * @version 1.0
 *          <pre>History: 2017/11/2  Wen TieHu Create </pre>
 */
public class Field implements AliasedColumn {
  /**
   * 所在表
   */
  private Table table;
  /**
   * 字段名
   */
  private String fieldName;

  /**
   * 别名
   */
  private String alias;

  public Field() {
  }

  public Field(String alias) {
    this.fieldName = UtilsTool.camelToUnderline(alias);
    this.alias = alias;
  }

  public Field(Table table, String fieldName, String alias) {
    this.table = table;
    this.fieldName = fieldName;
    this.alias = alias;
  }

  public Table getTable() {
    return table;
  }

  public void setTable(Table table) {
    this.table = table;
  }

  public String getFieldName() {
    return fieldName;
  }

  public void setFieldName(String fieldName) {
    this.fieldName = fieldName;
  }

  public void setAlias(String alias) {
    this.alias = alias;
  }

  /**
   * 获取字段信息
   *
   * @return String
   * @Author wenTieHu
   * @date 2017/11/2
   */
  @Override
  public String getAlias() {
    return null;
  }

}
