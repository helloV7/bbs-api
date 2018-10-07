package com.jyt.bbs.shiro.realm;


import com.jyt.bbs.dao.UserMapper;
import com.jyt.bbs.model.Do.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserMapper userMapper;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User user = (User) principalCollection.getPrimaryPrincipal();

        List<String> permission = userMapper.selectUserPermission(user.getId()+"");

        for (String permission_code:
                permission){
            authorizationInfo.addStringPermission(permission_code);
        }
        return authorizationInfo;
    }



    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userId= (String) authenticationToken.getPrincipal();

        User user = userMapper.selectByPrimaryKey(Integer.valueOf(userId));

        if (user==null){
            throw new RuntimeException("用户不存在");
//            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user, //用户名
                user.getPassword(), //密码
//                ByteSource.Util.bytes(user.getCredentialsSalt()),
                getName()  //shiro name
        );
        return authenticationInfo;
    }
}
