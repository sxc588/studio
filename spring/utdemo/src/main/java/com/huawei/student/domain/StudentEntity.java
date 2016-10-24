package com.huawei.student.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;



public class StudentEntity implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ClassEntity classEntity;
	private Date studentBirthday;
	private String studentID;
	private String studentName;
	private String studentSex;

	public ClassEntity getClassEntity()
	{
		return classEntity;
	}

	public Date getStudentBirthday()
	{
		return studentBirthday;
	}

	public String getStudentID()
	{
		return studentID;
	}

	public String getStudentName()
	{
		return studentName;
	}

	public String getStudentSex()
	{
		return studentSex;
	}

	public void setClassEntity(ClassEntity classEntity)
	{
		this.classEntity = classEntity;
	}

	public void setStudentBirthday(Date studentBirthday)
	{
		this.studentBirthday = studentBirthday;
	}

	public void setStudentID(String studentID)
	{
		this.studentID = studentID;
	}

	public void setStudentName(String studentName)
	{
		this.studentName = studentName;
	}

	public void setStudentSex(String studentSex)
	{
		this.studentSex = studentSex;
	}
}
