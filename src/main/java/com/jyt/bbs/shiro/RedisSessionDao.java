package com.jyt.bbs.shiro;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

@Component
public class RedisSessionDao extends EnterpriseCacheSessionDAO {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    RedisTemplate redisTemplate;


    private long expireTime;

    private static TimeUnit timeUnit = TimeUnit.MILLISECONDS;

    private String redisPrefix="user#token#";

    private String getKey(String originalKey) {
        return redisPrefix + originalKey;
    }

    @Override // 更新session
    public void update(Session session) throws UnknownSessionException {
        System.out.println("===============update================");
        if (session == null || session.getId() == null) {
            return;
        }

        System.out.println("update:"+session.getId());
        String key = getKey(session);
        redisTemplate.opsForValue().set(key, session, expireTime, timeUnit);
    }

    private String getKey(Session session) {
        return this.redisPrefix + String.valueOf(session.getId());
    }

    private String getSessionIdKey(String sessionId) {
        return this.redisPrefix + String.valueOf(sessionId);
    }

    @Override // 刪除session
    public void delete(Session session) {
        System.out.println("===============delete================");
        if (null == session) {
            return;
        }
        redisTemplate.opsForValue().getOperations().delete(getKey(session));

    }

    @Override
    // 獲取活躍的session，可以用來統計線上人數，如果要實現這個功能，可以在將session加入redis時指定一個session字首，統計的時候則使用keys("session-prefix*")的方式來模糊查詢redis中所有的session集合
    public Collection<Session> getActiveSessions() {
        //        System.out.println("==============getActiveSessions=================");
        //        return redisTemplate.keys("*");
        return Collections.EMPTY_LIST;
    }

    @Override// 加入session
    protected Serializable doCreate(Session session) {
        System.out.println("===============doCreate================");
        Serializable sessionId = this.generateSessionId(session);
        this.assignSessionId(session, sessionId);
        redisTemplate.opsForValue().set(getKey(session), session, expireTime, timeUnit);
        return sessionId;
    }

    @Override// 讀取session
    protected Session doReadSession(Serializable sessionId) {
        System.out.println("==============doReadSession=================");
        if (sessionId == null) {
            return null;
        }
        return (Session) redisTemplate.opsForValue().get(getSessionIdKey(String.valueOf(sessionId)));
    }

    public long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(long expireTime) {
        this.expireTime = expireTime;
    }
}
