package com.went.core.entity;

import com.went.core.base.BaseEntity;

/**
 *
 * Created by Administrator on 2017/8/26.
 */
public class BusinessInfo extends BaseEntity<BusinessInfo>{

    private String code;
    private String name;
    private String desc;
    private String rowId;
    private String desp;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public String getDesp() {
        return desp;
    }

    public void setDesp(String desp) {
        this.desp = desp;
    }
}
