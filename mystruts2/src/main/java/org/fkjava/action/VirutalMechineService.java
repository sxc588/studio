package org.fkjava.action;

import java.util.ArrayList;
import java.util.List;
import org.fkjava.domain.VirtualMechine;
import org.springframework.stereotype.Repository;

@Repository
public class VirutalMechineService
{

	/**
	 * 
	 * 获取服务的基础信息
	 * @param category
	 * @return
	 */
	public List<String> getServiceInfos(String category)
	{		
		List<String> infos = new ArrayList<String>();
		infos.add("ID生成器");
		infos.add("系统配置项");
		infos.add("元数据");
		return infos;
	}
}
