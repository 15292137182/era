package com.went.core.erabatis.component;


import com.went.core.erabatis.phantom.FieldSource;

/**
 * <p>Title: Order</p>
 * <p>Description: 排序条件</p>
 * <p>Copyright: Shanghai era Information of management platform 2017</p>
 *
 * @author Wen TieHu
 * @version 1.0
 *          <pre>History: 2017/10/21  Wen TieHu Create </pre>
 */
public class Order {

  private static final int DESC = 0, ASC = 1;

  private Object source;

  private int order = DESC;

  public Order(FieldSource fieldSource, int order) {
    this.source = fieldSource;
    this.order = order;
  }

  public Order(String alias, int order) {
    this.source = alias;
    this.order = order;
  }

  public void setSource(FieldSource fieldSource) {
    this.source = fieldSource;
  }

  public void setSource(String alias) {
    this.source = alias;
  }

  public Object getSource() {
    return source;
  }

  public int getOrder() {
    return order;
  }

  public void setOrder(int order) {
    this.order = order;
  }
}
