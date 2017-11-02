package com.went.core.erabatis.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Shanghai era Information of management platform, Inc</p>
 *
 * @author Wen TieHu
 * @version 1.0
 *          <pre>History: 2017/10/21  Wen TieHu Create </pre>
 */
@Mapper
public interface UsuallyMapper {

  //查询操作
  List<Map<String, Object>> plainSelect(List list);


  /**
   * 新增操作
   *
   * @param list ist
   * @return int
   * @Author wenTieu
   * @Date 2017/11/2
   */
  int plainInsert(List list);

  //更新操作
  int plainUpdate(List list);

  //删除操作
  int PlainDelete(List list);
}
