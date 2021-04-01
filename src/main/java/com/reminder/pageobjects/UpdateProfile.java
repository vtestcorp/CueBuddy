package com.reminder.pageobjects;

import java.awt.Point;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.android.uiautomator.core.UiSelector;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.sun.xml.fastinfoset.util.StringArray;

import config.DefineConstants;
import helperMethods.JsonUtils;
import helperMethods.Screenshots;
import helperMethods.WaitTypes;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.offset.PointOption;

public class UpdateProfile {
	private AppiumDriver driver;
//	public AppiumDriver<MobileElement> driver;
	private WaitTypes applyWait;
	private ExtentTest test;
	private Actions action;
	private TouchAction act;

	public UpdateProfile(AppiumDriver driver, ExtentTest test) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.applyWait = new WaitTypes(driver);
		this.test = test;
		action = new Actions(driver);
		act = new TouchAction(driver);
	}

	

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]")
	private WebElement birthdayDate;

	@FindBy(xpath = "//android.widget.Button[@content-desc='OK']")
	private WebElement okButton;

	// @FindBy(xpath = "//android.widget.Button[@content-desc='Select
	// country']")
	@FindBy(xpath = "//android.widget.Button[@index='8']")
	private WebElement country_Dropdown;

	@FindBy(xpath = "//android.view.View[@index='2']")
	private WebElement countryIndia_Dropdown;

	@FindBy(xpath = "//android.view.View[@index='3']")
	private WebElement countryCanada_Dropdown;
	
	@FindBy(xpath = "//android.view.View[@content-desc='Default Ocassion']")
	private WebElement defaultOcasion;
	
	@FindBy(xpath = "//android.widget.CheckBox[@content-desc='Diwali']")
	private WebElement deewaliOcasion;

	@FindBy(xpath = "//android.widget.ImageView[@content-desc='Save']")
	private WebElement save_Button;
	
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[1]")
	private WebElement hamburger_Button;
	
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View")
	private WebElement actualName;

	@FindBy(xpath = "//android.view.View[@content-desc='Change Password']")
	private WebElement changePassword_Button;

	@FindBy(xpath = "//android.widget.EditText[@text='Your Current Password']")
	private WebElement currentPassword_Textbox;

	@FindBy(xpath = "//android.widget.EditText[@text='Enter New Password']")
	private WebElement newPassword_Textbox;

	@FindBy(xpath = "//android.widget.EditText[@text='Re-enter Password']")
	private WebElement reEnternewPassword_Textbox;

	@FindBy(xpath = "//android.view.View[@index='0']")
	private WebElement passwordSuccessfull_Text;

	@FindBy(xpath = "//android.view.View[@content-desc='Logout']")
	private WebElement logout_Button;

	@FindBy(xpath = "//android.widget.ImageView[@content-desc='Yes']")
	private WebElement logout_YesButton;
	
	public void click_BirthdayDate(String date,String month,String year) throws InterruptedException {
	
		applyWait.waitForElementToBeClickable(birthdayDate, 60).click();
		MobileElement seekBar = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.SeekBar\").index(1)"));
		MobileElement seekBarM = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.SeekBar\").index(2)"));
		MobileElement seekBarY = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.SeekBar\").index(3)"));
		Thread.sleep(3000);
		
		while (!seekBar.getAttribute("content-desc").equals(date)) {
			System.err.println(seekBar.getAttribute("content-desc"));
			int start = seekBar.getLocation().getY();
			System.out.println("Startpoint - " + start);
			// get location of seekbar from top
			int y = seekBar.getLocation().getX();
			System.out.println("Yaxis - " + y);
			// Get total width of seekbar
			int end = seekBar.getSize().getHeight();
			System.out.println("End point - " + end);
			act.press(PointOption.point(y + 100, start + 20))
			.moveTo(PointOption.point(y + 20, (end / 3) + start - 3)).release().perform();
		}
		
		while (!seekBarM.getAttribute("content-desc").equals(month)) {
			System.err.println(seekBarM.getAttribute("content-desc"));
			int start = seekBarM.getLocation().getY();
			System.out.println("Startpoint - " + start);
			// get location of seekBarM from top
			int y = seekBarM.getLocation().getX();
			System.out.println("Yaxis - " + y);
			// Get total width of seekBarM
			int end = seekBarM.getSize().getHeight();
			System.out.println("End point - " + end);
			act.press(PointOption.point(y + 100, start + 20))
			.moveTo(PointOption.point(y + 20, (end / 3) + start - 3)).release().perform();
		}
		
		while (!seekBarY.getAttribute("content-desc").equals(year)) {
			System.err.println(seekBarY.getAttribute("content-desc"));
			int start = seekBarY.getLocation().getY();
			System.out.println("Startpoint - " + start);
			// get location of seekBarY from top
			int y = seekBarY.getLocation().getX();
			System.out.println("Yaxis - " + y);
			// Get total width of seekBarY
			int end = seekBarY.getSize().getHeight();
			System.out.println("End point - " + end);
			act.press(PointOption.point(y + 100, start + 20))
			.moveTo(PointOption.point(y + 20, (end / 3) + start - 3)).release().perform();
		}	
	}
	
	public void click_OkDateButton() throws Exception {
		applyWait.waitForElementToBeClickable(okButton, 30).click();
		Screenshots.takeScreenshot(driver, "User clicked Ok button");
		test.log(Status.INFO, "User clicked OK button");
		Thread.sleep(9000L);
	}

	public void select_CountryDropdown(String input_Country) throws IOException {
		System.out.println("select country");
		applyWait.waitForElementToBeClickable(country_Dropdown, 30).click();
		if (input_Country.equalsIgnoreCase("India")) {
			applyWait.waitForElementToBeClickable(countryIndia_Dropdown, 30).click();
			Screenshots.takeScreenshot(driver, "User selected country as " + input_Country);
			test.log(Status.INFO, "User selected country as " + input_Country);
		} else if (input_Country.equalsIgnoreCase("Canada")) {
			applyWait.waitForElementToBeClickable(countryCanada_Dropdown, 30).click();
			Screenshots.takeScreenshot(driver, "User selected country as " + input_Country);
			test.log(Status.INFO, "User selected country as " + input_Country);
		}
	}
	
	public void enter_DefaultOcassion_Update_Profile() throws Exception {
		applyWait.waitForElementToBeClickable(defaultOcasion, 60).click();
		applyWait.waitForElementToBeClickable(deewaliOcasion, 60).click();
		applyWait.waitForElementToBeClickable(okButton, 60).click();
		Screenshots.takeScreenshot(driver, "User enter Default Occasion");
		test.log(Status.INFO, "User enter Default Occasion");
		Thread.sleep(9000L);
	}

	public void click_SaveButton() throws Exception {
		applyWait.waitForElementToBeClickable(save_Button, 60).click();
		Screenshots.takeScreenshot(driver, "User clicked save button");
		test.log(Status.INFO, "User clicked save button");
		Thread.sleep(9000L);
	}
	
	public void click_HamburgerMenu() throws Exception {
		applyWait.waitForElementToBeClickable(hamburger_Button, 60).click();
		Screenshots.takeScreenshot(driver, "User clicked hamburger button");
		test.log(Status.INFO, "User clicked hamburger button");
		Thread.sleep(9000L);
	}
	
	public void verifyUsername(String inputEmail) {
		applyWait.waitforElementToBeDisplayed(actualName, 60);
		WebElement text=actualName.findElement(By.xpath("//android.widget.ImageView[@index='0']"));
		String actualText=text.getAttribute("content-desc");
		String[] ch=actualText.split("\n");
		Assert.assertEquals(inputEmail, ch[1]);
		try {
			System.out.println("Email " + inputEmail + " is verified");
			Screenshots.takeScreenshot(driver,"Email " + inputEmail + " is verified");
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.log(Status.INFO, "Email " + inputEmail + " is verified");
	}
	

	public void click_ChangePassword_Button() throws IOException {
		applyWait.waitForElementToBeClickable(changePassword_Button, 60).click();
		Screenshots.takeScreenshot(driver, "User clicked change password button");
		test.log(Status.INFO, "User clicked change password button");
	}

	public void enter_CurrentPassword(String input_CurrentPassword) throws IOException {
		applyWait.waitForElementToBeClickable(currentPassword_Textbox, 30).click();
		action.sendKeys(input_CurrentPassword).build().perform();
		Screenshots.takeScreenshot(driver, "User entered current password as " + input_CurrentPassword);
		test.log(Status.INFO, "User entered current password as " + input_CurrentPassword);
	}

	public void enter_NewPassword(String input_NewPassword) throws IOException {
		applyWait.waitForElementToBeClickable(newPassword_Textbox, 30).click();
		action.sendKeys(input_NewPassword).build().perform();
		Screenshots.takeScreenshot(driver, "User entered new password as " + input_NewPassword);
		test.log(Status.INFO, "User entered new password as " + input_NewPassword);
	}

	public void reEnter_NewPassword(String input_reEnter_NewPassword) throws IOException {
		applyWait.waitForElementToBeClickable(reEnternewPassword_Textbox, 30).click();
		action.sendKeys(input_reEnter_NewPassword).build().perform();
		Screenshots.takeScreenshot(driver, "User re entered new password as " + input_reEnter_NewPassword);
		test.log(Status.INFO, "User re entered new password as " + input_reEnter_NewPassword);
	}

	public void verify_PasswordUpdatedText(String message) throws IOException {
		applyWait.waitForElementToBeClickable(passwordSuccessfull_Text, 30);
		System.out.println("text " + passwordSuccessfull_Text.getText());
		if (passwordSuccessfull_Text.isEnabled() || passwordSuccessfull_Text.isDisplayed()) {
			Assert.assertTrue(true);
			Screenshots.takeScreenshot(driver, "Password updated text is " + message);
			test.log(Status.INFO, "Password updated text is " + message);
		} else {
			Assert.assertTrue(false);
			Screenshots.takeScreenshot(driver, "Password updated text is not displayed");
			test.log(Status.INFO, "Password updated text is not displayed");
		}
	}
	
	public void click_OKButton() throws IOException, InterruptedException {
		Thread.sleep(9000);
		act.tap(PointOption.point(360, 715)).perform();
		// applyWait.waitForElementToBeClickable(okButton, 30).click();
		// driver.navigate().back();
		Screenshots.takeScreenshot(driver, "User clicked ok button after filling all details");
		test.log(Status.INFO, "User clicked ok button after filling all details");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void click_Logout_Button() throws IOException {
		applyWait.waitForElementToBeClickable(logout_Button, 30).click();
		Screenshots.takeScreenshot(driver, "User clicked logout button");
		test.log(Status.INFO, "User clicked logout button");
	}

	public void click_LogoutYes_Button() throws IOException {
		applyWait.waitForElementToBeClickable(logout_YesButton, 30).click();
		Screenshots.takeScreenshot(driver, "User clicked logout yes button");
		test.log(Status.INFO, "User clicked logout yes button");
	}

}
