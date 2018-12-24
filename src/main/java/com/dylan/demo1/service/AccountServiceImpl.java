package com.dylan.demo1.service;

import com.dylan.demo1.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accountDao;
	
	public void setAccountDao(AccountDao accountDao){
		this.accountDao = accountDao;
	}
	
	@Override
	public void transfer(String out, String in, Double money) {
		accountDao.outMoney(out, money);
		//int i = 1 / 0;
		accountDao.inMoney(in, money);
		
	}
	
}
