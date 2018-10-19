package com.jyt.bbs.shiro;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.util.SerializationUtils;

import java.io.Serializable;

public class CollectionSerializer<T extends Serializable> implements RedisSerializer<T> {
    private CollectionSerializer(){}
    public static volatile CollectionSerializer<Serializable> collectionSerializer=null;
    public static CollectionSerializer<Serializable> getInstance(){
        if(collectionSerializer==null){
            synchronized (CollectionSerializer.class) {
                if(collectionSerializer==null){
                    collectionSerializer=new CollectionSerializer<>();
                }
            }
        }
        return collectionSerializer;
    }
    @Override
    public byte[] serialize(T t) throws SerializationException {
        return SerializationUtils.serialize(t);
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        return (T) SerializationUtils.deserialize(bytes);
    }


}
