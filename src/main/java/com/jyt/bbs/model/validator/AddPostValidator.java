package com.jyt.bbs.model.validator;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class AddPostValidator {

    @Getter
    @Setter
    @ApiModelProperty(value = "板块id")
    @NotNull(message = "板块id不能为空")
    private Integer areaId;

    @Getter
    @Setter
    @Range(min = 0,max = 2,message = "非法类型")
    @Digits(integer = 1,fraction = 0,message = "非法类型")
    @ApiModelProperty(value = "帖子类型 0、讨论交流。1、分享。2、求助")
    private int type;

    @Getter
    @Setter
    @Range(min = 0,max = 1,message = "非法类型")
    @Digits(integer = 1,fraction = 0,message = "非法类型")
    @ApiModelProperty(value = "0、可见1、回复可见")
    private int see;

    @Getter
    @Setter
    private BigDecimal score;

    @Getter
    @Setter
    private String file_url;

    @Getter
    @Setter
    @NotBlank
    private String title;

    @Getter
    @Setter
    @NotBlank
    private String content;

}
