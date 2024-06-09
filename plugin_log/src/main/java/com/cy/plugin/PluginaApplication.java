package com.cy.plugin;

import com.gitee.starblues.bootstrap.SpringPluginBootstrap;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PluginaApplication extends SpringPluginBootstrap {

    public static void main(String[] args) {
        new PluginaApplication().run(args);
    }

}
