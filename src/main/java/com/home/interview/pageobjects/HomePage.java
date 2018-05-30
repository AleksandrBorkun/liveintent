package com.home.interview.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	@FindBy(xpath = "//*[@class = 'icon icon--conversion-trackers icon--xl']")
	WebElement conversionTrackersBtn;

	public HomePage(WebDriver driver) {
		super(driver);
		wait.waitForElementIsClickable(conversionTrackersBtn);
	}
	
	public ConversionTrackingPage goToConversionTrackingPage(){
		System.out.println("Try to click conversion-trackers button");
		conversionTrackersBtn.click();
		return new ConversionTrackingPage(driver);
	}

}
