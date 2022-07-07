package com.build.qa.build.selenium.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class AddToCartOverlay {
	
	WebDriver driver;
	Wait<WebDriver> wait;
	By itemDescCartOverlay = By.xpath("//div[@class='content-body']/div[@class='name']");
	By partNumberCartOverlay = By.xpath("//div[@class='content-body']/div[2]/span[2]");
	By addToCartOverlay = By.xpath("//button[contains(@class, 'add-to-cart')]");


	public AddToCartOverlay(WebDriver driver) {
		this.driver = driver;
	}

	public String addToCartOnOverlay() {
		
		String partNumberExpected = null;
		
		try {
			Thread.sleep(10000);
			wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class);
			partNumberExpected = driver.findElement(partNumberCartOverlay).getText().trim();
			System.out.println("Part Number from Cart Overlay: " + partNumberExpected);
		}
			catch (Exception e) {
		}
		
		try {
			wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class);
			driver.findElement(addToCartOverlay).click();

		}
			catch (Exception e) {
		}
		
		return partNumberExpected;
				
	}
	
	public void addToCartOnOverlayt() {
			
		try {
			Thread.sleep(10000);
			wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(5000, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class);
			driver.findElement(addToCartOverlay).click();
			
		}
			catch (Exception e) {
		}
		
	}
}
