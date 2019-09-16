package com.github.support.service.ceph;

public class PTResult {

	private String code;// 结果编码
	private Object data;
	private String message;// 结果描述

	public PTResult() {
		this.setCode(PTConstants.ResultCode.SUCCESS);
		this.setMessage(PTConstants.ResultCode.SUCCESS.msg());

	}

	public PTResult(PTConstants.ResultCode code) {
		this.setCode(code);
		this.setMessage(code.msg());
	}

	public PTResult(PTConstants.ResultCode code, String message) {
		this.setCode(code);
		this.setMessage(message);
	}

	public PTResult(PTConstants.ResultCode code, String message, Object data) {
		this.setCode(code);
		this.setMessage(message);
		this.setData(data);
	}

	public String getCode() {
		return code;
	}

	public Object getData() {
		return data;
	}

	public String getMessage() {
		return message;
	}

	public void setCode(PTConstants.ResultCode code) {
		this.code = code.val();
		this.message = code.msg();
	}

	public void setData(Object data) {
		this.data = data;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}