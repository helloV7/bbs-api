package com.jyt.bbs.model.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class PostThumb {
    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private Integer perfect;

    @Getter
    @Setter
    private Integer overhead;

    @Getter
    @Setter
    private Integer userId;

    @Getter
    @Setter
    private Integer state;

    @Getter
    @Setter
    private Integer areaId;

    @Getter
    @Setter
    private Date createTime;

    @Getter
    @Setter
    private Integer type;

    @Getter
    @Setter
    private String title;

}
