package com.glen.mapper;

import java.util.List;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;
import com.glen.model.Account;

public interface AccountMapper
{
	List<Account>getAllAccount();
	Integer add(Account account);
	Integer  batchAdd(List<Account> list);

}
