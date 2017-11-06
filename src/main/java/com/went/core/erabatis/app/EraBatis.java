package com.went.core.erabatis.app;

import com.went.core.base.support.BeanInterface;
import com.went.core.erabatis.actiondata.DeleteAction;
import com.went.core.erabatis.actiondata.InsertAction;
import com.went.core.erabatis.actiondata.QueryAction;
import com.went.core.erabatis.actiondata.UpdateAction;
import com.went.core.erabatis.component.constant.JoinType;
import com.went.core.erabatis.component.Field;
import com.went.core.erabatis.phantom.FieldSource;
import com.went.core.erabatis.phantom.TableSource;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * <p>Title: EraBatis</p>
 * <p>Description: 封装mybatis SQL语句</p>
 * <p>Copyright: Shanghai era Information of management platform, Inc. Copyright(c) 2017</p>
 *
 * @author Wen TieHu
 * @version 1.0
 *          <pre>History: 2017/10/21  Wen TieHu Create </pre>
 */
public interface EraBatis {

  /**
   * 获取实体类全部主键字段
   *
   * @param entityClass 实体类class
   */
  Collection<Field> getPks(Class entityClass);

  /**
   * 获取实体类全部字段
   *
   * @param entityClass 实体类class
   */
  Collection<Field> getColumns(Class entityClass);

  /**
   * 获取实体类对应表
   *
   * @param entityClass 实体类class
   */
  TableSource getTable(Class entityClass);

  Field getColumnByAlias(Class entityClass, String alias);

  /**
   * 根据实体类的class对象与实体类属性名称获取对应字段对象 如果没有对应的字段就返回扩展属性
   *
   * @param entityClass 实体类
   * @param alias       实体类属性名称
   */
  FieldSource getColumnOrEtcByAlias(Class entityClass, String alias);

  /**
   * 根据实体类的class对象与实体类属性名称获取对应字段对象
   *
   * @param entityClass 实体类
   * @param alias       实体类属性名称
   */
  Collection<Field> getColumnByAlias(Class entityClass, Collection<String> alias);

  /**
   * 插入一个实体类
   *
   * @param entity 要插入的实体类
   * @return 返回插入的结果标识
   */
  <T extends BeanInterface<T>> int insertEntity(T entity);

  /**
   * 根据主键删除一个实体类
   *
   * @param entity 要更新的实体类
   */
  <T extends BeanInterface<T>> int deleteEntity(T entity);

  /**
   * 根据主键更新一个实体类
   *
   * @param entity 要更新的实体类
   */
  <T extends BeanInterface<T>> int updateEntity(T entity);

  /**
   * 根据主键更新一个实体类
   *
   * @param entity 要更新的实体类
   */
  <T extends BeanInterface<T>> int updateEntity(T entity, Object excluded);


  /**
   * 根据主键更新一个实体类
   *
   * @param entity 要更新的实体类
   * @param excluded 排除的字段
   * @return T
   */
  <T extends BeanInterface<T>> int updateEntity(T entity, Collection excluded);

  /**
   * 单表查询
   *
   * @param entity 要查询的实体类class
   * @return QueryAction
   */
  QueryAction select(Class entity);

  /**
   * 两个表的inner join查询
   *
   * @param primary           主表class对象
   * @param secondary         从表class对象
   * @param relationPrimary   主表中与从表关联的字段
   * @param relationSecondary 从表中与主表关联的字段
   * @return 未设置条件的查询语句对象
   */
  QueryAction select(Class primary,
                     Class secondary, String relationPrimary, String relationSecondary);


  /**
   * 两个表join查询 - 查询全列
   *
   * @param primary           主表class对象
   * @param secondary         从表class对象
   * @param relationPrimary   主表中与从表关联的字段
   * @param relationSecondary 从表中与主表关联的字段
   * @param joinType          join类型
   * @return 未设置条件的查询语句对象
   */
  QueryAction select(Class primary,
                     Class secondary, String relationPrimary, String relationSecondary, JoinType joinType);

  /**
   * 两个表join查询 - 指定查询列
   *
   * @param primary           主表class对象
   * @param secondary         从表class对象
   * @param relationPrimary   主表中与从表关联的字段
   * @param relationSecondary 从表中与主表关联的字段
   * @param fields            指定查询列
   * @param joinType          join类型
   * @return 未设置条件的查询语句对象
   */
  QueryAction select(Class primary,
                     Class secondary, String relationPrimary, String relationSecondary, Collection<Field> fields, JoinType joinType);

  /**
   * 更新操作（未设置条件）
   *
   * @param entity 实体类的对象
   * @param value  要更新的值(支持null)
   */
  UpdateAction update(Class entity, Map<String, Object> value);

  /**
   * 多行插入
   *
   * @param entity 实体类的class
   * @param values 插入数据库的多行数据
   */
  InsertAction insert(Class entity, List<Map<String, Object>> values);

  /**
   * 单行插入
   *
   * @param entity 实体类的class
   * @param value  插入数据库的单行数据
   * @return 未执行的插入语句对象
   */
  InsertAction insert(Class entity, Map<String, Object> value);

  /**
   * 删除(未设置条件)
   *
   * @param entity 实体类的class
   * @return 未设置条件的删除语句对象
   */
  DeleteAction delete(Class entity);


  QueryAction updateStatement();

  QueryAction selectStatement();

  InsertAction insertStatement();

  DeleteAction deleteStatement();

  List<Map<String, Object>> execute(QueryAction queryAction);

  int execute(InsertAction insertAction);

  int execute(UpdateAction updateAction);

  int execute(DeleteAction deleteAction);

  String getDefaultMapColumnAlias();

}
