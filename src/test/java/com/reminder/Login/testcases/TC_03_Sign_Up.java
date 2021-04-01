package com.reminder.Login.testcases;

import java.util.Random;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.android.uiautomator.core.UiSelector;
import com.reminder.pageobjects.DashboardPage;
import com.reminder.pageobjects.LoginPage;
import com.reminder.pageobjects.RegisterPage;
import com.reminder.pageobjects.ReminderPage;
import com.reminder.pageobjects.UpdateProfile;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;

public class TC_03_Sign_Up extends BaseClass {

	LoginPage loginPage;
	RegisterPage registerPage;
	UpdateProfile updateProfile;
	
	@BeforeMethod
	public static void randomStringGenerate() {
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 5;
		Random random = new Random();
		
		String generatedString = random.ints(leftLimit, rightLimit + 1).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, 
				StringBuilder::append).toString();   //String Generate
		
		System.out.println(generatedString);
		JsonUtils.setData("Full Name", generatedString, DefineConstants.TC_03_Sign_Up);
		JsonUtils.setData("Email", generatedString + "@gmail.com", DefineConstants.TC_03_Sign_Up);
		JsonUtils.setData("Password", generatedString+"@123", DefineConstants.TC_03_Sign_Up);
	}

	@Test(enabled = true)
	public void signUp() throws Exception {

		test = extent.createTest("TC_03_Sign_Up", "User should be able to sign up by filling all details");

		loginPage = new LoginPage(driver, test);		
		registerPage = new RegisterPage(driver, test);
		updateProfile = new UpdateProfile(driver, test);
	
		loginPage.click_GetStartedButton();
		loginPage.click_RegisterHereButton();
		registerPage.enter_FullName(JsonUtils.getData(DefineConstants.TC_03_Sign_Up, "Full Name"));
		registerPage.enter_Email(JsonUtils.getData(DefineConstants.TC_03_Sign_Up, "Email"));
		registerPage.enterPassword(JsonUtils.getData(DefineConstants.TC_03_Sign_Up, "Password"));
		registerPage.click_RegisterButton();
		updateProfile.click_BirthdayDate(JsonUtils.getData(DefineConstants.TC_03_Sign_Up, "Date"),
										JsonUtils.getData(DefineConstants.TC_03_Sign_Up, "Month"),
										JsonUtils.getData(DefineConstants.TC_03_Sign_Up, "Year"));
		updateProfile.click_OkDateButton();
		updateProfile.select_CountryDropdown(JsonUtils.getData(DefineConstants.TC_03_Sign_Up, "Country"));
		updateProfile.enter_DefaultOcassion_Update_Profile();
		updateProfile.click_SaveButton();	
		updateProfile.click_HamburgerMenu();
		updateProfile.verifyUsername(JsonUtils.getData(DefineConstants.TC_03_Sign_Up, "Email"));
	}
}