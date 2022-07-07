package com.build.qa.build.selenium.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class ShoppingCart {
	
	WebDriver driver;
	Wait<WebDriver> wait;
	By cartHeaderShoppingCart = By.xpath("//div[@class='cart']/a/span/i[@class='cart-icon']");
	By proddescShoppingCartPage = By.xpath("//div[@class='cl-name']/a/p");
	By partNumberShoppingCartPage = By.xpath("//div[@class='cl-info']/p");
	By firstItmQtyBtnCartPage = By.xpath("//li[(@class='js-items-column')][1]/descendant::input[@name='updateQuantity']");
	By secItemQtyBtnCartPage = By.xpath("//li[(@class='js-items-column')][2]/descendant::input[@name='updateQuantity']");
	By firstItmQtyUpBtnCartPage = By.xpath("//li[(@class='js-items-column')][1]/descendant::div[contains(@class, 'jq-qty-up')]");
	By secItemQtyUpBtnCartPage = By.xpath("//li[(@class='js-items-column')][2]/descendant::div[contains(@class, 'jq-qty-up')]");
	By firstItmTotalPrice = By.xpath("//li[(@class='js-items-column')][1]/descendant::div[(@class='total-price')]/span[1]");
	By sectItmTotalPrice = By.xpath("//li[(@class='js-items-column')][2]/descendant::div[(@class='total-price')]/span[1]");
	By cartTotalPrice = By.xpath("//div[(@class='js-cart-summary')]//descendant::div[contains(@class, 'total-cost')]/span[2]/b");
	
	public ShoppingCart(WebDriver driver) {
		this.driver = driver;
	}

	public String shoppingCartPage() {
		
		String partNumberActual = null;

		try {
			Thread.sleep(10000);
			wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class);
			driver.findElement(cartHeaderShoppingCart).click();
		}
			catch (Exception e) {
		}
		
		try {
			Thread.sleep(10000);
			wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class);
			partNumberActual = driver.findElement(partNumberShoppingCartPage).getText().trim();
			System.out.println("Part Number from Shopping Cart Page: " + partNumberActual);

		}
			catch (Exception e) {
				System.out.println("Element not found");
		}
		
		return partNumberActual;
		
	}

	public void increaseQtyCartPage() {
		
		Actions action = new Actions(driver);
				
		try {
			Thread.sleep(10000);
			wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class);
			driver.findElement(cartHeaderShoppingCart).click();
			
		}
			catch (Exception e) {
		}
		
		String firstItmTotalPriceDollars = null;
		String sectItmTotalPriceDollars = null;
		String cartTotalPriceDollars = null;
		
		for (int i=1; i<=2; i++) {
			
			firstItmTotalPriceDollars = driver.findElement(firstItmTotalPrice).getText().trim();
			sectItmTotalPriceDollars = driver.findElement(sectItmTotalPrice).getText().trim();
			cartTotalPriceDollars = driver.findElement(cartTotalPrice).getText().trim();
		
			System.out.println("Cost of First Item in the Cart for Qty " + i + ":" + firstItmTotalPriceDollars);
			System.out.println("Cost of Second Item in the Cart for Qty " + i + ":" + sectItmTotalPriceDollars);	
			System.out.println("Total Cost of Items in the Cart for Total Qty " + (i+i) + ":" + cartTotalPriceDollars);	
		
			if (i<2) {
				try {
					Thread.sleep(15000);
					wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS)
							.ignoring(NoSuchElementException.class);
					WebElement firstItemQty = driver.findElement(firstItmQtyBtnCartPage);
					action.moveToElement(firstItemQty).perform();
					wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS)
							.ignoring(NoSuchElementException.class);
					driver.findElement(firstItmQtyUpBtnCartPage).click();
					Thread.sleep(10000);
					wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS)
							.ignoring(NoSuchElementException.class);
					WebElement secItemQty = driver.findElement(secItemQtyBtnCartPage);
					action.moveToElement(secItemQty).perform();
					wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS)
							.ignoring(NoSuchElementException.class);
					driver.findElement(secItemQtyUpBtnCartPage).click();
					Thread.sleep(5000);
					}
					catch (Exception e) {
						System.out.println("Element not found");
					}
			}

		}	
	}

}
