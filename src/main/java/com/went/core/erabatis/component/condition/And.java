package com.went.core.erabatis.component.condition;

import com.went.core.erabatis.phantom.ChainCondition;
import com.went.core.erabatis.phantom.Condition;

import java.util.Arrays;
import java.util.Collections;
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
public class And implements ChainCondition<And> {

  private List<Condition> conditions;
  private boolean not = false;

  @Override
  public List<Condition> getConditions() {
    return conditions;
  }

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

  public And(Condition... conditions) {
    LinkedList<Condition> linkedList = new LinkedList<>();
    linkedList.addAll(Arrays.asList(conditions));
    setConditions(linkedList);
  }

  public And(List<Condition> conditions) {
    setConditions(conditions);
  }

}
