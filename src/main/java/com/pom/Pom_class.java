package com.pom;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Pom_class {

	
	public static WebDriver driver;
	
	@FindBy (xpath = "(//button[text()='ADD TO CART'])[1]")
	private WebElement Add_cart;
	
	@FindBy (xpath = "//img[@alt='Cart']")
	private WebElement Cart;
	
	@FindBy (xpath = "//button[text()='PROCEED TO CHECKOUT']")
	private WebElement Proceed_to_checkOut;
	
	@FindBy (xpath = "//button[text()='Place Order']")
	private WebElement place_order;
	
	@FindBy (xpath = "//select[@style='width: 200px;']")
	private WebElement select_country;
	
	@FindBy (xpath ="//input[@type='checkbox']")
	private WebElement Checkbox;
	
	@FindBy (xpath ="//button[text()='Proceed']")
	private WebElement Proceed_button;
	
	@FindBy (xpath = "//span[@style='color:green;font-size:25px']")
	private WebElement order_placedSucessfully;


public Pom_class(WebDriver driver2) {
	this.driver = driver2;
	
	PageFactory.initElements(driver2, this);
}

public WebElement getCheckbox() {
	return Checkbox;
}

public void setCheckbox(WebElement checkbox) {
	Checkbox = checkbox;
}

public WebElement getAdd_cart() {
	return Add_cart;
}

public WebElement getCart() {
	return Cart;
}

public WebElement getProceed_to_checkOut() {
	return Proceed_to_checkOut;
}

public WebElement getPlace_order() {
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	getPlace_order().click();
	return place_order;
}

public WebElement getSelect_country() {
	
	WebElement list = driver.findElement(By.xpath("//select[@style='width: 200px;']"));
	list.click();
	Select s = new Select(list);
	s.selectByValue("India");
	return select_country;
}

public WebElement getProceed_button() {
	return Proceed_button;
}

public WebElement getOrder_placedSucessfully() {
	return order_placedSucessfully;
}

public static String Loadproperty(String value) throws FileNotFoundException, IOException {
	Properties prop = new Properties();
	prop.load(new FileInputStream("./property_File\\Input_data.properties"));
	return prop.getProperty(value);
}}