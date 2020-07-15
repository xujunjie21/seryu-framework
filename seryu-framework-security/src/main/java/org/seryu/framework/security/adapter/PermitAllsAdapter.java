package org.seryu.framework.security.adapter;

import java.util.List;
import org.seryu.framework.security.dto.PermitAllsDto;

/**
 * @program: seryu-framework-security
 * @description: 静态资源适配器
 * @author: xujunjie
 * @create: 2020-04-08 16:01
 */
public interface PermitAllsAdapter {
  /**
   * @description: 获取静态资源
   * @return 资源列表
   */
  List<PermitAllsDto> get();
}
