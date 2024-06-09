package com.cy.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
public class PageObject<T> implements Serializable {
    private List<T> records;//当前页总记录
    private Integer pageCurrent=0;//当前页码值
    private Integer pageSize=3;//页大小
    private Integer rowCount=0;//总行数 查询
    private Integer pageCount=0;//总页数 计算 用来验证
    public PageObject(Integer pageCurrent, Integer pageSize, Integer rowCount, List<T> records) {
        super();
        this.pageCurrent = pageCurrent;
        this.pageSize = pageSize;
        this.rowCount = rowCount;
        this.records = records;
        this.pageCount=(rowCount-1)/pageSize+1;
    }
}
