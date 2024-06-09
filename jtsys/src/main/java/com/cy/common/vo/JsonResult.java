package com.cy.common.vo;



import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class JsonResult implements Serializable {
    private int state = 1;
    private String message = "OK";
    private Object data;

    public JsonResult(){}

    public JsonResult(Object data){
        this.data = data;
    }

    public JsonResult(Throwable t){
        this.state = 0;
        this.message = t.getMessage();
    }




}
