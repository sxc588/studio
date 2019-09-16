package com.github.support.dbaccess.dto;

public class MonScheduleCronExpression {

	private int count;

	private String cronExpression;

	public int getCount() {
		return count;
	}

	public String getCronExpression() {
		return cronExpression;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}
}