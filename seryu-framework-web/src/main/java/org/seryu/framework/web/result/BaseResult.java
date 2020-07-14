package org.seryu.framework.web.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.seryu.framework.web.enums.ResultCodeEnum;

import java.util.Date;

/**
 * @program: seryu-framework
 * @description: 定义返回结果
 * @author: xujunjie
 * @create: 2020-04-22 10:10
 */
@Data
@ToString
@ApiModel(value = "BaseResult", description = "返回结果")
public class BaseResult<T> {
  @ApiModelProperty(value = "返回码", name = "code", dataType = "String", example = "0")
  private String code;

  @ApiModelProperty(value = "返回消息体", name = "msg", dataType = "String", example = "成功")
  private String msg;

  @ApiModelProperty(value = "返回对象", name = "data", dataType = "Object", example = "")
  private T data;

  @ApiModelProperty(
      value = "返回时间戳",
      name = "timestamp",
      dataType = "String",
      example = "1587465193")
  private String timestamp;

  public BaseResult() {
  }

  public BaseResult(String code, String msg, T data, String timestamp) {
    this.code = code;
    this.msg = msg;
    this.data = data;
    this.timestamp = timestamp;
  }

  public BaseResult(ResultCodeEnum code, T data, String timestamp) {
    this(code.getCode(), code.getMsg(), data, timestamp);
  }

  public BaseResult(ResultCodeEnum code, T data) {
    this(code.getCode(), code.getMsg(), data, String.valueOf(new Date().getTime()));
  }

  public BaseResult(String code, String msg, T data) {
    this(code, msg, data, String.valueOf(new Date().getTime()));
  }
}
