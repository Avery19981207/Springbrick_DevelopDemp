package com.cy.plugin.service;

import com.cy.common.vo.SysRoleMenuVo;
import com.cy.plugin.pojo.SysRole;
import com.cy.pojo.PageObject;


public interface SysRoleService {
    PageObject<SysRole>findPageObjects(String name, Integer pageCurrent);

    int deleteObjectByRoleId(Integer id);

    int saveObject(SysRole entity,Integer[]menuIds);

    SysRoleMenuVo findObjectById(Integer id) ;

    int updateObject(SysRole entity,Integer[] menuIds);
}
