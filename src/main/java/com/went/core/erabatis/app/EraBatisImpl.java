package com.went.core.erabatis.app;

import com.went.core.base.support.BeanInterface;
import com.went.core.erabatis.actiondata.DeleteAction;
import com.went.core.erabatis.actiondata.InsertAction;
import com.went.core.erabatis.actiondata.QueryAction;
import com.went.core.erabatis.actiondata.UpdateAction;
import com.went.core.erabatis.component.constant.JoinType;
import com.went.core.erabatis.component.function.Field;
import com.went.core.erabatis.configuration.EntityEntry;
import com.went.core.erabatis.configuration.builder.EntityEntriesBuilder;
import com.went.core.erabatis.configuration.builder.EntityEntryBuilder;
import com.went.core.erabatis.mapper.SuitMapper;
import com.went.core.erabatis.phantom.FieldSource;
import com.went.core.erabatis.phantom.SqlComponentTranslator;
import com.went.core.erabatis.phantom.TableSource;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Shanghai era Information of management platform, Inc. Copyright(c) 2017</p>
 *
 * @author Wen TieHu
 * @version 1.0
 *          <pre>History: 2017/10/21  Wen TieHu Create </pre>
 */
public class EraBatisImpl implements EraBatis {

  private SuitMapper suitMapper;
  private SqlComponentTranslator translator;
  private Map<Class, Collection<Field>> entityColumns;
  private Map<Class, Collection<Field>> entityPks;
  private Map<Class, Map<String, Field>> aliasMap;
  private Map<Class, TableSource> entityTables;
  private String defaultMapColumnAlias = "etc";
  private List<EntityEntriesBuilder> entityEntriesBuilders;

  public EraBatisImpl(SuitMapper suitMapper, SqlComponentTranslator translator, Collection entityEntries) {
    this.suitMapper = suitMapper;
    this.translator = translator;
    this.entityColumns = new HashMap<>();
    this.entityPks = new HashMap<>();
    this.entityTables = new HashMap<>();
    this.aliasMap = new HashMap<>();
    List<EntityEntriesBuilder> entriesBuilders = new LinkedList<>();
    for (Object entity : entityEntries) {
      EntityEntry entityEntry;
      if (entity instanceof EntityEntry) {
        entityEntry = (EntityEntry) entity;
      } else if (entity instanceof EntityEntryBuilder) {
        entityEntry = ((EntityEntryBuilder) entity).getEntry();
      } else if (entity instanceof EntityEntriesBuilder) {
        entriesBuilders.add((EntityEntriesBuilder) entity);
        continue;
      } else {
        throw new UnsupportedOperationException("你输入的提供的实体类注册信息不正确");
      }
      registerEntityEntry(entityEntry);
    }
    entityEntriesBuilders = entriesBuilders;
  }

  private void registerEntityEntry(EntityEntry entityEntry){
    Class<? extends BeanInterface> entityClass = entityEntry.getEntityClass();
//    entityEntry+
  }
  /**
   * 获取实体类全部主键字段
   *
   * @param entityClass 实体类class
   */
  @Override
  public Collection<Field> getPks(Class entityClass) {
    return null;
  }

  /**
   * 获取实体类全部字段
   *
   * @param entityClass 实体类class
   */
  @Override
  public Collection<Field> getColumns(Class entityClass) {
    return null;
  }

  /**
   * 获取实体类对应表
   *
   * @param entityClass 实体类class
   */
  @Override
  public TableSource getTable(Class entityClass) {
    return null;
  }

  @Override
  public Field getColumnByAlias(Class entityClass, String alias) {
    return null;
  }

  /**
   * 根据实体类的class对象与实体类属性名称获取对应字段对象 如果没有对应的字段就返回扩展属性
   *
   * @param entityClass 实体类
   * @param alias       实体类属性名称
   */
  @Override
  public FieldSource getColumnOrEtcByAlias(Class entityClass, String alias) {
    return null;
  }

