package org.seryu.framework.security.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.seryu.framework.data.bo.BaseBo;

import java.util.List;

/**
 * @description: seryu-framework-security
 * @author xujunjie
 * @since 2020-05-06
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SecurityPermissionDetail extends BaseBo {
  private static final long serialVersionUID = 1L;
  @ApiModelProperty(value = "ID", name = "id", dataType = "Long", example = "")
  private Long id;
  @ApiModelProperty(value = "接口名称", name = "name", dataType = "String", example = "")
  private String name;
  @ApiModelProperty(value = "url地址", name = "url", dataType = "String", example = "")
  private String url;
  @ApiModelProperty(value = "接口Key", name = "pKey", dataType = "String", example = "")
  private String pKey;
  @ApiModelProperty(value = "拥有该资源的角色列表", name = "pKey", dataType = "String", example = "")
  private List<SecurityRoleDetail> roles;
}
