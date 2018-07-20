package com.capgemini.bean;

public class CustomerDetails {

	private String name;
	private int age;
	private long aadhar;
	private String email;
	private long phone;
	private String username;
	private String password;
	
	
	
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setAadhar(long aadhar) {
		this.aadhar = aadhar;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public long getAadhar() {
		return aadhar;
	}
	public String getEmail() {
		return email;
	}
	public long getPhone() {
		return phone;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	@Override
	public String toString() {
		return "CustomerDetails [name=" + name + ", age=" + age + ", aadhar=" + aadhar + ", email=" + email + ", phone="
				+ phone + ", username=" + username + ", password=" + password + "]";
	}
	
	

	
	
	
	
}
