package com.jyt.bbs.controller;

import com.jyt.bbs.model.vo.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/shiro")
@RestController
public class ShiroController  {

    @RequestMapping(value = "/needLogin",method = RequestMethod.GET)
    public R needLogin(){
        return R.error().setMessage("请登陆");
    }

    @RequestMapping(value = "/403",method = RequestMethod.GET)
    public R noPermission(){
        return R.error().setMessage("权限不足");
    }

}
