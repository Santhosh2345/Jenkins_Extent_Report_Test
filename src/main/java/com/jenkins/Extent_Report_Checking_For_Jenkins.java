package com.jenkins;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.projectSpecific.base.ProjectSpecificMethods;

import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Extent_Report_Checking_For_Jenkins extends ProjectSpecificMethods{

	public Extent_Report_Checking_For_Jenkins(RemoteWebDriver driver, ExtentTest node, Properties prop,
			                            String Environment, String StageUrl, String Stage1Url) {
		
		this.driver = driver;
		this.node = node;
		this.prop = prop;
		this.Environment = Environment;
		this.StageURL = StageUrl;
		this.Stage1URL = Stage1Url;
	} 
	
	@Given("Launch the Website")
	public void launchWebsite() {
		if(Environment.equalsIgnoreCase("Live")) {
			navigateto(StageURL);
		}else {
			navigateto(Stage1URL);
		}
	}
	
	@When("Navigate to Another Website")
	public void navigateTo_Another_Website() throws InterruptedException {
		if(driver.findElement(By.xpath("//ul[@class='mlist']//a")).isDisplayed()) {
			String a = "This is SalezRobot Website<br />"+url();
			reportStep2(a, "PASS");
		}else {
			String a = "SalezRobot Website ScreenShot Fail<br />"+url();
			reportStep2(a, "FAIL");
		}
		
		Thread.sleep(3000);
		navigateto("https://www.amazon.in");
		if(driver.findElement(By.xpath("//a[@href='/ref=nav_logo']")).isDisplayed()) {
			String a = "This is Amazon Website<br />"+url();
			reportStep2(a, "PASS");
		}else {
			String a = "Amazon Website ScreenShot Fail<br />"+url();
			reportStep2(a, "FAIL");
		}
		
	}
	
}
