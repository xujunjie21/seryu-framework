package org.seryu.framework.rbac.client.api.qry;

import org.seryu.framework.data.exception.InterfacesException;
import org.seryu.framework.data.page.PageData;
import org.seryu.framework.rbac.client.bo.PostDetailBo;
import org.seryu.framework.rbac.client.query.PostDetailQry;

/**
 * @program: seryu-framework-security-rbac
 * @description: 岗位服务
 * @author: xujunjie
 * @create: 2020-04-23 11:53
 **/
public interface PostServiceQryI extends BaseQryI
{
    /**
     * @description: 获取岗位列表
     * @param qry 岗位查询条件
     * @return 岗位列表
     */
    PageData<PostDetailBo> page(PostDetailQry qry) throws InterfacesException;

    /**
     * @description: 根据岗位Id查询菜单列表
     * @param id 岗位Id
     * @return 岗位信息
     * @throws InterfacesException
     */
    PostDetailBo infoById(Long id) throws InterfacesException;
}
