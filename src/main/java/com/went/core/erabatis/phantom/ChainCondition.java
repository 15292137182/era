package com.went.core.erabatis.phantom;

import java.util.List;

/**
 * <p>Title: </p>
 * <p>Description: 链式条件构造 </p>
 * <p>Copyright: Shanghai Batchsight GMP Information of management platform, Inc. Copyright(c) 2017</p>
 *
 * @author Wen TieHu
 * @version 1.0
 * <pre>History: 2018/2/8  Wen TieHu Create </pre>
 */
public interface ChainCondition<T extends Condition<T>> extends Condition<T> {
  /**
   * 获取条件
   *
   * @return get
   */
  List<Condition> getConditions();

  /**
   * 设置条件
   *
   * @param conditions set
   */
  void setConditions(List<Condition> conditions);
}
