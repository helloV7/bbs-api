package com.jyt.bbs.dao;

import com.jyt.bbs.model.entity.OperationLog;
import java.util.List;

public interface OperationLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table operation_log
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table operation_log
     *
     * @mbggenerated
     */
    int insert(OperationLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table operation_log
     *
     * @mbggenerated
     */
    OperationLog selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table operation_log
     *
     * @mbggenerated
     */
    List<OperationLog> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table operation_log
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(OperationLog record);
}