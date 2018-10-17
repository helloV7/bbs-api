package com.jyt.bbs.service.impl;

import com.jyt.bbs.dao.UserMapper;
import com.jyt.bbs.model.entity.User;
import com.jyt.bbs.model.validator.UserRegisterValidator;
import com.jyt.bbs.service.UserService;
import com.jyt.bbs.shiro.RedisSessionDao;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Date;

@Component
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;
    @Autowired
    RedisSessionDao redisSessionDao;


    @Override
    public User login(String username, String password) {
        User user =  userMapper.getUserByUsernameAndPassword(username,password);
        if (user==null){
            throw new RuntimeException("用户名或密码错误");
        }

        String token = user.getToken();
        if (!StringUtils.isEmpty(token)){
            Session session = redisSessionDao.readSession(token);
            session.setTimeout(0);
            session.stop();
            redisSessionDao.update(session);
            redisSessionDao.delete(session);
        }

        SecurityUtils.getSubject().login(new UsernamePasswordToken(user.getId()+"",user.getPassword()));
        token = SecurityUtils.getSubject().getSession().getId().toString();

        user.setToken(token);
        userMapper.updateByPrimaryKey(user);

        return user;

    }

    @Override
    public User register(UserRegisterValidator userRegisterValidator) {

        User user = userMapper.getUserByUsername(userRegisterValidator.getUsername());
        if (user!=null){
            throw new RuntimeException("用户已存在");
        }

        user = new User();
        user.setCreateTime(new Date());
        BeanUtils.copyProperties(userRegisterValidator,user);

        userMapper.insert(user);

        if (user.getId()!=null){
            return  user;
        }else {
            throw new RuntimeException("用户保存失败");
        }

    }

    @Override
    public User updateUserBaseInfo(User user) {
        userMapper.updateByPrimaryKey(user);
        return user;
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
