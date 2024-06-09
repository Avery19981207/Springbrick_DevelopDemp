package com.cy.controller.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysRoleUserDao {
    int deleteObjectByRoleId(Integer roleId);

}
