package com.jyt.bbs.dao;

import com.jyt.bbs.model.entity.Config;
import java.util.List;

public interface ConfigMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table config
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table config
     *
     * @mbggenerated
     */
    int insert(Config record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table config
     *
     * @mbggenerated
     */
    Config selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table config
     *
     * @mbggenerated
     */
    List<Config> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table config
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Config record);
}