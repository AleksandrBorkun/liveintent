package com.home.interview.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConversionTrackingPage extends BasePage{
	
	@FindBy(xpath = "//*[@class = 'button--create']")
	public WebElement createBtn;
	
	@FindBy(xpath = "//*[@name = 'advertiser']//input")
	public WebElement advertiserFld;
	
	@FindBy(xpath = "//button[contains(text(), 'Create Tracker')]")
	public WebElement createTrackerBtn;
	
	@FindBy(xpath = "//input[@name = 'name']")
	public WebElement trackerNameFld;
	
	@FindBy(xpath = "//*[@name = 'advertiser']//div[@class = 'dropdown']/div")
	public WebElement advertiserDropDown;
	
	@FindBy(xpath = "//*[@class = 'alert']")
	public WebElement alertMsg;
		

	public ConversionTrackingPage(WebDriver driver) {
		super(driver);
		wait.waitForElementIsClickable(createBtn);
	}
	
	
	public void createTracking(String advertiser, String trackingName){
		advertiserFld.clear();
		advertiserFld.sendKeys(advertiser);
		advertiserFld.click();
		advertiserDropDown.click();
		System.out.println("Fill Tracking Name");
		trackerNameFld.sendKeys(trackingName);
		System.out.println("Fill Adverstiser Field");
		advertiserFld.clear();
		advertiserFld.sendKeys(advertiser);
		advertiserFld.click();
		wait.waitForElementIsClickable(advertiserDropDown);
		advertiserDropDown.click();
		System.out.println("Try to click Create Tracking Button");
		wait.waitForElementIsClickable(createTrackerBtn);
		createTrackerBtn.click();		
	}
		

}
