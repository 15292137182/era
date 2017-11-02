package com.went.core.base;


import com.went.core.utils.ServerResult;

import java.util.List;
import java.util.Map;

/**
 * @author Went
 */
public interface BaseService {

  //  PageResult<Map<String, Object>> select(Map condition, int page, int limit);
//
//  List<Map<String, Object>> select(Map condition);
//
//  List<Map<String, Object>> select(Condition condition, List<Column> columns, List<Order> orders);
//
  ServerResult<Map<String, Object>> selectAll(Map map);

  List<Map<String, Object>> select(Map map);

  int update(Map value);

  int insert(Map value);

  int delete(Map condition);
}