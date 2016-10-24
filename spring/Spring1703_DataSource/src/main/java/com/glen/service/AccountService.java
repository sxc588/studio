package com.glen.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.glen.mapper.AccountMapper;
import com.glen.model.Account;

@Component
public class AccountService
{
	@Autowired
	private AccountMapper accountMapper;

	public List<Account> getAllAccount()
	{
		return accountMapper.getAllAccount();
	}

	public Integer add(Account account)
	{
		return accountMapper.add(account);
	}

	public Integer batchAdd(List<Account> accounts)
	{
		return accountMapper.batchAdd(accounts);
	}
}