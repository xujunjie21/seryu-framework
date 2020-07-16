package org.seryu.framework.core.web.message.converters.support;

/**
 * @program: seryu-framework-core
 * @description:
 * @author: xujunjie
 * @create: 2020-07-09 15:08
 */
public class HttpMessageConverterThreadLocal {
  private static ThreadLocal<String> uri = new ThreadLocal<>();

  public static String get() {
    return uri.get();
  }

  public static void set(String uriStr) {
    uri.set(uriStr);
  }
}
