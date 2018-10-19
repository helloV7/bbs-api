package com.jyt.bbs.model.validator;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class AddFloorValidator {

    @Getter
    @Setter
    @NotBlank
    private String content;

    @Getter
    @Setter
    @ApiModelProperty(value = "回复的楼层",name = "toNum",example = "1")
    private String toNum;

    @Getter
    @Setter
    @NotNull(message = "帖子id不能为空")
    private Integer postId;

}
