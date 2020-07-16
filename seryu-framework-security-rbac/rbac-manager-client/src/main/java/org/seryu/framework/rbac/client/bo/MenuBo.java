package org.seryu.framework.rbac.client.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @program: seryu-framework-security-rbac
 * @description: 菜单信息
 * @author: xujunjie
 * @create: 2020-04-22 16:25
 */
@Data
@ToString
@ApiModel(value = "菜单信息", description = "菜单信息")
public class MenuBo extends BaseBo implements Serializable {
  @ApiModelProperty(value = "菜单Id", name = "id", dataType = "Long", example = "53")
  private Long id;

  @ApiModelProperty(value = "菜单名称", name = "menuName", dataType = "Integer", example = "系统管理")
  private String menuName;

  @ApiModelProperty(value = "父菜单Id", name = "parentId", dataType = "Integer", example = "0")
  private Integer parentId;

  @ApiModelProperty(value = "序号", name = "orderNum", dataType = "Integer", example = "1")
  private Integer orderNum;

  @ApiModelProperty(
      value = "url地址",
      name = "url",
      dataType = "String",
      example = "http://www.google.com")
  private String url;

  @ApiModelProperty(
      value = "菜单类型\n 1、菜单 \n 2、按钮",
      name = "menuType",
      dataType = "Integer",
      example = "1")
  private Integer menuType;

  @ApiModelProperty(
      value = "可见性\n 1、可见 \n 2、隐藏",
      name = "visible",
      dataType = "Integer",
      example = "1")
  private Integer visible;

  @ApiModelProperty(value = "权限标识", name = "perms", dataType = "String", example = "admin:test")
  private String perms;

  @ApiModelProperty(value = "图标", name = "icon", dataType = "String", example = "cog")
  private String icon;

  @ApiModelProperty(
      value = "外链:\n 1、是 \n 2、否",
      name = "isFrame",
      dataType = "Integer",
      example = "1")
  private Integer isFrame;

  @ApiModelProperty(value = "组件", name = "component", dataType = "String", example = "")
  private String component;

  @ApiModelProperty(value = "路由名称", name = "routeName", dataType = "String")
  private String routeName;

  @ApiModelProperty(value = "路由地址", name = "routePath", dataType = "String")
  private String routePath;

  @ApiModelProperty(
      value = "路由缓存:\n 1、是\n 2、否",
      name = "routeCache",
      dataType = "Integer",
      example = "1")
  private Integer routeCache;

  @ApiModelProperty(value = "路由组件", name = "routeComponent", dataType = "String", example = "")
  private String routeComponent;

  @ApiModelProperty(value = "子菜单列表", name = "childrenList", dataType = "MenuBo")
  private List<MenuBo> childrenList;
}
