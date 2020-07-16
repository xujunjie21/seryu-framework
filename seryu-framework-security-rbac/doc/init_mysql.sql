# 初始化表
# Dump of table t_dept_detail
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_dept_detail`;

CREATE TABLE `t_dept_detail` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `PARENT_ID` int(11) DEFAULT NULL COMMENT '部门父Id',
  `ANCESTORS` varchar(500) DEFAULT NULL,
  `DEPT_NAME` varchar(500) DEFAULT NULL COMMENT '部门名称',
  `ORDER_NUM` int(11) DEFAULT NULL COMMENT '排序编号',
  `LEADER` varchar(500) DEFAULT NULL COMMENT '负责人',
  `PHONE` varchar(500) DEFAULT NULL COMMENT '手机号',
  `EMAIL` varchar(500) DEFAULT NULL COMMENT '邮箱',
  `STATUS` varchar(500) DEFAULT NULL COMMENT '状态： 1、激活  2、禁用',
  `REMARK` varchar(500) DEFAULT NULL COMMENT '备注',
  `CREATE_USER_ID` varchar(500) DEFAULT NULL COMMENT '创建者Id',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_USER_ID` varchar(500) DEFAULT NULL COMMENT '更新者Id',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


# Dump of table t_dict_detail
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_dict_detail`;

CREATE TABLE `t_dict_detail` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DICT_NAME` varchar(11) DEFAULT NULL COMMENT '字典名称',
  `DICT_VALUE_TYPE` int(11) DEFAULT NULL COMMENT '字段值类型  1、数字  2、字符',
  `DICT_TYPE` varchar(500) DEFAULT NULL COMMENT '字段标识',
  `STATUS` varchar(500) DEFAULT NULL COMMENT '状态： 1、激活  2、禁用',
  `REMARK` varchar(500) DEFAULT NULL COMMENT '备注',
  `CREATE_USER_ID` varchar(500) DEFAULT NULL COMMENT '创建者Id',
  `CREATE_DATE` varchar(500) DEFAULT NULL COMMENT '创建时间',
  `UPDATE_USER_ID` varchar(500) DEFAULT NULL COMMENT '更新者Id',
  `UPDATE_DATE` varchar(500) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


# Dump of table t_dict_value_detail
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_dict_value_detail`;

CREATE TABLE `t_dict_value_detail` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DICT_ID` int(11) DEFAULT NULL COMMENT '字典Id',
  `DICT_SORT` int(11) DEFAULT NULL COMMENT '字典值排序',
  `DICT_LABEL` varchar(500) DEFAULT NULL COMMENT '字典值名称',
  `DICT_TYPE` varchar(500) DEFAULT NULL COMMENT '字段标识',
  `DICT_VALUE_TYPE` int(11) DEFAULT NULL COMMENT '字段值类型  1、数字  2、字符',
  `DICT_NUMBER` int(11) DEFAULT NULL COMMENT '字段值  1、数字  2、字符',
  `DICT_VALUE` varchar(500) DEFAULT NULL COMMENT '字段值',
  `IS_DEFAULT` int(11) DEFAULT NULL COMMENT '是否默认选中  1、选中  2、未选中',
  `CSS_CLASS` varchar(500) DEFAULT NULL COMMENT '样式类',
  `STATUS` varchar(500) DEFAULT NULL COMMENT '状态： 1、激活  2、禁用',
  `REMARK` varchar(500) DEFAULT NULL COMMENT '备注',
  `CREATE_USER_ID` varchar(500) DEFAULT NULL COMMENT '创建者Id',
  `CREATE_DATE` varchar(500) DEFAULT NULL COMMENT '创建时间',
  `UPDATE_USER_ID` varchar(500) DEFAULT NULL COMMENT '更新者Id',
  `UPDATE_DATE` varchar(500) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table t_menu_detail
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_menu_detail`;

CREATE TABLE `t_menu_detail` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `MENU_NAME` varchar(500) DEFAULT NULL COMMENT '菜单名称',
  `PARENT_ID` bigint(11) DEFAULT NULL COMMENT '父菜单Id',
  `ORDER_NUM` int(11) DEFAULT NULL COMMENT '序号',
  `URL` varchar(500) DEFAULT NULL COMMENT 'url地址',
  `MENU_TYPE` int(11) DEFAULT NULL COMMENT '菜单类型 1、菜单  2、按钮',
  `VISIBLE` int(11) DEFAULT NULL COMMENT '可见性 1、可见  2、隐藏',
  `PERMS` varchar(500) DEFAULT NULL COMMENT '权限标识',
  `ICON` varchar(500) DEFAULT NULL COMMENT '图标',
  `IS_FRAME` int(11) DEFAULT NULL COMMENT '外链: 1、是  2、否',
  `COMPONENT` varchar(500) DEFAULT NULL COMMENT '组件',
  `ROUTE_NAME` varchar(500) DEFAULT NULL COMMENT '路由名称',
  `ROUTE_PATH` varchar(500) DEFAULT NULL COMMENT '路由地址',
  `ROUTE_CACHE` int(11) DEFAULT NULL COMMENT '路由缓存: 1、是 2、否',
  `ROUTE_COMPONENT` varchar(500) DEFAULT NULL COMMENT '路由组件',
  `REMARK` varchar(500) DEFAULT NULL COMMENT '备注',
  `CREATE_USER_ID` varchar(500) DEFAULT NULL COMMENT '创建者Id',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_USER_ID` varchar(500) DEFAULT NULL COMMENT '更新者Id',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table t_menu_permission
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_menu_permission`;

CREATE TABLE `t_menu_permission` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `m_id` bigint(200) DEFAULT NULL COMMENT '菜单Id',
  `p_id` bigint(200) DEFAULT NULL COMMENT '接口Id',
  `CREATE_USER_ID` varchar(500) DEFAULT NULL COMMENT '创建者Id',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_USER_ID` varchar(500) DEFAULT NULL COMMENT '更新者Id',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table t_permission_detail
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_permission_detail`;

CREATE TABLE `t_permission_detail` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(200) DEFAULT NULL COMMENT '接口名称',
  `URL` varchar(200) DEFAULT NULL COMMENT 'url地址',
  `p_key` varchar(200) DEFAULT NULL COMMENT '接口Key',
  `REMARK` varchar(500) DEFAULT NULL COMMENT '备注',
  `CREATE_USER_ID` varchar(500) DEFAULT NULL COMMENT '创建者Id',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_USER_ID` varchar(500) DEFAULT NULL COMMENT '更新者Id',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table t_post_detail
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_post_detail`;

CREATE TABLE `t_post_detail` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `POST_NAME` varchar(500) DEFAULT NULL COMMENT '岗位名称',
  `REMARK` varchar(500) DEFAULT NULL COMMENT '备注',
  `CREATE_USER_ID` varchar(500) DEFAULT NULL COMMENT '创建者Id',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_USER_ID` varchar(500) DEFAULT NULL COMMENT '更新者Id',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table t_role_detail
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_role_detail`;

CREATE TABLE `t_role_detail` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ROLE_NAME` varchar(50) DEFAULT NULL COMMENT '角色名称',
  `ROLE_KEY` varchar(200) DEFAULT NULL,
  `REMARK` varchar(500) DEFAULT NULL COMMENT '备注',
  `CREATE_USER_ID` varchar(500) DEFAULT NULL COMMENT '创建者Id',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_USER_ID` varchar(500) DEFAULT NULL COMMENT '更新者Id',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table t_role_menu
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_role_menu`;

