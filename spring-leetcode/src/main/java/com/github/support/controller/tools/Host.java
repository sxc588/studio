package com.github.support.controller.tools;

import java.util.Date;

public class Host {

	private String hostName;

	private String ipAddress;

	private String status;
	
	private String lastUpdateBy;

	private Date lastUpdateTime;


	/**
	 * @param hostName
	 */
	public Host(String hostName) {
		super();
		this.hostName = hostName;
		

		this.lastUpdateBy = "unkonow";
		this.lastUpdateTime = new Date();
		this.ipAddress = "127.0.0.1";
		this.status = "80";
	}
	public String getHostName() {
		return hostName;
	}

	public String getIpAddress() {
		return ipAddress;
	}


	public String getLastUpdateBy() {
		return lastUpdateBy;
	}
	
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public String getStatus() {
		return status;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}



	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}



	public void setLastUpdateBy(String lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
}
