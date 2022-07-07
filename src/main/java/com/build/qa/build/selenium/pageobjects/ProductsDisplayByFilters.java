package com.build.qa.build.selenium.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class ProductsDisplayByFilters {
	
	WebDriver driver;
	Wait<WebDriver> wait;
	By totalResults = By.xpath("//div[(@class='rc-fg-search-word')]/descendant::div[contains(@class, 'total-record')]");
	By brandSel = By.xpath("//div[(@class='refinements')]/div[2]/descendant::p[text()='Moen']");
	
	By colFin = By.xpath("//div[(@data-dname='Color_Finish_Category')]/descendant::p[text()='Chromes']");
	By filtoResults = By.xpath("//div[(@class='rc-fg-search-word')]/descendant::div[contains(@class, 'total-record')]");

	public ProductsDisplayByFilters(WebDriver driver) {
		this.driver = driver;
	}

	public void productCounts() {
		
		String totalResultsDisplayed = null;
		String filterResultsbyBrand = null;
		String filterResultsbyBrandandFinish = null;
		
		try {
			Thread.sleep(10000);
			wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class);
			totalResultsDisplayed = driver.findElement(totalResults).getAttribute("data-total-record");
			System.out.println("Total Number of Products: " + totalResultsDisplayed);
			Thread.sleep(10000);
			
			wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class);
			driver.findElement(brandSel).click();
			wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class);
			Thread.sleep(10000);
			filterResultsbyBrand = driver.findElement(filtoResults).getAttribute("data-total-record");
			System.out.println("Total Number of Products filtered by Brand: " + filterResultsbyBrand);
			
			Thread.sleep(10000);
			wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class);
			driver.findElement(colFin).click();
			wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class);
			Thread.sleep(10000);
			filterResultsbyBrandandFinish = driver.findElement(filtoResults).getAttribute("data-total-record");
			System.out.println("Total Number of Products filtered by Brand and Color Finish: " + filterResultsbyBrandandFinish);
			Thread.sleep(3000);

					}
			catch (Exception e) {
				System.out.println("Element not found");
		}
		
	}
	
}

