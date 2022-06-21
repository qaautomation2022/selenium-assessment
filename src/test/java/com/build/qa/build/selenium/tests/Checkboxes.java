package com.build.qa.build.selenium.tests;

//import java.time.Duration;
import java.util.List;
//import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;

//import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkboxes {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// app page for exercises: https://the-internet.herokuapp.com  
		System.setProperty("webdriver.chrome.driver", "C:\\webdrvrs\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/checkboxes");
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    List <WebElement> checkbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
	    
        int Size = checkbox.size();     // Finding the number of check boxes and assigning to the variable 'Size'
        System.out.println(Size);		// print the number of checkboxes
 
        for(int i=0; i<Size; i++)   {   // Starts the loop and goes through all checkboxes
        	checkbox.get(i).click();    // step to click all checkboxes
        }
        
        System.out.println("All checkboxes are clicked once");
        driver.close();
	}

}
