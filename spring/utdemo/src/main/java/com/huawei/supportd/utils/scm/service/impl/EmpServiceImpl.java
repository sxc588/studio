package com.huawei.supportd.utils.scm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.huawei.supportd.utils.scm.dao.EmpDao;
import com.huawei.supportd.utils.scm.model.Emp;
import com.huawei.supportd.utils.scm.service.EmpService;
@Component
public class EmpServiceImpl implements EmpService
{
	@Autowired
	private EmpDao empDao;

	@Override
	public void insertEmp(Emp emp)
	{
		empDao.insertEmp(emp);
	}

	public EmpDao getEmpDao()
	{
		return empDao;
	}

	public void setEmpDao(EmpDao empDao)
	{
		this.empDao = empDao;
	}
}
