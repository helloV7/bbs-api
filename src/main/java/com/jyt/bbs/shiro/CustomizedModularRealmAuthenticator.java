package com.jyt.bbs.shiro;


import com.jyt.bbs.shiro.token.CustomizedToken;
import com.jyt.bbs.shiro.token.LoginType;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.realm.Realm;

import java.util.ArrayList;
import java.util.Collection;

public class CustomizedModularRealmAuthenticator extends ModularRealmAuthenticator {

    @Override
    protected AuthenticationInfo doAuthenticate(AuthenticationToken authenticationToken) throws AuthenticationException {
        assertRealmsConfigured();
        CustomizedToken customizedToken = (CustomizedToken) authenticationToken;
        LoginType loginType = customizedToken.getLoginType();

        // 所有Realm
        Collection<Realm> realms = getRealms();
        // 登录类型对应的所有Realm
        Collection<Realm> typeRealms = new ArrayList<>();
        for (Realm realm : realms) {
            if (realm.getName().toLowerCase().contains(loginType.name().toLowerCase()))
                typeRealms.add(realm);
        }
// 判断是单Realm还是多Realm
        if (typeRealms.size() == 1)
            return doSingleRealmAuthentication(typeRealms.iterator().next(), customizedToken);
        else
            return doMultiRealmAuthentication(typeRealms, customizedToken);
    }
}
