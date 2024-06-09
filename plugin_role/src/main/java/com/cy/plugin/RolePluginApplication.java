package com.cy.plugin;

import com.gitee.starblues.bootstrap.SpringPluginBootstrap;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RolePluginApplication extends SpringPluginBootstrap {

    public static void main(String[] args) {
        new RolePluginApplication().run(args);
    }

}
