package com.capgemini.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.capgemini.bean.AccountDetails;
import com.capgemini.bean.CustomerDetails;

public class AccountDao implements IAccountDao {



	 static HashMap<String,AccountDetails> map=new HashMap<>();

	static AccountDetails account;
	
	static List<String> transaction=new ArrayList<String>();
	
	int flag=0;
	
	int tid=(int)((Math.random()*123)+999);
	//static AccountDetails acc1;
	
	public boolean addAccountDetails(AccountDetails details2) {
		// TODO Auto-generated method stub
	   for(String key:map.keySet())
	   {
		   if(details2.getDetails().getUsername().equals(key))
		   {
			   return false;
		   }
	   }
	   map.put(details2.getDetails().getUsername(),details2);
	   return true;
	}
	
	public boolean loginYourAccount(String username, String password) {
		// TODO Auto-generated method stub
		for(String key:map.keySet())
		{
		account=map.get(key);	
			if(account.getDetails().getUsername().equals(username) && account.getDetails().getPassword().equals(password))
			{
				return true;
			}
		}
		return false;
	}

	public int showBalance() {
		// TODO Auto-generated method stub
		return account.getBalance();
	}
	

	public boolean deposit(int amount) {
		// TODO Auto-generated method stub
		account.setBalance(account.getBalance()+amount);
		String deposit="Amount of  "+amount+"  is deposited: "+"Current Balance is "+account.getBalance();
		transaction.add(deposit);
		return true;
	}

	public boolean withdraw(int amount) {
		// TODO Auto-generated method stub
		if(account.getBalance()>=(amount+1000))
		{
			account.setBalance(account.getBalance()-amount);
			String withdraw="Amount of  "+amount+"  is withdrawn: "+"Current Balance is "+account.getBalance();
			transaction.add(withdraw);
			return true;
		}
		else
		{
			System.out.println("You have reached minimum balance");
		}
		return false;
	}

	

	public boolean fundTransfer(int accnum, int amount) {
		// TODO Auto-generated method stub
		if(account.getBalance()<(amount+1000))
		{
			System.out.println("Minimum Balance Violation");
			return false;
		}
		for(String key:map.keySet())
		{
			AccountDetails ac=map.get(key);
			if(ac.getId()==accnum)
			{
				ac.setBalance(ac.getBalance()+amount);
				account.setBalance(account.getBalance()-amount);
				String transfer="Amount of  "+amount+"  is withdrawn: "+"Current Balance is "+account.getBalance()+"  add deposited in  "+ac.getId();
				return true;
			}
		}
		System.out.println("Incorrect receiver account number");
		return false;
	}
	

	public List<String> printTransaction() {
		// TODO Auto-generated method stub
		return transaction;
	}
	
	
	
	
}
