package org.seryu.framework.rbac.infrastructure.gateway;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.seryu.framework.data.util.StringUtil;
import org.seryu.framework.rbac.domain.dto.UserDetailDto;
import org.seryu.framework.rbac.domain.exception.RbacDomainCode;
import org.seryu.framework.rbac.domain.exception.RbacDomainException;
import org.seryu.framework.rbac.domain.gateway.UserDetailGateway;
import org.seryu.framework.rbac.infrastructure.repository.Do.UserDetailDo;
import org.seryu.framework.rbac.infrastructure.repository.UserDetailRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @program: seryu-framework-security-rbac
 * @description: 用户相关操作
 * @author: xujunjie
 * @create: 2020-05-18 15:05
 */
@Slf4j
@Service
public class UserDetailGatewayImpl extends UserDetailRepository implements UserDetailGateway {
  @Override
  public void updatePwd(String userId, String oldPwd, String newPwd) {
    UserDetailDto info = this.getById(userId);
    if (StringUtils.pathEquals(info.getPassword(), pwd(oldPwd, info.getSalt()))) {
      updatePwd(info, newPwd);
    } else {
      log.error("用户密码和原密码不一致");
      throw new RbacDomainException(RbacDomainCode.UPDATE_PWD_FAIL, "用户密码和原密码不一致");
    }
  }

  @Override
  public void updatePwdAdmin(String userId, String newPwd) {
    updatePwd(this.getById(userId), newPwd);
  }

  private void updatePwd(UserDetailDto info, String newPwd) {
    if (null != info && !StringUtil.isEmpty(info.getId())) {
      LambdaQueryWrapper<UserDetailDo> wapper = new LambdaQueryWrapper<>();
      wapper.eq(UserDetailDo::getId, info.getId());
      UserDetailDo userDetailDo = new UserDetailDo();
      userDetailDo.setPassword(pwd(newPwd, info.getSalt()));
      this.getBaseMapper().update(userDetailDo, wapper);
    }
  }
}
