package com.cy.plugin.controller;


import com.cy.common.vo.JsonResult;
import com.cy.plugin.service.SysLogService;
import com.cy.plugin.pojo.SysLog;
import com.cy.pojo.PageObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class SysLogController {
    @Autowired
    private SysLogService sysLogService;

    @ResponseBody
    @RequestMapping("doFindPageObjects")
    public JsonResult doFindPageObjects(@RequestParam("userName")String userName, @RequestParam("pageCurrent")Integer pageCurrent){
        PageObject<SysLog> pageObject = sysLogService.findPageObjects(userName,pageCurrent);
        return new JsonResult(pageObject);
    }

    @ResponseBody
    @RequestMapping("doDeleteObjects")
    public JsonResult doDeleteObjects(Integer ...ids){
        int rows = sysLogService.deletePageObjects(ids);
        return new JsonResult("delete ok!");
    }


    public JsonResult doAddObject(SysLog sysLog){
        int row = sysLogService.addPageObject(sysLog);
        return new JsonResult("ADD OK!");
    }
}
