package com.cy.controller;

import com.cy.common.vo.JsonResult;
import com.cy.pojo.SysMenu;
import com.cy.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/menu/")
public class SysMenuController {
    @Autowired
    private SysMenuService sysMenuService;

    @ResponseBody
    @RequestMapping("doFindObjects")
    public JsonResult doFindObjects(){
        return new JsonResult(sysMenuService.findObjects());
    }

    @ResponseBody
    @RequestMapping("doDeleteObject")
    public JsonResult doDeleteObject(Integer id){
        sysMenuService.deleteObject(id);
        return new JsonResult("delete OK!");
    }
    @ResponseBody
    @RequestMapping("doFindZtreeMenuNodes")
    public JsonResult doFindZtreeMenuNodes(){
        return new JsonResult(sysMenuService.findZtreeMenuNodes());
    }

    @ResponseBody
    @RequestMapping("doSaveObject")
    public JsonResult doSaveObject(SysMenu entity){
        sysMenuService.saveObject(entity);
        return new JsonResult("save ok!");
    }

    @ResponseBody
    @RequestMapping("doUpdateObject")
    public JsonResult doUpdateObject(SysMenu entity){
        sysMenuService.updateObject(entity);
        return new JsonResult("update ok!");
    }


}
