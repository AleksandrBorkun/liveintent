package com.home.interview.utils;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.home.interview.dataprovider.DataProvider;

public class SeleniumWaitUtils {

	private final WebDriver driverWait;
	private final Wait<WebDriver> wait;
	private static final Integer duration = Integer.parseInt(DataProvider.getProperty("timeout"));

	public SeleniumWaitUtils(WebDriver driver) {
		this.driverWait = driver;
		wait = new WebDriverWait(this.driverWait, duration)
				.ignoring(StaleElementReferenceException.class, WebDriverException.class)
				.withMessage("Element was not found by locator ");
	}

	public void waitForElementIsClickable(WebElement element) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (RuntimeException e) {
			throw new RuntimeException("Element wasn't found");
		}
	}

	public void waitElementPresent(WebElement locator) {
		try {
			wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOf(locator)));
		} catch (RuntimeException e) {
			throw new RuntimeException("Element isn't on the page");
		}
	}

}
