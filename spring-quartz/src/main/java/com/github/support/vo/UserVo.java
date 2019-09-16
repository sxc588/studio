package com.github.support.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.dexcoder.commons.pager.Pageable;

public class UserVo extends Pageable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String Address;

	private int Age;
	private int Country;
	private Date lastUpdateTime;
	private boolean Married;
	private String Name;

	public UserVo(String name, int age, int country, String address, boolean married) {
		super();
		Name = name;
		Age = age;
		Country = country;
		Address = address;
		Married = married;

		lastUpdateTime = new Date();
	}

	public String getAddress() {
		return Address;
	}

	public int getAge() {
		return Age;
	}

	public int getCountry() {
		return Country;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public String getLastUpdateTimeFmt() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		return sdf.format(lastUpdateTime);
	}

	public String getName() {
		return Name;
	}

	public boolean isMarried() {
		return Married;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public void setAge(int age) {
		Age = age;
	}

	public void setCountry(int country) {
		Country = country;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public void setMarried(boolean married) {
		Married = married;
	}

	public void setName(String name) {
		Name = name;
	}
}
