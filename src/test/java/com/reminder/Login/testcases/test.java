package com.reminder.Login.testcases;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.reminder.pageobjects.DashboardPage;
import com.reminder.pageobjects.LoginPage;
import com.reminder.pageobjects.ReminderPage;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;
import helperMethods.ScrollTypes;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class test extends BaseClass{
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
		
		loginPage.click_GetStartedButton();
		loginPage.enterEmail(JsonUtils.getData(DefineConstants.TC_08_Multiple_Reminder, "Email"));
		loginPage.enterPassword(JsonUtils.getData(DefineConstants.TC_08_Multiple_Reminder, "Passoword"));
		loginPage.clickSignInButton();
		Thread.sleep(9000);
		/*List<MobileElement> s=driver.findElements(By.className("android.view.View"));
		Iterator itr=s.iterator();
	
		  while (itr.hasNext()) { Object object = (Object) itr.next();
		  System.out.println(object);
		  
		  }
		
		System.out.println(s.size());
		for (MobileElement object : s) {
			System.out.println(object.getText());
		}
		///hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[4]/android.view.View/android.view.View[1]
		
		 *
		 */
	
		System.out.println("1");
		WebElement s=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[2]/android.view.View"));
		int count=1;
		List<MobileElement> e=s.findElements(By.xpath("//android.view.View[@index='0']"));
		//System.out.println(e.getAttribute("content-desc"));
		System.out.println(e.size());
		for (MobileElement mobileElement : e) {
			if (mobileElement.getAttribute("content-desc") != null) {
				
			
			  if (mobileElement.getAttribute("content-desc").contains("Sushil")) {
				  System.out.println(count);
			  System.out.println("Sushil"); 
			  int leftX = mobileElement.getLocation().getX();
			  int rightX = leftX + mobileElement.getSize().getWidth();
			  int middleX = (rightX + leftX) / 2;
			  int upperY = mobileElement.getLocation().getY();
			  int lowerY = upperY + mobileElement.getSize().getHeight();
			  int middleY = (upperY + lowerY) / 2;
			  System.out.println(leftX);
			  System.out.println(rightX);
			  System.out.println(middleX);
			  System.out.println(middleY);
			  System.out.println(upperY);
			  System.out.println(lowerY);
			  }
			}  
			count++; 
		//	System.out.println(mobileElement.getAttribute("content-desc"));
		}
		}
	
}


