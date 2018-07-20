package com.capgemini.service;

import java.util.List;

import com.capgemini.bean.AccountDetails;
import com.capgemini.dao.AccountDao;

public class AccountService implements IAccountService {
	
	AccountDao dao=new AccountDao();

	@Override
	public boolean addAccountDetails(AccountDetails details) {
		// TODO Auto-generated method stub
		return dao.addAccountDetails(details);
	}

	@Override
	public int showBalance() {
		// TODO Auto-generated method stub
		return dao.showBalance();
	}

	@Override
	public boolean deposit(int amount) {
		// TODO Auto-generated method stub
		return dao.deposit(amount);
	}

	@Override
	public boolean withdraw(int amount) {
		// TODO Auto-generated method stub
		return dao.withdraw(amount);
	}

	@Override
	public boolean loginYourAccount(String username,String password) {
		// TODO Auto-generated method stub
		return dao.loginYourAccount(username,password);
	}

	@Override
	public boolean fundTransfer(int accnum, int amount) {
		// TODO Auto-generated method stub
		return dao.fundTransfer(accnum, amount);
	}

	@Override
	public void printTransaction() {
		// TODO Auto-generated method stub
		dao.printTransaction();
	}

	

	}
