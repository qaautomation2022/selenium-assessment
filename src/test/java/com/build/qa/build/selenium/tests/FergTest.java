package com.build.qa.build.selenium.tests;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.Assert;
import com.build.qa.build.selenium.framework.BaseFramework;
import com.build.qa.build.selenium.pageobjects.homepage.Elements;
import com.build.qa.build.selenium.pageobjects.homepage.HomePage;


public class FergTest extends BaseFramework {

	/**
	 * Extremely basic test that outlines some basic
	 * functionality and page objects as well as assertJ
	 */
	@Test
	//Test Case 1
	public void navigateToHomePage() {
		driver.get(getConfiguration("HOMEPAGE"));
		HomePage homePage = new HomePage(driver, wait);

		softly.assertThat(homePage.onHomePage())
			.as("The website should load up with the Build.com desktop theme.")
			.isTrue();
	}

	/**
	 * Search for the Moen m6702bn from the search bar
	 * @throws InterruptedException 
	 * @assert: That the product page we land on is what is expected by checking the product brand and product id
	 * @difficulty Easy
	 */
	@Test
	//Test Case 2
		public void searchForProductLandsOnCorrectProduct() throws InterruptedException {
		// TODO: Implement this test
		driver.get(getConfiguration("HOMEPAGE"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		// identifying search bar, search button, brand name and part # on product page
		driver.findElement(Elements.searchBar).sendKeys("Moen m6702bn");
		driver.findElement(Elements.searchButton).click();
		String brandValueActual = driver.findElement(Elements.brandonProductpg).getText();
		String productIdActual = driver.findElement(Elements.partNo).getText();
		
		//Expected Values for brand name and part # on product page
		String brandValueExpected = "Moen";
		String productIdExpected = "Part #M6702BN";
		
		//Verification of actual values against expected values for brand and part # and print when the test passes
		softly.assertThat(brandValueActual)
		.isEqualTo(brandValueExpected);
		
		System.out.println("Actual Brand Value" + brandValueActual + "is equal to Expected Brand Value" + brandValueExpected);
		
		softly.assertThat(productIdActual)
		.isEqualTo(productIdExpected);
		
		System.out.println("Actual Brand Value" + productIdActual + "is equal to Expected Brand Value" + productIdExpected);
	}

	/**
	 * Go to the Bathroom Sinks category directly
	 * (https://www.ferguson.com/category/bathroom-plumbing/bathroom-faucets/bathroom-sink-faucets/_/N-zbq4i3)
	 * and add the second product on the search results (Category Drop) page to the cart.
	 * @throws InterruptedException 
	 * @assert: the product that is added to the cart is what is expected
	 * @difficulty Easy-Medium
	 */
	@Test
	//Test Case 3
	public void addProductToCartFromCategoryDrop() throws InterruptedException {
		// TODO: Implement this test
		//Open Product search results page directly and maximize the window
		//Implicit wait for elements to load and add the item to the cart
		driver.get("https://www.ferguson.com/category/bathroom-plumbing/bathroom-faucets/bathroom-sink-faucets/_/N-zbq4i3");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(Elements.addToCartSrch).click();
		
		//Cart popup window: Implicit wait for elements to load and add the first item to the cart 
		//from popup window, retrieve item description		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String itemDescriptionExp = driver.findElement(Elements.itemDescCartpopup).getText();
		driver.findElement(Elements.addToCartPopup).click();
		
		//Click on Cart in Search results page to move onto Cart page
		driver.findElement(Elements.cartHeader).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String proddescCartPgActual = driver.findElement(Elements.proddescCartPg).getText();
		
		//Verification of actual values against expected values for brand and part # and print when the test passes
		softly.assertThat(itemDescriptionExp)
		.isEqualTo(proddescCartPgActual);
		
		System.out.println("Actual Brand Value" + proddescCartPgActual);
		System.out.println ("Expected Brand Value" + itemDescriptionExp);
		
	}

	/**
	 * Add two different finishes of a product (such as Moen m6702bn) to cart,
	 * change the quantity of each finish on the cart page
	 * @assert that the product and cart total update as expected when the quantity is changed
	 * @difficulty Medium-Hard
	 */
	@Test
//	Test Case 4
	public void addMultipleCartItemsAndChangeQuantity() throws InterruptedException {
		// TODO: Implement this test
		//Open Product search results page directly and maximize the window
		//Implicit wait for elements to load and add the item to the cart
		driver.get("https://www.ferguson.com/category/bathroom-plumbing/bathroom-faucets/bathroom-sink-faucets/_/N-zbq4i3");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElement(Elements.addToCartSrch).click();
		
		//Cart popup window: Implicit wait for elements to load and add the first item to the cart 
		//from popup window, retrieve item description
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		String itemDescriptionExp = driver.findElement(Elements.itemDescCartpopup).getText();
		System.out.println(itemDescriptionExp);
		driver.findElement(Elements.addToCartPopup).click();
		
		//Back to Product search results page
		// Implicit wait for elements to load and add the same item with different finish to the cart from popup window
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElement(Elements.nextProdFinish).click();
		driver.findElement(Elements.addToCartSrchtwo).click();
		String itemDescriptionExp2 = driver.findElement(Elements.itemDescCartpopup).getText();
		System.out.println(itemDescriptionExp2);
		
		//change the quantity of each finish in the cart and assert
		//that the product and cart total update as expected when the quantity is changed
		//This is not completed***
	}

	/**
	 * Go to a category drop page (such as Bathroom Faucets) and narrow by
	 * at least two filters (facets), e.g: Finish=Chromes and Brand=Brizo
	 * @assert that the correct filters are being narrowed, and the result count
	 * is correct, such that each facet selection is narrowing the product count.
	 * @difficulty Hard
	 */
	@Test
	public void facetNarrowBysResultInCorrectProductCounts() {
		// TODO: Implement this test
	}
}
