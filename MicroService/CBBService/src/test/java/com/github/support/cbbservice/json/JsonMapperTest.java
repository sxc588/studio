package com.github.support.cbbservice.json;

import java.util.ArrayList;
import org.junit.Test;

import com.github.support.cbbservice.json.JsonMapper;

public class JsonMapperTest
{

	@Test
	public void test()
	{
        Student student = getStudents();  
        Long beginTime = System.currentTimeMillis();  
        //bean2json  
        String json = JsonMapper.toLogJson(student);  
        System.out.println("对象转换为json：" + json);  
        System.out.println("转换用时：" + (System.currentTimeMillis()-beginTime) + "ms");  
        //json2bean，需要注意：Student类和Teacher类必须有一个空的构造方法  
        beginTime = System.currentTimeMillis();  
        //JsonMapper提供了很多创建Mapper的方法，不是非要用buildNonDefaultMapper，你可以对比几种方法的转换时间，挑个最快的  
        Student student2 = JsonMapper.buildNonDefaultMapper().fromJson(json, Student.class);  
        System.out.println("json转换成对象：" + student2);  
        System.out.println("转换用时：" + (System.currentTimeMillis()-beginTime) + "ms");  
    }  
 
    /** 
     * 初始化一个student 
     * @return 
     */  
    private static Student getStudents() {  
        Teacher t1 = new Teacher("teacher1",35);  
        Teacher t2 = new Teacher("teacher1",25);  
        Teacher t3 = new Teacher("teacher1",30);  
        ArrayList<Teacher> teachers = new ArrayList<Teacher>();  
        teachers.add(t1);  
        teachers.add(t2);  
        teachers.add(t3);  
        Student s = new Student();  
        s.setAge(20);  
        s.setName("student1");  
        s.setTeachers(teachers);  
        return s;  
    }  
}
