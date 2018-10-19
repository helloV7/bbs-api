package com.jyt.bbs.controller.front;

import com.jyt.bbs.model.entity.User;
import com.jyt.bbs.model.validator.LoginValidator;
import com.jyt.bbs.model.validator.ModifyUserInfoValidator;
import com.jyt.bbs.model.validator.UserRegisterValidator;
import com.jyt.bbs.model.vo.R;
import com.jyt.bbs.model.vo.UserCenterInfo;
import com.jyt.bbs.service.UserService;
import io.swagger.annotations.Api;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "用户控制器",tags = "用户")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public R<User> login(@RequestBody @Validated LoginValidator loginParams ){

        User user = userService.login(loginParams.getUsername(),loginParams.getPassword());

        user.setPassword(null);

        return R.ok().setData(user).setMessage("登陆成功");
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public R register(@RequestBody @Validated UserRegisterValidator userRegisterValidator){
        User user = userService.register(userRegisterValidator);
        return R.ok().setData(user).setMessage("注册成功");
    }


    @RequiresPermissions(value = "user:update")
    @RequestMapping(value = "/modify",method = RequestMethod.POST)
    public R modify(@RequestBody @Validated ModifyUserInfoValidator userInfoValidator){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        BeanUtils.copyProperties(userInfoValidator,user);
        userService.updateUserBaseInfo(user);
        return R.ok().setMessage("修改成功");
    }


    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public R<UserCenterInfo> getUserCenterInfo(){

        User user = (User) SecurityUtils.getSubject().getPrincipal();

        user = userService.getUserById(user.getId());

        UserCenterInfo userCenterInfo = new UserCenterInfo();

        BeanUtils.copyProperties(user,userCenterInfo);

        return R.ok().setData(userCenterInfo);
    }

}
