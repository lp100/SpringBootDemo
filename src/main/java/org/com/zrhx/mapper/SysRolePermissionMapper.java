package org.com.zrhx.mapper;

import org.com.zrhx.model.SysRolePermission;

public interface SysRolePermissionMapper  {
    int deleteByPrimaryKey(String relationID);

    int insert(SysRolePermission record);

    int insertSelective(SysRolePermission record);

    SysRolePermission selectByPrimaryKey(String relationID);

    int updateByPrimaryKeySelective(SysRolePermission record);

    int updateByPrimaryKey(SysRolePermission record);
}