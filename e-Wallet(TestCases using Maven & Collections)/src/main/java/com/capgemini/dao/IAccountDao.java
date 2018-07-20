package com.capgemini.dao;

import java.util.List;

import com.capgemini.bean.AccountDetails;

public interface IAccountDao {

	public boolean addAccountDetails(AccountDetails details);

	public int showBalance();

	public boolean deposit(int amount);

	public boolean withdraw(int amount);
	
	public boolean loginYourAccount(String username,String password);
	
	public boolean fundTransfer(int accnum,int amount);

	public List<String> printTransaction();
}
