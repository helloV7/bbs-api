package com.jyt.bbs.config;

import com.alibaba.druid.sql.visitor.functions.Bin;
import com.jyt.bbs.model.vo.R;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletRequest;

@EnableWebMvc
@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(value = {AuthorizationException.class,UnauthorizedException.class,UnauthenticatedException.class})
    public @ResponseBody
    R noPermission(){
        return R.error().setMessage("无权访问");
    }

    @ExceptionHandler(BindException.class)
    public @ResponseBody
    R bindException(BindException ex){
        return R.error().setMessage(ex.getFieldError().getDefaultMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public @ResponseBody
    R errorHandler(HttpServletRequest req, Exception ex) {
        ex.printStackTrace();
        return  R.error().setMessage(ex.getMessage());
    }

    @ExceptionHandler(value = NoHandlerFoundException.class)
    public @ResponseBody
    R notFoundException(Exception ex){
        return R.error().setMessage("请求路径有误");

    }

}
