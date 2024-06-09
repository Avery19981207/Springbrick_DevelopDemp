package com.cy.service;

import com.cy.pojo.Node;
import com.cy.pojo.PageObject;
import com.cy.pojo.SysDept;
import com.cy.pojo.SysMenu;

import java.util.List;
import java.util.Map;

public interface SysDeptService {
    List<Map<String ,Object>> findObjects();

    int deleteObject(Integer id);

    List<Node>findZtreeMenuNodes();

    int saveObject(SysDept entity);

    int updateObject(SysDept entity);
}
