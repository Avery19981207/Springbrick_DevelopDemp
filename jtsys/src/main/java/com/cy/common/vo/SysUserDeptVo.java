package com.cy.common.vo;

import com.cy.pojo.SysDept;
import lombok.Data;

import java.util.Date;
@Data
public class SysUserDeptVo {
    private Integer id;
    private String username;
    private String password;
    private String salt;
    private String email;
    private String mobile;
    private Integer valid = 1;
    private SysDept sysDept;
    private Date createdTime;
    private Date modifiedTime;
    private String createdUser;
    private String modifiedUser;




}
