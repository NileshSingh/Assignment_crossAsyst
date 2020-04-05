package com.selenium.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utility.Constant;
import com.utility.ExcelUtils;

public class create_Account {
	
	private WebDriver driver;
	 
	 
	  
	  @Test
	  public void newAccount() throws Exception {
		  
		  driver.findElement(By.linkText("Sign in")).click();
		  
		  ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"sheet1");
	      
	      String email = ExcelUtils.getCellData(1,1);
	      String FN = ExcelUtils.getCellData(1,2);
	      String LN = ExcelUtils.getCellData(1,3);
	      String email1 = ExcelUtils.getCellData(1,4);
	      String password = ExcelUtils.getCellData(1,5);
	      String FN1 = ExcelUtils.getCellData(1,6);
	      String LN1 = ExcelUtils.getCellData(1,7);
	      String company = ExcelUtils.getCellData(1,8);
	      String add1 = ExcelUtils.getCellData(1,9);
	      String add2 = ExcelUtils.getCellData(1,10);
	      String city = ExcelUtils.getCellData(1,11);
	      String PostCode = ExcelUtils.getCellData(1,12);
	      String addInfo = ExcelUtils.getCellData(1,13);
	      String home_phone = ExcelUtils.getCellData(1,14);
	      String phone = ExcelUtils.getCellData(1,15);
	      String alise = ExcelUtils.getCellData(1,16);
	      
	      String post = PostCode.trim();
	      
	      System.out.println("phone " + home_phone);
	      System.out.println("mobile " + phone);
	      System.out.println("postal code " + PostCode);
	      
		  
		  
		  
		    
		    driver.findElement(By.id("email_create")).click();
		    driver.findElement(By.id("email_create")).sendKeys(email);
		    driver.findElement(By.cssSelector("#SubmitCreate > span")).click();
		    driver.findElement(By.id("id_gender1")).click();
		    driver.findElement(By.id("customer_firstname")).click();
		    driver.findElement(By.id("customer_firstname")).sendKeys(FN);
		    driver.findElement(By.id("customer_lastname")).click();
		    driver.findElement(By.id("customer_lastname")).sendKeys(LN);
		    driver.findElement(By.id("email")).click();
		    driver.findElement(By.id("email")).clear();

		    driver.findElement(By.id("email")).sendKeys(email1);
		    driver.findElement(By.id("passwd")).click();
		    driver.findElement(By.id("passwd")).sendKeys(password);
		    driver.findElement(By.id("days")).click();
		    
		      WebElement dropdown3 = driver.findElement(By.id("days"));
		      dropdown3.findElement(By.xpath("//*[@id=\"days\"]/option[12]")).click();
		    
		    driver.findElement(By.id("days")).click();
		    driver.findElement(By.id("months")).click();
		    
		      WebElement dropdown2 = driver.findElement(By.id("months"));
		      dropdown2.findElement(By.xpath("//*[@id=\"months\"]/option[2]")).click();
		    
		    driver.findElement(By.id("months")).click();
		    driver.findElement(By.id("years")).click();
		    
		      WebElement dropdown1 = driver.findElement(By.id("years"));
		      dropdown1.findElement(By.xpath("//*[@id=\"years\"]/option[29]")).click();
		    
		    driver.findElement(By.id("years")).click();
		    driver.findElement(By.id("newsletter")).click();
		    driver.findElement(By.id("optin")).click();
		    driver.findElement(By.id("company")).click();
		    driver.findElement(By.id("company")).sendKeys(company);
		    driver.findElement(By.id("address1")).click();
		    driver.findElement(By.id("address1")).sendKeys(add1);
		    driver.findElement(By.id("city")).sendKeys(city);
		   
		    
		    driver.findElement(By.id("address2")).click();
		    driver.findElement(By.id("address2")).sendKeys(add2);
		    driver.findElement(By.id("id_state")).click();
		    
		      WebElement dropdown = driver.findElement(By.id("id_state"));
		      dropdown.findElement(By.xpath("//*[@id=\"id_state\"]/option[20]")).click();
		    
		    driver.findElement(By.id("id_state")).click();
		    
		    driver.findElement(By.id("postcode")).click(); 
		    driver.findElement(By.id("postcode")).sendKeys(post); 
		    driver.findElement(By.id("other")).sendKeys(addInfo);
		    
		    WebElement dropdown5 = driver.findElement(By.id("id_country"));
		      dropdown.findElement(By.xpath("//*[@id=\"id_country\"]/option[2]")).click();
		    
		    driver.findElement(By.id("phone")).click();
		    driver.findElement(By.id("phone")).sendKeys(home_phone);
		    driver.findElement(By.id("phone_mobile")).click();
		    driver.findElement(By.id("phone_mobile")).sendKeys(phone);
		    driver.findElement(By.id("alias")).click();
		    driver.findElement(By.id("alias")).sendKeys(alise);
		    driver.findElement(By.id("submitAccount")).click();
		    
		    driver.findElement(By.linkText("Sign out")).click();
	  
	   
	  
		  
		  
	  }
	  
	  

	  @BeforeMethod
	  public void beforeMethod() {
		  
		  // Create a new instance of the Firefox driver

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


	     
	      //driver.quit();
	      ExcelUtils.setCellData("Pass", 1,17);
	  }

}
