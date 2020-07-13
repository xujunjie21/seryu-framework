package org.seryu.framework.db.mybatisPlugs.code;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

/**
 * @program: seryu-framework
 * @description: 领域模型转换器
 * @author: xujunjie
 * @create: 2020-04-29 16:30
 */
public interface DtoConverter<T, D> {
  /**
   * @description: 基础转换
   * @param entity 实体对象
   * @return d 领域对象
   */
  default D coverDto(T entity) {
    D dto = (D) new Object();
    BeanUtils.copyProperties(entity, dto);
    return dto;
  }

  /**
   * @description: 基础转换
   * @param dto 领域对象
   * @return D 实体对象
   */
  default T coverDo(D dto) {
    T entity = (T) new Object();
    BeanUtils.copyProperties(dto, entity);
    return entity;
  }

  /**
   * @description: 基础转换
   * @param entitys 实体列表
   * @return list 领域信息列表
   */
  default List<D> coverDtoList(Collection<T> entitys) {
    List<D> dtos = new ArrayList<>();
    if (!CollectionUtils.isEmpty(entitys)) {
      entitys.forEach(info -> dtos.add(coverDto(info)));
    }
    return dtos;
  }

  /**
   * @description: 基础转换
   * @param dtos 领域信息列表
   * @return list 实体信息列表
   */
  default List<T> coverDoList(Collection<D> dtos) {
    List<T> entitys = new ArrayList<>();
    if (!CollectionUtils.isEmpty(dtos)) {
      dtos.forEach(info -> entitys.add(coverDo(info)));
    }
    return entitys;
  }
}
