package com.benjamin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.benjamin.entities.SysPermission;
import com.benjamin.request.SysPermissionReq;
import com.benjamin.response.ResponseWithEntities;
import com.benjamin.vo.SysPermissionVo;

import java.util.List;

/**
 * <p>
 * 权限 服务类
 * </p>
 *
 * @author benjamin
 * @since 2023-07-08
 */
public interface SysPermissionService extends IService<SysPermission> {

    /**
     * 所有权限
     *
     * @return
     */
    ResponseWithEntities<List<SysPermissionVo>> allPermissions();

    /**
     * 添加权限
     *
     * @param sysPermissionReq
     * @return
     */
    ResponseWithEntities<String> addPermission(SysPermissionReq sysPermissionReq);



    /**
     * RabbitMQ队列测试
     *
     * @return
     */
    ResponseWithEntities<String> testRabbitMQ();
}
