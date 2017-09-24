package com.went.core.base;


import com.went.core.utils.UtilsTool;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static com.went.core.utils.UtilsTool.getDateTimeNow;
import static com.went.core.utils.UtilsTool.underlineToCamel;


/**
 * 基础 entity 类，建议所有实体类均继承此类
 *
 * Create By HCL at 2017/7/31
 */
public class BaseEntity<T extends BaseEntity> implements Serializable {

  private String status;//状态
  private String version;//版本
  private String createUser;//创建人
  private String createUserName;//创建名称
  private String createTime;//创建时间
  private String modifyUser;//修改人
  private String modifyUserName;//修改名称
  private String modifyTime;//修改时间

//  private Map etc;

  /**
   * 构建 - 创建信息
   *
   * @return 返回自身
   */
  @SuppressWarnings("unchecked")
  public T buildCreateInfo() {
      String data = getDateTimeNow();
      setCreateTime(data);
      setCreateUser("admin");
      setCreateUserName("系统管理员");
      setModifyTime(data);
    return (T) this;
  }

  /**
   * 构建 - 修改信息
   *
   * @return 返回自身
   */
  @SuppressWarnings("unchecked")
  public T buildModifyInfo() {
    setModifyTime(getDateTimeNow());
    setModifyUser("admin");
    setModifyUserName("系统管理员");
    return (T) this;
  }

  /**
   * 将 entity 实体类转换为 map
   *
   * @return map
   */
  @SuppressWarnings("unchecked")
  public Map<String, Object> toMap() {
    return UtilsTool.jsonToObj(UtilsTool.objToJson(this), HashMap.class);
  }

  /**
   * 尝试从 map 中读取 entity 类
   *
   * 为了满足需求，我决定造一个轮子
   *
   * @param map map数据
   * @param isUnderline 传入map的key是否为下划线命名
   * @return 返回实体类
   */
  @SuppressWarnings("unchecked")
  public T fromMap(Map<String, Object> map, boolean isUnderline) {
    Class current = getClass();
    do {
      Method[] methods = current.getDeclaredMethods();
      Object temp;
      for (Method method : methods) {
        if (method.getName().startsWith("set") && method.getParameterCount() == 1) {
          String fieldName = underlineToCamel(
              method.getName().substring(3, method.getName().length()), false);
          temp = isUnderline ? map.get(underlineToCamel(fieldName, false)) : map.get(fieldName);
          if (null != temp && !temp.getClass().equals(method.getParameterTypes()[0])) {
            if (temp instanceof String) {
              temp = UtilsTool.jsonToObj((String) temp, method.getParameterTypes()[0]);
            } else {
              temp = UtilsTool.jsonToObj(UtilsTool.objToJson(temp), method.getParameterTypes()[0]);
            }
          }
          try {
            method.invoke(this, temp);
          } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
          }
        }
      }
      current = current.getSuperclass();
    } while (current != Object.class);

    return (T) this;
  }

  /**
   * 尝试从 map 中读取 entity 类
   *
   * 为了满足需求，我决定造一个轮子
   *
   * @param map map数据
   * @return 返回实体类
   */
  public T fromMap(Map<String, Object> map) {
    return fromMap(map, false);
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public String getCreateUser() {
    return createUser;
  }

  public void setCreateUser(String createUser) {
    this.createUser = createUser;
  }

  public String getCreateUserName() {
    return createUserName;
  }

  public void setCreateUserName(String createUserName) {
    this.createUserName = createUserName;
  }

  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }

  public String getModifyUser() {
    return modifyUser;
  }

  public void setModifyUser(String modifyUser) {
    this.modifyUser = modifyUser;
  }

  public String getModifyUserName() {
    return modifyUserName;
  }

  public void setModifyUserName(String modifyUserName) {
    this.modifyUserName = modifyUserName;
  }

  public String getModifyTime() {
    return modifyTime;
  }

  public void setModifyTime(String modifyTime) {
    this.modifyTime = modifyTime;
  }

//  public Map getEtc() {
//    return etc;
//  }
//
//  public void setEtc(Map etc) {
//    this.etc = etc;
//  }
//
//  private MoreBatis getMoreBatis() {
//    return (MoreBatis) SpringContextHolder.getBean("moreBatis");
//  }
//
//  public T insert() {
//    getMoreBatis().insertEntity((T)this);
//    return (T) this;
//  }
//
//  public T delete() {
//    getMoreBatis().deleteEntity((T)this);
//    return (T) this;
//  }
//
//  public T update() {
//    getMoreBatis().updateEntity((T)this);
//    return (T) this;
//  }
//
//
//  public T selectByPks() {
//    return (T) getMoreBatis().selectEntityByPks((T) this);
//  }


}
