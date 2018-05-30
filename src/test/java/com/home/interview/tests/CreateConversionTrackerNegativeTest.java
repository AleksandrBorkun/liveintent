package com.home.interview.tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.home.interview.dataprovider.DataProvider;
import com.home.interview.driver.DriverFactory;
import com.home.interview.pageobjects.ConversionTrackingPage;
import com.home.interview.pageobjects.HomePage;
import com.home.interview.pageobjects.LoginPage;
import com.home.interview.utils.Logger;

public class CreateConversionTrackerNegativeTest {
	
	private final static String LOGIN_URL = DataProvider.getProperty("loginURL");
	private final static String EMAIL = DataProvider.getProperty("email");
	private final static String PASS = DataProvider.getProperty("password");
	private final static String ADVERTISER = DataProvider.getProperty("advertiser_name");
	private final static String TRACK_NAME = DataProvider.getProperty("tracking_name");
	
	private LoginPage loginPage;
	private HomePage homePage;
	private ConversionTrackingPage conversionPage;
	
	private WebDriver driver;
	
	@BeforeMethod(alwaysRun = true)
	public void setup(){
		driver = DriverFactory.getInstance().getDriver();
	}
	
	@Test
	public void createConversionTrackerNegativeTest(){
		Logger.log("STEP 1 - Login To System");
		driver.get(LOGIN_URL);
		loginPage = new LoginPage(driver);
		homePage = loginPage.goToHomePage(EMAIL, PASS);

		Logger.log("STEP 2 - Go to Conversion Tracker Page");
		conversionPage = homePage.goToConversionTrackingPage();

		Logger.log("STEP 3 - Create New Conversion Tracker");
		conversionPage.createBtn.click();
		conversionPage.createTracking(ADVERTISER, TRACK_NAME);
		assertTrue(conversionPage.alertMsg.isDisplayed(), "Verify That Alert Is Present");	
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown(){
		driver.close();
	}

}
