package com.jyt.bbs.model.entity;

import java.io.Serializable;

public class Version implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column version.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column version.oldversion
     *
     * @mbggenerated
     */
    private String oldversion;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column version.newversion
     *
     * @mbggenerated
     */
    private String newversion;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column version.packagesize
     *
     * @mbggenerated
     */
    private String packagesize;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column version.content
     *
     * @mbggenerated
     */
    private String content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column version.downloadurl
     *
     * @mbggenerated
     */
    private String downloadurl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column version.enforce
     *
     * @mbggenerated
     */
    private Boolean enforce;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column version.createtime
     *
     * @mbggenerated
     */
    private Integer createtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column version.updatetime
     *
     * @mbggenerated
     */
    private Integer updatetime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column version.weigh
     *
     * @mbggenerated
     */
    private Integer weigh;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column version.status
     *
     * @mbggenerated
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table version
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column version.id
     *
     * @return the value of version.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column version.id
     *
     * @param id the value for version.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column version.oldversion
     *
     * @return the value of version.oldversion
     *
     * @mbggenerated
     */
    public String getOldversion() {
        return oldversion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column version.oldversion
     *
     * @param oldversion the value for version.oldversion
     *
     * @mbggenerated
     */
    public void setOldversion(String oldversion) {
        this.oldversion = oldversion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column version.newversion
     *
     * @return the value of version.newversion
     *
     * @mbggenerated
     */
    public String getNewversion() {
        return newversion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column version.newversion
     *
     * @param newversion the value for version.newversion
     *
     * @mbggenerated
     */
    public void setNewversion(String newversion) {
        this.newversion = newversion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column version.packagesize
     *
     * @return the value of version.packagesize
     *
     * @mbggenerated
     */
    public String getPackagesize() {
        return packagesize;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column version.packagesize
     *
     * @param packagesize the value for version.packagesize
     *
     * @mbggenerated
     */
    public void setPackagesize(String packagesize) {
        this.packagesize = packagesize;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column version.content
     *
     * @return the value of version.content
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column version.content
     *
     * @param content the value for version.content
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column version.downloadurl
     *
     * @return the value of version.downloadurl
     *
     * @mbggenerated
     */
    public String getDownloadurl() {
        return downloadurl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column version.downloadurl
     *
     * @param downloadurl the value for version.downloadurl
     *
     * @mbggenerated
     */
    public void setDownloadurl(String downloadurl) {
        this.downloadurl = downloadurl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column version.enforce
     *
     * @return the value of version.enforce
     *
     * @mbggenerated
     */
    public Boolean getEnforce() {
        return enforce;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column version.enforce
     *
     * @param enforce the value for version.enforce
     *
     * @mbggenerated
     */
    public void setEnforce(Boolean enforce) {
        this.enforce = enforce;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column version.createtime
     *
     * @return the value of version.createtime
     *
     * @mbggenerated
     */
    public Integer getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column version.createtime
     *
     * @param createtime the value for version.createtime
     *
     * @mbggenerated
     */
    public void setCreatetime(Integer createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column version.updatetime
     *
     * @return the value of version.updatetime
     *
     * @mbggenerated
     */
    public Integer getUpdatetime() {
        return updatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column version.updatetime
     *
     * @param updatetime the value for version.updatetime
     *
     * @mbggenerated
     */
    public void setUpdatetime(Integer updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column version.weigh
     *
     * @return the value of version.weigh
     *
     * @mbggenerated
     */
    public Integer getWeigh() {
        return weigh;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column version.weigh
     *
     * @param weigh the value for version.weigh
     *
     * @mbggenerated
     */
    public void setWeigh(Integer weigh) {
        this.weigh = weigh;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column version.status
     *
     * @return the value of version.status
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column version.status
     *
     * @param status the value for version.status
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table version
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
        sb.append(", oldversion=").append(oldversion);
        sb.append(", newversion=").append(newversion);
        sb.append(", packagesize=").append(packagesize);
        sb.append(", content=").append(content);
        sb.append(", downloadurl=").append(downloadurl);
        sb.append(", enforce=").append(enforce);
        sb.append(", createtime=").append(createtime);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", weigh=").append(weigh);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}