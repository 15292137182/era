package com.went.core.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.went.core.erabatis.center.PageResult;
import com.went.core.erabatis.center.SqlSegment;
import com.went.core.erabatis.mapper.MysqlMapper;
import com.went.core.utils.ServerResult;
import com.went.core.utils.SpringContextHolder;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * @author Administrator
 * @date 2017/8/26
 */
@Service
public class BusinessServiceImpl {


  public ServerResult selectAll(Map param) {
    MysqlMapper mysqlMapper = SpringContextHolder.getBean("mysqlMapper");
    List<SqlSegment> list = new LinkedList<>();
    SqlSegment select = new SqlSegment("select");
    SqlSegment code = new SqlSegment("code");
    SqlSegment segment = new SqlSegment(",");
    SqlSegment name = new SqlSegment("name");
    SqlSegment S__ = new SqlSegment(",");
    SqlSegment desc = new SqlSegment("'desc'");
    SqlSegment __ = new SqlSegment(",");
    SqlSegment createUser = new SqlSegment("create_user");
    SqlSegment from = new SqlSegment("from");
    SqlSegment t_business = new SqlSegment("era.t_business");
    SqlSegment ORDER_BY = new SqlSegment("order by");
    SqlSegment code1 = new SqlSegment("code");
    SqlSegment DESC = new SqlSegment("desc");
    list.add(select);
    list.add(code);
    list.add(segment);
    list.add(name);
    list.add(S__);
    list.add(desc);
    list.add(__);
    list.add(createUser);
    list.add(from);
    list.add(t_business);
    list.add(ORDER_BY);
    list.add(code1);
    list.add(DESC);
    List<Map<String, Object>> maps = mysqlMapper.plainSelect(list);
    String pageNum = param.get("pageNum").toString();
    String pageSize = param.get("pageSize").toString();
    int pan = Integer.valueOf(pageNum);
    int pas = Integer.valueOf(pageSize);
    PageHelper.startPage(pan, pas);

    PageInfo pageInfo = new PageInfo<>(maps);
    PageResult pageResult = new PageResult<>(pageInfo.getTotal(), pan, pas, maps);

    return new ServerResult<>(pageResult, -1, "成功");
  }
}
