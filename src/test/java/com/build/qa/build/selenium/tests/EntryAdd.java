package com.build.qa.build.selenium.tests;

import java.util.concurrent.TimeUnit;

//import java.util.concurrent.TimeUnit;

//import java.time.Duration;
//import java.util.List;
//import java.util.concurrent.TimeUnit;

//import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EntryAdd {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// app page for exercises: https://the-internet.herokuapp.com  
		System.setProperty("webdriver.chrome.driver", "C:\\webdrvrs\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/entry_ad");
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    //to close the pop-up
	    for (String winhandle: driver.getWindowHandles()) {
		    driver.switchTo().window(winhandle);
		    driver.findElement(By.xpath("(//p[normalize-space()='Close'])")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    }
	    driver.switchTo().defaultContent();
	    // pop-up is opening only when the link is clicked twice, hence this step
	    for (int i = 0; i < 2; i++) {
	    	driver.findElement(By.linkText("click here")).click();
	    	}
	    driver.close();
	    
	}

}
