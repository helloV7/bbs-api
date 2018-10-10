package com.jyt.bbs.dao;

import com.jyt.bbs.model.entity.Advertisement;
import java.util.List;

public interface AdvertisementMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table advertisement
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table advertisement
     *
     * @mbggenerated
     */
    int insert(Advertisement record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table advertisement
     *
     * @mbggenerated
     */
    Advertisement selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table advertisement
     *
     * @mbggenerated
     */
    List<Advertisement> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table advertisement
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Advertisement record);
}