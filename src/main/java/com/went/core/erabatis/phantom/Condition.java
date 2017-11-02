package com.went.core.erabatis.phantom;

/**
 * <p>Title: Condition</p>
 * <p>Description: 过滤条件</p>
 * <p>Copyright: Shanghai era Information of management platform 2017</p>
 *
 * @author Wen TieHu
 * @version 1.0
 *          <pre>History: 2017/10/21  Wen TieHu Create </pre>
 */
public interface Condition<T extends Condition<T>> {

  boolean isNot();

  void setNot(boolean not);

  default T not() {
    setNot(!isNot());
    return (T) this;
  }

  /**
   * 获得sql片段
   *
   * @return String
   */
  String getConditionSqlFragment();
}
