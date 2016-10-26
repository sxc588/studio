package com.huawei.supportd.utils.scm.mappers;

import java.util.List;
import java.util.Map;

import com.huawei.supportd.utils.scm.model.Emp;

public interface EmpMapper
{
	int insertEmp(Emp emp);

	List<Emp> getAllEmp();

	Emp getById(String id);

	void deleteEmp(String id);

	void updateEmp(Map<String, Object> map);
}
