package com.jyt.bbs.controller;


import com.jyt.bbs.dao.UserMapper;
import com.jyt.bbs.model.entity.User;
import com.jyt.bbs.model.vo.R;
import com.jyt.bbs.shiro.token.CustomizedToken;
import com.jyt.bbs.shiro.token.LoginType;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/shirotest")
@RestController
public class ShiroTestController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "/nologin",method = RequestMethod.GET)
    public R testNoLogin(){
        return R.ok().setMessage("访问成功");
    }


    @RequestMapping(value = "/needlogin",method = RequestMethod.GET)
    public R testNeedLogin(){
        return R.ok().setMessage("访问成功");
    }

    @RequiresPermissions("user:list")
    @RequestMapping(value = "/needAuthen",method = RequestMethod.GET)
    public R needAuthenticated(){
        return R.ok().setMessage("访问成功");
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public R login(String username,String password){
        User user = userMapper.getUserByUsernameAndPassword(username,password);
        if (user==null){
            return R.error().setMessage("用户名或密码错误");
        }

        SecurityUtils.getSubject().login(new CustomizedToken(user.getId()+"",password, LoginType.USER));
        return R.ok().setData(SecurityUtils.getSubject().getSession().getId());
    }
}
