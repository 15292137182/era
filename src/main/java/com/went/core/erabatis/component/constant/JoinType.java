package com.went.core.erabatis.component.constant;

/**
 * <p>Title: JoinType</p>
 * <p>Description: 关联查询的类型</p>
 * <p>Copyright: Shanghai era Information of management platform 2017</p>
 *
 * @author Wen TieHu
 * @version 1.0
 *          <pre>History: 2017/10/21  Wen TieHu Create </pre>
 */
public enum JoinType {
  INNER_JOIN, LEFT_JOIN, RIGHT_JOIN, FULL_JOIN, NATURAL_JOIN;
  private String sql;

  JoinType() {
    this.sql = this.toString().toLowerCase().replace('_', ' ');
  }

  public String getSql() {
    return this.sql;
  }
}