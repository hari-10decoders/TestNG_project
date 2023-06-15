package com.stepdef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.runner.Runner_class;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef {
	
	public static WebDriver driver = Runner_class.driver;
	
	@Given("I will open Ninja tutorial home page")
	public void i_will_open_ninja_tutorial_home_page() throws InterruptedException {

	driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
	Thread.sleep(3000);
	}
	@When("I navigate the login page")
	public void i_navigate_the_login_page() {
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
	}
	@When("I Enter the E-mail ID")
	public void i_enter_the_e_mail_id() {
		driver.findElement(By.id("input-email")).sendKeys("hphari8280@gmail.com");
	}
	@When("I Enter the password")
	public void i_enter_the_password() {
		driver.findElement(By.id("input-password")).sendKeys("Vikkram@2023");
	}
	@Then("I click the login button it should navigate to logged-In page.")
	public void i_click_the_login_button_it_should_navigate_to_logged_in_page() {
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}



	
}
