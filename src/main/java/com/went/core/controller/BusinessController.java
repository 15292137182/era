package com.went.core.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.went.core.constants.BaseConstants;
import com.went.core.constants.Message;
import com.went.core.constants.UrlConstants;
import com.went.core.entity.BusinessInfo;
import com.went.core.erabatis.mapper.UsuallyMapper;
import com.went.core.service.BusinessService;
import com.went.core.utils.PageResult;
import com.went.core.utils.PlatResult;
import com.went.core.utils.ServerResult;
import com.went.core.utils.SpringContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/9.
 */
@RestController
@RequestMapping(UrlConstants.URL_PREFIX + "/business")
public class BusinessController {
  @Autowired
  BusinessService businessService;

  @RequestMapping("/queryAll")
  public PlatResult selectAll(@RequestParam Map<String, Object> param) {
    UsuallyMapper usuallyMapper = SpringContextHolder.getBean("usuallyMapper");
    List<String> list = new LinkedList<>();
    list.add("select");
    list.add("*");
    list.add("from");
    list.add("era.t_business");
    list.add("ORDER BY");
    list.add("code");
    list.add("DESC");
    List<Map<String, Object>> maps = usuallyMapper.plainSelect(list);
    System.out.println(maps);
    String pageNum = param.get("pageNum").toString();
    String pageSize = param.get("pageSize").toString();
    int pan = Integer.valueOf(pageNum);
    int pas = Integer.valueOf(pageSize);
    PageHelper.startPage(pan, pas);

    List<BusinessInfo> businessInfos = businessService.selectAll(param);
    PageInfo pageInfo = new PageInfo<>(businessInfos);
    PageResult pageResult = new PageResult<>(pageInfo.getTotal(), pan, pas, businessInfos);

    ServerResult serverResult = new ServerResult<>(pageResult, BaseConstants.STATUS_SUCCESS, Message.QUERY_SUCCESS);
    return PlatResult.success(serverResult);
  }
}
