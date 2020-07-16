package org.seryu.framework.rbac.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.seryu.framework.data.page.PageData;
import org.seryu.framework.rbac.client.api.cmd.UserLoginServiceCmdI;
import org.seryu.framework.rbac.client.api.cmd.UserServiceCmdI;
import org.seryu.framework.rbac.client.api.qry.UserServiceQryI;
import org.seryu.framework.rbac.client.bo.*;
import org.seryu.framework.rbac.client.query.UpdatePwdQry;
import org.seryu.framework.security.dto.JwtUserDto;
import org.seryu.framework.security.dto.UserDto;
import org.seryu.framework.security.token.TokenProvider;
import org.seryu.framework.web.BaseController;
import org.seryu.framework.web.result.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: seryu-framework-security-rbac
 * @description: 用户相关
 * @author: xujunjie
 * @create: 2020-04-22 11:43
 */
@Slf4j
@Api(tags = "用户", value = "/admin/user", description = "用户相关接口")
@RestController
@RequestMapping("/admin/user")
public class UserController extends BaseController {
  private static final String TAG_NAME = "用户";

  @Autowired private UserLoginServiceCmdI userLogInServiceI;
  @Autowired private UserServiceQryI userServiceQryI;
  @Autowired private UserServiceCmdI userServiceCmdI;

  @Autowired private AuthenticationManagerBuilder authenticationManagerBuilder;
  @Autowired private TokenProvider tokenProvider;

  @ApiOperation(
      value = "用户登录",
      notes = "用户登录接口",
      httpMethod = "POST",
      tags = TAG_NAME,
      response = LoginDetailBo.class)
  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public BaseResult<LoginDetailBo> login(@RequestBody LoginBo loginDto) {

    UsernamePasswordAuthenticationToken authenticationToken =
        new UsernamePasswordAuthenticationToken(loginDto.getUserName(), loginDto.getPassword());
    Authentication authenticate =
        authenticationManagerBuilder.getObject().authenticate(authenticationToken);
    SecurityContextHolder.getContext().setAuthentication(authenticate);
    String token = tokenProvider.createToken(authenticate);

    JwtUserDto jwtUserDto = (JwtUserDto) authenticate.getPrincipal();
    LoginDetailBo loginDetailBo = new LoginDetailBo();
    loginDetailBo.setToken(token);
    loginDetailBo.setUserId(jwtUserDto.getId());
    loginDetailBo.setNickname(jwtUserDto.getNickName());
    loginDetailBo.setUserName(jwtUserDto.getUsername());
    return success(loginDetailBo);
  }

  @ApiOperation(
      value = "用户登出",
      notes = "用户登出接口",
      httpMethod = "POST",
      tags = TAG_NAME,
      response = BaseResult.class)
  @RequestMapping(value = "/logout", method = RequestMethod.POST)
  public BaseResult logout() {
    userLogInServiceI.logout(new LogoutBo("123"));
    return success();
  }

  @ApiOperation(
      value = "验证token",
      notes = "验证token",
      httpMethod = "POST",
      tags = TAG_NAME,
      response = CheckTokenBo.class)
  @RequestMapping(value = "/check_token", method = RequestMethod.POST)
  public BaseResult<CheckTokenBo> checkToken() {
    //        return error(ResultCodeEnum.AUTH_FAIL,null);
    return success(userLogInServiceI.checkToken(""));
  }

  /**
   * 查询用户列表
   *
   * @param query 用户信息查询条件
   * @return BaseResult
   */
  @ApiOperation(
      value = "查询用户列表",
      notes = "查询用户列表",
      httpMethod = "POST",
      tags = TAG_NAME,
      response = UserDetailQry.class)
  @RequestMapping(value = "/index", method = RequestMethod.POST)
  public BaseResult<PageData<UserDetailBo>> page(@RequestBody UserDetailQry query) {
    return success(userServiceQryI.page(query));
  }

  /**
   * 创建用户
   *
   * @param info
   * @return
   */
  @ApiOperation(
      value = "创建用户",
      notes = "创建用户",
      httpMethod = "PUT",
      tags = TAG_NAME,
      response = BaseResult.class)
  @RequestMapping(value = "/create", method = RequestMethod.PUT)
  public BaseResult create(@RequestBody UserDetailBo info) {
    userServiceCmdI.create(info);
    return success();
  }

  /**
   * 查看用户
   *
   * @param info
   * @return
   */
  @ApiOperation(
      value = "查询用户",
      notes = "查询用户",
      httpMethod = "POST",
      tags = TAG_NAME,
      response = UserDetailBo.class)
  @RequestMapping(value = "/info", method = RequestMethod.POST)
  public BaseResult<UserDetailBo> info(@RequestBody UserDetailBo info) {
    return success(userServiceQryI.infoById(info.getId()));
  }

  /**
   * 更新用户
   *
   * @param info
   * @return
   */
  @ApiOperation(
      value = "更新用户",
      notes = "更新用户",
      httpMethod = "PUT",
      tags = TAG_NAME,
      response = BaseResult.class)
  @RequestMapping(value = "/update", method = RequestMethod.PUT)
  public BaseResult update(@RequestBody UserDetailBo info) {
    userServiceCmdI.updateById(info);
    return success();
  }

  /**
   * 删除用户
   *
   * @param info
   * @return
   */
  @ApiOperation(
      value = "删除用户",
      notes = "删除用户",
      httpMethod = "DELETE",
      tags = TAG_NAME,
      response = BaseResult.class)
  @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
  public BaseResult delete(@RequestBody UserDetailBo info) {
    userServiceCmdI.deleteById(info.getId());
    return success();
  }

  /**
   * 修改密码
   *
   * @param query 修改密码
   * @return BaseResult
   */
  @ApiOperation(
      value = "修改密码",
      notes = "查询用户列表",
      httpMethod = "PUT",
      tags = TAG_NAME,
      response = UserDetailBo.class)
  @RequestMapping(value = "/updatePwd", method = RequestMethod.PUT)
  public BaseResult<PageData<UserDetailBo>> page(@RequestBody UpdatePwdQry query) {
    UserDto userDto =
        (UserDto) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    userServiceCmdI.updatePwd(userDto.getId(), query.getOldPwd(), query.getNewPwd());
    return success();
  }
}
