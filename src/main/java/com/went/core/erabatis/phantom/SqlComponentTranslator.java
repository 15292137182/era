package com.went.core.erabatis.phantom;


import com.went.core.erabatis.actiondata.DeleteAction;
import com.went.core.erabatis.actiondata.InsertAction;
import com.went.core.erabatis.actiondata.QueryAction;
import com.went.core.erabatis.actiondata.UpdateAction;

import java.util.LinkedList;

/**
 * sql组件的拼接语句组成器
 *
 * @author WenTieHu
 * @date 2017/11/2
 */
public interface SqlComponentTranslator {
  /**
   * 执行查询操作
   *
   * @param queryAction 查询数据的条件
   * @param linkedList  拼接查询sql语句
   * @return LinkedList
   */
  LinkedList translateQueryAction(QueryAction queryAction, LinkedList linkedList);

  /**
   * 执行新增操作
   *
   * @param insertAction 新增数据的条件
   * @param linkedList   拼接新增sql语句
   * @return linkedList
   */
  LinkedList translateInsertAction(InsertAction insertAction, LinkedList linkedList);

  /**
   * 执行删除操作
   *
   * @param deleteAction 删除数据的条件
   * @param linkedList   拼接删除sql语句
   * @return linkedList
   */
  LinkedList translateDeleteAction(DeleteAction deleteAction, LinkedList linkedList);

  /**
   * 执行更新操作
   *
   * @param updateAction 更新数据的条件
   * @param linkedList   拼接更新sql语句
   * @return linkedList
   */
  LinkedList translateUpdateAction(UpdateAction updateAction, LinkedList linkedList);
}