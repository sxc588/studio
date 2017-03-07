package com.github.support.htmlarea.ws.dto;

import java.util.Date;


public class HtmlAreaBean
{
	private String areaId;
	private String content;
	private String description;
	private String lastUpdateBy;
	private Date lastUpdateTtime;
	private Date careteTtime;
	public String getAreaId()
	{
		return areaId;
	}
	public void setAreaId(String areaId)
	{
		this.areaId = areaId;
	}
	public String getContent()
	{
		return content;
	}
	public void setContent(String content)
	{
		this.content = content;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public String getLastUpdateBy()
	{
		return lastUpdateBy;
	}
	public void setLastUpdateBy(String lastUpdateBy)
	{
		this.lastUpdateBy = lastUpdateBy;
	}
	public Date getLastUpdateTtime()
	{
		return lastUpdateTtime;
	}
	public void setLastUpdateTtime(Date lastUpdateTtime)
	{
		this.lastUpdateTtime = lastUpdateTtime;
	}
	public Date getCareteTtime()
	{
		return careteTtime;
	}
	public void setCareteTtime(Date careteTtime)
	{
		this.careteTtime = careteTtime;
	}
}
