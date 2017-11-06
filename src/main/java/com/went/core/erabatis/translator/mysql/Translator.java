package com.went.core.erabatis.translator.mysql;

import com.went.core.erabatis.actiondata.DeleteAction;
import com.went.core.erabatis.actiondata.InsertAction;
import com.went.core.erabatis.actiondata.QueryAction;
import com.went.core.erabatis.actiondata.UpdateAction;
import com.went.core.erabatis.app.EraBatis;
import com.went.core.erabatis.center.SqlSegment;
import com.went.core.erabatis.phantom.AliasedColumn;
import com.went.core.erabatis.phantom.SqlComponentTranslator;
import com.went.core.utils.SpringContextHolder;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Administrator on 2017/11/4.
 */
public class Translator implements SqlComponentTranslator {

    private EraBatis getEraBatis(EraBatis eraBatis) {
        if (eraBatis == null) {
            eraBatis = SpringContextHolder.getBean("eraBatis");
        }
        return eraBatis;
    }

    /**
     * 执行查询操作
     *
     * @param queryAction 查询数据的条件
     * @param linkedList  拼接查询sql语句
     * @return LinkedList
     */
    @Override
    public LinkedList translateQueryAction(QueryAction queryAction, LinkedList linkedList) {
        appendSql(SqlTokens.SELECT, linkedList);
        if (Boolean.TRUE == queryAction.getDistinct()) {
            appendSql(SqlTokens.DISTINCT, linkedList);
        }
        return null;
    }

    public LinkedList translateColumns(QueryAction queryAction, LinkedList linkedList) {
        Iterator<AliasedColumn> iterator = queryAction.getAliasedColumns().iterator();
        while (iterator.hasNext()) {
            AliasedColumn next = iterator.next();

        }
        return null;
    }

    /**
     * 执行新增操作
     *
     * @param insertAction 新增数据的条件
     * @param linkedList   拼接新增sql语句
     * @return linkedList
     */
    @Override
    public LinkedList translateInsertAction(InsertAction insertAction, LinkedList linkedList) {
        return null;
    }

    /**
     * 执行删除操作
     *
     * @param deleteAction 删除数据的条件
     * @param linkedList   拼接删除sql语句
     * @return linkedList
     */
    @Override
    public LinkedList translateDeleteAction(DeleteAction deleteAction, LinkedList linkedList) {
        return null;
    }

    /**
     * 执行更新操作
     *
     * @param updateAction 更新数据的条件
     * @param linkedList   拼接更新sql语句
     * @return linkedList
     */
    @Override
    public LinkedList translateUpdateAction(UpdateAction updateAction, LinkedList linkedList) {
        return null;
    }

    private LinkedList appendSql(SqlSegment sqlSegment, LinkedList list) {
        list.add(sqlSegment);
        return list;
    }
}
