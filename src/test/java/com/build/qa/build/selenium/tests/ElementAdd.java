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

public class ElementAdd {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// app page for exercises: https://the-internet.herokuapp.com  
		System.setProperty("webdriver.chrome.driver", "C:\\webdrvrs\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	    
	    //to create 4 buttons
	    for (int i = 0; i < 4; i++) {
	    	   driver.findElement(By.xpath("(//button[@onclick='addElement()'])")).click();
	    	}
	    //System.out.println(driver.findElements(By.xpath("(//div[@id='elements']//button)")).size());
	    
	    //find and print number of buttons before removal
	    int buttonSizeBf = driver.findElements(By.xpath("(//div[@id='elements']//button)")).size();
	    System.out.println("Total number of Delete Buttons before removal:"+ buttonSizeBf);
	    
	    //to delete button #2
	    for(int i=0; i<buttonSizeBf; i++)   {   // Starts the loop from first button to the last one
        	//System.out.println("Button Number not deleted is:"+ i);
        		if(i == 2) {
        			driver.findElement(By.xpath("(//div[@id='elements']//button)")).click();
        			System.out.println("Button Number deleted is:"+ i);
        		}
        }
	    //find and print number of buttons left
	    int buttonSizeAf = driver.findElements(By.xpath("(//div[@id='elements']//button)")).size();
	    System.out.println("Total number of Delete Buttons after removal:"+ buttonSizeAf);
	    
	    driver.close();
	    
	}

}
