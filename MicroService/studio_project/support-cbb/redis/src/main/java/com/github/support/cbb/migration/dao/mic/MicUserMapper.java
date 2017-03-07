package com.github.support.cbb.migration.dao.mic;

import java.util.List;
import java.util.Map;
import com.github.support.cbb.migration.model.MicUser;

public interface MicUserMapper
{

	List<MicUser> getAll(Map<String, Object> pagePam);

	int detete(MicUser micUser);

	int save(MicUser micUser);

}
