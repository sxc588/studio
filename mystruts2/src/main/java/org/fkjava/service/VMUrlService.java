package org.fkjava.service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.apache.commons.lang3.StringUtils;
import org.fkjava.domain.User;
import org.fkjava.domain.VirtualMechine;
import org.springframework.stereotype.Service;
import com.ctc.wstx.util.StringUtil;

@Service
public class VMUrlService
{
	static List<VirtualMechine> userDb;
	static
	{
		userDb = new ArrayList<VirtualMechine>();
		userDb.add(new VirtualMechine("IDGenerator", "Alpha", "8080", "4040", "http://127.0.0.1:8080/idgenerator/rest/v1"));
		userDb.add(new VirtualMechine("IDGenerator", "Alpha", "8080", "4040", "http://127.0.0.1:8080/idgenerator/rest/v1"));
		userDb.add(new VirtualMechine("IDGenerator", "Alpha", "8080", "4040", "http://127.0.0.1:8080/idgenerator/rest/v1"));
		userDb.add(new VirtualMechine("IDGenerator", "Alpha", "8080", "4040", "http://127.0.0.1:8080/idgenerator/rest/v1"));
	}

	public List<VirtualMechine> getAll()
	{
		return userDb;
	}

	public Integer addUrls(String stage, String[] urls) throws MalformedURLException
	{

		for (String url : urls)
		{
			VirtualMechine vm = new VirtualMechine();

			if (StringUtils.isNotBlank(url))
			{
				URL ur = new URL(url.trim());
				vm.setName(ur.getPath());
				vm.setPort("8080");
				vm.setUrl(url);
				userDb.add(vm);
				
			}
		}
		return 0;
	}
	
	
	
	

}
