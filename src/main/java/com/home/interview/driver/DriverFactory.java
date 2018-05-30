package com.home.interview.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.home.interview.dataprovider.DataProvider;

public class DriverFactory {

	private static final Integer TIME_OUT = Integer.parseInt(DataProvider.getProperty("timeout"));
	private WebDriver driver;

	private static DriverFactory INSTANCE = new DriverFactory();

	public static DriverFactory getInstance() {
		return INSTANCE;
	}

	public WebDriver getDriver() {
		if (driver != null) {
			return driver;
		}
		System.out.println("Open Browser");
		System.setProperty("webdriver.chrome.driver", DataProvider.getProperty("chrome"));
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().pageLoadTimeout(TIME_OUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TIME_OUT, TimeUnit.SECONDS);
		return driver;
	}

}
