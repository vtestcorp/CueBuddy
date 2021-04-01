package com.reminder.Login.testcases;

import java.util.Random;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.reminder.pageobjects.DashboardPage;
import com.reminder.pageobjects.LoginPage;
import com.reminder.pageobjects.RegisterPage;
import com.reminder.pageobjects.ReminderPage;
import com.reminder.pageobjects.UpdateProfile;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;

public class TC_04_Change_Password extends BaseClass {

	LoginPage loginPage;
	DashboardPage dashboardPage;
	UpdateProfile updateProfile;
	RegisterPage registerPage;
	
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
		JsonUtils.setData("Full Name", generatedString, DefineConstants.TC_04_Change_Password);
		JsonUtils.setData("Email", generatedString + "@gmail.com", DefineConstants.TC_04_Change_Password);
		JsonUtils.setData("Password", generatedString+"@123", DefineConstants.TC_04_Change_Password);
	}
	
	@Test(enabled = true)
	public void changePassword() throws Exception {

		test = extent.createTest("TC_04_Change_Password", "User should be able to login and change password");

		loginPage = new LoginPage(driver, test);
		dashboardPage = new DashboardPage(driver, test);
		updateProfile= new UpdateProfile(driver, test);
		registerPage = new RegisterPage(driver, test);
		
		//Register Here
		loginPage.click_GetStartedButton();
		loginPage.click_RegisterHereButton();
		registerPage.enter_FullName(JsonUtils.getData(DefineConstants.TC_04_Change_Password, "Full Name"));
		registerPage.enter_Email(JsonUtils.getData(DefineConstants.TC_04_Change_Password, "Email"));
		registerPage.enterPassword(JsonUtils.getData(DefineConstants.TC_04_Change_Password, "Password"));
		registerPage.click_RegisterButton();
		updateProfile.click_BirthdayDate(JsonUtils.getData(DefineConstants.TC_04_Change_Password, "Date"),
										JsonUtils.getData(DefineConstants.TC_04_Change_Password, "Month"),
										JsonUtils.getData(DefineConstants.TC_04_Change_Password, "Year"));
		updateProfile.click_OkDateButton();
		updateProfile.select_CountryDropdown(JsonUtils.getData(DefineConstants.TC_04_Change_Password, "Country"));
		updateProfile.enter_DefaultOcassion_Update_Profile();
		updateProfile.click_SaveButton();	
		updateProfile.click_HamburgerMenu();
		updateProfile.click_Logout_Button();
		updateProfile.click_LogoutYes_Button();
		
		//Change Password
		loginPage.enterEmail(JsonUtils.getData(DefineConstants.TC_04_Change_Password, "Email"));
		loginPage.enterPassword(JsonUtils.getData(DefineConstants.TC_04_Change_Password, "Password"));
		loginPage.clickSignInButton();
		dashboardPage.click_LeftPaneButton();
		updateProfile.click_ChangePassword_Button();
		updateProfile.enter_CurrentPassword(JsonUtils.getData(DefineConstants.TC_04_Change_Password, "Password"));
		updateProfile.enter_NewPassword(JsonUtils.getData(DefineConstants.TC_04_Change_Password, "New Password"));
		updateProfile.reEnter_NewPassword(JsonUtils.getData(DefineConstants.TC_04_Change_Password, "New Password"));
		updateProfile.click_SaveButton();
		updateProfile.click_OKButton();
		//updateProfile.verify_PasswordUpdatedText(JsonUtils.getData(DefineConstants.TC_04_Change_Password, "Message"));
		updateProfile.click_Logout_Button();
		updateProfile.click_LogoutYes_Button();
		
		//Verify with new Password
		loginPage.enterEmail(JsonUtils.getData(DefineConstants.TC_04_Change_Password, "Email"));
		loginPage.enterPassword(JsonUtils.getData(DefineConstants.TC_04_Change_Password, "New Password"));
		loginPage.clickSignInButton();
		dashboardPage.verify_PlusButton_For_Change_Password(JsonUtils.getData(DefineConstants.TC_04_Change_Password, "Password"),
															JsonUtils.getData(DefineConstants.TC_04_Change_Password, "New Password"));
	}
}