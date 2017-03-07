package com.github.support.cbb.migration.dao.sup;

import java.util.List;
import java.util.Map;
import com.github.support.cbb.migration.model.SupUser;

public interface SupUserMapper
{

	List<SupUser> getAll(Map<String, Object> pagePam);

	SupUser get(SupUser supUser);

}
