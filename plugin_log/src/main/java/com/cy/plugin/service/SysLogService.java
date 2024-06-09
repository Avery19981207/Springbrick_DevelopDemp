package com.cy.plugin.service;

import com.cy.plugin.pojo.SysLog;
import com.cy.pojo.PageObject;


public interface SysLogService {

    PageObject<SysLog> findPageObjects(String username, Integer  pageCurrent);

    int deletePageObjects(Integer ...id);

    int addPageObject(SysLog sysLog);
}
