package com.github.support.dbaccess.dto;

import java.util.Date;

public class MonSysConfig {
	private String description;

	private Integer key;

	private String lastUpdateBy;

	private Date lastUpdateTime;

	private String value;

	public MonSysConfig() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MonSysConfig(Integer key, String value, String description, Date lastUpdateTime, String lastUpdateBy) {
		super();
		this.key = key;
		this.value = value;
		this.description = description;
		this.lastUpdateTime = lastUpdateTime;
		this.lastUpdateBy = lastUpdateBy;
	}

	public String getDescription() {
		return description;
	}

	public Integer getKey() {
		return key;
	}

	public String getLastUpdateBy() {
		return lastUpdateBy;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public String getValue() {
		return value;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public void setKey(Integer key) {
		this.key = key;
	}

	public void setLastUpdateBy(String lastUpdateBy) {

		this.lastUpdateBy = lastUpdateBy == null ? null : lastUpdateBy.trim();
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public void setValue(String value) {
		this.value = value == null ? null : value.trim();
	}
}