package com.capgemini.bean;

public class AccountDetails {

	private int balance;
	private int id;
	private CustomerDetails details;
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setDetails(CustomerDetails details) {
		this.details = details;
	}
	public int getBalance() {
		return balance;
	}
	public int getId() {
		return id;
	}
	public CustomerDetails getDetails() {
		return details;
	}
	@Override
	public String toString() {
		return "AccountDetails [balance=" + balance + ", id=" + id + ", details=" + details + "]";
	}
	
	
	
}
