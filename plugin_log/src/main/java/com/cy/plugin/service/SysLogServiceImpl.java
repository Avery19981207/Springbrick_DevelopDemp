package com.cy.plugin.service;

import com.cy.common.exception.ServiceException;

import com.cy.plugin.controller.dao.SysLogDao;

import com.cy.pojo.PageObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cy.plugin.pojo.SysLog;
import java.util.List;

@Service
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    private SysLogDao sysLogDao;

    public PageObject<SysLog> findPageObjects(String username, Integer pageCurrent) {
        //1.验证参数合法性
        //1.1验证pageCurrent的合法性，
        //不合法抛出IllegalArgumentException异常
        if(pageCurrent==null || pageCurrent<1)
            throw new IllegalArgumentException("输入页号有误");

        //2.基于条件查询总记录数
        //2.1) 执行查询
        int rowCount = sysLogDao.gerRowCountByName(username);

        //2.2) 验证查询结果，假如结果为0不再执行如下操作
        if(rowCount==0)
            throw new ServiceException("该用户无日志记录");
        //3.基于条件查询当前页记录(pageSize定义为3)
        //3.1)定义pageSize
        int pageSize = 10;
        //3.2)计算startIndex
        int startIndex = (pageCurrent-1)*pageSize;
        //3.3)执行当前数据的查询操作
        List<SysLog> list = sysLogDao.doFindPageObjects(pageSize,startIndex,username);
        //4.对分页信息以及当前页记录进行封装
        //4.1)构建PageObject对象
        PageObject<SysLog> records = new PageObject<SysLog>(pageCurrent,pageSize,rowCount,list);
        //5.返回封装结果。
        return records;
    }


    public int deletePageObjects(Integer ...ids) {
        if(ids==null || ids.length==0)
            throw  new ServiceException("请选择至少一个");
        int rows = sysLogDao.doDeletePageObjects(ids);
        return rows;
    }


    public int addPageObject(SysLog sysLog) {
        if(sysLog==null)
            throw new ServiceException("请输入");
        return sysLogDao.addPageObject(sysLog);
    }
}
