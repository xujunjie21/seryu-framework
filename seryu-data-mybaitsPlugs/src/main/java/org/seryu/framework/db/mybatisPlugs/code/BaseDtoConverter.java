package org.seryu.framework.db.mybatisPlugs.code;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.seryu.framework.data.gateway.DtoConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * @program: seryu-framework
 * @description: 默认转换器
 * @author: xujunjie
 * @create: 2020-04-29 18:51
 */
@Slf4j
@Service
public class BaseDtoConverter<T, D> implements DtoConverter<T, D> {
  /**
   * @description: 基础转换 当前转换器使用反射进行对象创建,Do和Dto必须在对应包下 *.infrastructure.repository.Do ==> *.domain.dto
   * @param entity 实体转换器
   * @return 领域对象(dto)
   */
  public D coverDto(T entity) {
    if (null == entity) {
      return null;
    }

    String classNameT = entity.getClass().getName();
    String classNameD = classNameT.replace(".infrastructure.repository.Do.", ".domain.dto.");
    classNameD = classNameD.substring(0, classNameD.length() - 2) + "Dto";
    try {
      D dto = (D) Class.forName(classNameD).newInstance();
      BeanUtils.copyProperties(entity, dto);
      return dto;
    } catch (Exception e) {
      log.error("类型转换异常 {} {} ", classNameD, classNameT);
    }
    return null;
  }

  /**
   * @description: 基础转换 当前转换器使用反射进行对象创建,Do和Dto必须在对应包下 *.infrastructure.repository.Do ==> *.domain.dto
   * @param dto 领域对象
   * @return 实体对象
   */
  public T coverDo(D dto) {
    String classNameD = dto.getClass().getName();
    String classNameT =
        classNameD
            .replace(".domain.", ".infrastructure.repository.Do.")
            .replace(".dto.", ".")
            .replace("Dto", "Do");
    try {
      T entity = (T) Class.forName(classNameT).newInstance();
      BeanUtils.copyProperties(dto, entity);
      return entity;
    } catch (Exception e) {
      log.error("类型转换异常 {} {} ", classNameD, classNameT);
    }
    return null;
  }

  /**
   * @description: 基础转换
   * @param entitys 实体对象集
   * @return list
   */
  public List<D> coverDtoList(Collection<T> entitys) {
    List<D> dtos = new ArrayList<D>();
    if (!CollectionUtils.isEmpty(entitys)) {
      entitys.forEach(info -> dtos.add(coverDto(info)));
    }
    return dtos;
  }

  /**
   * @description: 基础转换
   * @param dtos 领域对象列表
   * @return 实体对象列表
   */
  public List<T> coverDoList(Collection<D> dtos) {
    List<T> entitys = new ArrayList<>();
    if (!CollectionUtils.isEmpty(dtos)) {
      dtos.forEach(info -> entitys.add(coverDo(info)));
    }
    return entitys;
  }
}
