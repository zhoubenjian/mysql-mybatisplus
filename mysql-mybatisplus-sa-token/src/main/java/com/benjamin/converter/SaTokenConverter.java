package com.benjamin.converter;

import com.benjamin.entities.SysUser;
import com.benjamin.vo.SysUserVo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface SaTokenConverter {

    // SysUser => SysUserVo
    SysUserVo sysUser2SysUserVo(SysUser sysUser);
    List<SysUserVo> sysUserList2SysUserVoList(List<SysUser> list);
}
