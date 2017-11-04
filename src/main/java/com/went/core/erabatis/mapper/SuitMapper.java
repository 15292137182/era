package com.went.core.erabatis.mapper;


import com.went.core.erabatis.actiondata.DeleteAction;
import com.went.core.erabatis.actiondata.InsertAction;
import com.went.core.erabatis.actiondata.QueryAction;
import com.went.core.erabatis.actiondata.UpdateAction;

import java.util.List;
import java.util.Map;

/**
 * <p>Title: SuitMapper</p>
 * <p>Description: 通用 mapper </p>
 * <p>Copyright: Shanghai era Information of management platform, Inc</p>
 *
 * @author Wen TieHu
 * @version 1.0
 *          <pre>History: 2017/11/02  Wen TieHu Create </pre>
 */
public interface SuitMapper {

  /**
   * 通用查询方法.
   *
   * @param list 查询参数
   * @return 查询结果
   */
  List<Map<String, Object>> plainSelect(List list);

  /**
   * 通用新增方法
   *
   * @param list 新增参数
   * @return 新增条数
   */
  int plainInsert(List list);


  /**
   * 通用删除方法
   *
   * @param list 删除参数
   * @return 删除的条数
   */
  int plainDelete(List list);

  /**
   * 通用更新方法
   *
   * @param list 更新参数
   * @return 更新数据的条数
   */
  int plainUpdate(List list);

  /**
   * 通用查询方法.
   *
   * @param queryActionLite 查询参数
   * @return 查询结果
   */
  List<Map<String, Object>> select(QueryAction queryActionLite);

  /**
   * 通用新增方法
   *
   * @param insertAction 新增参数
   * @return 新增条数
   */
  int insert(InsertAction insertAction);

  /**
   * 通用删除方法
   *
   * @param deleteAction 删除参数
   * @return 删除的条数
   */
  int delete(DeleteAction deleteAction);

  /**
   * 通用更新方法
   *
   * @param deleteAction 更新参数
   * @return 更新数据的条数
   */
  int update(UpdateAction deleteAction);
}
