package com.cy.plugin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HelloController {

    @RequestMapping("doHello")
    @ResponseBody
    public String hello(){
        return "this is plugin";
    }
}