  /**
   * 根据实体类的class对象与实体类属性名称获取对应字段对象
   *
   * @param entityClass 实体类
   * @param alias       实体类属性名称
   */
  @Override
  public Collection<Field> getColumnByAlias(Class entityClass, Collection<String> alias) {
    return null;
  }

  /**
   * 插入一个实体类
   *
   * @param entity 要插入的实体类
   * @return 返回插入的结果标识
   */
  @Override
  public <T extends BeanInterface<T>> int insertEntity(T entity) {
    return 0;
  }

  /**
   * 根据主键删除一个实体类
   *
   * @param entity 要更新的实体类
   */
  @Override
  public <T extends BeanInterface<T>> int deleteEntity(T entity) {
    return 0;
  }

  /**
   * 根据主键更新一个实体类
   *
   * @param entity 要更新的实体类
   */
  @Override
  public <T extends BeanInterface<T>> int updateEntity(T entity) {
    return 0;
  }

  /**
   * 根据主键更新一个实体类
   *
   * @param entity   要更新的实体类
   * @param excluded
   */
  @Override
  public <T extends BeanInterface<T>> int updateEntity(T entity, Object excluded) {
    return 0;
  }

  /**
   * 根据主键更新一个实体类
   *
   * @param entity   要更新的实体类
   * @param excluded 排除的字段
   * @return T
   */
  @Override
  public <T extends BeanInterface<T>> int updateEntity(T entity, Collection excluded) {
    return 0;
  }

  /**
   * 单表查询
   *
   * @param entity 要查询的实体类class
   */
  @Override
  public QueryAction select(Class entity) {
    return null;
  }

  /**
   * 两个表的inner join查询
   *
   * @param primary           主表class对象
   * @param secondary         从表class对象
   * @param relationPrimary   主表中与从表关联的字段
   * @param relationSecondary 从表中与主表关联的字段
   * @return 未设置条件的查询语句对象
   */
  @Override
  public QueryAction select(Class primary, Class secondary, String relationPrimary, String relationSecondary) {
    return null;
  }

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
  @Override
  public QueryAction select(Class primary, Class secondary, String relationPrimary, String relationSecondary, JoinType joinType) {
    return null;
  }

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
  @Override
  public QueryAction select(Class primary, Class secondary, String relationPrimary, String relationSecondary, Collection<Field> fields, JoinType joinType) {
    return null;
  }

  @Override
  public QueryAction selectStatement() {
    return null;
  }

  /**
   * 更新操作（未设置条件）
   *
   * @param entity 实体类的对象
   * @param value  要更新的值(支持null)
   */
  @Override
  public UpdateAction update(Class entity, Map<String, Object> value) {
    return null;
  }

  /**
   * 多行插入
   *
   * @param entity 实体类的class
   * @param values 插入数据库的多行数据
   */
  @Override
  public InsertAction insert(Class entity, List<Map<String, Object>> values) {
    return null;
  }

  /**
   * 单行插入
   *
   * @param entity 实体类的class
   * @param value  插入数据库的单行数据
   * @return 未执行的插入语句对象
   */
  @Override
  public InsertAction insert(Class entity, Map<String, Object> value) {
    return null;
  }

  /**
   * 删除(未设置条件)
   *
   * @param entity 实体类的class
   * @return 未设置条件的删除语句对象
   */
  @Override
  public DeleteAction delete(Class entity) {
    return null;
  }

  @Override
  public InsertAction insertStatement() {
    return null;
  }

  @Override
  public DeleteAction deleteStatement() {
    return null;
  }

  @Override
  public List<Map<String, Object>> execute(QueryAction queryAction) {
    return null;
  }

  @Override
  public int execute(InsertAction insertAction) {
    return 0;
  }

  @Override
  public int execute(UpdateAction updateAction) {
    return 0;
  }

  @Override
  public int execute(DeleteAction deleteAction) {
    return 0;
  }

  @Override
  public String getDefaultMapColumnAlias() {
    return null;
  }
}
