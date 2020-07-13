package org.seryu.framework.data.util;

import cn.hutool.core.bean.BeanUtil;
import org.seryu.framework.data.page.PageData;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: potato-parent
 * @description: bean转换
 * @author: xujunjie
 * @create: 2020-05-06 11:14
 */
public class ConverterUtil<T, D> {
  /**
   * 转换对象
   *
   * @param objectT
   * @param dClass
   * @param <T>
   * @param <D>
   * @return
   */
  public <T, D> D conver(T objectT, Class<D> dClass) {
    if (null == objectT) {
      return null;
    }
    return BeanUtil.toBean(objectT, dClass);
  }

  /**
   * 转换列表
   *
   * @param objectT
   * @param dClass
   * @param <T>
   * @param <D>
   * @return
   */
  public <T, D> List<D> converList(List<T> objectT, Class<D> dClass) {
    if (null == objectT) {
      return null;
    }

    List<D> list = new ArrayList<>();
    objectT.forEach(info -> list.add(BeanUtil.toBean(info, dClass)));
    return list;
  }

  /**
   * 转换page
   *
   * @param pageData
   * @param dClass
   * @param <T>
   * @param <D>
   * @return
   */
  public <T, D> PageData<D> converPage(PageData<T> pageData, Class<D> dClass) {
    PageData<D> pageDataD = new PageData<>();
    List<D> list = converList(pageData.getList(), dClass);
    BeanUtil.copyProperties(pageData, pageDataD, "list");
    pageDataD.setList(list);
    return pageDataD;
  }
}
