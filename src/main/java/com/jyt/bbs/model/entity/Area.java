package com.jyt.bbs.model.entity;

import java.io.Serializable;
import java.util.Date;

public class Area implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column area.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column area.parent_id
     *
     * @mbggenerated
     */
    private String parentId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column area.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column area.image_url
     *
     * @mbggenerated
     */
    private String imageUrl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column area.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column area.area_ notice
     *
     * @mbggenerated
     */
    private String areaNotice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table area
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column area.id
     *
     * @return the value of area.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column area.id
     *
     * @param id the value for area.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column area.parent_id
     *
     * @return the value of area.parent_id
     *
     * @mbggenerated
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column area.parent_id
     *
     * @param parentId the value for area.parent_id
     *
     * @mbggenerated
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column area.name
     *
     * @return the value of area.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column area.name
     *
     * @param name the value for area.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column area.image_url
     *
     * @return the value of area.image_url
     *
     * @mbggenerated
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column area.image_url
     *
     * @param imageUrl the value for area.image_url
     *
     * @mbggenerated
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column area.create_time
     *
     * @return the value of area.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column area.create_time
     *
     * @param createTime the value for area.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column area.area_ notice
     *
     * @return the value of area.area_ notice
     *
     * @mbggenerated
     */
    public String getAreaNotice() {
        return areaNotice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column area.area_ notice
     *
     * @param areaNotice the value for area.area_ notice
     *
     * @mbggenerated
     */
    public void setAreaNotice(String areaNotice) {
        this.areaNotice = areaNotice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table area
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
        sb.append(", parentId=").append(parentId);
        sb.append(", name=").append(name);
        sb.append(", imageUrl=").append(imageUrl);
        sb.append(", createTime=").append(createTime);
        sb.append(", areaNotice=").append(areaNotice);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}