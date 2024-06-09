package com.cy.pojo;

import lombok.Data;

import java.io.Serializable;
@Data
public class Node implements Serializable {
    private Integer id;
    private String name;
    private Integer parentId;
}
