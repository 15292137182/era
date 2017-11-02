package com.went.core.erabatis.component.function;

import com.went.core.erabatis.phantom.AliasedColumn;

/**
 * <p>Title: Field</p>
 * <p>Description: 字段值</p>
 * <p>Copyright: Shanghai era GMP Information of management platform, Inc. Copyright(c) 2017</p>
 *
 * @author Wen TieHu
 * @version 1.0
 *          <pre>History: 2017/11/2  Wen TieHu Create </pre>
 */
public class Field implements AliasedColumn {

  private Table table;

  /**
   * 获取字段信息
   *
   * @return String
   * @Author wenTieHu
   * @date 2017/11/2
   */
  @Override
  public String getAlias() {
    return null;
  }
}
