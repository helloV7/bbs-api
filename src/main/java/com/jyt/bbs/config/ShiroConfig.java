package com.jyt.bbs.config;


import com.jyt.bbs.shiro.CollectionRedisSessionDao;
import com.jyt.bbs.shiro.CustomizedModularRealmAuthenticator;
import com.jyt.bbs.shiro.RedisSessionDao;
import com.jyt.bbs.shiro.ShiroSessionManager;
import com.jyt.bbs.shiro.realm.UserRealm;
import com.jyt.bbs.shiro.session.ShiroSessionFactory;
import org.apache.shiro.authc.Authenticator;
import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class ShiroConfig {

    //session 过期时间
    long timeout = 30 * 60 *1000 *100;

    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        System.out.println("ShiroConfiguration.shirFilter()");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //拦截器.
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();
        // 配置不会被拦截的链接 顺序判断
        filterChainDefinitionMap.put("/swagger/**", "anon");
        filterChainDefinitionMap.put("/v2/api-docs", "anon");
        filterChainDefinitionMap.put("/swagger-ui.html", "anon");
        filterChainDefinitionMap.put("/webjars/**", "anon");
        filterChainDefinitionMap.put("/swagger-resources/**", "anon");
        filterChainDefinitionMap.put("/druid/**","anon");
        filterChainDefinitionMap.put("/statics/**", "anon");
        filterChainDefinitionMap.put("/shiro/*","anon");
        filterChainDefinitionMap.put("/kaptcha/*","anon");

        //        用户登陆接口
        filterChainDefinitionMap.put("/shirotest/nologin","anon");
        filterChainDefinitionMap.put("/shirotest/needlogin","authc");
        filterChainDefinitionMap.put("/shirotest/needAuthen","authc");



        //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("/logout", "logout");
        //<!-- 过滤链定义，从上向下顺序执行，一般将/**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
        //<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
//        filterChainDefinitionMap.put("/**", "authc");
        filterChainDefinitionMap.put("/**", "anon");
//         如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/shiro/needLogin");
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/index");

        //未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/shiro/403");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);


        return shiroFilterFactoryBean;
    }


    @Bean
    public SessionManager sessionManager(@Autowired CollectionRedisSessionDao redisSessionDao) {
        redisSessionDao.setExpireTime(timeout);

        ShiroSessionManager mySessionManager = new ShiroSessionManager();
        mySessionManager.setSessionDAO(redisSessionDao);
        mySessionManager.setSessionFactory(new ShiroSessionFactory());
        mySessionManager.setDeleteInvalidSessions(true);
        mySessionManager.setGlobalSessionTimeout(timeout);
        return mySessionManager;
    }

    @Bean(name = "userRealm")
    public Realm userRealm(){
        return new UserRealm();
    }

    @Bean
    public Authenticator authenticator(){
        CustomizedModularRealmAuthenticator customizedModularRealmAuthenticator = new CustomizedModularRealmAuthenticator();
        customizedModularRealmAuthenticator.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy());
        return customizedModularRealmAuthenticator;
    }

    @Bean
    public SecurityManager securityManager(@Autowired SessionManager sessionManager,
                                           @Autowired Authenticator authenticator ,
                                           @Qualifier(value = "userRealm") Realm userRealm){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        securityManager.setAuthenticator(authenticator);

        List<Realm> realms = new ArrayList<>();
        realms.add(userRealm);
        securityManager.setRealms(realms);

        securityManager.setSessionManager(sessionManager);
        securityManager.setCacheManager(new MemoryConstrainedCacheManager());

        return securityManager;
    }

    /**
     * 开启shiro aop注解支持.
     * 使用代理方式;所以需要开启代码支持;
     *
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}
