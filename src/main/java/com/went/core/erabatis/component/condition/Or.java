package com.went.core.erabatis.component.condition;

import com.went.core.erabatis.phantom.ChainCondition;
import com.went.core.erabatis.phantom.Condition;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Shanghai Batchsight GMP Information of management platform, Inc. Copyright(c) 2017</p>
 *
 * @author Wen TieHu
 * @version 1.0
 * <pre>History: 2018/2/8  Wen TieHu Create </pre>
 */
public class Or implements ChainCondition<Or> {

  private List<Condition> conditions;
  private boolean not = false;

  /**
   * 获取条件
   *
   * @return get
   */
  @Override
  public List<Condition> getConditions() {
    return conditions;
  }

  /**
   * 设置条件
   *
   * @param conditions set
   */
  @Override
  public void setConditions(List<Condition> conditions) {
    this.conditions = conditions;

  }

  @Override
  public boolean isNot() {
    return not;
  }

  @Override
  public void setNot(boolean not) {
    this.not = not;
  }

  public Or(Condition... conditions) {
    List<Condition> list = new LinkedList<>();
    list.addAll(Arrays.asList(conditions));
    this.conditions = list;
  }

  public Or(List<Condition> conditions) {
    this.conditions = conditions;
  }

}
