package com.reminder.Login.testcases;

import org.testng.annotations.Test;

import com.reminder.pageobjects.DashboardPage;
import com.reminder.pageobjects.LoginPage;
import com.reminder.pageobjects.ReminderPage;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;

public class TC_02_Login_With_Valid_Credentials extends BaseClass {

	LoginPage loginPage;
	DashboardPage dashboardPage;

	@Test(enabled = true)
	public void loginWithValidCredentials() throws Exception {

		test = extent.createTest("TC_02_Login_With_Valid_Credentials", "User should be able to login with valid credentials");

		loginPage = new LoginPage(driver, test);
		dashboardPage = new DashboardPage(driver, test);
		
		loginPage.click_GetStartedButton();
		loginPage.enterEmail(JsonUtils.getData(DefineConstants.TC_02_Login_With_Valid_Credentials, "Email"));
		loginPage.enterPassword(JsonUtils.getData(DefineConstants.TC_02_Login_With_Valid_Credentials, "Passoword"));
		loginPage.clickSignInButton();
		dashboardPage.verify_PlusButton();
	}
}