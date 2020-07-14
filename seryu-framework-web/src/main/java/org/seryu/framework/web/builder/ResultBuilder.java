package org.seryu.framework.web.builder;

import java.util.Date;
import org.seryu.framework.web.enums.ResultCodeEnum;
import org.seryu.framework.web.result.BaseResult;
import org.seryu.framework.web.result.ResultCodeI;

/**
 * @program: seryu-framework
 * @description: 结果构建
 * @author: xujunjie
 * @create: 2020-04-22 10:28
 */
public class ResultBuilder<T> {
  /**
   * @description: 构建成功结果
   * @return
   */
  public static <T> BaseResult success() {
    return success();
  }

  /**
   * @description: 构建成功结果
   * @param data 成功消息体
   * @return
   */
  public static <T> BaseResult success(T data) {
    BaseResult<T> tBaseResult =
        new BaseResult<>(ResultCodeEnum.SUCCESS, data, String.valueOf(new Date().getTime()));
    return tBaseResult;
  }

  /**
   * @description: 构建成功结果
   * @param data 成功消息体
   * @return T 返回对象
   */
  public static <T> BaseResult success(T data, String msg) {
    BaseResult baseResult =
        new BaseResult(
            ResultCodeEnum.SUCCESS.getCode(), msg, data, String.valueOf(new Date().getTime()));
    return baseResult;
  }

  /**
   * @description: 构建失败结果
   * @param resultCodeEnum 状态枚举
   * @param data 消息体
   * @return T 返回对象
   */
  public static <T> BaseResult error(ResultCodeI resultCodeEnum, T data) {
    BaseResult baseResult = new BaseResult(resultCodeEnum.getCode(), resultCodeEnum.getMsg(), data);
    return baseResult;
  }
}
