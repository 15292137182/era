package com.went.core.erabatis.configuration;


import com.went.core.base.support.BeanInterface;
import com.went.core.erabatis.component.Field;
import com.went.core.erabatis.phantom.TableSource;

import java.util.List;
/**
 * <p>Title: EntityEntry </p>
 * <p>Description: 实体 </p>
 * <p>Copyright: Shanghai era Information of management platform, Inc. Copyright(c) 2017</p>
 *
 * @author Wen TieHu
 * @version 1.0
 *          <pre>History: 2017/11/03  Wen TieHu Create </pre>
 */
public class EntityEntry {

  private Class<? extends BeanInterface> entityClass;
  private List<Field> pks;
  private List<Field> fields;
  private TableSource table;

  public EntityEntry(Class<? extends BeanInterface> entityClass, TableSource table,
                     List<Field> fields, List<Field> pks) {
    this.entityClass = entityClass;
    this.fields = fields;
    this.table = table;
    this.pks = pks;
  }

  public Class<? extends BeanInterface> getEntityClass() {
    return entityClass;
  }

  public List<Field> getFields() {
    return fields;
  }

  public TableSource getTable() {
    return table;
  }

  public List<Field> getPks() {
    return pks;
  }
}
