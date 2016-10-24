package com.huawei.supportd.scm.service;

import static org.junit.Assert.assertEquals;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huawei.supportd.utils.scm.dao.EmpDao;
import com.huawei.supportd.utils.scm.dao.impl.EmpDaoImpl;
import com.huawei.supportd.utils.scm.model.Emp;
import com.huawei.supportd.utils.scm.service.impl.EmpServiceImpl;

public class EmpServiceTest
{
	private static Logger LOG = LoggerFactory.getLogger(EmpServiceTest.class);

	//private EmpService impl = new EmpServiceImpl();

	@Before
	public void setUp() throws Exception
	{

	}

	@Test
	public void testIn()
	{

		Emp emp = new Emp();
		emp.setId("00000003");
		emp.setName("某某某");
		emp.setAge(50);
		emp.setSex("男");
		emp.setPhone("566666");

		Emp emp2 = new Emp();
		
		// Step1. record阶段，记录对若干依赖对象的期望
		EmpDao empDao = EasyMock.createNiceMock(EmpDaoImpl.class);// 创建Mock对象

		EasyMock.expect(empDao.insertEmp(emp)).andReturn(1);// 对mock对象，提出期望
		EasyMock.replay(empDao);// 期望设置完毕，进入replay阶段

		// Step2. Replay阶段，创建测试主对象，并添加依赖对象进去
		// impl(emp);(utils);

		// Step3. Verify阶段，验证测试结果与交互行为
		assertEquals(1, empDao.insertEmp(emp2));
		assertEquals(1, empDao.insertEmp(null));

		EasyMock.verify(empDao); // 对mock对象执行验证
	}

}