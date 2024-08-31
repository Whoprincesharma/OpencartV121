package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	
	@Test(groups={"Sanity", "Master"})
	public void verify_login()
	{
		logger.info("***** Starting TC002_LoginTest *****");
	    
		try
		{
		//HomePage
		logger.info("Clicking on Home Page");	
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//LoginPage
		logger.info("Clicking on Login Page");	
		LoginPage lp=new LoginPage(driver);
		logger.info("Entering Email");	
		lp.setEmail(p.getProperty("email"));
		logger.info("Entering Password");	
		lp.setPassword(p.getProperty("password"));
		logger.info("Clicking on Login Button");	
	    lp.clickLogin();
	
	    //MyAccount
	    logger.debug("Checking if My Account is Displayed");
	    MyAccountPage macc=new MyAccountPage(driver);
	    boolean targetPage=macc.isMyAccountPageExistes();
	    
	    //Assert.assertEquals(targetPage, true, "Login Failed");
	    Assert.assertTrue(targetPage);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	
	    logger.info("***** Finished TC002_LoginTest *****");
	}
	

}
