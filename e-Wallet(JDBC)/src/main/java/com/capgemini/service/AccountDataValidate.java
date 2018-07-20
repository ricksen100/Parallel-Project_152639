package com.capgemini.service;

public class AccountDataValidate {

	public boolean validateName(String name) {
		if (name!=null) {
			return true;
		} else
			return false;
	}

	public boolean validateAge(String age) {
		if (age.length() == 2) {
			return true;
		} else
			return false;
	}

	/*public boolean validateEmail(String email) {
		if (email.length() ==40) {
			return true;
		}
		return false;
	}*/

	public boolean validateMobile(String phone) {
		if (phone.length() == 10) {
			return true;
		}
		return false;
	}

	public boolean validateAadhar(String aadhar) {
		if (aadhar.length() == 12) {
			return true;
		}
		return false;
	}
}
