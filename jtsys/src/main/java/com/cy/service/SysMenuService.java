package com.cy.service;

import com.cy.pojo.Node;
import com.cy.pojo.SysMenu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface SysMenuService {
    List<Map<String ,Object>> findObjects();

    int deleteObject(Integer id);

    List<Node>findZtreeMenuNodes();

    int saveObject(SysMenu entity);

    int updateObject(SysMenu entity);


}
