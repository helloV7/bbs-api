package com.jyt.bbs.model.entity;

import java.io.Serializable;
import java.util.Date;

public class FlywaySchemaHistory implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column flyway_schema_history.installed_rank
     *
     * @mbggenerated
     */
    private Integer installedRank;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column flyway_schema_history.version
     *
     * @mbggenerated
     */
    private String version;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column flyway_schema_history.description
     *
     * @mbggenerated
     */
    private String description;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column flyway_schema_history.type
     *
     * @mbggenerated
     */
    private String type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column flyway_schema_history.script
     *
     * @mbggenerated
     */
    private String script;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column flyway_schema_history.checksum
     *
     * @mbggenerated
     */
    private Integer checksum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column flyway_schema_history.installed_by
     *
     * @mbggenerated
     */
    private String installedBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column flyway_schema_history.installed_on
     *
     * @mbggenerated
     */
    private Date installedOn;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column flyway_schema_history.execution_time
     *
     * @mbggenerated
     */
    private Integer executionTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column flyway_schema_history.success
     *
     * @mbggenerated
     */
    private Boolean success;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table flyway_schema_history
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column flyway_schema_history.installed_rank
     *
     * @return the value of flyway_schema_history.installed_rank
     *
     * @mbggenerated
     */
    public Integer getInstalledRank() {
        return installedRank;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column flyway_schema_history.installed_rank
     *
     * @param installedRank the value for flyway_schema_history.installed_rank
     *
     * @mbggenerated
     */
    public void setInstalledRank(Integer installedRank) {
        this.installedRank = installedRank;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column flyway_schema_history.version
     *
     * @return the value of flyway_schema_history.version
     *
     * @mbggenerated
     */
    public String getVersion() {
        return version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column flyway_schema_history.version
     *
     * @param version the value for flyway_schema_history.version
     *
     * @mbggenerated
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column flyway_schema_history.description
     *
     * @return the value of flyway_schema_history.description
     *
     * @mbggenerated
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column flyway_schema_history.description
     *
     * @param description the value for flyway_schema_history.description
     *
     * @mbggenerated
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column flyway_schema_history.type
     *
     * @return the value of flyway_schema_history.type
     *
     * @mbggenerated
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column flyway_schema_history.type
     *
     * @param type the value for flyway_schema_history.type
     *
     * @mbggenerated
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column flyway_schema_history.script
     *
     * @return the value of flyway_schema_history.script
     *
     * @mbggenerated
     */
    public String getScript() {
        return script;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column flyway_schema_history.script
     *
     * @param script the value for flyway_schema_history.script
     *
     * @mbggenerated
     */
    public void setScript(String script) {
        this.script = script;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column flyway_schema_history.checksum
     *
     * @return the value of flyway_schema_history.checksum
     *
     * @mbggenerated
     */
    public Integer getChecksum() {
        return checksum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column flyway_schema_history.checksum
     *
     * @param checksum the value for flyway_schema_history.checksum
     *
     * @mbggenerated
     */
    public void setChecksum(Integer checksum) {
        this.checksum = checksum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column flyway_schema_history.installed_by
     *
     * @return the value of flyway_schema_history.installed_by
     *
     * @mbggenerated
     */
    public String getInstalledBy() {
        return installedBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column flyway_schema_history.installed_by
     *
     * @param installedBy the value for flyway_schema_history.installed_by
     *
     * @mbggenerated
     */
    public void setInstalledBy(String installedBy) {
        this.installedBy = installedBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column flyway_schema_history.installed_on
     *
     * @return the value of flyway_schema_history.installed_on
     *
     * @mbggenerated
     */
    public Date getInstalledOn() {
        return installedOn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column flyway_schema_history.installed_on
     *
     * @param installedOn the value for flyway_schema_history.installed_on
     *
     * @mbggenerated
     */
    public void setInstalledOn(Date installedOn) {
        this.installedOn = installedOn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column flyway_schema_history.execution_time
     *
     * @return the value of flyway_schema_history.execution_time
     *
     * @mbggenerated
     */
    public Integer getExecutionTime() {
        return executionTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column flyway_schema_history.execution_time
     *
     * @param executionTime the value for flyway_schema_history.execution_time
     *
     * @mbggenerated
     */
    public void setExecutionTime(Integer executionTime) {
        this.executionTime = executionTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column flyway_schema_history.success
     *
     * @return the value of flyway_schema_history.success
     *
     * @mbggenerated
     */
    public Boolean getSuccess() {
        return success;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column flyway_schema_history.success
     *
     * @param success the value for flyway_schema_history.success
     *
     * @mbggenerated
     */
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flyway_schema_history
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", installedRank=").append(installedRank);
        sb.append(", version=").append(version);
        sb.append(", description=").append(description);
        sb.append(", type=").append(type);
        sb.append(", script=").append(script);
        sb.append(", checksum=").append(checksum);
        sb.append(", installedBy=").append(installedBy);
        sb.append(", installedOn=").append(installedOn);
        sb.append(", executionTime=").append(executionTime);
        sb.append(", success=").append(success);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}