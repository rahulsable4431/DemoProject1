package com.orange.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orange.qa.base.Orange_TestBase;
import com.orange.qa.pages.Orange_HomePage;
import com.orange.qa.pages.Orange_loginPage;

public class orange_loginPageTest extends Orange_TestBase {

	Orange_loginPage lp;
	Orange_HomePage hp;

	public orange_loginPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		Initialization();
		lp = new Orange_loginPage();

	}

	@Test(priority=1)
	public void validateLoginPageTitletest() {
		String Title = lp.validateLoginPageTitle();
		Assert.assertEquals(Title, "OrangeHRM");
		System.out.println(Title);
	}

	@Test(priority=0)
	public void VerifyLoginSuccessfullytest() {
		hp = lp.VerifyLoginSuccessfully(prop.getProperty("Username"), prop.getProperty("Password"));
	}
	@Test(priority=-1)
	public void verifylinksavailableonloginpageTest() {
		lp.listOfLinkPrestOnLoginPage();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
