package org.seryu.framework.data.util;

import java.math.BigDecimal;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @program: seryu-framework
 * @description: 字符串工具类
 * @author: xujunjie
 * @create: 2020-04-23 10:07
 */
@Slf4j
public abstract class StringUtil {

  public static String getUUID() {
    return UUID.randomUUID().toString().replace("-", "");
  }

  /**
   * @Title: splice @Description: 将整数数组使用指定的分隔符拼接成字符串。
   *
   * @param arr 整数数组
   * @param sp 分隔符
   * @return String 整数数组拼接后的字符串
   */
  public static String splice(String[] arr, char sp) {
    if (arr == null || arr.length == 0) {
      return "";
    }
    StringBuilder buff = new StringBuilder(arr.length * 2);

    for (int i = 0, len = arr.length; i < len; i++) {
      buff.append(arr[i]);
      if (i < len - 1) {
        buff.append(sp);
      }
    }
    return buff.toString();
  }

  public static String emptyIfNull(String input) {
    return input == null ? "" : input;
  }

  /**
   * @Title: truncate @Description: 按照指定长度截断字符串
   *
   * @param input 入参字符串
   * @param len 期望的字符串长度
   * @return String 指定长度截断字符串
   */
  public static String truncate(String input, int len) {
    if (input == null || input.equals("")) {
      return input;
    }
    return input.length() > len ? input.substring(0, len) : input;
  }

  /**
   * @Title: lenInRange @Description: 判断入参字符串的长度是否在[min, max]区间范围内。
   *
   * @param input 待判断的入参字符串
   * @param min 区间下限
   * @param max 区间上限
   * @return boolean 若入参字符串的长度处于[min, max]区间范围内返回true，反之为false。
   */
  public static boolean lenInRange(String input, int min, int max) {
    if (input == null) {
      return false;
    }
    int len = input.length();
    return len >= min && len <= max;
  }

  /**
   * 判断字符串是否为空
   *
   * @param str 字符串
   * @return boolean
   */
  public static boolean isEmpty(String str) {
      return null == str || str.equals("");
  }

  public static String toView(String str) {
    if (str == null) {
      return "";
    }
    return str;
  }

  public static String trim(String str) {
    if (null == str) {
      str = "";
    }

    return str.trim();
  }

  public static String trim(Object str) {
    if (null == str) {
      str = "";
    }

    return trim(str.toString());
  }

  /**
   * 判断字符是否匹配多个字符串中的任意一个
   *
   * @param src 字符串
   * @param matchs 规则
   * @return boolean
   */
  public static boolean matchs(String src, String[] matchs) {
    if (isEmpty(src) || null == matchs || matchs.length == 0) {
      return false;
    } else if (Arrays.asList(matchs).contains(src)) {
      return true;
    }
    return false;
  }

  /**
   * 字符串转换为整形值,异常时使用默认值
   *
   * @param src 字符串
   * @param defaultValue 默认值
   * @return
   */
  public static int toIntDefValue(String src, int defaultValue) {
    int intValue = 0;
    try {
      intValue = Integer.parseInt(src);
    } catch (NumberFormatException e) {
      return defaultValue;
    }
    return intValue;
  }

  public static float toFloatDefValue(String src, float defaultValue) {
    try {
      float intValue = Float.parseFloat(src);
      return intValue;
    } catch (NumberFormatException e) {
      return defaultValue;
    }
  }

  /**
   * 字符串转换为长整形值,异常时使用默认值
   *
   * @param src 字符串
   * @param defaultValue 默认值
   * @return
   */
  public static Long toLongDefValue(String src, Long defaultValue) {
    Long intValue = 0l;
    try {
      intValue = Long.parseLong(src);
    } catch (NumberFormatException e) {
      return defaultValue;
    }
    return intValue;
  }

  public static Double toDoubleDefValue(String src, Double defaultValue) {
    Double dvalue = 0d;
    try {
      dvalue = Double.parseDouble(src);
    } catch (NumberFormatException e) {
      return defaultValue;
    }
    return dvalue;
  }

