package com.orange.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orange.qa.base.Orange_TestBase;

public class Orange_loginPage extends Orange_TestBase {

	@FindBy(id = "txtUsername")
	WebElement Username;

	@FindBy(id = "txtPassword")
	WebElement Password;

	@FindBy(id = "btnLogin")
	WebElement LoginButton;
	
	private By link = By.tagName("img");

	public Orange_loginPage() {
		PageFactory.initElements(driver, this);

	}

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public Orange_HomePage VerifyLoginSuccessfully(String Un, String Pd) {
		Username.sendKeys(Un);
		Password.sendKeys(Pd);
		LoginButton.click();
		return new Orange_HomePage();
	}
	
	public void listOfLinkPrestOnLoginPage () {
		
		List<WebElement>elelist= driver.findElements(link);
		System.out.println("size of link: " +elelist.size());
		
		for (int i=0; i<elelist.size(); i++) {
			
			String linklist= elelist.get(i).getText();
			System.out.println(linklist);
			
		}
		
	}
}
