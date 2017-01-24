package com.github.support.cbb.migration.handler.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import com.github.support.cbb.migration.dao.MicUserService;
import com.github.support.cbb.migration.dao.ent.EntUserMapper;
import com.github.support.cbb.migration.dao.sup.SupUserMapper;
import com.github.support.cbb.migration.handler.IMigrationHandler;
import com.github.support.cbb.migration.model.MicUser;
import com.github.support.cbb.migration.model.SupUser;

public class UserHander implements IMigrationHandler
{
	@Autowired
	SupUserMapper supUserMapper;

	@Autowired
	EntUserMapper entUserMapper;

	@Autowired
	MicUserService micUserService;

	@Override
	public int migrationAll()
	{
		int indexPage = 0;

		int rows = 0;
		while (true)
		{
			Map<String, Object> pagePam = HandlerUtils.getPageParm(indexPage);

			List<SupUser> supUsers = supUserMapper.getAll(pagePam);

			if (CollectionUtils.isEmpty(supUsers))
			{
				return rows;
			}
			rows += micUserService.saveSup(supUsers);
			indexPage++;
		}
	}

	@Override
	public int migrationInc(Date beginTime, Date endTime)
	{

		int pageIndex = 0;

		int rows = 0;
		while (true)
		{
			Map<String, Object> pagePam = HandlerUtils.getPageParm(beginTime, endTime, pageIndex);

			List<SupUser> supUsers = supUserMapper.getAll(pagePam);

			if (CollectionUtils.isEmpty(supUsers))
			{
				return rows;
			}

			rows += micUserService.saveSup(supUsers);
			pageIndex++;
		}
	}

	@Override
	public int migrationDel()
	{
		int pageIndexi = 0;

		List<MicUser> toBeDelete = new ArrayList<MicUser>();

		while (true)
		{
			Map<String, Object> pagePam = HandlerUtils.getPageParm(pageIndexi);

			List<MicUser> micUsers = micUserService.getAll(pagePam);

			if (CollectionUtils.isEmpty(micUsers))
			{
				break;
			}

			for (MicUser micUser : micUsers)
			{
				SupUser supUser = new SupUser();

				SupUser supUser2 = supUserMapper.get(supUser);
				if (supUser2 == null)
				{
					toBeDelete.add(micUser);
				}
			}
			pageIndexi++;
		}
		return micUserService.delete(toBeDelete);
	}

	@Override
	public int migrationDelInc(Date beginTime, Date endTime)
	{
		// TODO Auto-generated method stub
		return 0;
	}

}
