package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{

	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups="Datadriven")
	public void verify_loginDDT(String email, String pwd, String exp)
	{
		logger.info("***** Starting TC003_LoginDDT *****");

		try {
		//HomePage
		logger.info("Clicking on Home Page");	
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();

		//LoginPage
		logger.info("Clicking on Login Page");	
		LoginPage lp=new LoginPage(driver);

		logger.info("Entering Email");	
		lp.setEmail(email);

		logger.info("Entering Password");	
		lp.setPassword(pwd);

		logger.info("Clicking on Login Button");	
		lp.clickLogin();

		//MyAccount
		logger.debug("Checking if My Account is Displayed");
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExistes();

		if (exp.equalsIgnoreCase("Valid")) 
		{
			if (targetPage==true) 
			{
				macc.clickLogout();
				Assert.assertTrue(true);
			}
			else 
			{
				Assert.assertTrue(false);
			}
		} 
		if (exp.equalsIgnoreCase("Invalid")) 
		{
			if (targetPage==true) 
			{
				macc.clickLogout();
				Assert.assertTrue(false);
			}
			else 
			{
				Assert.assertTrue(true);
			}
		} 
		} catch(Exception e)
		{
			Assert.fail();
		}

		logger.info("***** Ending TC003_LoginDDT *****");  
	}

}
