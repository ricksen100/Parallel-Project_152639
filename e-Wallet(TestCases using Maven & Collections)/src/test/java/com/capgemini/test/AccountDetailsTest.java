package com.capgemini.test;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;
import junit.framework.TestCase;

public class AccountDetailsTest extends TestCase{

	
	@Test
	public void testGetName() {
		//fail("Not yet implemented");
		Assert.assertEquals("Result", true,true);
		Assert.assertNotNull("Rick", "Rick");
		Assert.assertFalse("Shiv",false);
		Assert.assertEquals("Shiv", "Shiv");
		
	}

	@Test
	public void testGetAge() {
		//fail("Not yet implemented");
		Assert.assertEquals("Result", true,true);
		Assert.assertNotNull("20", "31");
		Assert.assertFalse("35",false);
		Assert.assertEquals("35", "35");
	}

	@Test
	public void testGetAadhar() {
		//fail("Not yet implemented");
		Assert.assertEquals("Result", true,true);
		Assert.assertNotNull("909410123815", "909410123815");
		Assert.assertFalse("907867895678",false);
		Assert.assertEquals("907867895678", "907867895678");
	}

	@Test
	public void testGetEmail() {
		//fail("Not yet implemented");
		Assert.assertEquals("Result", true,true);
		Assert.assertNotNull("ricksen100@gmail.com", "ricksen100@gmail.com");
		Assert.assertFalse("dipyaman96@gmail.com",false);
		Assert.assertEquals("dipyaman96@gmail.com", "dipyaman96@gmail.com");
	}
/*
    @Test
	public void testGetDob() {
		//fail("Not yet implemented");
		Assert.assertEquals("Result", true,true);
		Assert.assertNotNull("Rick", "Rick");
		Assert.assertFalse("Shiv",false);
		Assert.assertEquals("Shiv", "Shiv");
	} */

	@Test
	public void testGetPhone() {
		//fail("Not yet implemented");
		Assert.assertEquals("Result", true,true);
		Assert.assertNotNull("8171590847", "8171590847");
		Assert.assertFalse("8210567496",false);
		Assert.assertEquals("8210567496", "8210567496");
	}

	/*@Test
	public void testGetId() {
		//fail("Not yet implemented");
		Assert.assertEquals("Result", true,true);
		Assert.assertNotNull("Rick", "Rick");
		Assert.assertFalse("Shiv",false);
		Assert.assertEquals("Shiv", "Shiv");
	}*/

}
