package com.home.interview.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.home.interview.utils.SeleniumWaitUtils;

public abstract class BasePage {
	
	protected WebDriver driver;
	protected SeleniumWaitUtils wait;
	
	@FindBy(xpath = "//*[@class = 'logo']")
	WebElement logo;
	
	public BasePage(WebDriver driver){
		this.driver = driver;
		wait = new SeleniumWaitUtils(driver);
		PageFactory.initElements(driver, this);
		wait.waitElementPresent(logo);
	}

}
