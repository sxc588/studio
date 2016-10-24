package com.huawei.support.mybatis3.service;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import com.huawei.support.mybatis3.model.Student;

public class StudentServiceTest
{

	@Test
	public void Addtest() throws IOException
	{
		StudentService service = new StudentService();
		Student stu = new Student("李四", 12);
		int result = service.add(stu);
		if (result > 0)
		{
			System.out.println("添加成功");
		}
		assertEquals(1, result);
	}

}
