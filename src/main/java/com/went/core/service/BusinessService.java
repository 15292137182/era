package com.went.core.service;

import com.went.core.base.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/26.
 */
@Service
public class BusinessService implements BaseService{

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
