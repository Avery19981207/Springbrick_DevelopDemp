package com.cy.common.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SysRoleMenuVo implements Serializable {
    private Integer id;

    private String name;

    private String note;

    /**角色对应的菜单id*/

    private List<Integer> menuIds;
}
