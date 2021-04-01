package com.reminder.pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import helperMethods.Screenshots;
import helperMethods.WaitTypes;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class DashboardPage {
	private WebDriver driver;
//	public AppiumDriver<MobileElement> driver;
	private WaitTypes applyWait;
	private ExtentTest test;
    private Actions action;
    
	public DashboardPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.applyWait = new WaitTypes(driver);
		this.test = test;
		action= new Actions(driver);				
	}

	@FindBy(xpath = "//android.widget.Button[@index='5']")
	private WebElement plus_Button;
	
	@FindBy(xpath = "//android.widget.ImageView[@index='0']")
	private WebElement leftPane_Button;
		     	
	public void click_PlusButton() throws IOException {
		applyWait.waitForElementToBeClickable(plus_Button, 60).click();		
		Screenshots.takeScreenshot(driver, "User clicked Plus button");		
		test.log(Status.INFO, "User clicked Plus button");
	}
	

	
	public void verify_PlusButton() throws IOException {
		applyWait.waitForElementToBeClickable(plus_Button, 60);
		if (plus_Button.isEnabled()||plus_Button.isDisplayed()) {
			Assert.assertTrue(true);
			System.out.println("User login Successfully");
			Screenshots.takeScreenshot(driver, "Plus button is displayed, Test Case is Passed");
			test.log(Status.INFO, "Plus button is displayed, Test Case is Passed");
		} else {
			Assert.assertTrue(false);
			Screenshots.takeScreenshot(driver, "Plus button is not displayed");
			test.log(Status.INFO, "Plus button is not displayed");
		}
	}
	
	public void click_LeftPaneButton() throws IOException {
		applyWait.waitForElementToBeClickable(leftPane_Button, 60).click();		
		Screenshots.takeScreenshot(driver, "User clicked left pane button");		
		test.log(Status.INFO, "User clicked left pane button");
	}
	
	public void verify_PlusButton_For_Change_Password(String oldPassword,String newPassword) throws IOException  {
		applyWait.waitForElementToBeClickable(plus_Button, 60);
		if (plus_Button.isDisplayed()) {
			Assert.assertTrue(true);
			System.out.println("User change password Successfully and Login with new Password"+"\n Old Password :"+oldPassword+"\n New Password :"+newPassword);
			Screenshots.takeScreenshot(driver, "User change password Successfully and Login with new Password");
			test.log(Status.INFO, "User change password Successfully and Login with new Password"+"\n Old Password :"+oldPassword+"\n New Password :"+newPassword);
		} else {
			Assert.assertTrue(false);
			Screenshots.takeScreenshot(driver, "Plus button is not displayed");
			test.log(Status.INFO, "Plus button is not displayed");
		}
	}
	
		
}
