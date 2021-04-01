package com.reminder.Login.testcases;

import org.testng.annotations.Test;

import com.reminder.pageobjects.DashboardPage;
import com.reminder.pageobjects.LoginPage;
import com.reminder.pageobjects.ReminderPage;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;
import helperMethods.ScrollTypes;

public class TC_06_Delete_Reminder extends BaseClass{
	
	LoginPage loginPage;
	DashboardPage dashboardPage;
	ReminderPage reminderPage;
	ScrollTypes scorll;

	@Test(enabled = true)
	public void deleteReminder() throws Exception {

		test = extent.createTest("TC_06_Delete_Reminder", "Delete Reminder");

		loginPage = new LoginPage(driver, test);
		dashboardPage = new DashboardPage(driver, test);
		reminderPage = new ReminderPage(driver, test);
		scorll=new ScrollTypes(driver);

		loginPage.click_GetStartedButton();
		loginPage.enterEmail(JsonUtils.getData(DefineConstants.TC_06_Delete_Reminder, "Email"));
		loginPage.enterPassword(JsonUtils.getData(DefineConstants.TC_06_Delete_Reminder, "Password"));
		loginPage.clickSignInButton();
		
		//Create Reminder
		dashboardPage.click_PlusButton();
		reminderPage.click_FirstDateAnniversaryRadioButton();
		reminderPage.click_NextButton();
		reminderPage.enter_Name(JsonUtils.getData(DefineConstants.TC_06_Delete_Reminder, "Name"));
		reminderPage.click_Date(JsonUtils.getData(DefineConstants.TC_06_Delete_Reminder, "Date"),
								JsonUtils.getData(DefineConstants.TC_06_Delete_Reminder, "Month"),
								JsonUtils.getData(DefineConstants.TC_06_Delete_Reminder, "Year"));
		reminderPage.click_OkDateButton();
		reminderPage.enter_Age(JsonUtils.getData(DefineConstants.TC_06_Delete_Reminder, "Age"));
		reminderPage.enter_Description(JsonUtils.getData(DefineConstants.TC_06_Delete_Reminder, "Description"));		 
		reminderPage.select_Gender(JsonUtils.getData(DefineConstants.TC_06_Delete_Reminder, "Gender"));
		reminderPage.select_Relation(JsonUtils.getData(DefineConstants.TC_06_Delete_Reminder, "Relation"));
		scorll.scrollToEnd();
		reminderPage.click_NextButtonDetailsInfo();
		reminderPage.click_OnDayOfOccasion();
		reminderPage.select_ReminderType();
		reminderPage.click_SaveButton();
		reminderPage.click_OKButton();		
		
		//Delete Reminder
		reminderPage.enter_Name_In_SearchBox(JsonUtils.getData(DefineConstants.TC_06_Delete_Reminder, "Event Name"));
		reminderPage.getcoordinate(JsonUtils.getData(DefineConstants.TC_06_Delete_Reminder, "Name"));
		reminderPage.dragndrop();
		
		reminderPage.click_DeleteButton();
		reminderPage.click_DeleteAlert_Button();
		reminderPage.click_DeleteSuccessOk_Button();
		
	}

}
