package com.reminder.Login.testcases;

import org.testng.annotations.Test;

import com.reminder.pageobjects.DashboardPage;
import com.reminder.pageobjects.LoginPage;
import com.reminder.pageobjects.ReminderPage;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;
import helperMethods.ScrollTypes;

public class TC_08_Multiple_Reminder extends BaseClass {
	LoginPage loginPage;
	DashboardPage dashboardPage;
	ReminderPage reminderPage;
	ScrollTypes scorll;


	@Test(enabled = true)
	public void createReminder() throws Exception {

		test = extent.createTest("TC_08_Multiple_Reminder", "User able to Add multiple Reminder");

		loginPage = new LoginPage(driver, test);
		dashboardPage = new DashboardPage(driver, test);
		reminderPage = new ReminderPage(driver, test);
		scorll=new ScrollTypes(driver);
		
		//Create Reminder
		loginPage.click_GetStartedButton();
		loginPage.enterEmail(JsonUtils.getData(DefineConstants.TC_08_Multiple_Reminder, "Email"));
		loginPage.enterPassword(JsonUtils.getData(DefineConstants.TC_08_Multiple_Reminder, "Password"));
		loginPage.clickSignInButton();
	/*	dashboardPage.click_PlusButton();
		reminderPage.click_MarriageAnniversaryRadioButton();
		reminderPage.click_NextButton();
		reminderPage.enter_Name(JsonUtils.getData(DefineConstants.TC_08_Multiple_Reminder, "Name"));
		reminderPage.click_Date(JsonUtils.getData(DefineConstants.TC_08_Multiple_Reminder, "Date"),
								JsonUtils.getData(DefineConstants.TC_08_Multiple_Reminder, "Month"),
								JsonUtils.getData(DefineConstants.TC_08_Multiple_Reminder, "Year"));
		reminderPage.click_OkDateButton();
		reminderPage.enter_Age(JsonUtils.getData(DefineConstants.TC_08_Multiple_Reminder, "Age"));
		reminderPage.enter_Description(JsonUtils.getData(DefineConstants.TC_08_Multiple_Reminder, "Description"));		 
		reminderPage.select_Gender(JsonUtils.getData(DefineConstants.TC_08_Multiple_Reminder, "Gender"));
		reminderPage.select_Relation(JsonUtils.getData(DefineConstants.TC_08_Multiple_Reminder, "Relation"));
		scorll.scrollToEnd();
		reminderPage.click_NextButtonDetailsInfo();
		reminderPage.click_OnDayOfOccasion();
		reminderPage.click_OneDayBeforeOccasion();
		reminderPage.click_OneWeekBeforeOccasion();
		reminderPage.select_ReminderType();
		reminderPage.click_SaveButton();
		reminderPage.click_OKButton();
	*/	
		//Check multiple reminders selected or not 
		reminderPage.enter_Name_In_SearchBox(JsonUtils.getData(DefineConstants.TC_08_Multiple_Reminder, "Event Name"));
		reminderPage.getcoordinate(JsonUtils.getData(DefineConstants.TC_08_Multiple_Reminder, "Name"));
		reminderPage.dragndrop();
		reminderPage.click_Edit_Button();
		reminderPage.click_NextButton();
		scorll.scrollToEnd();
		reminderPage.click_NextButtonDetailsInfo();
		reminderPage.verifyMultipleReminder();
		
		
		
	}
}
