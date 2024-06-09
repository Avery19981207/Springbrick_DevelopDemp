package com.cy.controller;

import com.cy.common.vo.JsonResult;
import com.cy.pojo.SysDept;
import com.cy.pojo.SysMenu;
import com.cy.service.SysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/dept/")
public class SysDeptsController {
    @Autowired
    private SysDeptService sysDeptService;

    @RequestMapping("doFindObjects")
    @ResponseBody
    public JsonResult doFindObjects(){
        return new JsonResult(sysDeptService.findObjects());
    }

    @ResponseBody
    @RequestMapping("doDeleteObject")
    public JsonResult doDeleteObject(Integer id){
        sysDeptService.deleteObject(id);
        return new JsonResult("delete OK!");
    }
    @ResponseBody
    @RequestMapping("doFindZTreeNodes")
    public JsonResult doFindZtreeMenuNodes(){
        return new JsonResult(sysDeptService.findZtreeMenuNodes());
    }

    @ResponseBody
    @RequestMapping("doSaveObject")
    public JsonResult doSaveObject(SysDept entity){
        sysDeptService.saveObject(entity);
        return new JsonResult("save ok!");
    }

    @ResponseBody
    @RequestMapping("doUpdateObject")
    public JsonResult doUpdateObject(SysDept entity){
        sysDeptService.updateObject(entity);
        return new JsonResult("update ok!");
    }
}
