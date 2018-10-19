package com.jyt.bbs.model.dto;

import com.github.pagehelper.IPage;
import com.github.pagehelper.Page;
import lombok.Getter;
import lombok.Setter;

public class CustomPage implements IPage {

    private Integer pageNum;

    private Integer pageSize;

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public Integer getPageNum() {
        if (pageNum==null){
            return 1;
        }
        return pageNum;
    }

    @Override
    public Integer getPageSize() {
        if (pageSize==null){
            return 10;
        }
        return pageSize;
    }

    @Override
    public String getOrderBy() {
        return null;
    }
}
