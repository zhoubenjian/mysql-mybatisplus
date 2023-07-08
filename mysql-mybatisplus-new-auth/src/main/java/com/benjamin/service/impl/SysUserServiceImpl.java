package com.benjamin.service.impl;

import com.benjamin.entities.SysUser;
import com.benjamin.dao.SysUserMapper;
import com.benjamin.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author benjamin
 * @since 2023-07-08
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

}
