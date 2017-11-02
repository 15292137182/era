package com.went.core.erabatis.actiondata;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.went.core.erabatis.app.EraBatis;
import com.went.core.erabatis.center.PageResult;
import com.went.core.erabatis.component.function.Order;
import com.went.core.erabatis.phantom.AliasedColumn;
import com.went.core.erabatis.phantom.Condition;
import com.went.core.erabatis.phantom.FieldSource;
import com.went.core.erabatis.phantom.SqlComponentTranslator;
import com.went.core.erabatis.phantom.TableSource;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * <p>Title: QueryAction</p>
 * <p>Description: 组装查询条件</p>
 * <p>Copyright: Shanghai era Information of management platform 2017</p>
 *
 * @author Wen TieHu
 * @version 1.0
 *          <pre>History: 2017/10/21  Wen TieHu Create </pre>
 */
public class QueryAction {

  private EraBatis eraBatis;
  private TableSource tableSource;
  private Collection<AliasedColumn> aliasedColumns;
  private Condition where;
  private List<Order> order;
  private List<FieldSource> group;
  private SqlComponentTranslator translator;
  private Boolean distinct;

  public QueryAction(EraBatis eraBatis, SqlComponentTranslator translator) {
    this.eraBatis = eraBatis;
    this.translator = translator;
  }

  public EraBatis getEraBatis() {
    return eraBatis;
  }

  public void setEraBatis(EraBatis eraBatis) {
    this.eraBatis = eraBatis;
  }

  public TableSource getTableSource() {
    return tableSource;
  }

  public void setTableSource(TableSource tableSource) {
    this.tableSource = tableSource;
  }

  public Collection<AliasedColumn> getAliasedColumns() {
    return aliasedColumns;
  }

  public void setAliasedColumns(Collection<AliasedColumn> aliasedColumns) {
    this.aliasedColumns = aliasedColumns;
  }

  public Condition getWhere() {
    return where;
  }

  public void setWhere(Condition where) {
    this.where = where;
  }

  public List<Order> getOrder() {
    return order;
  }

  public void setOrder(List<Order> order) {
    this.order = order;
  }

  public List<FieldSource> getGroup() {
    return group;
  }

  public void setGroup(List<FieldSource> group) {
    this.group = group;
  }

  public SqlComponentTranslator getTranslator() {
    return translator;
  }

  public void setTranslator(SqlComponentTranslator translator) {
    this.translator = translator;
  }

  public Boolean getDistinct() {
    return distinct;
  }

  public void setDistinct(Boolean distinct) {
    this.distinct = distinct;
  }


  public QueryAction select(Collection<AliasedColumn> aliasedColumn) {
    this.aliasedColumns = aliasedColumn;
    return this;
  }

  public QueryAction where(Condition condition) {
    this.where = condition;
    return this;
  }

  public QueryAction distinct(boolean distinct) {
    this.distinct = distinct;
    return this;
  }

  public QueryAction distinct() {
    this.distinct = Boolean.TRUE;
    return this;
  }

  public QueryAction from(TableSource tableSource) {
    this.tableSource = tableSource;
    return this;
  }

  public QueryAction orderBy(Order... order) {
    this.order = Arrays.asList(order);
    return this;
  }

  public QueryAction orderBy(List<Order> order) {
    this.order = order;
    return this;
  }

  public QueryAction groupBy(FieldSource... fieldSource) {
    this.group = Arrays.asList(fieldSource);
    return this;
  }

  public QueryAction groupBy(List<FieldSource> fieldSources) {
    this.group = fieldSources;
    return this;
  }

  public List<Map<String, Object>> execute() {
    return eraBatis.execute(this);
  }

  public PageResult<Map<String, Object>> selectPage(int pageNum, int pageSize) {
    PageHelper.startPage(pageNum, pageSize);
    List<Map<String, Object>> result = execute();
    PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(result);
    PageResult<Map<String, Object>> pageResult = new PageResult<>(result);
    pageResult.setPageNum(pageInfo.getPageNum());
    pageResult.setPageSize(pageInfo.getPageSize());
    pageResult.setTotal(pageInfo.getTotal());
    return pageResult;
  }
}
