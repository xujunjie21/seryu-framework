package org.seryu.framework.db.mybatisPlugs.code;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.seryu.framework.data.biz.DbUserThreadLocal;
import org.seryu.framework.data.biz.UserDbEntiy;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @program: seryu-framework
 * @description: 自动填充器
 * @author: xujunjie
 * @create: 2020-04-26 16:49
 **/
@Component
public class MetaHandler implements MetaObjectHandler
{
    /**
     * @description: 新增数据执行
     * @param metaObject 数据信息
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        UserDbEntiy userDbEntiy = DbUserThreadLocal.getUserDbEntiy();
        this.setFieldValByName("createDate", new Date(), metaObject);
        this.setFieldValByName("updateDate", new Date(), metaObject);
        if(null != userDbEntiy && null != userDbEntiy.getUserId())
        {
            this.setFieldValByName("createUserId", userDbEntiy.getUserId(), metaObject);
            this.setFieldValByName("updateUserId", userDbEntiy.getUserId(), metaObject);
        }
    }

    /**
     * @description: 更新数据执行
     * @param metaObject 数据信息
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        UserDbEntiy userDbEntiy = DbUserThreadLocal.getUserDbEntiy();
        this.setFieldValByName("updateDate", new Date(), metaObject);
        if(null != userDbEntiy && null != userDbEntiy.getUserId()) {
            this.setFieldValByName("updateUserId", userDbEntiy.getUserId(), metaObject);
        }
    }
}
