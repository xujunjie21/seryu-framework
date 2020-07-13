package org.seryu.framework.data.enums;

/**
 * @program: seryu-framework-data
 * @description: 内容变更枚举
 * @author: xujunjie
 * @create: 2020-05-21 09:19
 */
public enum ContentChangeEnum {
  ADD(1, "添加"),
  UPDATE(2, "修改"),
  DELTET(3, "删除"),
  STATUS(4, "状态"),
  CUSTOM(99, "自定义");

  private int type;

  private String desc;

  ContentChangeEnum(int type, String desc) {
    this.type = type;
    this.desc = desc;
  }

  public int getType() {
    return type;
  }

  public String getDesc() {
    return desc;
  }
}
