package com.build.qa.build.selenium.tests;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Test;
import com.build.qa.build.selenium.framework.BaseFramework;
import com.build.qa.build.selenium.pageobjects.*;
import com.build.qa.build.selenium.pageobjects.homepage.HomePage;
//import com.build.qa.build.selenium.pageobjects.SinksCategoryBasePage;
import org.openqa.selenium.WebDriver;

public class FergTest extends BaseFramework {

//	/**
//	 * Extremely basic test that outlines some basic
//	 * functionality and page objects as well as assertJ
//	 */
	@Test
	public void navigateToHomePage() {
		driver.get(getConfiguration("HOMEPAGE"));
		HomePage homePage = new HomePage(driver, wait);

		softly.assertThat(homePage.onHomePage())
			.as("The website should load up with the Build.com desktop theme.")
			.isTrue();
		System.out.println("***** Test # 1 Completed *****");
	}

//	/**
//	 * Search for the Moen m6702bn from the search bar
//	 * @assert: That the product page we land on is what is expected by checking the product brand and product id
//	 * @difficulty Easy
//	 */

	@Test
	//Test Case 2
	public void searchForProductLandsOnCorrectProduct() {
	// TODO: Implement this test
		HomePageSearch objHomePageSearch;
		ProductPage objProductPage;
		
		driver.get(getConfiguration("HOMEPAGE"));
		HomePage homePage = new HomePage(driver, wait);
		softly.assertThat(homePage.onHomePage())
			.isTrue();
		
		objHomePageSearch = new HomePageSearch(driver);
		objHomePageSearch.searchonHomePage("Moen m6702bn");
		
		objProductPage = new ProductPage(driver);
		objProductPage.verifyProductpage();
		
		System.out.println("***** Test # 2 Completed *****");

	}

//	/**
//	 * Go to the Bathroom Sinks category directly
//	 * (https://www.ferguson.com/category/bathroom-plumbing/bathroom-faucets/bathroom-sink-faucets/_/N-zbq4i3)
//	 * and add the second product on the search results (Category Drop) page to the cart.
//	 * @assert: the product that is added to the cart is what is expected
//	 * @difficulty Easy-Medium
//	 */
	@Test
	//Test Case 3	
	public void addProductToCartFromCategoryDrop () {
		// TODO: Implement this test
		String partNumberonCartOverrlay;
		String partNumberonCartDetailPage;
		driver.get("https://www.ferguson.com/category/bathroom-plumbing/bathroom-faucets/bathroom-sink-faucets/_/N-zbq4i3");
		driver.manage().window().maximize();
		
		SinksCategoryPage objSinksCategoryPage = new SinksCategoryPage(driver);
		objSinksCategoryPage.productDefaultFinish();
		
		AddToCartOverlay objAddToCartOverlay = new AddToCartOverlay(driver);
		partNumberonCartOverrlay = objAddToCartOverlay.addToCartOnOverlay();
		
		ShoppingCart objShoppingCart = new ShoppingCart(driver);
		partNumberonCartDetailPage = objShoppingCart.shoppingCartPage();
		
		assertEquals(partNumberonCartOverrlay, partNumberonCartDetailPage);
		
		System.out.println("***** Test # 3 Completed *****");

	}

//	/**
//	 * Add two different finishes of a product (such as Moen m6702bn) to cart,
//	 * change the quantity of each finish on the cart page
//	 * @assert that the product and cart total update as expected when the quantity is changed
//	 * @difficulty Medium-Hard
//	 */
		@Test
		//Test Case 4		
		public void addMultipleCartItemsAndChangeQuantity() {
		// TODO: Implement this test
			
			driver.get("https://www.ferguson.com/category/bathroom-plumbing/bathroom-faucets/bathroom-sink-faucets/_/N-zbq4i3");
			driver.manage().window().maximize();
			
			SinksCategoryPage objSinksCategoryPage = new SinksCategoryPage(driver);
			AddToCartOverlay objAddToCartOverlay = new AddToCartOverlay(driver);
			ShoppingCart objShoppingCart = new ShoppingCart(driver);
			
			objSinksCategoryPage.productDefaultFinish();
			objAddToCartOverlay.addToCartOnOverlayt();

			objSinksCategoryPage.productSecondFinish();
			objAddToCartOverlay.addToCartOnOverlayt();
			
			objShoppingCart.increaseQtyCartPage();
			
			System.out.println("***** Test # 4 Completed *****");
			
	}

//
//	/**
//	 * Go to a category drop page (such as Bathroom Faucets) and narrow by
//	 * at least two filters (facets), e.g: Finish=Chromes and Brand=Brizo
//	 * @assert that the correct filters are being narrowed, and the result count
//	 * is correct, such that each facet selection is narrowing the product count.
//	 * @difficulty Hard
//	 */
	@Test
	public void facetNarrowBysResultInCorrectProductCounts() {
		// TODO: Implement this test
		driver.get("https://www.ferguson.com/category/bathroom-plumbing/bathroom-faucets/bathroom-sink-faucets/_/N-zbq4i3?sr=everywhere");
		driver.manage().window().maximize();
		
		ProductsDisplayByFilters objProductsDisplayByFilters = new ProductsDisplayByFilters(driver);
		objProductsDisplayByFilters.productCounts();
		
		System.out.println("***** Test # 5 Completed *****");
		
		}
}
