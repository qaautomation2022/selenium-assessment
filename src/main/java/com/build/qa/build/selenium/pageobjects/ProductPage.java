package com.build.qa.build.selenium.pageobjects;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

//import org.assertj.core.api.JUnitSoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class ProductPage {
	
	WebDriver driver;
	Wait<WebDriver> wait;
	By brandonProductpage = By.xpath("//div[contains(@class, 'row js_grey_line')][2]/descendant::h2[contains(@itemprop, 'name')]");
	By partnumbonProductpage = By.xpath("//span[@itemprop='productID']");
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void verifyProductpage() {

		//Expected Values for brand name and part # on product page
		String brandValueExpected = "Moen";
		String productIdExpected = "Part #M6702BN";
		
		//Actual Values for brand name and part # on product page	
		
		try {
			Thread.sleep(15000);
			wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(5000, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class);
			String brandValueActual = driver.findElement(brandonProductpage).getText().trim();
			String productIdActual = driver.findElement(partnumbonProductpage).getText().trim();
			
			//Verification of actual values against expected values for brand and part # and print when the test passes

			System.out.println("Expected Brand Value: " + brandValueExpected);
			System.out.println("Actual Brand Value: " + brandValueActual);
			
			System.out.println("Expected Product ID Value: " + productIdExpected);
			System.out.println("Actual Product ID Value: " + productIdActual);

			assertEquals ("Expected and Actual Brand Values did not match", brandValueExpected, brandValueActual);
			assertEquals ("Expected and Product ID Values did not match", productIdExpected, productIdActual);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}