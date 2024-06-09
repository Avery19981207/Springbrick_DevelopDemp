package com.cy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PageController {

    @RequestMapping("doIndexUI")
    public String doIndexUI(){
        return "starter";
    }
    @RequestMapping("doTest")
    public String doITest(){
        return "test";
    }

    @RequestMapping("doPageUI")
    public String doPageUI(){
        return "common/page";
    }
/*
    @RequestMapping("log/log_list")
    public String doLogUI(){
        return "sys/log_list";
    }


    @RequestMapping("menu/menu_list")
    public String doMenUI(){
        return "sys/menu_list";
    }
  */
    @RequestMapping("{module}/{moduleUI}")
    public String doModuleUI(@PathVariable String moduleUI){
        return "sys/"+moduleUI;
    }
}
