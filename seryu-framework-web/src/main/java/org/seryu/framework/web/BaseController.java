package org.seryu.framework.web;

import lombok.extern.slf4j.Slf4j;
import org.seryu.framework.web.builder.ResultBuilder;
import org.seryu.framework.web.result.BaseResult;
import org.seryu.framework.web.result.ResultCodeI;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @program: seryu-framework
 * @description: 基础Controller层
 * @author: xujunjie
 * @create: 2020-04-22 10:52
 */
@Slf4j
public class BaseController {
  /**
   * 成功
   *
   * @return
   */
  public BaseResult success() {
    return success(false);
  }

  /**
   * 成功
   *
   * @param data
   * @param <T>
   * @return
   */
  public <T> BaseResult<T> success(T data) {
    BaseResult success = ResultBuilder.success(data);
    printViewLog(success);
    return success;
  }

  /**
   * 成功
   *
   * @param data
   * @param <T>
   * @return
   */
  public <T> BaseResult<T> success(T data, String msg) {
    BaseResult success = ResultBuilder.success(data, msg);
    printViewLog(success);
    return success;
  }

  /**
   * 失败
   *
   * @param resultCodeEnum
   * @param data
   * @param <T>
   * @return
   */
  public <T> BaseResult<T> error(ResultCodeI resultCodeEnum, T data) {
    BaseResult error = ResultBuilder.error(resultCodeEnum, data);
    printViewLog(error);
    return error;
  }

  /** 打印请求日志 */
  private <T> void printViewLog(T data) {
    if (null != RequestContextHolder.getRequestAttributes()) {
      ServletRequestAttributes servletRequestAttributes =
          ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes());
      String path = servletRequestAttributes.getRequest().getServletPath();

      StringBuffer logStr = new StringBuffer();
      logStr.append(
          "\n ==================================================================================== \n");
      logStr.append("|请求地址 |");
      logStr.append(path + "\n");
      logStr.append("|请求体   |");
      //            logStr.append(readBody(servletRequestAttributes.getRequest()));
      logStr.append("|请响应   |");
      logStr.append(data + "\n");
      logStr.append(
          "====================================================================================");
      log.info(logStr.toString());
    }
  }

  public String readBody(HttpServletRequest request) {

    BufferedReader br = null;
    StringBuilder sb = new StringBuilder("");
    try {
      br = request.getReader();
      String str;
      while ((str = br.readLine()) != null) {
        sb.append(str);
      }
      br.close();
    } catch (IOException e) {
      log.error("读取body异常", request.getServletPath());
    } finally {
      if (null != br) {
        try {
          br.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return sb.toString();
  }
}
