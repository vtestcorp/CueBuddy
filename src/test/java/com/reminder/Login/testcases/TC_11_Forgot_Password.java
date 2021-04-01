package com.reminder.Login.testcases;

import org.testng.annotations.Test;

import com.reminder.pageobjects.Forgot_Password;
import com.reminder.pageobjects.LoginPage;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;

public class TC_11_Forgot_Password extends BaseClass{
	LoginPage loginPage;
	Forgot_Password forgotPassword;
	
	@Test(enabled = true)
	public void ForgotPassword() throws Exception 
	{
		test = extent.createTest("TC_11_ForgotPassword", "User should able to click on forgot password ");

		loginPage = new LoginPage(driver, test);
		loginPage.click_GetStartedButton();
		
		forgotPassword = new Forgot_Password(driver, test);
		forgotPassword.clickOnForgotPassword();
		forgotPassword.enterUsername((JsonUtils.getData(DefineConstants.TC_11_ForgotPassword, "Email")));
		forgotPassword.clickOnSendButton();
	}
}
