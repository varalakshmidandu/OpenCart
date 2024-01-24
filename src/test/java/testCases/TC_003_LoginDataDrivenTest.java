package testCases;

import org.testng.Assert;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDataDrivenTest extends BaseClass {

	
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void test_LoginDataDrivenTest(String email, String pwd, String exp) {
		logger.info(" Starting TC_003_LoginDataDrivenTest ");

		try {
			HomePage hp = new HomePage(driver);
			hp.myAccount();
			hp.login();

			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(pwd);
			lp.Clicklogin();

			MyAccountPage myacc=new MyAccountPage(driver);
			boolean targetpage = myacc.isMyAccountPageExists();// this method is created MyAccountPage
			if(exp.equals("Valid"))
			{
				if(targetpage==true)
				{
					myacc.clickLogout();
					Assert.assertTrue(true);
				}
				else
				{
					Assert.assertTrue(false);
				}
			}
			
			if(exp.equals("Invalid"))
			{
				if(targetpage==true)
				{
					myacc.clickLogout();
					Assert.assertTrue(true);
				}
				else
				{
					Assert.assertFalse(false);
				}
			}
			}
			catch(Exception e)
			{
				Assert.fail();
			}
			
			logger.info("Finishing TC_003_DataDrivenTest.......");
			
		}
	
}
