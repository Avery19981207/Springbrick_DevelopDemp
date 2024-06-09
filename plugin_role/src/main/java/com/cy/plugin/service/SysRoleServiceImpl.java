package com.cy.plugin.service;

import com.cy.common.exception.ServiceException;
import com.cy.common.vo.SysRoleMenuVo;

import com.cy.controller.dao.SysRoleMenuDao;
import com.cy.controller.dao.SysRoleUserDao;
import com.cy.plugin.controller.dao.SysRoleDao;
import com.cy.pojo.PageObject;


import com.gitee.starblues.bootstrap.annotation.AutowiredType;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cy.plugin.pojo.SysRole;
import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleDao sysRoleDao;
    @Autowired
    @AutowiredType(value = AutowiredType.Type.MAIN)
    private SysRoleMenuDao sysRoleMenuDao;
    @Autowired
    @AutowiredType(value = AutowiredType.Type.MAIN)
    private SysRoleUserDao sysRoleUserDao;

    @Override
    public PageObject<SysRole> findPageObjects(String name, Integer pageCurrent) {
        if(name.equals("aaa"))name = "";
        if(pageCurrent==null||pageCurrent<1)
            throw new ServiceException("页码不合法");
        int pageRows = sysRoleDao.getRowCount(name);
        if(pageRows==0)
            throw new ServiceException("不存在该角色");
        int pageSize = 10;
        int startIndex = (pageCurrent-1)*pageSize;

        List<SysRole>result = sysRoleDao.findPageObjects(pageSize,name,startIndex);
        return new PageObject<>(pageCurrent,pageSize,pageRows,result);
    }

    @Override
    public int deleteObjectByRoleId(Integer id) {
        if(id==null||id<=0)
            throw new ServiceException("请先选择");
        int rows = sysRoleDao.deleteObjectByRoleId(id);
        sysRoleMenuDao.deleteObjectByRoleId(id);
        sysRoleUserDao.deleteObjectByRoleId(id);
        if(rows==0)
            throw new ServiceException("该角色可能已经不存在");
        return rows;
    }

    @Override
    public int saveObject(SysRole entity, Integer[] menuIds) {
        //1.参数有效性校验
        if(entity==null)
            throw new IllegalArgumentException("保存对象不能为空");
        if(StringUtils.isEmpty(entity.getName()))
            throw new IllegalArgumentException("角色名不允许为空");
        if(menuIds==null||menuIds.length==0)
            throw new ServiceException("必须为角色分配权限");
        //2.保存角色自身信息
        int rows=sysRoleDao.insertObject(entity);
        //3.保存角色菜单关系数据
        sysRoleMenuDao.insertObjects(entity.getId(), menuIds);
        //4.返回业务结果
        return rows;
    }

    @Override
    public SysRoleMenuVo findObjectById(Integer id) {
        //1.合法性验证
        if(id==null||id<=0)
            throw new IllegalArgumentException("id的值不合法");
        //2.执行查询
        SysRoleMenuVo result=sysRoleDao.findObjectById(id);
        //3.验证结果并返回
        if(result==null)
            throw new ServiceException("此记录已经不存在");
        return result;
    }

    @Override
    public int updateObject(SysRole entity, Integer[] menuIds) {
        //1.合法性验证
        if(entity==null)
            throw new IllegalArgumentException("更新的对象不能为空");
        if(entity.getId()==null)
            throw new IllegalArgumentException("id的值不能为空");
        if(StringUtils.isEmpty(entity.getName()))
            throw new IllegalArgumentException("角色名不能为空");
        if(menuIds==null||menuIds.length==0)
            throw new IllegalArgumentException("必须为角色指定一个权限");
        //2.更新数据
        int rows=sysRoleDao.updateObject(entity);
        if(rows==0)
            throw new ServiceException("对象可能已经不存在");
        //因为关系表对应多条数据要更新，不能update，得删再加
        sysRoleMenuDao.deleteObjectByRoleId(entity.getId());
        sysRoleMenuDao.insertObjects(entity.getId(),menuIds);
        //3.返回结果
        return rows;
    }
}
