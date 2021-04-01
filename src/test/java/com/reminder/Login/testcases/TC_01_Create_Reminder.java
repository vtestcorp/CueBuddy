package com.reminder.Login.testcases;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.reminder.pageobjects.DashboardPage;
import com.reminder.pageobjects.LoginPage;
import com.reminder.pageobjects.ReminderPage;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JavascriptClick;
import helperMethods.JsonUtils;
import helperMethods.ScrollTypes;

public class TC_01_Create_Reminder extends BaseClass {

	LoginPage loginPage;
	DashboardPage dashboardPage;
	ReminderPage reminderPage;
	ScrollTypes scorll;
	

	@Test(enabled = true)
	public void createReminder() throws Exception {

		test = extent.createTest("TC_01_Create_Teminder", "Create Reminder by Login");

		loginPage = new LoginPage(driver, test);
		dashboardPage = new DashboardPage(driver, test);
		reminderPage = new ReminderPage(driver, test);
		scorll=new ScrollTypes(driver);
	

		loginPage.click_GetStartedButton();
		loginPage.enterEmail(JsonUtils.getData(DefineConstants.TC_01_Create_Reminder, "Email"));
		loginPage.enterPassword(JsonUtils.getData(DefineConstants.TC_01_Create_Reminder, "Password"));
		loginPage.clickSignInButton();
		dashboardPage.click_PlusButton();
		// reminderPage.click_ProposeDayRadioButton();
		reminderPage.click_FirstDateAnniversaryRadioButton();
		reminderPage.click_NextButton();
		reminderPage.enter_Name(JsonUtils.getData(DefineConstants.TC_01_Create_Reminder, "Name"));
		reminderPage.click_Date(JsonUtils.getData(DefineConstants.TC_01_Create_Reminder, "Date"),
								JsonUtils.getData(DefineConstants.TC_01_Create_Reminder, "Month"),
								JsonUtils.getData(DefineConstants.TC_01_Create_Reminder, "Year"));
		reminderPage.click_OkDateButton();
		reminderPage.enter_Age(JsonUtils.getData(DefineConstants.TC_01_Create_Reminder, "Age"));
		reminderPage.enter_Description(JsonUtils.getData(DefineConstants.TC_01_Create_Reminder, "Description"));		 
		reminderPage.select_Gender(JsonUtils.getData(DefineConstants.TC_01_Create_Reminder, "Gender"));
		reminderPage.select_Relation(JsonUtils.getData(DefineConstants.TC_01_Create_Reminder, "Relation"));
		scorll.scrollToEnd();
		reminderPage.click_NextButtonDetailsInfo();
		reminderPage.click_OnDayOfOccasion();
		reminderPage.select_ReminderType();
		reminderPage.click_SaveButton();
		reminderPage.click_OKButton();
		
		reminderPage.enter_Name_In_SearchBox(JsonUtils.getData(DefineConstants.TC_01_Create_Reminder, "Event Name"));
		reminderPage.verifyOccasionName(JsonUtils.getData(DefineConstants.TC_01_Create_Reminder, "Name"));
	}
}