package com.build.qa.build.selenium.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

//import com.build.qa.build.selenium.framework.BaseFramework;

public class HomePageSearch {
	
	WebDriver driver;
	Wait<WebDriver> wait;
	By searchBar = By.xpath("//div[contains(@class, 'header-container')]/descendant::input[(@name='search')]");
	By searchButton = By.xpath("//div[contains(@class, 'header-container')]/descendant::a[(@class='fg-icon-search')]");
	
	public HomePageSearch(WebDriver driver) {
		this.driver = driver;
	}
	
	public void searchonHomePage(String arg1) {
		try {
			Thread.sleep(15000);
			wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(5000, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class);
			driver.findElement(searchBar).sendKeys(arg1);
			driver.findElement(searchButton).click();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		e.printStackTrace();
		}
		
	}
}
