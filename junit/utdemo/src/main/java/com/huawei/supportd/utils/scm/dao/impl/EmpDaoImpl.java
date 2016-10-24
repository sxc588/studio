package com.huawei.supportd.utils.scm.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

import com.huawei.supportd.utils.scm.dao.EmpDao;
import com.huawei.supportd.utils.scm.mappers.EmpMapper;
import com.huawei.supportd.utils.scm.model.Emp;

@Component
public class EmpDaoImpl implements EmpDao
{
	@Autowired
	private EmpMapper empMapper; // 在此处注入一个empMapper

	// 这个empMapper由 Spring自动生成
	// 不需要我们自己手工去定义
	@Override
	public int insertEmp(Emp emp)
	{
		this.empMapper.insertEmp(emp);
		throw new RuntimeException("Error"); // 测试抛出RuntimeException//异常查看数据库是否存在记录
	}

	@Override
	public void deleteEmp(String id)
	{
		this.empMapper.deleteEmp(id);
	}

	@Override
	public List<Emp> getAllEmp()
	{
		return this.empMapper.getAllEmp();
	}

	@Override
	public Emp getById(String id)
	{
		return this.empMapper.getById(id);
	}

	@Override
	public void updateEmp(Map<String, Object> map)
	{
		this.empMapper.updateEmp(map);
	}

	public EmpMapper getEmpMapper()
	{
		return empMapper;
	}

	public void setEmpMapper(EmpMapper empMapper)
	{
		this.empMapper = empMapper;
	}
}
