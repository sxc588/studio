package com.github.support.dbaccess.dto;

public class MonScheduleCronExpression {

    public String getCronExpression() {
		return cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	private String cronExpression;

    private int count;
}