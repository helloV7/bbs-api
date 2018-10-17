package com.jyt.bbs.dao;

import com.jyt.bbs.model.entity.UserFile;
import java.util.List;

public interface UserFileMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_file
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_file
     *
     * @mbggenerated
     */
    int insert(UserFile record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_file
     *
     * @mbggenerated
     */
    UserFile selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_file
     *
     * @mbggenerated
     */
    List<UserFile> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_file
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(UserFile record);
}