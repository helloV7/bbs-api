package com.jyt.bbs.model.validator;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;

public class ModifyUserInfoValidator {

    @Getter
    @Setter
    @Email
    private String email;
    @Getter
    @Setter
    private Date birthday;
    @Getter
    @Setter
    @Digits(integer = 1,fraction = 0,message = "未知性别")
    @Range(min = 1,max = 2,message = "未知性别")
    private Integer gender;
    @Getter
    @Setter
    private String introduce;

    @Getter
    @Setter
    private String avatar;
}