  public static Double toDoubleWithExeption(String src) {
    Double dvalue = 0d;
    try {
      dvalue = Double.parseDouble(src);
    } catch (NumberFormatException e) {
      throw e;
    }
    return dvalue;
  }

  /**
   * 字符串转换为整形值,异常时抛出异常
   *
   * @param src
   * @return
   */
  public static int toIntWithException(String src) {
    int intValue = 0;
    try {
      intValue = Integer.parseInt(src);
    } catch (NumberFormatException e) {
      throw e;
    }
    return intValue;
  }

  public static float toFloatWithException(String src) {
    try {
      float intValue = Float.parseFloat(src);
      return intValue;
    } catch (NumberFormatException e) {
      throw e;
    }
  }

  /**
   * 字符串转换为长整形值,异常时抛出异常
   *
   * @param src
   * @return
   */
  public static Long toLongWithException(String src) {
    Long intValue = 0l;
    try {
      intValue = Long.parseLong(src);

    } catch (NumberFormatException e) {
      throw e;
    }
    return intValue;
  }

  /**
   * 正则校验
   *
   * @param str
   * @param pattern
   * @return
   */
  public static boolean regix(String str, String pattern) {
    Pattern p = Pattern.compile(pattern);
    Matcher m = p.matcher(str);
    return m.matches();
  }

  /**
   * 比较整形数值与字符串是否相等
   *
   * @param a
   * @param b
   * @return
   */
  public static boolean isEq(int a, String b) {
    if (null == b) {
      return false;
    }
    return String.valueOf(a).equals(b);
  }

  /**
   * 比较两个字符串是否相等
   *
   * @param a
   * @param b
   * @return
   */
  public static boolean isEq(String a, String b) {
    if (null == a || null == b) {
      return false;
    }
    return a.equals(b);
  }

  public static String subStr(String str, int length, int isEnd) {
    String resultStr = "";
    char[] ch = str.toCharArray();
    int count = ch.length;
    for (int i = 0; i < count; i++) {
      resultStr += ch[i];
      if (isEnd == 1) {
        if (resultStr.getBytes().length >= length - 3) {
          resultStr += "...";
          break;
        }
      } else {
        if (resultStr.getBytes().length >= length) {
          break;
        }
      }
    }
    return resultStr;
  }

  /**
   * 对字符串进行base64编码
   *
   * @param str
   * @return
   */
  // public static String base64Encode(String str)
  // {
  // BASE64Encoder encode = new BASE64Encoder();
  // return encode.encodeBuffer(str.getBytes());
  // }

  /**
   * 对字符串进行base64解码
   *
   * @param str
   * @return
   * @throws IOException
   */
  // public static String base64Decode(String str) throws IOException
  // {
  // BASE64Decoder decode = new BASE64Decoder();
  // return new String(decode.decodeBuffer(str));
  // }

  /**
   * 十六进制字符串到字节数组的转换
   *
   * @param s 十六进制字符串
   * @return 字节数组
   */
  public static byte[] hexStringToByteArray(String s) {
    byte[] buf = new byte[s.length() / 2];
    for (int i = 0; i < buf.length; i++) {
      buf[i] =
          (byte)
              (chr2hex(s.substring(i * 2, i * 2 + 1)) * 0x10
                  + chr2hex(s.substring(i * 2 + 1, i * 2 + 2)));
    }
    return buf;
  }

  /**
   * 十六进制字符到字节类型数据的转换
   *
   * @param chr 十六进制字符
   * @return 字节类型数据
   */
  private static byte chr2hex(String chr) {
    if ("0".equals(chr)) {
      return 0x00;
    } else if ("1".equals(chr)) {
      return 0x01;
    } else if ("2".equals(chr)) {
      return 0x02;
    } else if ("3".equals(chr)) {
      return 0x03;
    } else if ("4".equals(chr)) {
      return 0x04;
    } else if ("5".equals(chr)) {
      return 0x05;
    } else if ("6".equals(chr)) {
      return 0x06;
    } else if ("7".equals(chr)) {
      return 0x07;
    } else if ("8".equals(chr)) {
      return 0x08;
    } else if ("9".equals(chr)) {
      return 0x09;
    } else if ("A".equals(chr)) {
      return 0x0a;
    } else if ("B".equals(chr)) {
      return 0x0b;
    } else if ("C".equals(chr)) {
      return 0x0c;
    } else if ("D".equals(chr)) {
      return 0x0d;
    } else if ("E".equals(chr)) {
      return 0x0e;
    } else if ("F".equals(chr)) {
      return 0x0f;
    } else {
      return 0x00;
    }
  }

