package com.cy.controller.dao;

import com.cy.common.vo.SysUserDeptVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysUserDao {
    int getRowCount(String username);

    List<SysUserDeptVo> findPageObjects(@Param("userName") String userName, @Param("pageSize") Integer pageSize, @Param("startIndex") Integer startIndex);

}
