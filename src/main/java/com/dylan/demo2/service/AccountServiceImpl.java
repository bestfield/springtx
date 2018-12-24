package com.dylan.demo2.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.dylan.demo2.dao.AccountDao;

public class AccountServiceImpl implements AccountService{

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
