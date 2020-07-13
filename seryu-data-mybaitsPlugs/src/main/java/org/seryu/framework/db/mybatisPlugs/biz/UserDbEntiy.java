package org.seryu.framework.db.mybatisPlugs.biz;

import lombok.Data;
import lombok.ToString;

/**
 * @program: potato-parent
 * @description: 用户持久层信息
 * @author: xujunjie
 * @create: 2020-06-05 17:26
 */
@Data
@ToString
public class UserDbEntiy {
  private String userId;
  private String userName;

  public UserDbEntiy(String userId, String userName) {
    this.userId = userId;
    this.userName = userName;
  }
}
