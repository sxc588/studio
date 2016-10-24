package com.huawei.student.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.transaction.annotation.Transactional;

import com.huawei.student.dao.StudentMapper;
import com.huawei.student.domain.StudentEntity;
import com.huawei.student.service.StudentService;

//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:spring/spring*.xml"})
public class StudentMapperTest{

	@Autowired
	private ApplicationContext ctx;

    @Test
    public void getStudentTest(){ 
//        StudentEntity entity = studentMapper.getStudent("10000013"); 
//        System.out.println("" + entity.getStudentID() + entity.getStudentName()); 
//         
//        List<StudentEntity> studentList = studentMapper.getStudentAll(); 
//        for( StudentEntity entityTemp : studentList){ 
//            System.out.println(entityTemp.getStudentName()); 
//        } 
    	
    	assertNotNull(ctx);
         
    	
    } 
}
