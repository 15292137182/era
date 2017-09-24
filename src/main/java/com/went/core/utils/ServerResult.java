package com.went.core.utils;

import java.io.Serializable;
import java.util.Map;

import static com.went.core.constants.BaseConstants.STATUS_SUCCESS;

/**
 * Service 返回的结果
 *
 * Create By HCL at 2017/7/31
 */
public class ServerResult<T> implements Serializable {

  private static final long serialVersionUID = 812376774103405857L;

  private int state = STATUS_SUCCESS;
  private String message = "";
  private T data;
  private Map extra;

  /**
   * 空的构造方法，供 json 转换时使用
   *
   * Create By HCL at 2017/8/7
   */
  public ServerResult() {
  }

  /**
   * 全参数构造方法
   *
   * @param data 数据信息
   * @param state 状态
   * @param message 消息
   */
  public ServerResult(T data, int state, String message) {
    this.state = state;
    this.message = message;
    this.data = data;
  }

  public int getState() {
    return state;
  }

  public void setState(int state) {
    this.state = state;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public Map getExtra() {
    return extra;
  }

  public void setExtra(Map extra) {
    this.extra = extra;
  }

  public static ServerResult Msg(int state, String message){
    return new ServerResult(null, state,message);
  }

//  public PageResult<Map<String, Object>> selectPage(int pageNum,int pageSize){
//    Page<Map<String,Object>> pageTask = PageHelper.startPage(pageNum, pageSize);
//    List<Map<String, Object>> result = data;
//    PageInfo pageInfo = new PageInfo(result);
//    PageResult<Map<String, Object>> pageResult = new PageResult<>(result);
//    pageResult.setTotal(pageInfo.getTotal());
//    pageResult.setPageNum(pageInfo.getPageNum());
//    pageResult.setPageSize(pageInfo.getPageSize());
//    return pageResult;
//  }


}