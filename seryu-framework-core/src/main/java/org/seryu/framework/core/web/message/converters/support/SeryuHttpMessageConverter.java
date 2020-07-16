package org.seryu.framework.core.web.message.converters.support;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: seryu-framework-core
 * @description: 动态参数转换器
 * @author: xujunjie
 * @create: 2020-07-09 11:55
 */
public class SeryuHttpMessageConverter implements HttpMessageConverter {
  private Map<String, String> packageAndConverterMap = new TreeMap<>();

  private Map<String, HttpMessageConverter> converterMap = new ConcurrentHashMap();

  private List<MediaType> mediaTypes = new ArrayList<>();

  public SeryuHttpMessageConverter() {}

  public SeryuHttpMessageConverter(MessageConverterParm... messageConverterParms) {
    createRule(Arrays.asList(messageConverterParms));
  }

  protected void createRule(List<MessageConverterParm> messageConverterParms) {
    messageConverterParms.forEach(
        info -> {
          String className = info.getHttpMessageConverter().getClass().getName();
          // 添加容器
          if (null == converterMap.get(className)) {
            converterMap.put(className, info.getHttpMessageConverter());
          }

          // 添加路由地址
          if (!CollectionUtils.isEmpty(info.getPackages())) {
            info.getPackages().forEach(pack -> packageAndConverterMap.put(pack, className));
          }

          // 添加所有支持类型
          mediaTypes.addAll(info.getHttpMessageConverter().getSupportedMediaTypes());
        });
  }

  @Override
  public boolean canRead(Class clazz, MediaType mediaType) {
    HttpMessageConverter httpMessageConverter =
        findHttpMessageConverter(HttpMessageConverterThreadLocal.get());
    if (null == httpMessageConverter) {
      return false;
    } else {
      return httpMessageConverter.canRead(clazz, mediaType);
    }
  }

  @Override
  public boolean canWrite(Class clazz, MediaType mediaType) {
    HttpMessageConverter httpMessageConverter =
        findHttpMessageConverter(HttpMessageConverterThreadLocal.get());
    if (null == httpMessageConverter) {
      return false;
    } else {
      return httpMessageConverter.canWrite(clazz, mediaType);
    }
  }

  @Override
  public List<MediaType> getSupportedMediaTypes() {
    return mediaTypes;
  }

  @Override
  public Object read(Class clazz, HttpInputMessage inputMessage)
      throws IOException, HttpMessageNotReadableException {

    HttpMessageConverter httpMessageConverter =
        findHttpMessageConverter(HttpMessageConverterThreadLocal.get());
    if (null == httpMessageConverter) {
      return null;
    } else {
      return httpMessageConverter.read(clazz, inputMessage);
    }
  }

  @Override
  public void write(Object o, MediaType contentType, HttpOutputMessage outputMessage)
      throws IOException, HttpMessageNotWritableException {
    HttpMessageConverter httpMessageConverter =
        findHttpMessageConverter(HttpMessageConverterThreadLocal.get());
    if (null != httpMessageConverter) {
      httpMessageConverter.write(o, contentType, outputMessage);
    }
  }

  /**
   * 查找对应消息转换器 (替换规则使用最后的)
   *
   * @param uri
   * @return
   */
  private HttpMessageConverter findHttpMessageConverter(String uri) {
    HttpMessageConverter httpMessageConverter = null;
    for (Map.Entry<String, String> entry : packageAndConverterMap.entrySet()) {
      if (uri.indexOf(entry.getKey()) >= 0) {
        httpMessageConverter = converterMap.get(packageAndConverterMap.get(entry.getKey()));
      }
    }
    return httpMessageConverter;
  }
}
