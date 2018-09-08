package com.github.support.host.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.github.support.dto.HostDto;

@Repository
public class HostDao
{
	public List<HostDto> getAll()
	{
		List<HostDto> dtos = new ArrayList<HostDto>();

		for (int i = 100; i < 200; i++)
		{
			HostDto dto = new HostDto();
			dto.setUserId("SU" + (10000 + i));
			dto.setUserName("Name" + i);
			dto.setPasswd("PassWd" + i);
			dto.setInfo("Info" + i);
			dtos.add(dto);
		}
		return dtos;
	}

}
