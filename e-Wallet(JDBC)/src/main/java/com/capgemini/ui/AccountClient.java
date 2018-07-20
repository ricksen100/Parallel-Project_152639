package com.capgemini.ui;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Scanner;

import com.capgemini.bean.AccountDetails;
import com.capgemini.bean.CustomerDetails;
import com.capgemini.service.AccountDataValidate;
import com.capgemini.service.AccountService;

public class AccountClient {

	public static void main(String[] args) {
		int choice;
		
		do
		{
			int choice1;
			Scanner sc=new Scanner(System.in);
			System.out.println("--------------------------------");
			System.out.println("E-WALLET CONSOLE APP");
			System.out.println("--------------------------------");
			System.out.println("1.Sign Up/Create Account");
			System.out.println("2.Sign in/Login");
			System.out.println("3.EXIT");
			System.out.println("********************************");
			System.out.println("Enter your choice(1/2/3)");
			choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				
				createYourAccount1();
				break;
			
			case 2:
				
				boolean b= loginYourAccount();
				if(b)
				{
					do
					{
						System.out.println("-----------------------------");
						System.out.println("1.Show Balance");
						System.out.println("2.Deposit Amount");
						System.out.println("3.Withdraw Amount");
						System.out.println("4.Fund Transfer");
						System.out.println("5.Print Transaction");
						System.out.println("6.Exit");
						System.out.println("*****************************");
						System.out.println("Enter your choice");
						choice1=sc.nextInt();
						switch(choice1)
						{
						case 1:
							displayBalance();
							break;
						
						case 2:
							depositYourAmount();
							break;
							
						case 3:
							withdrawYourAmount();
							break;
						
						case 4:
							fundTransfer();
							break;
							
						case 5:
							printTransaction();
							break;
							
						default:
							break;
						}
					}
						while(choice1!=6);
						
					
					}
				else
				{
					System.out.println("Invalid Login Details");
				}
				break;
				
			case 3:
				System.exit(0);
				}
		}
		while(choice!=3);
	}
	
	
	
		public static void 	createYourAccount1()
		{
			boolean b = false;
			boolean isValidName; // service1
			boolean isValidAge; // service1
			boolean isValidEmail; // service1
			boolean isValidMobile; // service1
			boolean isValidAadhar;
			
			AccountDataValidate validate = new AccountDataValidate();
			
			AccountService service = new AccountService();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			String name;
			try {
				System.out.println("enter the name(should not be null)");
				name = br.readLine();
				System.out.println("enter the age(in two-digits)");
				String age = br.readLine();
				System.out.println("enter the aadhar(in tweive digits)");
				String aadhar = br.readLine();
				System.out.println("enter the email");
				String email = br.readLine();
				System.out.println("enter the phone(in ten digits)");
				String phone = br.readLine();
				System.out.println("enter username");
				String username=br.readLine();
				System.out.println("enter the password");
				String password=br.readLine();
				System.out.println("enter the initial balance(in integers)" );
				String balance=br.readLine();
				
				int id = (int) (Math.random() * 1234 + 9999);
				System.out.println("Your account id is:" + id);
				
				 CustomerDetails details = new CustomerDetails();
					details.setName(name);
					details.setAge(Integer.parseInt(age));
					details.setEmail(email);
					details.setAadhar(Long.parseLong(aadhar));
					details.setPhone(Long.parseLong(phone));
					details.setUsername(username);
					details.setPassword(password);
				
					AccountDetails details2=new AccountDetails();
					details2.setBalance(Integer.parseInt(balance));
					details2.setId(id);
					details2.setDetails(details);
				
	         
				
				
				isValidName = validate.validateName(name); // service1
				isValidAge = validate.validateAge(age); // service1
				//isValidEmail = validate.validateEmail(email); // service1
				isValidMobile = validate.validateMobile(phone); // service1
				isValidAadhar = validate.validateAadhar(aadhar);
				//b = service.addAccountDetails(details);
				
				if (isValidName && isValidAge && isValidMobile && isValidAadhar) 
				{
					b=service.addAccountDetails(details2);
			    } 
				else
				{
					System.out.println("Invalid Data");
				}
			}
				catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			      }
			

			if(b)
				{
					System.out.println("Account Created");
			    } 
				else 
				{
				System.out.println("Wrong Details");
			    }
			
		    
		}
		
		
		public static void displayBalance()
		{
			Scanner sc=new Scanner(System.in);
			AccountService service = new AccountService();
			int balance=service.showBalance();
			System.out.println("Balance="+balance);
		}
		
		public static void depositYourAmount()
		{
			Scanner sc=new Scanner(System.in);
			AccountService service = new AccountService();
			
			System.out.println("Enter amount to be deposited");
			int amount=sc.nextInt();
			boolean deposit=service.deposit(amount);
			
			if(deposit)
			{
				System.out.println("Ammount Deposited");
          	}
		}
		
		public static void withdrawYourAmount()
		{
			Scanner sc=new Scanner(System.in);
			AccountService service = new AccountService();
			
			System.out.println("Enter amount to be withdrawn");
			int amount=sc.nextInt();
			boolean deposit=service.withdraw(amount);
			
			if(deposit)
			{
				System.out.println("Ammount Withdrawn");
          	}
			
		}
		
		public static boolean loginYourAccount()
		{
			Scanner sc=new Scanner(System.in);
			AccountService service = new AccountService();
			AccountDetails details2=new AccountDetails();
			System.out.println("Enter the username");
			String username=sc.next();
			System.out.println("Enter the password");
			String password=sc.next();
			
			boolean b=service.loginYourAccount(username,password);
			if(true)
			{
				return true;
			}
			else
				return false;
		}
		
		public static void fundTransfer()
		{
			Scanner sc=new Scanner(System.in);
			AccountService service = new AccountService();
			System.out.println("Enter Account Number to transfer amount");
			int accnum=sc.nextInt();
			System.out.println("Enter the amount to be transfered");
			int amount=sc.nextInt();
			boolean c=service.fundTransfer(accnum,amount);
			if(c)
			{
				System.out.println("Amount Transferred Succesfully");
		    }
			else
			{
				System.out.println("Enter the correct details");
			}
		}
		
		public static void printTransaction()
		{
			AccountService service=new AccountService();
			service.printTransaction();
			
			
			
		}
}

		
		