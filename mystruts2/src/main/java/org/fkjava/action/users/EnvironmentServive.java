package org.fkjava.action.users;

import java.util.List;
import java.util.Vector;

public class EnvironmentServive
{

	public static List<EnvironmentInfo> getEnvInfos(String statge)
	{
		
		List<EnvironmentInfo> list = new Vector<EnvironmentInfo>();
		
		list.add(new EnvironmentInfo("部署", "http://support.huawei.com"));
		list.add(new EnvironmentInfo("ActiveMQ[主]", "http://support.huawei.com"));
		list.add(new EnvironmentInfo("ActiveMQ[备]", "http://support.huawei.com"));
		
		return list;
	}

}
