package com.green_kart;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pom.Pom_class;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Green_kart {
	public static WebDriver driver;
	public static Pom_class p;
	
	@BeforeTest
	public void browser_launch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@Test
	public void placeorder() throws InterruptedException, FileNotFoundException, IOException {
		p = new Pom_class(driver);
		driver.get(p.Loadproperty("URL"));
		
		p.getAdd_cart().click();
		p.getCart().click();
		p.getProceed_to_checkOut().click();
		p.getPlace_order().click();
		p.getSelect_country().click();
		p.getCheckbox().click();
		p.getProceed_button();
		
		Assert.assertTrue(p.getOrder_placedSucessfully().isDisplayed());
	}

	@AfterMethod
	public void Get_status(ITestResult result) throws IOException {
		if (ITestResult.FAILURE == result.getStatus()) {
			File src1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			System.out.println("hhh");
			FileUtils.copyFile(src1,
			new File("./Failed_screenshot\\failed.png"));
		driver.quit();	
		} 
		else {
		
		driver.quit();
		}

	}
}
