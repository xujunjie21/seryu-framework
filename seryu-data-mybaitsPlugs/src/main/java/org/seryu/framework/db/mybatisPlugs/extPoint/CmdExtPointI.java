package org.seryu.framework.db.mybatisPlugs.extPoint;

/**
 * @program: seryu-framework
 * @description: 数据库增删改扩展点
 * @author: xujunjie
 * @create: 2020-05-06 15:26
 */
public interface CmdExtPointI<T> {
  default T savePoint(T entity) {
    return entity;
  }

  default T updatePoint(T entity) {
    return entity;
  }
}
