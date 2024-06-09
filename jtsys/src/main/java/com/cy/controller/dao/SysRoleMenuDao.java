package com.cy.controller.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface SysRoleMenuDao {

    int deleteObjectsByMenuId(@Param("menuId")Integer menuId);

    int deleteObjectByRoleId(@Param("roleId")Integer roleId);
    int insertObjects(
            @Param("roleId")Integer roleId,
            @Param("menuIds")Integer[] menuIds);
}
