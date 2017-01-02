package com.github.support.cbb.migration.dao;

import java.util.List;
import java.util.Map;
import com.github.support.cbb.migration.dao.mic.MicUserMapper;
import com.github.support.cbb.migration.model.MicUser;
import com.github.support.cbb.migration.model.SupUser;

public class MicUserService
{
	MicUserMapper micUserMapper;

	public int saveSup(List<SupUser> supUsers)
	{
		int rows=0;
		for (SupUser supUser : supUsers)
		{
			MicUser micUser = new MicUser(supUser);
			rows += this.saveOne(micUser);
		}
		return rows;
	}

	public List<MicUser> getAll(Map<String, Object> pagePam)
	{
		return micUserMapper.getAll(pagePam);
	}

	public int delete(List<MicUser> toBeDelete)
	{
		int rows = 0;
		for (MicUser micUser : toBeDelete)
		{
			rows += micUserMapper.detete(micUser);
		}
		return rows;
	}

	public int saveOne(MicUser micUser)
	{
		return micUserMapper.save(micUser);
	}
}
