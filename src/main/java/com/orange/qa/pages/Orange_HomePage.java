package com.orange.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.orange.qa.base.Orange_TestBase;

public class Orange_HomePage extends Orange_TestBase{

	@FindBy (id = "menu_admin_viewAdminModule")
	WebElement Admin;
	
	@FindBy (id="menu_admin_UserManagement")
	WebElement UserManagement;
	
	@FindBy (id ="menu_admin_viewSystemUsers")
	WebElement User ;

	@FindBy(name="searchSystemUser[userName]")
	WebElement Username ;
	
	@FindBy(name= "searchSystemUser[employeeName][empName]")
	WebElement User_Role;
	
	@FindBy (id ="searchBtn")
	WebElement SearchButton;
	
	public Orange_HomePage() {
		PageFactory.initElements(driver, this);	
	}
	
	public Orange_HomePage toBeSearchAvailabilityOfUser(String un , String ur) {
		
		Actions Action =new Actions(driver);
		
		Action.moveToElement(Admin).build().perform();
		
		Action.moveToElement(UserManagement).build().perform();
		
		User.click();
		
		Username.sendKeys(un);
		
		Select select =new Select(driver.findElement(By.id("searchSystemUser_userType")));
		
		select.selectByIndex(1);
		
		User_Role.sendKeys(ur);
		
		Select selects = new Select (driver.findElement(By.id("searchSystemUser_status")));
		
		selects.selectByIndex(1);
		
		SearchButton.click();
		
		return new Orange_HomePage();
	
	}
	
}
