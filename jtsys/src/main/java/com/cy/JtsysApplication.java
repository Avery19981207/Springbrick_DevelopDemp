package com.cy;


import com.cy.controller.config.ClassImpl;
import com.gitee.starblues.loader.launcher.SpringBootstrap;
import com.gitee.starblues.loader.launcher.SpringMainBootstrap;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@EnableConfigurationProperties(ClassImpl.class)
public class JtsysApplication extends SpringBootServletInitializer implements SpringBootstrap {

    public static void main(String[] args) {
        // 这里使用 SpringMainBootstrap 引导启动
        SpringMainBootstrap.launch(JtsysApplication.class, args);
    }

    @Override
    public void run(String[] args) throws Exception {
        // 这里的写法和SpringBoot 启动保持一致
        SpringApplication.run(JtsysApplication.class, args);
    }

}