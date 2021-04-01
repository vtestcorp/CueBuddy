package com.reminder.pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import helperMethods.Screenshots;
import helperMethods.WaitTypes;

public class Forgot_Password {
	private WebDriver driver;
	private WaitTypes applyWait;
	private ExtentTest test;
	private Actions action;

	public Forgot_Password(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.applyWait = new WaitTypes(driver);
		this.test = test;
		action = new Actions(driver);
	}

	@FindBy(xpath = "//android.view.View[@content-desc='Forgot Password?']")
	private WebElement forgotPassword;
	
	//@FindBy(xpath = "//android.widget.EditText[@content-desc='Username']")
		//android.widget.EditText[@index="4"]
	
	@FindBy(xpath = "//android.widget.EditText[@index='4']")
	private WebElement userNameTextbox;
	
	@FindBy(xpath =	"//android.widget.ImageView[@content-desc='Send']")
	private WebElement sendButton;
	
	
	
	public void clickOnForgotPassword() throws IOException
	{
		applyWait.waitForElementToBeClickable(forgotPassword, 30).click();
		Screenshots.takeScreenshot(driver, "User clicked on Forgot Password link");
		test.log(Status.INFO, "User clicked on Forgot Password link");
	}
	
	
	public void clickOnSendButton() throws IOException
	{
		applyWait.waitForElementToBeClickable(sendButton, 30).click();
		Screenshots.takeScreenshot(driver, "User clicked on send button");
		test.log(Status.INFO, "User clicked on send button");
	}
	
	
	
	public void enterUsername(String inputEmailID) throws IOException {
		applyWait.waitForElementToBeClickable(userNameTextbox, 30).click();
		userNameTextbox.clear();
		action.sendKeys(inputEmailID).build().perform();
		Screenshots.takeScreenshot(driver, "User entered email as " + inputEmailID);
		test.log(Status.INFO, "User entered email as " + inputEmailID);
	}
	
	
}
