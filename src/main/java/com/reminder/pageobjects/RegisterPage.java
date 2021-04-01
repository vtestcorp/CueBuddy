package com.reminder.pageobjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.google.inject.spi.Element;

import helperMethods.Screenshots;
import helperMethods.WaitTypes;
import io.appium.java_client.MobileBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class RegisterPage {
	private WebDriver driver;
//	public AppiumDriver<MobileElement> driver;
	private WaitTypes applyWait;
	private ExtentTest test;
	private Actions action;
    private TouchAction touchAction;
	
	public RegisterPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.applyWait = new WaitTypes(driver);
		this.test = test;
		action = new Actions(driver);
		touchAction = new TouchAction((PerformsTouchActions) driver);
	}

	@FindBy(xpath = "//android.widget.EditText[@text='Full name']")
	private WebElement fullName_Textbox;

	@FindBy(xpath = "//android.widget.EditText[@text='Email']")
	private WebElement email_TextBox;

	@FindBy(xpath = "//android.widget.EditText[@text='Password']")
	private WebElement password_TextBox;

//	@FindBy(xpath = "//android.widget.ImageView[@elementId='57066920-abda-42e1-8fba-2f2e3a9599cf']")
//	@FindBy(xpath = "//android.widget.ImageView[@resource-id='register_register_button']")
	@FindBy(xpath = "//android.widget.ImageView[@content-desc='Register']")
//	@FindBy(xpath = "//android.widget.ImageView[@bounds='[0,1154][1080,1302]']")
//	@FindBy(xpath = "//android.widget.ImageView[@index='8'][@content-desc='Register']")
//	@FindBy(xpath = "//android.widget.ImageView[@package='com.example.reminder_app']")
	private WebElement register_Button;

	public void enter_FullName(String input_FullName)  {
		applyWait.waitForElementToBeClickable(fullName_Textbox, 30).click();
//		driver.findElement(By.id("com.example.reminder_app:id/register_name_field")).sendKeys("abcd");
		action.sendKeys(input_FullName).build().perform();	
		try {
			Screenshots.takeScreenshot(driver, "User entered full name as " + input_FullName);
			test.log(Status.INFO, "User entered full name as " + input_FullName);
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void enter_Email(String input_Email) {
		applyWait.waitForElementToBeClickable(email_TextBox, 30).click();
		action.sendKeys(input_Email).build().perform();
		try {
			Screenshots.takeScreenshot(driver, "User entered email as " + input_Email);
			test.log(Status.INFO, "User entered email as " + input_Email);
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enterPassword(String inputPassword) throws IOException {
		applyWait.waitForElementToBeClickable(password_TextBox, 30).click();
		action.sendKeys(inputPassword).build().perform();
		driver.navigate().back();
		Screenshots.takeScreenshot(driver, "User entered password as " + inputPassword);
		test.log(Status.INFO, "User entered password as " + inputPassword);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void click_RegisterButton() throws Exception {		
	//	applyWait.waitForElementToBeClickable(register_Button, 30).click();
//		 By toursButtonBy = MobileBy.AccessibilityId(accessibilityId)
		
//		action.click().perform();
		Thread.sleep(9000L);
		 
        touchAction.tap(PointOption.point(550, 810)).perform();
//		touchAction.tap(TapOptions.tapOptions().withElement(element(register_Button)));
		
//		System.out.println("outtt "+register_Button.getText());
		Screenshots.takeScreenshot(driver, "User clicked register button");
		test.log(Status.INFO, "User clicked register button");
		Thread.sleep(3000);
	}
}
