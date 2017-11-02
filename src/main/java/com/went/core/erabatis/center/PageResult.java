package com.went.core.erabatis.center;

import java.util.List;

/**
 * <p>Title: PageResult</p>
 * <p>Description: 分页封装</p>
 * <p>Copyright: Shanghai era Information of management platform 2017</p>
 *
 * @author Wen TieHu
 * @version 1.0
 *          <pre>History: 2017/10/21  Wen TieHu Create </pre>
 */
public class PageResult<T> {

  long total;
  int pageNum;
  int pageSize;
  List<T> result;

  public PageResult(List<T> result) {
    this.result = result;
  }

  public PageResult(long total, int pageNum, int pageSize, List<T> result) {
    this.total = total;
    this.pageNum = pageNum;
    this.pageSize = pageSize;
    this.result = result;
  }

  public long getTotal() {
    return total;
  }

  public void setTotal(long total) {
    this.total = total;
  }

  public int getPageNum() {
    return pageNum;
  }

  public void setPageNum(int pageNum) {
    this.pageNum = pageNum;
  }

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  public List<T> getResult() {
    return result;
  }

  public void setResult(List<T> result) {
    this.result = result;
  }
}
