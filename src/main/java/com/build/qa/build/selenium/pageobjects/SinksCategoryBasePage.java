package com.build.qa.build.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import com.build.qa.build.selenium.pageobjects.BasePage;

public class SinksCategoryBasePage extends BasePage {
	
	private By sinksCategoryBasePageWrapper;
	
	public SinksCategoryBasePage(WebDriver driver, Wait<WebDriver> wait) {
		super(driver, wait);
		driver.manage().window().maximize();
		sinksCategoryBasePageWrapper = By.cssSelector("#wrapper.plp");
		
	}
	
	public boolean onSinksCategoryBasePage() {
		return wait.until(ExpectedConditions.presenceOfElementLocated(sinksCategoryBasePageWrapper)) != null;
	}
	
}
