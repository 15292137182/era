package com.went.core.mapper;

import com.went.core.entity.BusinessInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * mybatis sql映射自定义接口
 *
 * @author wzp 2015年12月17日
 */
@Mapper
public interface BusinessMapper{

    /**
     * 查询方法,返回记录 List 参数: entity <p> 2015年12月17日
     */
    List<BusinessInfo> selectAll();





}
