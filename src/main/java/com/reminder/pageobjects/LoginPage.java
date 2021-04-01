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

public class LoginPage {
	private WebDriver driver;
	// public AppiumDriver<MobileElement> driver;
	private WaitTypes applyWait;
	private ExtentTest test;
	private Actions action;

	public LoginPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.applyWait = new WaitTypes(driver);
		this.test = test;
		action = new Actions(driver);
	}

	@FindBy(xpath = "//android.widget.ImageView[@content-desc='Get Started']")
	private WebElement getStarted_Button;

	@FindBy(xpath = "//android.widget.EditText[@text='Username']")
	private WebElement emailID_TextBox;

	@FindBy(xpath = "//android.widget.EditText[@text='Password']")
	private WebElement password_TextBox;

	@FindBy(xpath = "//android.widget.ImageView[@content-desc='Login']")
	private WebElement signIn_Button;

	@FindBy(xpath = "//android.view.View[@content-desc='Register Here']")
	private WebElement registerHere_Button;

	@FindBy(xpath = "//android.view.View[@content-desc='Login']")
	private WebElement login_Heading;

	public void click_GetStartedButton() throws IOException {
		applyWait.waitForElementToBeClickable(getStarted_Button, 30).click();
		Screenshots.takeScreenshot(driver, "User clicked get started button");
		test.log(Status.INFO, "User clicked get started button");
	}

	public void enterEmail(String inputEmailID) throws IOException {
		applyWait.waitForElementToBeClickable(emailID_TextBox, 30).click();
		emailID_TextBox.clear();
		action.sendKeys(inputEmailID).build().perform();
		Screenshots.takeScreenshot(driver, "User entered email as " + inputEmailID);
		test.log(Status.INFO, "User entered email as " + inputEmailID);
	}

	public void enterPassword(String inputPassword) throws IOException {
		applyWait.waitForElementToBeClickable(password_TextBox, 30).click();
		action.sendKeys(inputPassword).build().perform();
		Screenshots.takeScreenshot(driver, "User entered password as " + inputPassword);
		test.log(Status.INFO, "User entered password as " + inputPassword);
	}

	public void clickSignInButton() throws IOException {
		driver.navigate().back();
		applyWait.waitForElementToBeClickable(signIn_Button, 60).click();
		Screenshots.takeScreenshot(driver, "User clicked sign in button");
		test.log(Status.INFO, "User clicked sign button after entering credentials");
	}

	public void click_RegisterHereButton() throws IOException {
		applyWait.waitForElementToBeClickable(registerHere_Button, 30).click();
		Screenshots.takeScreenshot(driver, "User clicked register here button");
		test.log(Status.INFO, "User clicked register here button");
	}

	public void verify_LoginHeading() throws IOException {
		applyWait.waitForElementToBeClickable(login_Heading, 30);
		if (login_Heading.isDisplayed()) {
			System.out.println("User logged out successfully");
		}
		Screenshots.takeScreenshot(driver, "User clicked register here button");
		test.log(Status.INFO, "User clicked register here button");
	}
}
