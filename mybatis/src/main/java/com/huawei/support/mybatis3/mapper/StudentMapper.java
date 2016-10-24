package com.huawei.support.mybatis3.mapper;

import java.util.List;

import com.huawei.support.mybatis3.model.Student;

public interface StudentMapper
{
	int add(Student stu);

	int update(Student stu);

	int deleteStudent(Integer id);
	
	Student getStudent(Integer id);

	List<Student> getAllStudent();


}
