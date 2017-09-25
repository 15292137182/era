package com.went.core.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.went.core.constants.BaseConstants;
import com.went.core.constants.Message;
import com.went.core.constants.SysMessage;
import com.went.core.constants.UrlConstants;
import com.went.core.entity.BusinessInfo;
import com.went.core.service.BusinessService;
import com.went.core.utils.PageResult;
import com.went.core.utils.PlatResult;
import com.went.core.utils.ServerResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import java.util.List;
import java.util.Map;

import static com.went.core.constants.BaseConstants.UNUSED;

/**
 *
 * Created by Administrator on 2017/9/9.
 */
@RestController
@RequestMapping(UrlConstants.URL_PREFIX+"/business")
public class BusinessController {
    @Autowired
    BusinessService businessService;

    @RequestMapping("/queryAll")
    public PlatResult selectAll(@RequestParam Map<String,Object> param ){
        String pageNum = param.get("pageNum").toString();
        String pageSize = param.get("pageSize").toString();
        int pan = Integer.valueOf(pageNum);
        int pas = Integer.valueOf(pageSize);
        PageHelper.startPage(pan,pas);

        List<BusinessInfo> businessInfos = businessService.selectAll(param);
        PageInfo pageInfo = new PageInfo<>(businessInfos);
        PageResult pageResult = new PageResult<>(pageInfo.getTotal(),pan,pas,businessInfos);

        ServerResult serverResult = new ServerResult<>(pageResult, BaseConstants.STATUS_SUCCESS, Message.QUERY_SUCCESS);
        return PlatResult.success(serverResult);
    }
}
