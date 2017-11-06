package com.went.core.erabatis.component;


import com.went.core.erabatis.phantom.FieldSource;

/**
 * <p>Title: SubAttribute</p>
 * <p>Description: 子属性</p>
 * <p>Copyright: Shanghai era GMP Information of management platform, Inc. Copyright(c) 2017</p>
 *
 * @author Wen TieHu
 * @version 1.0
 *          <pre>History: 2017/11/2  Wen TieHu Create </pre>
 */
public class SubAttribute implements FieldSource<SubAttribute> {

    FieldSource field;
    String key;

    public SubAttribute(FieldSource field, String key) {
        this.field = field;
        this.key = key;
    }

    public FieldSource getField() {
        return field;
    }

    public void setField(FieldSource field) {
        this.field = field;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
