package com.cy.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class SysMenu implements Serializable {
    private Integer id;
    private String name;
    private String url;
    private Integer type=1;
    private String note;
    private Integer sort;
    private Integer parentId;
    private String permission;
    private String createdUser;
    private String modifiedUser;
    private Date createdTime;
    private Date modifiedTime;

}
