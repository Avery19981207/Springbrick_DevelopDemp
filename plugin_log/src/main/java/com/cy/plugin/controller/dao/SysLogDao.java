package com.cy.plugin.controller.dao;

import com.cy.plugin.pojo.SysLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysLogDao {

    List<SysLog> doFindPageObjects(@Param("pageSize") Integer pageSize,
                                   @Param("startIndex") Integer startIndex,
                                   @Param("userName") String userName);

    int gerRowCountByName(@Param("userName")String username );

    int doDeletePageObjects(@Param("ids")Integer ...id);

    int addPageObject(SysLog log);

}
