package com.qa.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.datadriven.DataDriven;

public class LoginTest {
	public static WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\work\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 wait=new WebDriverWait(driver,10);
	}
	
	@Test(dataProvider="getData")
	public void verifyLogin(String uname,String pwd)
	{
		driver.findElement(By.name("userName")).sendKeys(uname);
		driver.findElement(By.name("password")).sendKeys(pwd);
		WebElement siginbtn=driver.findElement(By.name("login"));
		wait.until(ExpectedConditions.elementToBeClickable(siginbtn));
		siginbtn.click();
		String actual=driver.getTitle();
		String expected="Find a Flight: Mercury Tours:";
		Assert.assertEquals(actual, expected,"Title does not match");
	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		Object data[][]=new Object[2][2]; // 0 1
		
		for(int i=0;i<=1;i++)   // <3  0 1 2
		{
			for(int j=0;j<=1;j++)
			{
				data[i][j]=DataDriven.fetachDatafromExcel("Sheet1", i+1, j);
			}
		}
		/*
		data[0][0]=DataDriven.fetachDatafromExcel("Sheet1", 1, 0);
		data[0][1]=DataDriven.fetachDatafromExcel("Sheet1", 1, 1);
		data[1][0]=DataDriven.fetachDatafromExcel("Sheet1", 2, 0);
		data[1][1]=DataDriven.fetachDatafromExcel("Sheet1", 2, 1);*/
		return data;
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