CREATE TABLE `t_role_menu` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `r_id` bigint(200) DEFAULT NULL COMMENT '角色Id',
  `m_id` bigint(200) DEFAULT NULL COMMENT '菜单Id',
  `REMARK` varchar(400) DEFAULT NULL,
  `CREATE_USER_ID` varchar(20) DEFAULT NULL COMMENT '创建者Id',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_USER_ID` varchar(20) DEFAULT NULL COMMENT '更新者Id',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table t_user_detail
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_user_detail`;

CREATE TABLE `t_user_detail` (
  `ID` varchar(500) NOT NULL DEFAULT '',
  `NICKNAME` varchar(500) DEFAULT NULL COMMENT '用户昵称',
  `USER_NAME` varchar(500) DEFAULT NULL COMMENT '用户名称',
  `USER_TYPE` int(11) DEFAULT NULL COMMENT '用户类型',
  `EMAIL` varchar(500) DEFAULT NULL COMMENT '邮箱',
  `PHONE` varchar(500) DEFAULT NULL COMMENT '座机号',
  `PHONE_NUMBER` varchar(500) DEFAULT NULL COMMENT '手机号',
  `SEX` int(11) DEFAULT NULL COMMENT '性别: 1、男  2、女  0、未知',
  `AVATAR` varchar(500) DEFAULT NULL COMMENT '头像',
  `PASSWORD` varchar(500) DEFAULT NULL COMMENT '密码',
  `SALT` varchar(500) DEFAULT NULL COMMENT '密码盐',
  `STATUS` int(11) DEFAULT NULL COMMENT '用户状态  1、激活  2、禁用',
  `DEPT_ID` int(11) DEFAULT NULL COMMENT '部门Id',
  `LOGIN_IP` varchar(500) DEFAULT NULL COMMENT '最近一次登录IP',
  `LOGIN_DATE` varchar(500) DEFAULT NULL COMMENT '最近一次登录时间',
  `USER_POST` varchar(500) DEFAULT NULL COMMENT '岗位Ids（逗号分割）',
  `USER_ROLE` varchar(500) DEFAULT NULL COMMENT '角色Ids（逗号分割）',
  `REMARK` varchar(500) DEFAULT NULL COMMENT '备注',
  `CREATE_USER_ID` varchar(500) DEFAULT NULL COMMENT '创建者Id',
  `CREATE_DATE` varchar(500) DEFAULT NULL COMMENT '创建时间',
  `UPDATE_USER_ID` varchar(500) DEFAULT NULL COMMENT '更新者Id',
  `UPDATE_DATE` varchar(500) DEFAULT NULL COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


