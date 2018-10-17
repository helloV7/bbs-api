package com.jyt.bbs.model.validator;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.util.Date;

public class UserRegisterValidator {

    @Getter
    @Setter
    @NotBlank
    private String username;
    @Getter
    @Setter
    @NotBlank
    private String avatar;
    @Getter
    @Setter
    @NotBlank
    private String nickname;
    @Getter
    @Setter
    @Digits(integer = 1,fraction = 0,message = "未知性别")
    @Range(min = 1,max = 2,message = "未知性别")
    private int gender;
    @Getter
    @Setter
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @PastOrPresent(message = "你都没出生呢，不给注册")
    private Date birthday;
    @Getter
    @Setter
    @NotBlank
    @Pattern(regexp = "[0-9a-fA-F]{32}",message = "密码格式不对")
    private String password;


}
