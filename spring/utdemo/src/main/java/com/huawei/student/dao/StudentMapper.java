package com.huawei.student.dao;

import java.util.List;

import com.huawei.student.domain.StudentEntity;

public interface StudentMapper
{
	StudentEntity getStudent(String studentID);

	StudentEntity getStudentAndClass(String studentID);

	List<StudentEntity> getStudentAll();

	void insertStudent(StudentEntity entity);

	void deleteStudent(StudentEntity entity);

	void updateStudent(StudentEntity entity);
}
