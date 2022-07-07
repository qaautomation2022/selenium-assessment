package com.build.qa.build.selenium.pageobjects;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.NoSuchElementException;

public class SinksCategoryPage {
	
	WebDriver driver;
	Wait<WebDriver> wait;
	
	By addToCartSecProdDefFinish = By.xpath("//div[(@class='fg-search-results-box')]/ul/li[2]/div[1]/div[8]/p");
	By addToCartSecProdSecFinish = By.xpath("//div[(@class='fg-search-results-box')]/ul/li[2]/div[2]/div[8]/p");
	By addToCartColorSwap = By.xpath("//div[(@class='fg-search-results-box')]/ul/li[2]/div[1]/div[3]/div[1]/div[1]/label[2]/div[(@class='inner-box')]/span");
	
	public SinksCategoryPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void productDefaultFinish() {
		try {
			Thread.sleep(30000);
			wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class);
			driver.findElement(addToCartSecProdDefFinish).click();

		}
			catch (Exception e) {
		}
		
	}
	
	public void productSecondFinish() {
		try {
			Thread.sleep(10000);
			wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class);
			driver.findElement(addToCartColorSwap).click();
			driver.findElement(addToCartSecProdSecFinish).click();
		}
			catch (Exception e) {
		}
		
	}
}
