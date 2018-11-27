package com.github.support.dbaccess.dto;

import java.util.Date;

public class MonMatrixDto
{
	public String getMachineName() {
		return machineName;
	}
	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}
	public String getMatrixKey() {
		return matrixKey;
	}
	public void setMatrixKey(String matrixKey) {
		this.matrixKey = matrixKey;
	}
	public String getMatrixFiled() {
		return matrixFiled;
	}
	public void setMatrixFiled(String matrixFiled) {
		this.matrixFiled = matrixFiled;
	}
	public Integer getMatrixValue() {
		return matrixValue;
	}
	public void setMatrixValue(Integer matrixValue) {
		this.matrixValue = matrixValue;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	private String machineName;

	private String matrixKey;

	private String matrixFiled;

	private Integer matrixValue;
	private Date createDate;


}