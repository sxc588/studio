package com.github.support.dbaccess.dto;

import java.util.Date;

public class MonMatrixDto {
	private Date createDate;
	private String machineName;
	private String matrixFiled;
	private String matrixKey;
	private Integer matrixValue;

	public Date getCreateDate() {
		return createDate;
	}

	public String getMachineName() {
		return machineName;
	}

	public String getMatrixFiled() {
		return matrixFiled;
	}

	public String getMatrixKey() {
		return matrixKey;
	}

	public Integer getMatrixValue() {
		return matrixValue;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}

	public void setMatrixFiled(String matrixFiled) {
		this.matrixFiled = matrixFiled;
	}

	public void setMatrixKey(String matrixKey) {
		this.matrixKey = matrixKey;
	}

	public void setMatrixValue(Integer matrixValue) {
		this.matrixValue = matrixValue;
	}

}