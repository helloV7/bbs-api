package com.jyt.bbs.model.entity;

import java.io.Serializable;

public class Attachment implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column attachment.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column attachment.admin_id
     *
     * @mbggenerated
     */
    private Integer adminId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column attachment.user_id
     *
     * @mbggenerated
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column attachment.url
     *
     * @mbggenerated
     */
    private String url;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column attachment.imagewidth
     *
     * @mbggenerated
     */
    private String imagewidth;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column attachment.imageheight
     *
     * @mbggenerated
     */
    private String imageheight;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column attachment.imagetype
     *
     * @mbggenerated
     */
    private String imagetype;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column attachment.imageframes
     *
     * @mbggenerated
     */
    private Integer imageframes;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column attachment.filesize
     *
     * @mbggenerated
     */
    private Integer filesize;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column attachment.mimetype
     *
     * @mbggenerated
     */
    private String mimetype;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column attachment.extparam
     *
     * @mbggenerated
     */
    private String extparam;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column attachment.createtime
     *
     * @mbggenerated
     */
    private Integer createtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column attachment.updatetime
     *
     * @mbggenerated
     */
    private Integer updatetime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column attachment.uploadtime
     *
     * @mbggenerated
     */
    private Integer uploadtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column attachment.storage
     *
     * @mbggenerated
     */
    private String storage;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column attachment.sha1
     *
     * @mbggenerated
     */
    private String sha1;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table attachment
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column attachment.id
     *
     * @return the value of attachment.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column attachment.id
     *
     * @param id the value for attachment.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column attachment.admin_id
     *
     * @return the value of attachment.admin_id
     *
     * @mbggenerated
     */
    public Integer getAdminId() {
        return adminId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column attachment.admin_id
     *
     * @param adminId the value for attachment.admin_id
     *
     * @mbggenerated
     */
    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column attachment.user_id
     *
     * @return the value of attachment.user_id
     *
     * @mbggenerated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column attachment.user_id
     *
     * @param userId the value for attachment.user_id
     *
     * @mbggenerated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column attachment.url
     *
     * @return the value of attachment.url
     *
     * @mbggenerated
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column attachment.url
     *
     * @param url the value for attachment.url
     *
     * @mbggenerated
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column attachment.imagewidth
     *
     * @return the value of attachment.imagewidth
     *
     * @mbggenerated
     */
    public String getImagewidth() {
        return imagewidth;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column attachment.imagewidth
     *
     * @param imagewidth the value for attachment.imagewidth
     *
     * @mbggenerated
     */
    public void setImagewidth(String imagewidth) {
        this.imagewidth = imagewidth;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column attachment.imageheight
     *
     * @return the value of attachment.imageheight
     *
     * @mbggenerated
     */
    public String getImageheight() {
        return imageheight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column attachment.imageheight
     *
     * @param imageheight the value for attachment.imageheight
     *
     * @mbggenerated
     */
    public void setImageheight(String imageheight) {
        this.imageheight = imageheight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column attachment.imagetype
     *
     * @return the value of attachment.imagetype
     *
     * @mbggenerated
     */
    public String getImagetype() {
        return imagetype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column attachment.imagetype
     *
     * @param imagetype the value for attachment.imagetype
     *
     * @mbggenerated
     */
    public void setImagetype(String imagetype) {
        this.imagetype = imagetype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column attachment.imageframes
     *
     * @return the value of attachment.imageframes
     *
     * @mbggenerated
     */
    public Integer getImageframes() {
        return imageframes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column attachment.imageframes
     *
     * @param imageframes the value for attachment.imageframes
     *
     * @mbggenerated
     */
    public void setImageframes(Integer imageframes) {
        this.imageframes = imageframes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column attachment.filesize
     *
     * @return the value of attachment.filesize
     *
     * @mbggenerated
     */
    public Integer getFilesize() {
        return filesize;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column attachment.filesize
     *
     * @param filesize the value for attachment.filesize
     *
     * @mbggenerated
     */
    public void setFilesize(Integer filesize) {
        this.filesize = filesize;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column attachment.mimetype
     *
     * @return the value of attachment.mimetype
     *
     * @mbggenerated
     */
    public String getMimetype() {
        return mimetype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column attachment.mimetype
     *
     * @param mimetype the value for attachment.mimetype
     *
     * @mbggenerated
     */
    public void setMimetype(String mimetype) {
        this.mimetype = mimetype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column attachment.extparam
     *
     * @return the value of attachment.extparam
     *
     * @mbggenerated
     */
    public String getExtparam() {
        return extparam;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column attachment.extparam
     *
     * @param extparam the value for attachment.extparam
     *
     * @mbggenerated
     */
    public void setExtparam(String extparam) {
        this.extparam = extparam;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column attachment.createtime
     *
     * @return the value of attachment.createtime
     *
     * @mbggenerated
     */
    public Integer getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column attachment.createtime
     *
     * @param createtime the value for attachment.createtime
     *
     * @mbggenerated
     */
    public void setCreatetime(Integer createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column attachment.updatetime
     *
     * @return the value of attachment.updatetime
     *
     * @mbggenerated
     */
    public Integer getUpdatetime() {
        return updatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column attachment.updatetime
     *
     * @param updatetime the value for attachment.updatetime
     *
     * @mbggenerated
     */
    public void setUpdatetime(Integer updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column attachment.uploadtime
     *
     * @return the value of attachment.uploadtime
     *
     * @mbggenerated
     */
    public Integer getUploadtime() {
        return uploadtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column attachment.uploadtime
     *
     * @param uploadtime the value for attachment.uploadtime
     *
     * @mbggenerated
     */
    public void setUploadtime(Integer uploadtime) {
        this.uploadtime = uploadtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column attachment.storage
     *
     * @return the value of attachment.storage
     *
     * @mbggenerated
     */
    public String getStorage() {
        return storage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column attachment.storage
     *
     * @param storage the value for attachment.storage
     *
     * @mbggenerated
     */
    public void setStorage(String storage) {
        this.storage = storage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column attachment.sha1
     *
     * @return the value of attachment.sha1
     *
     * @mbggenerated
     */
    public String getSha1() {
        return sha1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column attachment.sha1
     *
     * @param sha1 the value for attachment.sha1
     *
     * @mbggenerated
     */
    public void setSha1(String sha1) {
        this.sha1 = sha1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attachment
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
        sb.append(", adminId=").append(adminId);
        sb.append(", userId=").append(userId);
        sb.append(", url=").append(url);
        sb.append(", imagewidth=").append(imagewidth);
        sb.append(", imageheight=").append(imageheight);
        sb.append(", imagetype=").append(imagetype);
        sb.append(", imageframes=").append(imageframes);
        sb.append(", filesize=").append(filesize);
        sb.append(", mimetype=").append(mimetype);
        sb.append(", extparam=").append(extparam);
        sb.append(", createtime=").append(createtime);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", uploadtime=").append(uploadtime);
        sb.append(", storage=").append(storage);
        sb.append(", sha1=").append(sha1);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}