package com.cy.service.impl;

import com.cy.common.exception.ServiceException;
import com.cy.controller.dao.SysDeptDao;
import com.cy.pojo.Node;
import com.cy.pojo.SysDept;
import com.cy.service.SysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.List;
import java.util.Map;

@Service
public class SysDeptServiceImpl implements SysDeptService {
    @Autowired
    private SysDeptDao sysDeptDao;

    @Override
    public List<Map<String, Object>> findObjects() {
        List<Map<String,Object>>list = sysDeptDao.findObjects();
        if(list==null||list.size()==0)
            throw new ServiceException("无对应菜单");
        return list;
    }

    @Override
    public int deleteObject(Integer id) {
        if(id==null || id <=0)
            throw new ServiceException("请先选择");
        int childCount = sysDeptDao.getChildCount(id);
        if(childCount>0)
            throw new ServiceException("请先删除子部门");
        int rows = sysDeptDao.deleteObject(id);
        if(rows==0)
            throw new ServiceException("部门可能不存在了");
        return rows;
    }

    @Override
    public List<Node> findZtreeMenuNodes() {
        return sysDeptDao.findZtreeMenuNodes();
    }

    @Override
    public int saveObject(SysDept entity) {
        if(entity==null){
            throw new ServiceException("保存不能为空");
        }
        int rows = sysDeptDao.insertObject(entity);
        return rows;
    }

    @Override
    public int updateObject(SysDept entity) {
        if(entity == null)
            throw new ServiceException("修改不可为空");
        if(StringUtils.isEmpty(entity.getName()))
            throw new ServiceException("属性名不能为空");
        int rows = sysDeptDao.updateObject(entity);
        if(rows==0)
            throw new ServiceException("记录可能已经不存在");
        return rows;
    }
}
