package com.went.core.erabatis.component;

import com.went.core.erabatis.center.SqlSegment;

/**
 * <p>Title: Table</p>
 * <p>Description: 数据库表</p>
 * <p>Copyright: Shanghai era Information of management platform, Inc. Copyright(c) 2017</p>
 *
 * @author Wen TieHu
 * @version 1.0
 *          <pre>History: 2017/11/2  Wen TieHu Create </pre>
 */
public class Table {

  private String tableName;
  private String schema;
  private SqlSegment sqlSegment;

  public Table() {
  }

  public Table(String tableName) {
    this.tableName = tableName;
    sqlSegment = new SqlSegment(getTableName());
  }

  public Table(String schema, String tableName) {
    this.tableName = tableName;
    this.schema = schema;
  }

  public String getTableName() {
    return tableName;
  }

  public void setTableName(String tableName) {
    this.tableName = tableName;
    sqlSegment = new SqlSegment(getTableName());
  }

  public String getSchema() {
    return schema;
  }

  public void setSchema(String schema) {
    this.schema = schema;
  }

  public SqlSegment getSqlSegment() {
    return sqlSegment;
  }

  public void setSqlSegment(SqlSegment sqlSegment) {
    this.sqlSegment = sqlSegment;
  }
}
