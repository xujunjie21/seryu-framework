package org.seryu.framework.rbac.infrastructure.repository.Do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.seryu.framework.db.mybatisPlugs.code.BaseDo;

/**
 * @author xujunjie
 * @since 2020-04-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_menu_detail")
public class MenuDetailDo extends BaseDo {

  private static final long serialVersionUID = 1L;

  @TableId(value = "ID", type = IdType.AUTO)
  private Long id;

  /** 菜单名称 */
  @TableField("MENU_NAME")
  private String menuName;

  /** 父菜单Id */
  @TableField("PARENT_ID")
  private Integer parentId;

  /** 序号 */
  @TableField("ORDER_NUM")
  private Integer orderNum;

  /** url地址 */
  @TableField("URL")
  private String url;

  /** 菜单类型 1、菜单 2、按钮 */
  @TableField("MENU_TYPE")
  private Integer menuType;

  /** 可见性 1、可见 2、隐藏 */
  @TableField("VISIBLE")
  private Integer visible;

  /** 权限标识 */
  @TableField("PERMS")
  private String perms;

  /** 图标 */
  @TableField("ICON")
  private String icon;

  /** 外链: 1、是 2、否 */
  @TableField("IS_FRAME")
  private Integer isFrame;

  /** 组件 */
  @TableField("COMPONENT")
  private String component;

  /** 路由名称 */
  @TableField("ROUTE_NAME")
  private String routeName;

  /** 路由地址 */
  @TableField("ROUTE_PATH")
  private String routePath;

  /** 路由缓存: 1、是 2、否 */
  @TableField("ROUTE_CACHE")
  private Integer routeCache;

  /** 路由组件 */
  @TableField("ROUTE_COMPONENT")
  private String routeComponent;
}
