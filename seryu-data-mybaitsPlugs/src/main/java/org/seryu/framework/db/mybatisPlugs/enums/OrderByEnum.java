package org.seryu.framework.db.mybatisPlugs.enums;

/**
 * @program: seryu-framework
 * @description: 排序类型
 * @author: xujunjie
 * @create: 2020-05-14 09:30
 */
public enum OrderByEnum {
  ASC("ASC", "降序"),
  DESC("DESC", "升序");

  private String key;

  private String desc;

  OrderByEnum(String key, String desc) {
    this.key = key;
    this.desc = desc;
  }

  public String getKey() {
    return key;
  }

  public String getDesc() {
    return desc;
  }
}
