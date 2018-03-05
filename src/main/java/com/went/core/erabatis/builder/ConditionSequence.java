package com.went.core.erabatis.builder;

import com.went.core.erabatis.phantom.Condition;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Shanghai Batchsight GMP Information of management platform, Inc. Copyright(c) 2017</p>
 *
 * @author Wen TieHu
 * @version 1.0
 * <pre>History: 2018/2/8  Wen TieHu Create </pre>
 */
public interface ConditionSequence {

  /**
   * 添加条件
   *
   * @param condition 条件
   */
  void append(Condition condition);
}
