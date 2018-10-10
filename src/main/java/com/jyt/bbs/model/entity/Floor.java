package com.jyt.bbs.model.entity;

import java.io.Serializable;
import java.util.Date;

public class Floor implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column floor.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column floor.user_id
     *
     * @mbggenerated
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column floor.post_id
     *
     * @mbggenerated
     */
    private Integer postId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column floor.num
     *
     * @mbggenerated
     */
    private String num;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column floor.to_num
     *
     * @mbggenerated
     */
    private String toNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column floor.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column floor.content
     *
     * @mbggenerated
     */
    private String content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table floor
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column floor.id
     *
     * @return the value of floor.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column floor.id
     *
     * @param id the value for floor.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column floor.user_id
     *
     * @return the value of floor.user_id
     *
     * @mbggenerated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column floor.user_id
     *
     * @param userId the value for floor.user_id
     *
     * @mbggenerated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column floor.post_id
     *
     * @return the value of floor.post_id
     *
     * @mbggenerated
     */
    public Integer getPostId() {
        return postId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column floor.post_id
     *
     * @param postId the value for floor.post_id
     *
     * @mbggenerated
     */
    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column floor.num
     *
     * @return the value of floor.num
     *
     * @mbggenerated
     */
    public String getNum() {
        return num;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column floor.num
     *
     * @param num the value for floor.num
     *
     * @mbggenerated
     */
    public void setNum(String num) {
        this.num = num;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column floor.to_num
     *
     * @return the value of floor.to_num
     *
     * @mbggenerated
     */
    public String getToNum() {
        return toNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column floor.to_num
     *
     * @param toNum the value for floor.to_num
     *
     * @mbggenerated
     */
    public void setToNum(String toNum) {
        this.toNum = toNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column floor.create_time
     *
     * @return the value of floor.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column floor.create_time
     *
     * @param createTime the value for floor.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column floor.content
     *
     * @return the value of floor.content
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column floor.content
     *
     * @param content the value for floor.content
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table floor
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", postId=").append(postId);
        sb.append(", num=").append(num);
        sb.append(", toNum=").append(toNum);
        sb.append(", createTime=").append(createTime);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}