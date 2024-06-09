package com.cy.controller;

import com.cy.common.vo.JsonResult;
import com.cy.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user/")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;



    @RequestMapping("doFindPageObjects")
    @ResponseBody
    public JsonResult doFindPageObjects(String username, Integer pageCurrent) {
        return new JsonResult(sysUserService.findPageObjects(username, pageCurrent));

    }
}
