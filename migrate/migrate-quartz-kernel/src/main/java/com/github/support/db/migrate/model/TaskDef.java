package com.github.support.db.migrate.model;

public class TaskDef {
    private Integer id;

    private String configValue;

    private String jobClass;

    private String beginTime;

    private String endTime;

    private String statusCode;

    private String execption;

    private String statusDescription;

    private String ddfff;

    private String dddff;

    private String fff;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue == null ? null : configValue.trim();
    }

    public String getJobClass() {
        return jobClass;
    }

    public void setJobClass(String jobClass) {
        this.jobClass = jobClass == null ? null : jobClass.trim();
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime == null ? null : beginTime.trim();
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode == null ? null : statusCode.trim();
    }

    public String getExecption() {
        return execption;
    }

    public void setExecption(String execption) {
        this.execption = execption == null ? null : execption.trim();
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription == null ? null : statusDescription.trim();
    }

    public String getDdfff() {
        return ddfff;
    }

    public void setDdfff(String ddfff) {
        this.ddfff = ddfff == null ? null : ddfff.trim();
    }

    public String getDddff() {
        return dddff;
    }

    public void setDddff(String dddff) {
        this.dddff = dddff == null ? null : dddff.trim();
    }

    public String getFff() {
        return fff;
    }

    public void setFff(String fff) {
        this.fff = fff == null ? null : fff.trim();
    }
}