package com.capgemini.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.capgemini.bean.AccountDetails;
import com.capgemini.bean.CustomerDetails;

public class AccountDao implements IAccountDao {

	static AccountDetails account;
	static String accountNumber;
	int balance;
	int flag=0;
	
	static long adn;
	long aadhar;
	String details;
	static int acc;
	int acc_num;
	
	static List<String> transaction=new ArrayList<String>();
	
	@Override
	public boolean addAccountDetails(AccountDetails details) {
		// TODO Auto-generated method stub
	    Connection conn=JdbcUtil.getConnection();
	    
	    
	    int balance=details.getBalance();
	    int account_number=details.getId();
	    
	    String name=details.getDetails().getName();
	    int age=details.getDetails().getAge();
	    long aadhar=details.getDetails().getAadhar();
	    String email=details.getDetails().getEmail();
	    long phone=details.getDetails().getPhone();
	    String username=details.getDetails().getUsername();
	    String password=details.getDetails().getPassword();
	    
	    String insertQuery="insert into accountdetails(balance,id,aadhar) values(?,?,?)";
	    String insertQuery2="insert into customerdetails(name,age,aadhar,email,phone,username,password) values(?,?,?,?,?,?,?)";
	    
	    try {
			java.sql.PreparedStatement st=conn.prepareStatement(insertQuery);
			java.sql.PreparedStatement st1=conn.prepareStatement(insertQuery2);
			
			st.setInt(1,balance);
			st.setInt(2,account_number);
			st.setLong(3,aadhar);
			
			st1.setString(1,name);
			st1.setInt(2,age);
			st1.setLong(3,aadhar);
			
			st1.setString(4,email);
			st1.setLong(5,phone);
			st1.setString(6,username);
			st1.setString(7,password);
			
			st1.executeUpdate();
			st.executeUpdate();
			
			
	
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	@Override
	public boolean loginYourAccount(String username,String password) {
		// TODO Auto-generated method stub
		try {
		Connection conn=JdbcUtil.getConnection();
		
		
		
		//String selectQuery="select * from customerdetails where username=? and password=?";
   String selectQuery="select  customerdetails.username,customerdetails.password,customerdetails.aadhar,accountdetails.id from customerdetails,accountdetails where customerdetails.aadhar=accountdetails.aadhar";
   Statement st=conn.createStatement();
		
			
		 /* st.setString(1,username);
		  st.setString(2,password);*/
			
			ResultSet rs=st.executeQuery(selectQuery);
			
			while(rs.next())
			{
			
				if(username.equals(rs.getString("username"))&&(password.equals(rs.getString("password")))) {
					
					
					 adn=rs.getLong("aadhar");
					 acc=rs.getInt("id");
					 System.out.println(acc);
					return true;
				}
			
				
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return false;
	}
	
	

	

	@Override
	public int showBalance() {
		// TODO Auto-generated method stub
		aadhar=adn;
		Connection conn=JdbcUtil.getConnection();
		try {

			Statement st=conn.createStatement();
			
			String Query = "select * from accountdetails where aadhar= '"+aadhar+"'  ";
			
			
			ResultSet rs=st.executeQuery(Query);

			while (rs.next()) {
				balance = rs.getInt("balance");
			}
           
		}
		

		catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		finally {

			try {
				conn.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return balance;
	}
	

	@Override
	public boolean deposit(int amount) {
		// TODO Auto-generated method stub
		Connection conn=JdbcUtil.getConnection();
		aadhar=adn;
		acc_num=acc;
		try {
			String deposit="THE AMOUNT\t"+amount+"\tIS DEPOSITED";
			String insertq="insert into transactions values(?,?)";
			String Query="update accountdetails set balance=balance+? where aadhar= ?  ";
			
			PreparedStatement st=conn.prepareStatement(Query);
			st.setInt(1, amount);
			st.setLong(2, aadhar);
	        st.executeUpdate();
	        
	        PreparedStatement st1=conn.prepareStatement(insertq);
	        st1.setString(1,deposit);
	        st1.setInt(2,acc_num);
	        st1.execute();
	        
	        conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
		
	}

	@Override
	public boolean withdraw(int amount) {
		// TODO Auto-generated method stub
		aadhar=adn;
		acc_num=acc;
		Connection conn=JdbcUtil.getConnection();
		
		try {
			String withdraw ="THE AMOUNT\t"+amount+"\tIS WITHDRAWN";
			String insertw="INSERT INTO Transactions values(?,?)";
			String selectQuery="select * from accountdetails where aadhar='"+aadhar+"'";
			
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery(selectQuery);
			while(rs.next())
			{
				balance=rs.getInt("balance");
			}
			if(balance>amount)
			{
				String Query="update accountdetails set balance=balance-? where aadhar= ?  ";
				PreparedStatement st1=conn.prepareStatement(Query);
				st1.setInt(1, amount);
				st1.setLong(2, aadhar);
		        st1.executeUpdate();
		        
		        PreparedStatement st2=conn.prepareStatement(insertw);
		        st2.setString(1,withdraw);
		        st2.setInt(2,acc_num);
		        st2.executeUpdate();
			}
			else
			{
				System.out.println("Amount Exceeds");
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	
	@Override
	public boolean fundTransfer(int accnum, int amount) {
		// TODO Auto-generated method stub
		Connection conn=JdbcUtil.getConnection();
		aadhar=adn;
		acc_num=acc;
		try {
			String fdt="THE AMOUNT\t"+amount+"\tIS TRANSFERRED TO\t"+accnum;
			String insertfund="insert into transactions value(?,?)";
			String query="update accountdetails set balance=balance+? where id=?";
			
			
			PreparedStatement st=conn.prepareStatement(query);
			st.setInt(1,amount);
			st.setLong(2,accnum);
			st.execute();
			
			Statement st1=conn.createStatement();
			String query1="select * from accountdetails where aadhar='"+aadhar+"'";
			ResultSet rs=st.executeQuery(query1);
			while(rs.next())
			{
				balance=rs.getInt("balance");
			}
			
			if(balance>amount)
			{
				String query2="update accountdetails set balance=balance-? where aadhar= ?  ";
				PreparedStatement st2=conn.prepareStatement(query2);
				st2.setInt(1, amount);
				st2.setLong(2, aadhar);
				
				PreparedStatement st3=conn.prepareStatement(insertfund);
				st3.setString(1,fdt);
				st3.setInt(2,acc_num);
				
				st3.execute();
		        st2.execute();
			}
			else
			{
				System.out.println("Amount Exceeds");
			}
		  conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void printTransaction() {
		// TODO Auto-generated method stub
		acc_num=acc;
        Connection conn=JdbcUtil.getConnection();
        
        try {
        	String query="select * from transactions where id='"+acc_num+"' ";
        	Statement st = conn.createStatement();
			ResultSet rs=st.executeQuery(query);
			while(rs.next())
			{
				 details =rs.getString("transaction_info");
				System.out.println(details);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	}

	/*static HashMap<String,AccountDetails> map=new HashMap<>();

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
	
	*/
	
	

