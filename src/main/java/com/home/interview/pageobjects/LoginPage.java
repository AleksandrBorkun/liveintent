package com.home.interview.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	@FindBy(id = "email")
	public WebElement emailFld;
	
	@FindBy(id = "password")
	public WebElement passwordFld;
	
	@FindBy(xpath = "//*[@type='submit']")
	public WebElement loginBtn;
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
		wait.waitForElementIsClickable(emailFld);
	}
	
	public HomePage goToHomePage(String email, String pass){
		System.out.println("Fill login form");
		emailFld.sendKeys(email);
		passwordFld.sendKeys(pass);
		loginBtn.click();
		return new HomePage(driver);
	}

}
