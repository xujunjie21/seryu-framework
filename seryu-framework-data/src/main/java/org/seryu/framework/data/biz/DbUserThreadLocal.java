package org.seryu.framework.data.biz;

/**
 * @program: seryu-framework
 * @description: 用户信息
 * @author: xujunjie
 * @create: 2020-04-26 17:46
 */
public class DbUserThreadLocal {
  private static final ThreadLocal<UserDbEntiy> userIdThread = new ThreadLocal<>();

  /**
   * @description: 设置用户信息
   * @param UserDbEntiy 用户信息
   */
  public static void setUser(UserDbEntiy UserDbEntiy) {
    userIdThread.set(UserDbEntiy);
  }

  /**
   * @description: 获取用户Id
   * @return string 用户Id
   */
  public static String getUserId() {
    return userIdThread.get().getUserId();
  }

  public static UserDbEntiy getUserDbEntiy() {
    return userIdThread.get();
  }

  /**
   * @description: 获取用户Id
   * @return string 用户名称
   */
  public static String getUserName() {
    return userIdThread.get().getUserName();
  }

  /** @description: 清理用户信息 */
  public static void clear() {
    userIdThread.remove();
  }
}
