package org.seryu.framework.rbac.app.qry;

import lombok.extern.slf4j.Slf4j;
import org.seryu.framework.data.exception.InterfacesException;
import org.seryu.framework.data.util.ConverterUtil;
import org.seryu.framework.data.util.StringUtil;
import org.seryu.framework.rbac.client.api.qry.DeptServiceQryI;
import org.seryu.framework.rbac.client.bo.DeptDetailBo;
import org.seryu.framework.rbac.domain.dto.DeptDetailDto;
import org.seryu.framework.rbac.domain.gateway.DeptDetailGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: seryu-framework-security-rbac
 * @description: 部门查询服务
 * @author: xujunjie
 * @create: 2020-04-23 09:54
 */
@Slf4j
@Service
public class DeptServiceQry implements DeptServiceQryI {
  @Autowired private DeptDetailGateway deptDetailGateway;

  private ConverterUtil<DeptDetailDto, DeptDetailBo> converterUtil = new ConverterUtil<>();

  @Override
  public List<DeptDetailBo> findAll() throws InterfacesException {
    return buildByRecursive(converterUtil.converList(deptDetailGateway.list(), DeptDetailBo.class));
  }

  @Override
  public DeptDetailBo infoById(Long id) {
    DeptDetailDto dto = deptDetailGateway.getById(id);
    return converterUtil.conver(dto, DeptDetailBo.class);
  }

  public static List<DeptDetailBo> buildByRecursive(List<DeptDetailBo> detailBos) {
    List<DeptDetailBo> trees = new ArrayList<>();
    for (DeptDetailBo menuBo : detailBos) {
      if (0 == menuBo.getParentId()) {
        trees.add(findChildren(menuBo, detailBos));
      }
    }
    return trees;
  }

  public static DeptDetailBo findChildren(DeptDetailBo detailBo, List<DeptDetailBo> detailBos) {
    for (DeptDetailBo it : detailBos) {
      if (StringUtil.isEq(detailBo.getId() + "", it.getParentId() + "")) {
        if (detailBo.getChildrenList() == null) {
          detailBo.setChildrenList(new ArrayList<>());
        }
        detailBo.getChildrenList().add(findChildren(it, detailBos));
      }
    }
    return detailBo;
  }
}
