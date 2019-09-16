package com.github.support.vo;

import java.util.Date;

import com.dexcoder.commons.pager.Pageable;

/**
 * author : benjamin createTime : 2017.06.06 description : 定时任务模型Vo version :
 * 1.0
 */
public class ScheduleJobVo extends Pageable {

	/** 任务调度的参数key */
	public static final String JOB_PARAM_KEY = "jobParam";

	private static final long serialVersionUID = -4216107640768329946L;

	/** 任务别名 */
	private String aliasName;

	/** 任务运行时间表达式 */
	private String cronExpression;

	/** 任务描述 */
	private String description;

	/** 创建时间 */
	private Date gmtCreate;

	/** 修改时间 */
	private Date gmtModify;

	/** 是否异步 */
	private Boolean isSync;

	/** 任务分组 */
	private String jobGroup;

	/** 任务名称 */
	private String jobName;

	/** 触发器 */
	private String jobTrigger;

	/** 修改时间 */
	private Date nextFireTime;

	/** 修改时间 */
	private Date previousFireTime;

	/** 任务id */
	private Long scheduleJobId;

	/** 任务状态 */
	private String status;

	/** 任务执行url */
	private String url;

	// private Trigger trigger;

//    public Trigger getTrigger()
//	{
//		return trigger;
//	}
//
//	public void setTrigger(Trigger trigger)
//	{
//		this.trigger = trigger;
//	}

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

	public Boolean getIsSync() {
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

	public Date getNextFireTime() {
		return nextFireTime;
	}

	public Date getPreviousFireTime() {
		return previousFireTime;
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
		this.aliasName = aliasName;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public void setGmtModify(Date gmtModify) {
		this.gmtModify = gmtModify;
	}

	public void setIsSync(Boolean isSync) {
		this.isSync = isSync;
	}

	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public void setJobTrigger(String jobTrigger) {
		this.jobTrigger = jobTrigger;
	}

	public void setNextFireTime(Date nextFireTime) {
		this.nextFireTime = nextFireTime;
	}

	public void setPreviousFireTime(Date previousFireTime) {
		this.previousFireTime = previousFireTime;
	}

	public void setScheduleJobId(Long scheduleJobId) {
		this.scheduleJobId = scheduleJobId;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
