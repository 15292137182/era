package com.went.core.base;


import java.util.List;
import java.util.Map;

/**
 * Create By HCL at 2017/8/1
 */
public interface BaseService<T extends BaseEntity> {

//  PageResult<Map<String, Object>> select(Map condition, int page, int limit);
//
//  List<Map<String, Object>> select(Map condition);
//
//  List<Map<String, Object>> select(Condition condition, List<Column> columns, List<Order> orders);
//
//  PageResult<Map<String, Object>> select(Condition condition, List<Column> columns, List<Order> orders, int pageNum, int pageSize);

    List<Map<String, Object>> select(Map map);

    int update(Map value);

    int insert(Map value);

    int delete(Map condition);
}