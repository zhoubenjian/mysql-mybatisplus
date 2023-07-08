package com.benjamin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.benjamin.converter.SysConverter;
import com.benjamin.dao.SysPermissionMapper;
import com.benjamin.entities.SysPermission;
import com.benjamin.response.ResponseWithCollection;
import com.benjamin.response.ResponseWithEntities;
import com.benjamin.service.SysPermissionService;
import com.benjamin.vo.SysPermissionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 权限 服务实现类
 * </p>
 *
 * @author benjamin
 * @since 2023-07-08
 */
@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements SysPermissionService {

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Autowired
    private SysConverter sysConverter;



    /**
     * 所有权限
     *
     * @return
     */
    @Override
    public ResponseWithEntities<List<SysPermissionVo>> allPermissions() {

        List<SysPermission> sysPermissionList = sysPermissionMapper.allPermissions();

        List<SysPermissionVo> list = new ArrayList<>();
        for (SysPermission sysPermission : sysPermissionList) {
            SysPermissionVo vo = new SysPermissionVo();
            sysConverter.sysPermission2SysPermissionVo(vo, sysPermission);
            list.add(vo);
        }

        // 找到所有一级目录
        List<SysPermissionVo> firstList = new ArrayList<>();
        for (SysPermissionVo vo : list) {
            // 一级目录
            if (vo.getParentId() == 0)
                firstList.add(vo);
        }

        // 遍历一级目录，为一级目录设置子层级(调用下方定义的递归体getChild())
        for (SysPermissionVo first : firstList)
            first.setChildList(getChild(first.getId(), list));

        return new ResponseWithEntities<List<SysPermissionVo>>().setData(firstList);
    }



    /**
     * 递归体，主方法中进行循环调用
     *
     * @param id    主键
     * @param list  权限列表
     * @return
     */
    private List<SysPermissionVo> getChild(Long id, List<SysPermissionVo> list) {

        List<SysPermissionVo> childList = new ArrayList<>();
        for (SysPermissionVo child : list) {
            if (child.getId() != null && child.getParentId().equals(id))
                childList.add(child);
        }

        // 递归终止的条件(没有子层级)
        if (childList.size() == 0)
            return null;

        // 如果有子目录还有子层级，遍历childList，继续进行递归调用
        for (SysPermissionVo child : childList)
            child.setChildList(getChild(child.getId(), list));

        return childList;
    }
}
