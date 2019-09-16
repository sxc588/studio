package com.github.support.dbaccess.dto;

import java.util.Date;

public class MonScheduleBase2 {
	private String aliasName;

	private String cronExpression;

	private String description;

	private Date gmtCreate;

	private Date gmtModify;

	private String isSync;

	private String jobGroup;

	private String jobName;

	private String jobTrigger;

	private Long scheduleJobId;

	private String status;

	private String url;

	public String getAliasName() {
		return aliasName;
	}

	public String getCronExpression() {
		return cronExpression;
	}

	public String getDescription() {
		return description;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public Date getGmtModify() {
		return gmtModify;
	}

	public String getIsSync() {
		return isSync;
	}

	public String getJobGroup() {
		return jobGroup;
	}

	public String getJobName() {
		return jobName;
	}

	public String getJobTrigger() {
		return jobTrigger;
	}

	public Long getScheduleJobId() {
		return scheduleJobId;
	}

	public String getStatus() {
		return status;
	}

	public String getUrl() {
		return url;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName == null ? null : aliasName.trim();
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression == null ? null : cronExpression.trim();
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public void setGmtModify(Date gmtModify) {
		this.gmtModify = gmtModify;
	}

	public void setIsSync(String isSync) {
		this.isSync = isSync == null ? null : isSync.trim();
	}

	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup == null ? null : jobGroup.trim();
	}

	public void setJobName(String jobName) {
		this.jobName = jobName == null ? null : jobName.trim();
	}

	public void setJobTrigger(String jobTrigger) {
		this.jobTrigger = jobTrigger == null ? null : jobTrigger.trim();
	}

	public void setScheduleJobId(Long scheduleJobId) {
		this.scheduleJobId = scheduleJobId;
	}

	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
	}
}