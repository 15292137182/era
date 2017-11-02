package com.went.core.controller;

import com.went.core.constants.UrlConstants;
import com.went.core.service.BusinessServiceImpl;
import com.went.core.utils.PlatResult;
import com.went.core.utils.ServerResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author Administrator
 * @date 2017/9/9
 */
@RestController
@RequestMapping(UrlConstants.URL_PREFIX + "/business")
public class BusinessController {

  @Resource
  private BusinessServiceImpl businessServiceImpl;

  @RequestMapping("/queryAll")
  public PlatResult selectAll(@RequestParam Map<String, Object> param) {
    ServerResult businessInfos = businessServiceImpl.selectAll(param);
    return PlatResult.success(businessInfos);
  }
}
