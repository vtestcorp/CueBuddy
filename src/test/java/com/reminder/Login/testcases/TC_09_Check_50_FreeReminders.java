package com.reminder.Login.testcases;

import org.testng.annotations.Test;

import com.reminder.pageobjects.DashboardPage;
import com.reminder.pageobjects.LoginPage;
import com.reminder.pageobjects.ReminderPage;

import base.BaseClass;

import org.testng.annotations.Test;
import config.DefineConstants;
import helperMethods.JsonUtils;
import helperMethods.ScrollTypes;
import junit.framework.Assert;

public class TC_09_Check_50_FreeReminders extends BaseClass {
	
	
	LoginPage loginPage;
	DashboardPage dashboardPage;
	ReminderPage reminderPage;
	ScrollTypes scorll;

	@Test(enabled = true)
	public void createReminder() throws Exception {

		test = extent.createTest("TC_09_Check_50_FreeReminders", "User able to create upto 50 free Reminders");

		loginPage = new LoginPage(driver, test);
		dashboardPage = new DashboardPage(driver, test);
		reminderPage = new ReminderPage(driver, test);
		scorll=new ScrollTypes(driver);
		
		
		loginPage.click_GetStartedButton();
		loginPage.enterEmail(JsonUtils.getData(DefineConstants.TC_09_Check_50_FreeReminders, "Email"));
		loginPage.enterPassword(JsonUtils.getData(DefineConstants.TC_09_Check_50_FreeReminders, "Passoword"));
		loginPage.clickSignInButton();
		
		for(int i=0;i<13;i++)
		{
		//char ch=(char) i;
		String strName = JsonUtils.getData(DefineConstants.TC_09_Check_50_FreeReminders, "Name")+i;
		System.out.println(strName);
		dashboardPage.click_PlusButton();

		
		//reminderPage.click_FirstDateAnniversaryRadioButton();
		reminderPage.click_MarriageAnniversaryRadioButton();
		reminderPage.click_NextButton();
		reminderPage.enter_Name(strName);
		reminderPage.click_date_textBox();
//		reminderPage.click_Date(JsonUtils.getData(DefineConstants.TC_01_Create_Reminder, "Date"),
//								JsonUtils.getData(DefineConstants.TC_01_Create_Reminder, "Month"),
//								JsonUtils.getData(DefineConstants.TC_01_Create_Reminder, "Year"));

		
		reminderPage.click_OkDateButton();
		reminderPage.enter_Age(JsonUtils.getData(DefineConstants.TC_09_Check_50_FreeReminders, "Age"));
		reminderPage.enter_Description(JsonUtils.getData(DefineConstants.TC_09_Check_50_FreeReminders, "Description"));		 
		reminderPage.select_Gender(JsonUtils.getData(DefineConstants.TC_09_Check_50_FreeReminders, "Gender"));
		reminderPage.select_Relation(JsonUtils.getData(DefineConstants.TC_09_Check_50_FreeReminders, "Relation"));
		
		scorll.scrollToEnd();
		reminderPage.click_NextButtonDetailsInfo();
		reminderPage.click_OnDayOfOccasion();
		reminderPage.click_OneDayBeforeOccasion();
		reminderPage.click_OneWeekBeforeOccasion();
		reminderPage.click_OneMonthBeforeOccasion();
		//scorll.scrollToEnd();
		reminderPage.click_custom();
		
		reminderPage.select_ReminderType();
		reminderPage.click_SaveButton();
		reminderPage.click_OKButton();
		
		//Assert.assertTrue(mobileElement.getAttribute("content-desc").contains(name+nameEdited));
		
		}//End of for loop
		
	}
}