  public static byte[] ivGeneration(String ivString) {
    byte[] ivBytes = new byte[ivString.length()];
    for (int i = 0; i < ivString.length(); i++) {
      ivBytes[i] = Byte.parseByte(ivString.substring(i, i + 1));
    }
    return ivBytes;
  }

  /**
   * 格式化HTML文本
   *
   * @param content
   * @return
   */
  public static String htmlToStr(String content) {
    if (content == null) return "";
    content = content.replaceAll("'", "&apos;");
    content = content.replaceAll("\"", "&quot;");
    content = content.replaceAll("\t", "&nbsp;&nbsp;"); // 替换跳格
    content = content.replaceAll("<", "&lt;");
    content = content.replaceAll(">", "&gt;");
    return content;
  }

  public static boolean isMobile(String mobile) {
    return CommonUtil.checkCellPhone(mobile);
  }

  /**
   * 隐藏手机号码中4位
   *
   * @param mobile
   * @return
   */
  public static String hideMobile(String mobile) {
    if (StringUtil.isMobile(mobile)) {
      mobile = mobile.substring(0, 3) + "****" + mobile.substring(7, 11);
    }
    return mobile;
  }

  /**
   * 按字节长度截取字符串(支持截取带HTML代码样式的字符串)
   *
   * @param param :将要截取的字符串参数
   * @param length :截取的字节长度
   * @param end :字符串末尾补上的字符串
   * @return 返回截取后的字符串
   */
  public static String subStringHTML(String param, int length, String end) {
    StringBuffer result = new StringBuffer();
    int n = 0;
    char temp;
    boolean isCode = false; // 是不是HTML代码
    boolean isHTML = false; // 是不是HTML特殊字符,如
    for (int i = 0; i < param.length(); i++) {
      temp = param.charAt(i);
      if (temp == '<') {
        isCode = true;
      } else if (temp == '&') {
        isHTML = true;
      } else if (temp == '>' && isCode) {
        n = n - 1;
        isCode = false;
      } else if (temp == ';' && isHTML) {
        isHTML = false;
      }

      if (!isCode && !isHTML) {
        /** n = n + 1; // UNICODE码字符占两个字节 if ((temp + "").getBytes().length > 1) { n = n + 1; } */
        n = n + (temp + "").getBytes().length;
      }

      result.append(temp);
      if (n >= length) {
        break;
      }
    }
    result.append(end);
    // 取出截取字符串中的HTML标记
    String temp_result = result.toString().replaceAll("(>)[^<>]*(<?)", "$1$2");
    // 去掉不需要结素标记的HTML标记
    temp_result = temp_result.replaceAll("</?(content|a)[^<>]*/?>", "");
    // 去掉成对的HTML标记
    temp_result = temp_result.replaceAll("<([a-zA-Z]+)[^<>]*>(.*?)<//1>", "$2");
    // 用正则表达式取出标记
    Pattern p = Pattern.compile("<([a-zA-Z]+)[^<>]*>");
    Matcher m = p.matcher(temp_result);

    List endHTML = new ArrayList();

    while (m.find()) {
      endHTML.add(m.group(1));
    }
    // 补全不成对的HTML标记
    for (int i = endHTML.size() - 1; i >= 0; i--) {
      result.append("</");
      result.append(endHTML.get(i));
      result.append(">");
    }

    return result.toString();
  }

  public static boolean isEmail(String s) {
    String check =
        "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
    Pattern regex = Pattern.compile(check);
    Matcher matcher = regex.matcher(s);
    return matcher.matches();
  }

