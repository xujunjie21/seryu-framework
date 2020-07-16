package org.seryu.framework.security.service;

import org.seryu.framework.data.enums.StatusEnum;
import org.seryu.framework.security.SecurityRoleService;
import org.seryu.framework.security.SecurityUserService;
import org.seryu.framework.security.bo.SecurityRoleDetail;
import org.seryu.framework.security.bo.SecurityUserDetail;
import org.seryu.framework.security.dto.JwtUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: seryu-framework-security
 * @description: 用户认证业务方法
 * @author: xujunjie
 * @create: 2020-04-08 17:06
 */
@Service("userDetailsService")
public class UserDetailsBiz implements UserDetailsService {
  @Autowired private SecurityUserService userServiceQryI;

  @Autowired private SecurityRoleService roleServiceQryI;

  @Override
  public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    return createJwtUser(userServiceQryI.infoByUser(userName));
  }

  private UserDetails createJwtUser(SecurityUserDetail userDetailBo) {
    JwtUserDto jwtUserDto = new JwtUserDto();
    jwtUserDto.setId(userDetailBo.getId());
    jwtUserDto.setUsername(userDetailBo.getUserName());
    jwtUserDto.setNickName(userDetailBo.getNickname());
    jwtUserDto.setSex(userDetailBo.getSex() + "");
    jwtUserDto.setPassword(userDetailBo.getPassword());
    jwtUserDto.setAvatar(userDetailBo.getAvatar());
    jwtUserDto.setEmail(userDetailBo.getEmail());
    jwtUserDto.setPhone(userDetailBo.getPhoneNumber());
    jwtUserDto.setDept(userDetailBo.getDeptId() + "");
    jwtUserDto.setLastPasswordResetDate(userDetailBo.getLoginDate());
    jwtUserDto.setEnabled(userDetailBo.getStatus() == StatusEnum.ENABLE.getCode());

    List<GrantedAuthority> grantedAuthorities = new ArrayList();
    List<String> list = Arrays.asList(userDetailBo.getUserRole().split(","));
    list.forEach(
        rid -> {
          SecurityRoleDetail bo = roleServiceQryI.infoById(Long.valueOf(rid));
          GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(bo.getRoleKey());
          grantedAuthorities.add(grantedAuthority);
        });
    jwtUserDto.setAuthorities(grantedAuthorities);

    return jwtUserDto;
  }
}
