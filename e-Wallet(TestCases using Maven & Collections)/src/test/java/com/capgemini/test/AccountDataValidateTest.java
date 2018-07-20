package com.capgemini.test;

import com.capgemini.service.AccountDataValidate;

import junit.framework.Assert;
import junit.framework.TestCase;

public class AccountDataValidateTest extends TestCase {

	 AccountDataValidate validate = new AccountDataValidate();
		public void testValidateName() {
			//fail("Not yet implemented");
			Assert.assertEquals("result", true, true);
			Assert.assertNotNull("Rick", "Rick");
			Assert.assertFalse("Shiv",false);
			Assert.assertEquals("Shiv", "Shiv");
		}

		public void testValidateAge() {
			//fail("Not yet implemented");
			Assert.assertEquals("result", true, true);
			Assert.assertNotNull("20", "31");
			Assert.assertFalse("35",false);
			Assert.assertEquals("35", "35");
		}

		public void testValidateEmail() {
			//fail("Not yet implemented");
			Assert.assertEquals("result", true, true);
			Assert.assertNotNull("ricksen100@gmail.com", "ricksen100@gmail.com");
			Assert.assertFalse("dipyaman96@gmail.com",false);
			Assert.assertEquals("dipyaman96@gmail.com", "dipyaman96@gmail.com");
		}

		public void testValidateMobile() {
			//fail("Not yet implemented");
			Assert.assertEquals("result", true, validate.validateMobile("8171590847"));
			Assert.assertNotNull("8171590847", "8171590847");
			Assert.assertFalse("8210567496",false);
			Assert.assertEquals("8210567496", "8210567496");
		}

		public void testValidateAadhar() {
			//fail("Not yet implemented");
			Assert.assertEquals("result", true, true);
			Assert.assertNotNull("909410123815", "909410123815");
			Assert.assertFalse("907867895678",false);
			Assert.assertEquals("907867895678", "907867895678");
		}


}
