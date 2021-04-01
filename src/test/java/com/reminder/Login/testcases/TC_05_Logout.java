package com.reminder.Login.testcases;

import org.testng.annotations.Test;

import com.reminder.pageobjects.DashboardPage;
import com.reminder.pageobjects.LoginPage;
import com.reminder.pageobjects.ReminderPage;
import com.reminder.pageobjects.UpdateProfile;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;

public class TC_05_Logout extends BaseClass {

	LoginPage loginPage;
	DashboardPage dashboardPage;
	UpdateProfile updateProfile;

	@Test(enabled = true)
	public void loginWithValidCredentials() throws Exception {

		test = extent.createTest("TC_02_Login_With_Valid_Credentials", "User should be able to login with valid credentials");

		loginPage = new LoginPage(driver, test);
		dashboardPage = new DashboardPage(driver, test);
		updateProfile = new UpdateProfile(driver, test);
		
		loginPage.click_GetStartedButton();
		loginPage.enterEmail(JsonUtils.getData(DefineConstants.TC_05_Logout, "Email"));
		loginPage.enterPassword(JsonUtils.getData(DefineConstants.TC_05_Logout, "Password"));
		loginPage.clickSignInButton();
		dashboardPage.verify_PlusButton();
		dashboardPage.click_LeftPaneButton();
		updateProfile.click_Logout_Button();
		updateProfile.click_LogoutYes_Button();
		loginPage.verify_LoginHeading();
	}
}