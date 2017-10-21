package com.went.core.service;

import com.went.core.base.BaseService;
import com.went.core.entity.BusinessInfo;
import com.went.core.mapper.BusinessMapper;
import com.went.core.utils.SpringContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.List;


/**
 *
 * Created by Administrator on 2017/8/26.
 */
@Service
public class BusinessService implements BaseService{

    public List<BusinessInfo> selectAll(Map map) {
        BusinessMapper businessMapper = SpringContextHolder.getBean("businessMapper");
        List<BusinessInfo> businessInfos = businessMapper.selectAll();
        return businessInfos;
    }

    @Override
    public List<Map<String, Object>> select(Map map) {
        return null;
    }

    @Override
    public int update(Map value) {
        return 0;
    }

    @Override
    public int insert(Map value) {
        return 0;
    }

    @Override
    public int delete(Map condition) {
        return 0;
    }
}
