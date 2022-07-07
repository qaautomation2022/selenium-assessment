package com.build.qa.build.selenium.pageobjects.homepage;

import org.openqa.selenium.By;


public class Elements {
	
	//Home Page
	public static By searchBar = By.xpath("//input[@class='text-input search react-search-input-normal js-reload-value']");
	public static By searchButton = By.xpath("//a[@href='javascript:;']");
	
	//Product detail page
	public static By brandonProductpg = By.xpath("//h2[@class='product__brand']");
	public static By partNo = By.xpath("//span[@itemprop='productID']");
	
	//Category and pop-up add to cart Page
	public static By addToCartSrch = By.xpath("//div[(@class='fg-search-results-box')]/ul/li[2]/div[1]/div[8]");
	public static By addToCartSrchtwo = By.xpath("//div[(@class='fg-search-results-box')]/ul/li[2]/div[2]/div[8]");
	public static By addToCartPopup = By.xpath("//button[contains(@class, 'add-to-cart')]");
	public static By nextProdFinish = By.xpath("//div[(@class='fg-search-results-box')]/ul/li[2]/div[1]/div[3]/div[1]/div[1]/label[2]/div[1]");

	//public static By itemDescCartpopup = By.className("name");
	public static By itemDescCartpopup = By.xpath("//div[@class='name']");
	
	// Cart icon on header
	public static By cartHeader = By.xpath("//div[@class='cart']/a/span/i");
	//public static By cartHeader = By.xpath("//div/a/span/i[contains@class, 'cart-icon')]");
	
	//Cart detail Page
	public static By proddescCartPg = By.xpath("//div[@class='cl-name']/a/p");
	public static By proddescShoppingCartPage;
}
