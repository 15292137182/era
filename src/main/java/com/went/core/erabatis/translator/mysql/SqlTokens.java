package com.went.core.erabatis.translator.mysql;

import com.went.core.erabatis.center.SqlSegment;

/**
 * <p>Title: this SqlTokens </p>
 * <p>Description: mysql 常用关键字</p>
 * <p>Copyright: Shanghai Batchsight GMP Information of management platform, Inc. Copyright(c) 2017</p>
 *
 * @author Wen TieHu
 * @version 1.0
 *          <pre>History: 2017/10/30  Wen TieHu Create </pre>
 */
public class SqlTokens {

  protected static final SqlSegment SELECT = new SqlSegment("SELECT");
  protected static final SqlSegment DISTINCT = new SqlSegment("DISTINCT");
  protected static final SqlSegment DELETE = new SqlSegment("DELETE");
  protected static final SqlSegment INSERT_INTO = new SqlSegment("INSERT INTO");
  protected static final SqlSegment UPDATE = new SqlSegment("UPDATE");
  protected static final SqlSegment SET = new SqlSegment("SET");
  protected static final SqlSegment AS = new SqlSegment("AS");
  protected static final SqlSegment FROM = new SqlSegment("FROM");
  protected static final SqlSegment ON = new SqlSegment("ON");
  protected static final SqlSegment JOIN = new SqlSegment("JOIN");
  protected static final SqlSegment INNER = new SqlSegment("INNER");
  protected static final SqlSegment LEFT = new SqlSegment("LEFT");
  protected static final SqlSegment RIGHT = new SqlSegment("RIGHT");
  protected static final SqlSegment NATURAL = new SqlSegment("NATURAL");
  protected static final SqlSegment FULL = new SqlSegment("FULL");
  protected static final SqlSegment WHERE = new SqlSegment("WHERE");
  protected static final SqlSegment GROUP_BY = new SqlSegment("GROUP BY");
  protected static final SqlSegment AND = new SqlSegment("AND");
  protected static final SqlSegment OR = new SqlSegment("OR");
  protected static final SqlSegment FALSE = new SqlSegment("FALSE");
  protected static final SqlSegment TRUE = new SqlSegment("TRUE");
  protected static final SqlSegment DOT = new SqlSegment(".");
  protected static final SqlSegment COMMA = new SqlSegment(",");
  protected static final SqlSegment VALUES = new SqlSegment("VALUES");
  protected static final SqlSegment BRACKET_START = new SqlSegment("(");
  protected static final SqlSegment BRACKET_END = new SqlSegment(")");
  protected static final SqlSegment ASC = new SqlSegment("ASC");
  protected static final SqlSegment DESC = new SqlSegment("DESC");
  protected static final SqlSegment ORDER_BY = new SqlSegment("ORDER BY");
  protected static final SqlSegment EQUAL = new SqlSegment("=");
  protected static final SqlSegment NOT_EQUAL = new SqlSegment("!=");
  protected static final SqlSegment IN = new SqlSegment("IN");
  protected static final SqlSegment NOT_IN = new SqlSegment("NOT IN");
  protected static final SqlSegment LIKE = new SqlSegment("LIKE");
  protected static final SqlSegment NOT_LIKE = new SqlSegment("NOT LIKE");
  protected static final SqlSegment BETWEEN = new SqlSegment("BETWEEN");
  protected static final SqlSegment NOT_BETWEEN = new SqlSegment("NOT BETWEEN");
  protected static final SqlSegment IS_NULL = new SqlSegment("IS NULL");
  protected static final SqlSegment NOT_NULL = new SqlSegment("IS NOT NULL");
  protected static final SqlSegment LIKE_RIGHT = new SqlSegment(",'%')");
  protected static final SqlSegment LIKE_LEFT = new SqlSegment("concat('%',");
  protected static final SqlSegment CONCAT = new SqlSegment("concat(");
  protected static final SqlSegment NOT = new SqlSegment("NOT");
  protected static final SqlSegment CAST_JSON = new SqlSegment("::jsonb");
  protected static final SqlSegment JSON_ATTR = new SqlSegment("::jsonb->>");
}
