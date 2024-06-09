package com.cy.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class SysDept implements Serializable {
    private Integer id;
    private String name;
    private Integer parentId;
    private Integer sort;
    private String note;
    private Date createdTime;
    private String modifiedTime;
    private String createdUser;
    private String modifiedUser;

}
