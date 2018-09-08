package com.github.support.vo;

import com.dexcoder.commons.pager.Pageable;

import java.util.Date;

/**
 * author : benjamin
 * createTime : 2017.06.06
 * description : 产品模型Vo
 * version : 1.0
 */
public class IssueVo //extends Pageable 
{

    public IssueVo(String issueID, String title, String description, String progress, Date createTime, String locked)
	{
		super();
		this.issueID = issueID;
		this.title = title;
		this.description = description;
		this.progress = progress;
		this.createTime = createTime;
		this.locked = locked;
	}
//	private static final long  serialVersionUID = -4216107640768329947L;
    
    private String issueID;
    
    private String title;
    private String description;
    private String progress;
    private Date createTime;
    private String locked;
	public String getIssueID()
	{
		return issueID;
	}
	public void setIssueID(String issueID)
	{
		this.issueID = issueID;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public String getProgress()
	{
		return progress;
	}
	public void setProgress(String progress)
	{
		this.progress = progress;
	}
	public Date getCreateTime()
	{
		return createTime;
	}
	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}
	public String getLocked()
	{
		return locked;
	}
	public void setLocked(String locked)
	{
		this.locked = locked;
	}


}
