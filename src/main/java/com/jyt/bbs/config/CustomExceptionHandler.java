package com.jyt.bbs.config;

import com.jyt.bbs.model.vo.R;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(value = {AuthorizationException.class,UnauthorizedException.class,UnauthenticatedException.class})
    public @ResponseBody
    R noPermission(){
        return R.error().setMessage("无权访问");

    }

}
