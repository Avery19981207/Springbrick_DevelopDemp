package com.cy.plugin.controller.dao;

import com.cy.common.vo.SysRoleMenuVo;

import com.cy.plugin.pojo.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysRoleDao {
    int getRowCount(@Param("name") String name);

    List<SysRole>findPageObjects(
            @Param("pageSize")Integer pageSize,
            @Param("name")String username,
            @Param("pageIndex")Integer pageIndex);

    int deleteObjectByRoleId(@Param("roleId") Integer roleId);

    int insertObject(SysRole entity);

    SysRoleMenuVo findObjectById(Integer id);

    int updateObject(SysRole entity);
}
