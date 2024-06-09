package com.cy.controller.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("impl")
@ToString
public class ClassImpl {
    @Getter
    @Setter
    String name;

    @Getter
    @Setter
    String[] clazz;

}

