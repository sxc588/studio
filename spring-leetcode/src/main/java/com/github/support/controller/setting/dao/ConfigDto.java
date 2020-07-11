package com.github.support.controller.setting.dao;

import java.io.Serializable;
import java.util.Date;

public class ConfigDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String description;
	private String key;
	private String lastUpdateBy;

	private Date lastUpdateTime;
	private String value;

	public String getDescription() {
		return description;
	}

	public String getKey() {
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
		this.description = description;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setLastUpdateBy(String lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
