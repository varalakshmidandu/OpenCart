package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

	@Test(groups= {"Regression","Master"}) //Step8 groups added
	public void test_account_Registration()
	{
		
		logger.info("********* staring TC_001_AccountRegistrationTest ******");		
		logger.trace("capturing tracing logs.....");
		logger.debug("capturing debug logs.......");
		
		try
		{
		HomePage hp=new HomePage(driver);
		logger.info("clicking on my account link");
		hp.myAccount();
		logger.info("clicking on registration link");	
		hp.register();
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		logger.info("Proving customer details");
		regpage.setFirstName(randomeString().toUpperCase());
	   regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
		//regpage.setEmail("varalakshmi12@gmail.com");// duplicate email should fail test case
		logger.info("Provided Email ");
		regpage.setTelephone(randomeNumber());
		
		String password=randomAlphaNumeric();
		regpage.setPassword(password);
		logger.info("Provided password");
		//regpage.setPassword("abcd1234");
		regpage.setConfirmPassword(password);
		//regpage.setConfirmPassword("abcd1234");
		
		regpage.setPrivacyPolicy();
		logger.info("clicking on continue");
		regpage.clickContinue();
		
		String confmsg=regpage.getConfirmationMsg();
		
     logger.info("verifying customer registration");
		
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			
			logger.info("test passed..");
			Assert.assertTrue(true);
	
		}
		else
		{
			logger.warn("customer registration is not successful");
			logger.error("test failed..");
			Assert.assertTrue(false);
			
		}
		
		 
		//Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("********* finished TC_001_AccountRegistrationTest ******");	
	}
}
