package com.cy.service;

import com.cy.common.vo.SysUserDeptVo;
import com.cy.pojo.PageObject;

public interface SysUserService {
    PageObject<SysUserDeptVo>findPageObjects(String username,Integer pageCurrent);

}
