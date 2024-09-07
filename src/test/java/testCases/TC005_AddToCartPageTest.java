package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;


public class TC005_AddToCartPageTest extends BaseClass {
	
	@Test(groups= {"Master"})
	public void verify_addToCart() throws InterruptedException {
		logger.info(" *****Starting TC_005_AddToCartPageTest***** ");

		try {
			
			HomePage hp=new HomePage(driver);
			logger.info(" *****Entering Product Name***** ");
			hp.enterProductName("iPhone");
			logger.info(" *****Clicking On Search Button***** ");
			hp.clickSearch();
			
						
			SearchPage sp=new SearchPage(driver);
			logger.info(" *****Checking if Product Exists***** ");
			if(sp.isProductExist("iPhone"))
			{
				sp.selectProduct("iPhone");
				logger.info(" *****Entering Product Quantity***** ");
				sp.setQuantity("2");
				logger.info(" *****Entering Product To Cart***** ");
				sp.addToCart();
				
			}
						
			Assert.assertEquals(sp.checkConfMsg(),true , "*****Confirmation Message Did not Displayed*****");

		} catch (Exception e) {
			Assert.fail();
		}

		logger.info(" *****Finished TC005_AddToCartPageTest***** ");

	}
}
