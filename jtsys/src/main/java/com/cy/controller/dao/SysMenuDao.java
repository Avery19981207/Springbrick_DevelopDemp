package com.cy.controller.dao;

import com.cy.pojo.Node;
import com.cy.pojo.SysMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
@Mapper
public interface SysMenuDao {
    List<Map<String,Object>> findObjects();

    int deleteObject(Integer id);

    int getChildCount(Integer id);

    List<Node>findZtreeMenuNodes();

    int insertObject(SysMenu sysMenu);

    int updateObject(SysMenu sysMenu);

    int insertObjects(
            @Param("roleId")Integer roleId,
            @Param("menuIds")Integer[] menuIds);
}
