package org.seryu.framework.rbac.client.query;

import lombok.Data;
import lombok.ToString;
import org.seryu.framework.data.page.Page;

/**
 * @program: seryu-framework-security-rbac
 * @description: 部门查询条件
 * @author: xujunjie
 * @create: 2020-04-23 11:55
 */
@Data
@ToString
public class PostDetailQry extends Page {
  private String postName;
}
