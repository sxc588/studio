package com.github.support.vo;

import java.util.Date;

/**
 * author : benjamin createTime : 2017.06.06 description : 产品模型Vo version : 1.0
 */
public class IssueVo // extends Pageable
{

	private Date createTime;

	private String description;

	private String issueID;
	private String locked;
	private String progress;
	private String title;

	public IssueVo(String issueID, String title, String description, String progress, Date createTime, String locked) {
		super();
		this.issueID = issueID;
		this.title = title;
		this.description = description;
		this.progress = progress;
		this.createTime = createTime;
		this.locked = locked;
	}

//	private static final long  serialVersionUID = -4216107640768329947L;
	public Date getCreateTime() {
		return createTime;
	}

	public String getDescription() {
		return description;
	}

	public String getIssueID() {
		return issueID;
	}

	public String getLocked() {
		return locked;
	}

	public String getProgress() {
		return progress;
	}

	public String getTitle() {
		return title;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setIssueID(String issueID) {
		this.issueID = issueID;
	}

	public void setLocked(String locked) {
		this.locked = locked;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
