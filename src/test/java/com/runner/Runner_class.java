package com.runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\java\\com\\feature",glue="com\\stepdef",
plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class Runner_class {
	
	public static WebDriver driver;
	
	@BeforeClass
	public static void driver_launch() {
		
	 WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
	}
	
	@AfterClass
	public static void TearDown() {
		driver.close();
	}
}
