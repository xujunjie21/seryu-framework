package org.seryu.framework.data.util;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: seryu-framework
 * @description: 工具类
 * @author: xujunjie
 * @create: 2020-04-23 10:07
 */
@Slf4j
public class CommonUtil {

  // =========================== 号码验证 =============================

  /**
   * 判断是否电信号码
   *
   * @param cellPhoneNr
   * @return
   */
  public static boolean bolChinaMobile(String cellPhoneNr) {

    if (checkCellPhone(cellPhoneNr)) {
      List<String> chinaUnicom = Arrays.asList(new String[] {"133", "153", "180", "181", "189"});

      String mms = cellPhoneNr.substring(0, 3);
      return (chinaUnicom.contains(mms));
    }
    return false;
  }

  /** 手机号码验证,11位，不知道详细的手机号码段，只是验证开头必须是1和位数 */
  public static boolean checkCellPhone(String cellPhoneNr) {
    // String reg = "^[1][\\d]{10}$";
    String reg = "^1[0|3|4|5|6|7|8|9][0-9]{9}$";
    return startCheck(reg, cellPhoneNr);
  }

  /**
   * @param @param password
   * @return boolean 返回类型 @Title: checkPassword @Description: 密码长度6-16个字符，必须由数字、小写字母、大写字母组合。
   */
  public static boolean checkPassword(String password) {
    String reg = "^[A-Za-z0-9]{6,16}$";
    return startCheck(reg, password);
  }

  private static boolean startCheck(String reg, String string) {
    boolean tem = false;

    Pattern pattern = Pattern.compile(reg);
    Matcher matcher = pattern.matcher(string);

    tem = matcher.matches();
    return tem;
  }

  // ===================== 号码验证 END =================

  /**
   * 获取类实例的属性值
   *
   * @param clazz 类名
   * @param includeParentClass 是否包括父类的属性值
   * @return 类名.属性名=属性类型
   */
  public static Map<String, Class> getClassFields(Class clazz, boolean includeParentClass) {
    Map<String, Class> map = new HashMap<String, Class>();
    Field[] fields = clazz.getDeclaredFields();
    for (Field field : fields) {
      map.put(field.getName(), field.getType());
    }
    if (includeParentClass) getParentClassFields(map, clazz.getSuperclass());
    return map;
  }

  /**
   * 获取类实例的父类的属性值
   *
   * @param map 类实例的属性值Map
   * @param clazz 类名
   * @return 类名.属性名=属性类型
   */
  private static Map<String, Class> getParentClassFields(Map<String, Class> map, Class clazz) {
    Field[] fields = clazz.getDeclaredFields();
    for (Field field : fields) {
      map.put(field.getName(), field.getType());
    }
    if (clazz.getSuperclass() == null) {
      return map;
    }
    getParentClassFields(map, clazz.getSuperclass());
    return map;
  }
}