  /**
   * @Title: isLocalIP @Description: 判断是否存在本机IP
   *
   * @param @param ips
   * @param @return 设定文件
   * @return boolean 返回类型
   * @throws
   */
  public static boolean isLocalIP(String ips) {
    if (StringUtil.isEmpty(ips)) {
      return false;
    }

    String ip;
    try {
      InetAddress addr = InetAddress.getLocalHost();
      ip = addr.getHostAddress(); // 获得本机IP
      return ips.indexOf(ip) >= 0 ? true : false;
    } catch (Exception e) {
      // System.out.println("Bad IP Address!" + e);
    }
    return false;
  }

  public static boolean checkUrl(String url) {
    return url.matches(
        "^((https|http|ftp|rtsp|mms)?://)"
            + "+(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?"
            + "(([0-9]{1,3}\\.){3}[0-9]{1,3}"
            + "|"
            + "([0-9a-z_!~*'()-]+\\.)*"
            + "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\\."
            + "[a-z]{2,6})"
            + "(:[0-9]{1,4})?"
            + "((/?)|"
            + "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$");
  }

  /**
   * 无签名
   *
   * @param hostUrl
   * @param params
   * @return
   */
  public static String getWholeUrlunSign(String hostUrl, Map<String, String> params) {
    StringBuilder resultUrl = new StringBuilder(hostUrl + "?");
    if (params == null || params.isEmpty()) {
      return null;
    }
    Set<Map.Entry<String, String>> set = params.entrySet();
    if (set.size() <= 0) {
      return null;
    }
    Iterator<Map.Entry<String, String>> it = set.iterator();
    if (it.hasNext()) {
      Map.Entry<String, String> entry = (Map.Entry<String, String>) it.next();
      String param = entry.getKey() + "=" + entry.getValue();
      resultUrl.append(param);
    }
    while (it.hasNext()) {
      Map.Entry<String, String> entry = (Map.Entry<String, String>) it.next();
      String param = entry.getKey() + "=" + entry.getValue();
      resultUrl.append("&" + param);
    }

    return resultUrl.toString();
  }

  /**
   * 存储单位转换
   *
   * @param size
   * @return
   */
  public static String getPrintSize(long size) {
    BigDecimal filesize = new BigDecimal(size);
    BigDecimal megabyte = new BigDecimal(1024 * 1024);
    float returnValue = filesize.divide(megabyte, 2, BigDecimal.ROUND_UP).floatValue();
    if (returnValue > 1) return (returnValue + "MB");
    BigDecimal kilobyte = new BigDecimal(1024);
    returnValue = filesize.divide(kilobyte, 2, BigDecimal.ROUND_UP).floatValue();
    return (returnValue + "KB");
  }

  /**
   * 时长转换
   *
   * @param duration
   * @return
   */
  public static String getDuration(Long duration) {
    Long minutes = duration / 60;
    Long remainingSeconds = duration % 60;
    StringBuilder sb = new StringBuilder();
    sb.append(minutes.toString());
    sb.append("分");
    sb.append(remainingSeconds.toString());
    sb.append("秒");
    return sb.toString();
  }

  /**
   * 解析地址
   *
   * @author lin
   * @param address
   * @return
   */
  public static List<String> addressResolution(String address) {
    String regex =
        "(?<province>[^省]+省|.+自治区)(?<city>[^市]+市|.+自治州)(?<county>[^县]+县|.+区)?(?<town>[^区]+区|.+镇)?(?<village>.*)";
    Matcher m = Pattern.compile(regex).matcher(address);
    String province = null, city = null, county = null;
    List<String> table = new ArrayList<>();
    while (m.find()) {
      province = m.group("province");
      city = m.group("city");
      county = m.group("county");
      table.add(StringUtil.isEmpty(province) ? "" : province);
      table.add(StringUtil.isEmpty(city) ? "" : city);
      table.add(StringUtil.isEmpty(county) ? "" : county);
    }
    return table;
  }

  // 首字母转大写
  public static String toUpperCaseFirstOne(String s) {
    if (Character.isUpperCase(s.charAt(0))) return s;
    else
      return (new StringBuilder())
          .append(Character.toUpperCase(s.charAt(0)))
          .append(s.substring(1))
          .toString();
  }
}
