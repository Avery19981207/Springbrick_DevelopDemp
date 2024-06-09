package com.cy.service.impl;

import com.cy.common.exception.ServiceException;
import com.cy.common.vo.SysUserDeptVo;
import com.cy.controller.dao.SysUserDao;
import com.cy.pojo.PageObject;
import com.cy.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserDao sysUserDao;
    @Override
    public PageObject<SysUserDeptVo> findPageObjects(String username, Integer pageCurrent) {
        if(pageCurrent==null||pageCurrent==0)
            throw new ServiceException("当前页号不合法");
        int rowCount = sysUserDao.getRowCount(username);
        int pageSize = 10;
        int pageIndex = (pageCurrent-1)*pageSize;
        System.out.println("before!@$!@^&%*^%&$^#%@%#^$%&^*%&$^$@#%$^#%&$^%#^@%#!$^%&$^%I");
        List<SysUserDeptVo> records = sysUserDao.findPageObjects(username,pageSize,pageIndex);
        System.out.println(records);

        return new PageObject<SysUserDeptVo>(pageCurrent,pageSize,rowCount,records);
    }
}
