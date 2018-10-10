package com.jyt.bbs.dao;

import com.jyt.bbs.model.entity.UserMessage;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMessageMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_message
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(@Param("userId") Integer userId, @Param("messageId") Integer messageId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_message
     *
     * @mbggenerated
     */
    int insert(UserMessage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_message
     *
     * @mbggenerated
     */
    List<UserMessage> selectAll();
}