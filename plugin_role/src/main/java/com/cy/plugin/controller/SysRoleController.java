package com.cy.plugin.controller;

import com.cy.common.vo.JsonResult;

import com.cy.plugin.pojo.SysRole;
import com.cy.plugin.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;

    @ResponseBody
    @RequestMapping("doFindPageObjects")
    public JsonResult doFindPageObjects(@RequestParam("name") String name, @RequestParam("pageCurrent")Integer pageCurrent) {
        return new JsonResult(sysRoleService.findPageObjects(name, pageCurrent));
    }

    @ResponseBody
    @RequestMapping("doDeleteObject")
    public JsonResult doDeleteObject(Integer id) {
        sysRoleService.deleteObjectByRoleId(id);
        return new JsonResult("delete ok!");
    }

    @RequestMapping("doSaveObject")
    @ResponseBody
    public JsonResult doSaveObject(
            SysRole entity, Integer[] menuIds) {
        sysRoleService.saveObject(entity, menuIds);
        return new JsonResult("save ok");
    }

    @ResponseBody
    @RequestMapping("doFindObjectById")
    public JsonResult doFindObjectById(@RequestParam("id") Integer id) {
        return new JsonResult(sysRoleService.findObjectById(id));
    }

    @ResponseBody
    @RequestMapping("doUpdateObject")
    public JsonResult doUpdateObject(SysRole entity,
                                     Integer... menuIds) {
        sysRoleService.updateObject(entity, menuIds);
        return new JsonResult("update ok");
    }
}
