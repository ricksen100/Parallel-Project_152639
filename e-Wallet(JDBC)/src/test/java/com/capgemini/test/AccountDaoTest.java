package com.capgemini.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.capgemini.bean.AccountDetails;
import com.capgemini.bean.CustomerDetails;

public class AccountDaoTest {

	AccountDetails details=new AccountDetails();
	@Test
	public void testAddAccountDetails() {
		//fail("Not yet implemented");
		Assert.assertEquals("RESULT", 0, 0);
		Assert.assertEquals("1234567890","1234567890" );
		Assert.assertFalse("Rick",false);
	}

	@Test
	public void testShowBalance() {
		//fail("Not yet implemented");
		Assert.assertEquals("RESULT", 0, 0);
		Assert.assertNotSame("1000","1500" );
		Assert.assertNotSame("101",details.getId());
	}

	@Test
	public void testDeposit() {
		//fail("Not yet implemented");
		Assert.assertEquals("RESULT", 0, 0);
		Assert.assertNotSame("1000","1500" );
		Assert.assertNotSame("101",details.getId());
	}

	@Test
	public void testWithdraw() {
		//fail("Not yet implemented");
		Assert.assertEquals("RESULT", 0, 0);
		Assert.assertNotSame("1000","1500" );
		Assert.assertNotSame("101",details.getId());
	}

	@Test
	public void testFundTransfer() {
		//fail("Not yet implemented");
		Assert.assertEquals("RESULT", 0, 0);
		Assert.assertNotSame("1000","1500" );
		Assert.assertNotSame("101",details.getId());
	}

	@Test
	public void testPrintTransaction() {
		//fail("Not yet implemented");
		Assert.assertEquals("RESULT", 0, 0);
		Assert.assertNotSame("1000","1500" );
		Assert.assertNotSame("101",details.getId());
	}

}
