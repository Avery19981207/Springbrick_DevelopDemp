package com.cy.controller.dao;


import com.cy.pojo.Node;
import com.cy.pojo.SysDept;
import com.cy.pojo.SysMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SysDeptDao {
    List<Map<String,Object>> findObjects();

    int deleteObject(Integer id);

    int getChildCount(Integer id);

    List<Node>findZtreeMenuNodes();

    int insertObject(SysDept sysDept);

    int updateObject(SysDept sysDept);

    SysDept findById(Integer id);
}
