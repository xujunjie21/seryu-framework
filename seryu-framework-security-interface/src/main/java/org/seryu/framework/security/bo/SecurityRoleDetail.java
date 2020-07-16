package org.seryu.framework.security.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.seryu.framework.data.bo.BaseBo;

import java.io.Serializable;

/**
 * @program: seryu-framework-security
 * @description: 角色信息
 * @author: xujunjie
 * @create: 2020-04-23 13:25
 */
@Data
@ToString
@ApiModel(value = "角色信息", description = "角色信息")
public class SecurityRoleDetail extends BaseBo implements Serializable {
  @ApiModelProperty(value = "角色Id", name = "id", dataType = "Integer", example = "8")
  private Long id;
  @ApiModelProperty(value = "角色名称", name = "roleName", dataType = "String", example = "")
  private String roleName;
  @ApiModelProperty(value = "权限字符", name = "roleKey", dataType = "String", example = "")
  private String roleKey;
  @ApiModelProperty(value = "角色对应菜单", name = "roleMenu", dataType = "String", example = "1,2,3,5")
  private String roleMenu;
}
