package com.jyt.bbs.service;

import com.jyt.bbs.model.entity.User;
import com.jyt.bbs.model.validator.UserRegisterValidator;

public interface UserService {

    User login(String username,String password);

    User register(UserRegisterValidator userRegisterValidator);

    User updateUserBaseInfo(User user);

    User getUserById(Integer id);
}
