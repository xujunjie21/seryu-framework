package org.seryu.framework.rbac.domain.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.seryu.framework.data.dto.BaseDto;

/**
 * @program: seryu-framework-security-rbac
 * @description: 领域模型
 * @author xujunjie
 * @since 2020-04-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class MenuDetailDto extends BaseDto {

  private static final long serialVersionUID = 1L;

  private Long id;

  /** 菜单名称 */
  private String menuName;

  /** 父菜单Id */
  private Integer parentId;

  /** 序号 */
  private Integer orderNum;

  /** url地址 */
  private String url;

  /** 菜单类型 1、菜单 2、按钮 */
  private Integer menuType;

  /** 可见性 1、可见 2、隐藏 */
  private Integer visible;

  /** 权限标识 */
  private String perms;

  /** 图标 */
  private String icon;

  /** 外链: 1、是 2、否 */
  private Integer isFrame;

  /** 组件 */
  private String component;

  /** 路由名称 */
  private String routeName;

  /** 路由地址 */
  private String routePath;

  /** 路由缓存: 1、是 2、否 */
  private Integer routeCache;

  /** 路由组件 */
  private String routeComponent;
}
