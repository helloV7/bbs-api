package com.jyt.bbs.dao;

import com.jyt.bbs.model.entity.Appeal;
import java.util.List;

public interface AppealMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table appeal
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table appeal
     *
     * @mbggenerated
     */
    int insert(Appeal record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table appeal
     *
     * @mbggenerated
     */
    Appeal selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table appeal
     *
     * @mbggenerated
     */
    List<Appeal> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table appeal
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Appeal record);
}