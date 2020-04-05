package com.selenium.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utility.Constant;
import com.utility.ExcelUtils;

public class verify_profile_cart_amount {
	
	private WebDriver driver;
	
	
	String price;
	
	 @Test
	  public void Verify_amount() throws Exception {
	  
		  driver.findElement(By.linkText("Sign in")).click();
		    
		    ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"sheet1");
		    
		    String email = ExcelUtils.getCellData(1,1);
		    String password = ExcelUtils.getCellData(1,5);
		    
		    
		    driver.findElement(By.id("email")).click();
		    driver.findElement(By.id("email")).click();
		    
		      WebElement element1 = driver.findElement(By.id("email"));
		      Actions builder1 = new Actions(driver);
		      builder1.doubleClick(element1).perform();
		    
		    driver.findElement(By.id("email")).sendKeys(email);
		    driver.findElement(By.id("passwd")).click();
		    driver.findElement(By.id("passwd")).sendKeys(password);
		    driver.findElement(By.cssSelector("#SubmitLogin > span")).click();
		    
		    driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span")).click();
		    driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[1]/a/span")).click();
		    
		   price = driver.findElement(By.xpath("//*[@id=\"order-list\"]/tbody/tr/td[3]/span")).getText();
		   System.out.println("final price:"+price);
		   
			  
		   	
			  
			 

	  }
	 
	 @BeforeMethod
	  public void beforeMethod() {
		  

		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nilesh\\Desktop\\selenium\\chromedriver.exe");
			//System.setProperty("webdriver.firefox.marionette","C:\\Users\\Nilesh\\Desktop\\selenium\\geckodriver.exe");
			 //driver = new FirefoxDriver();
			 driver=new ChromeDriver();
	      //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
		        driver.manage().window().maximize();

	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	      //Launch the Online Store Website

	      driver.get(Constant.URL);
	     
	      
	  }

	
	 @AfterMethod
	  public void afterMethod() throws Exception { 


	     
	      driver.quit();
	      //ExcelUtils.setCellData("Pass", 1,17);
	  }

}
