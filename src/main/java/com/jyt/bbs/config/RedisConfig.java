package com.jyt.bbs.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;



public class RedisConfig {


    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(factory);
        /**Jackson序列化  json占用的内存最小 */
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);

        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        om.configure(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE,false);
        om.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES,false);
        om.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES,false);
        om.configure(DeserializationFeature.FAIL_ON_MISSING_EXTERNAL_TYPE_ID_PROPERTY,false);
        om.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES,false);

        jackson2JsonRedisSerializer.setObjectMapper(om);
        /**Jdk序列化   JdkSerializationRedisSerializer是最高效的*/
      JdkSerializationRedisSerializer jdkSerializationRedisSerializer = new JdkSerializationRedisSerializer();
        /**String序列化*/
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        /**将key value 进行stringRedisSerializer序列化*/
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
//        redisTemplate.setValueSerializer(jdkSerializationRedisSerializer);
        /**将HashKey HashValue 进行序列化*/
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
//        redisTemplate.setHashValueSerializer(jdkSerializationRedisSerializer);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }


}
