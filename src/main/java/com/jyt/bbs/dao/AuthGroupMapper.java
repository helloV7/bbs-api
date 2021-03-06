package com.jyt.bbs.dao;

import com.jyt.bbs.model.entity.AuthGroup;
import java.util.List;

public interface AuthGroupMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table auth_group
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table auth_group
     *
     * @mbggenerated
     */
    int insert(AuthGroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table auth_group
     *
     * @mbggenerated
     */
    AuthGroup selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table auth_group
     *
     * @mbggenerated
     */
    List<AuthGroup> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table auth_group
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(AuthGroup record);
}