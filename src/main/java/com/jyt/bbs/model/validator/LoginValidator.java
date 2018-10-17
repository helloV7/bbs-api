package com.jyt.bbs.model.validator;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

public class LoginValidator {
    @Getter
    @Setter
    @NotBlank(message = "用户名不能为空")
    private String username;

    @Getter
    @Setter
    @NotBlank(message = "密码不能为空")
    private String password;
}
