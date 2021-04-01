package com.reminder.pageobjects;

import static org.testng.Assert.assertEquals;

import java.awt.Robot;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.google.common.base.Verify;

import config.DefineConstants;
import helperMethods.JsonUtils;
import helperMethods.Keyboard;
import helperMethods.Screenshots;
import helperMethods.WaitTypes;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import junit.framework.Assert;

public class ReminderPageSupriya {
	private AppiumDriver driver;
//	public AppiumDriver<MobileElement> driver;
	private WaitTypes applyWait;
	private ExtentTest test;
    private Actions action;
    private TouchAction act;
    
    
	public ReminderPageSupriya(AppiumDriver driver, ExtentTest test) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.applyWait = new WaitTypes(driver);
		this.test = test;
		action= new Actions(driver);	
		act=new TouchAction(driver);

	}

	// Occasions
	@FindBy(xpath = "//android.view.View[@content-desc='Propose Day Anniversary']")
	private WebElement proposeDay_RadioButton;
	
	@FindBy(xpath = "//android.view.View[@content-desc='Home Anniversary']")
	private WebElement home_RadioButton;
	
	@FindBy(xpath = "//android.view.View[@content-desc='Marriage Anniversary']")
	private WebElement marriage_Anniversary_RadioButton;
	
	@FindBy(xpath = "//android.view.View[@content-desc='First Date Anniversary']")
	private WebElement firstDateAnniversary_RadioButton;
	
	@FindBy(xpath = "//android.widget.ImageView[@content-desc='Next']")
	private static WebElement next_Button;
		     	
	public static WebElement getNext_Button() {
		return next_Button;
	}

	public void setNext_Button(WebElement next_Button) {
		this.next_Button = next_Button;
	}

	// Details Info	
	@FindBy(xpath = "//android.widget.ImageView[@index='0']/android.widget.ScrollView/android.widget.EditText[1]")
	private WebElement name_Textbox;
	
	@FindBy(xpath = "//android.widget.EditText[@text='Age']")
	private WebElement age_Textbox;
	
	@FindBy(xpath = "//android.widget.ImageView[@index='0']/android.widget.ScrollView/android.view.View[1]")
	private WebElement date_Textbox;
	
	@FindBy(xpath = "//android.widget.Button[@content-desc='OK']")
	private WebElement okButtonAddReminder;
	
//	@FindBy(xpath = "//android.widget.SeekBar[@bounds='[165,863][390,1189]']")
//	private WebElement date_Day;
	
//	@FindBy(xpath = "//android.widget.SeekBar[@index='2']")
//	private WebElement date_Month;
	
//	@FindBy(xpath = "//android.widget.SeekBar[@index='3']")
//	private WebElement date_Year;
	
	@FindBy(xpath = "	\n"
			+ "//android.widget.ImageView[@index='0']/android.widget.ScrollView/android.widget.EditText[3]")
	private WebElement description_Textbox;
	
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]")
	private WebElement searchBox;
	
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText")
	private WebElement enterNameInsearchBox;
	
	@FindBy(xpath = "//android.widget.ImageView[@content-desc='Next']")
	private WebElement next_ButtonDetailslInfo;
	
	// Remind me
	@FindBy(xpath = "//android.view.View[@content-desc='On the day of Occasion']/android.view.View")
	private WebElement onDayOfOccasion;
	
	@FindBy(xpath = "//android.view.View[@content-desc='1 Day Before the Occasion']")
	private WebElement oneDayBeforeOccasion;
	
	@FindBy(xpath = "//android.view.View[@content-desc='1 Week Before the Occasion']")
	private WebElement oneWeekBeforeOccasion;
	
	@FindBy(xpath = "//android.view.View[@content-desc='1 Month before the Occasion']")
	private WebElement oneMonthBeforeOccasion;
	
	@FindBy(xpath = "//android.view.View[@content-desc='Custom']")
	private WebElement custom;
	
	@FindBy(xpath = "//android.view.View[@content-desc='Repeat Yearly']/android.widget.RadioButton")
	private WebElement repeatYearly;
	
	@FindBy(xpath = "//android.widget.ImageView[@content-desc='Save']")
	private WebElement saveButton;
	
//	@FindBy(xpath = "//android.view.View[@content-desc='success Reminder Created successfully. Ok']")
	@FindBy(xpath = "//android.view.View[@bounds='[105,866][975,1231]']")
	private WebElement okButton;
	
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.widget.ImageView[2]")
	private WebElement deleteButton;
	
	@FindBy(xpath = "//android.widget.ImageView[@content-desc='Delete']")
	private WebElement deleteAlertButton;
	
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.widget.ImageView[1]")
	private WebElement editButton;
	
	@FindBy(xpath = "//android.widget.ImageView[@content-desc='Alert Your free reminder are not sufficient. Please upgrade your subscription plan. Ok']")
	private WebElement alertButton;
	//android.view.View[@content-desc="Alert Your free reminder are not sufficient. Please upgrade your subscription plan. Ok"]
	
	
	public void clickonAlertButton() throws IOException
	{
		String getAlertmsg = alertButton.getText();
		String expected = JsonUtils.getData(DefineConstants.TC_09_Check_50_FreeReminders, "Message");
		//assert.assertEquals(actualStr, getAlertmsg);
		Assert.assertEquals(expected, getAlertmsg);
		
		//applyWait.waitForElementToBeClickable(proposeDay_RadioButton, 60).click();		
		Screenshots.takeScreenshot(driver, "User clicked on Alert button");		
		test.log(Status.INFO, "User clicked propose day button");
	}
	
	// Occasions
	public void click_ProposeDayRadioButton() throws IOException {
		applyWait.waitForElementToBeClickable(proposeDay_RadioButton, 60).click();		
		Screenshots.takeScreenshot(driver, "User clicked propose day button");		
		test.log(Status.INFO, "User clicked propose day button");
	}
	
	public void click_MarriageAnniversaryRadioButton() throws IOException {
		applyWait.waitForElementToBeClickable(marriage_Anniversary_RadioButton, 60).click();		
		Screenshots.takeScreenshot(driver, "User clicked Marriage Anniversary button");		
		test.log(Status.INFO, "User clicked Marriage Anniversary button");
	}
	
	public void click_FirstDateAnniversaryRadioButton() throws IOException {
		applyWait.waitForElementToBeClickable(firstDateAnniversary_RadioButton, 60).click();		
		Screenshots.takeScreenshot(driver, "User clicked first date anniversary radio button");		
		test.log(Status.INFO, "User clicked first date anniversary radio button");
	}
	
	public void click_NextButton() throws IOException {
		applyWait.waitForElementToBeClickable(next_Button, 60).click();		
		Screenshots.takeScreenshot(driver, "User clicked next button");		
		test.log(Status.INFO, "User clicked next button");
	}
	
	// Details Info
	
	public void enter_Name(String input_Name)throws IOException {
		applyWait.waitForElementToBeClickable(name_Textbox, 60).clear();
		name_Textbox.click();
		action.sendKeys(input_Name).build().perform();
		Screenshots.takeScreenshot(driver, "User entered name as "+ input_Name);
		test.log(Status.INFO, "User entered name as "+ input_Name);
		driver.navigate().back();
	}
	
	public void click_date_textBox()
	{
		applyWait.waitForElementToBeClickable(date_Textbox, 60).click();
	}
	
	
	
	public void click_Date(String date,String month,String year) throws InterruptedException {
		
		applyWait.waitForElementToBeClickable(date_Textbox, 60).click();
		MobileElement seekBar = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.SeekBar\").index(1)"));
		MobileElement seekBarM = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.SeekBar\").index(2)"));
		MobileElement seekBarY = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.SeekBar\").index(3)"));
		Thread.sleep(3000);
		
		int num=Integer.parseInt(date);
		int yr=Integer.parseInt(year);
		
		//For Date
		if (Integer.parseInt(seekBar.getAttribute("content-desc")) >= num) {
		while (!seekBar.getAttribute("content-desc").equals(date)) {  //swap above
			System.err.println(seekBar.getAttribute("content-desc"));
			int start = seekBar.getLocation().getY();
			System.out.println("Startpoint - " + start);
			// get location of seekbar from top
			int y = seekBar.getLocation().getX();
			System.out.println("Yaxis - " + y);
			// Get total width of seekbar
			int end = seekBar.getSize().getHeight();
			System.out.println("End point - " + end);
			act.press(PointOption.point(y + 100, start + 20))
			.moveTo(PointOption.point(y + 20, (end / 3) + start - 3)).release().perform();
		}
		}else {
			while (!seekBar.getAttribute("content-desc").equals(date)) {  // swap below
				System.err.println(seekBar.getAttribute("content-desc"));
				int start = seekBar.getLocation().getY();
				System.out.println("Startpoint - " + start);
				// get location of seekbar from top
				int y = seekBar.getLocation().getX();
				System.out.println("Yaxis - " + y);
				// Get total width of seekbar
				int end = seekBar.getSize().getHeight();
				System.out.println("End point - " + end);
				act.press(PointOption.point(y + 20, (end / 3) + start - 3))
				.moveTo(PointOption.point(y + 100, start + 20)).release().perform();
			}	
		}
		//For Month
		while (!seekBarM.getAttribute("content-desc").equals(month)) {
			System.err.println(seekBarM.getAttribute("content-desc"));
			int start = seekBarM.getLocation().getY();
			System.out.println("Startpoint - " + start);
			// get location of seekBarM from top
			int y = seekBarM.getLocation().getX();
			System.out.println("Yaxis - " + y);
			// Get total width of seekBarM
			int end = seekBarM.getSize().getHeight();
			System.out.println("End point - " + end);
			act.press(PointOption.point(y + 100, start + 20))
			.moveTo(PointOption.point(y + 20, (end / 3) + start - 3)).release().perform();
		}
		//For Year
		if (Integer.parseInt(seekBar.getAttribute("content-desc")) >= yr) {
		while (!seekBarM.getAttribute("content-desc").equals(year)) {
			System.err.println(seekBarM.getAttribute("content-desc"));
			int start = seekBarM.getLocation().getY();
			System.out.println("Startpoint - " + start);
			// get location of seekBarM from top
			int y = seekBarM.getLocation().getX();
			System.out.println("Yaxis - " + y);
			// Get total width of seekBarM
			int end = seekBarM.getSize().getHeight();
			System.out.println("End point - " + end);
			act.press(PointOption.point(y + 100, start + 20))
			.moveTo(PointOption.point(y + 20, (end / 3) + start - 3)).release().perform();
		}
		}else {
			while (!seekBarY.getAttribute("content-desc").equals(year)) {
				System.err.println(seekBarY.getAttribute("content-desc"));
				int start = seekBarY.getLocation().getY();
				System.out.println("Startpoint - " + start);
				// get location of seekBarY from top
				int y = seekBarY.getLocation().getX();
				System.out.println("Yaxis - " + y);
				// Get total width of seekBarY
				int end = seekBarY.getSize().getHeight();
				System.out.println("End point - " + end);
				act.press(PointOption.point(y + 20, (end / 3) + start - 3))
				.moveTo(PointOption.point(y + 100, start + 20)).release().perform();
		}
			
		}	
	}
	
	public void enter_Age(String input_Name)throws IOException {
		applyWait.waitForElementToBeClickable(age_Textbox, 60);
		age_Textbox.click();
		action.sendKeys(input_Name).build().perform();
		Screenshots.takeScreenshot(driver, "User entered age as "+ input_Name);
		test.log(Status.INFO, "User entered age as "+ input_Name);
		driver.navigate().back();
	}
	
	public void click_OkDateButton() throws Exception {
		applyWait.waitForElementToBeClickable(okButtonAddReminder, 30).click();
		Screenshots.takeScreenshot(driver, "User clicked Ok button");
		test.log(Status.INFO, "User clicked OK button");
	
	}
	
	
	public void enter_Description(String input_Description)throws IOException {
		applyWait.waitForElementToBeClickable(description_Textbox, 60).click();
		action.sendKeys(input_Description).build().perform();
		Screenshots.takeScreenshot(driver, "User entered description as "+ input_Description);
		test.log(Status.INFO, "User entered description as "+ input_Description);
		driver.navigate().back();
	}
	
	public void select_Gender(String input_Gender) throws IOException {
		WebElement gender = driver.findElement(By.xpath("//android.view.View[@content-desc='"+input_Gender+"']"));
		applyWait.waitForElementToBeClickable(gender, 30).click();		
		Screenshots.takeScreenshot(driver, "User selcted gender as "+input_Gender);		
		test.log(Status.INFO, "User selcted gender as "+input_Gender);		
	}
	
	public void select_Relation(String input_Relation) throws IOException {
		WebElement relation = driver.findElement(By.xpath("//android.view.View[@content-desc='"+input_Relation+"']"));
		applyWait.waitForElementToBeClickable(relation, 30).click();		
		Screenshots.takeScreenshot(driver, "User selcted relation as "+input_Relation);		
		test.log(Status.INFO, "User selcted relation as "+input_Relation);		
	}
	
	public void click_NextButtonDetailsInfo() throws IOException {
		applyWait.waitForElementToBeClickable(next_ButtonDetailslInfo, 60).click();		
		Screenshots.takeScreenshot(driver, "User clicked next button on details info page");		
		test.log(Status.INFO, "User clicked next button on details info page");
	}
	
	// Remind me
	public void click_OnDayOfOccasion() throws IOException {
		applyWait.waitForElementToBeClickable(onDayOfOccasion, 60).click();		
		Screenshots.takeScreenshot(driver, "User selected  on day of occasion");		
		test.log(Status.INFO, "User selected  on day of occasion");
	}
	
	public void click_OneDayBeforeOccasion() throws IOException {
		applyWait.waitForElementToBeClickable(oneDayBeforeOccasion, 60).click();		
		Screenshots.takeScreenshot(driver, "User selected one day before of occasion");		
		test.log(Status.INFO, "User selected  on day of occasion");
	}
	
	public void click_OneWeekBeforeOccasion() throws IOException {
		applyWait.waitForElementToBeClickable(oneWeekBeforeOccasion, 60).click();		
		Screenshots.takeScreenshot(driver, "User selected  on day of occasion");		
		test.log(Status.INFO, "User selected  on day of occasion");
	}
	
	public void click_OneMonthBeforeOccasion() throws IOException {
		applyWait.waitForElementToBeClickable(oneMonthBeforeOccasion, 60).click();		
		Screenshots.takeScreenshot(driver, "User selected  on day of occasion");		
		test.log(Status.INFO, "User selected  on day of occasion");
	}
	
	public void click_custom() throws IOException {
		applyWait.waitForElementToBeClickable(custom, 60).click();		
		Screenshots.takeScreenshot(driver, "User selected  on day of occasion");		
		test.log(Status.INFO, "User selected  on day of occasion");
	}
	
	public void select_ReminderType() throws IOException {		
		applyWait.waitForElementToBeClickable(repeatYearly, 60).click();		
		Screenshots.takeScreenshot(driver, "User selcted reminder type as repeat yearly");		
		test.log(Status.INFO, "User selcted reminder type as repeat yearly");		
	}
	
	public void click_SaveButton() throws IOException {
		applyWait.waitForElementToBeClickable(saveButton, 60).click();		
		Screenshots.takeScreenshot(driver, "User clicked save button on Remind me page");		
		test.log(Status.INFO, "User clicked save button on Remind me page");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void click_OKButton() throws IOException, InterruptedException {
		Thread.sleep(3000);
	//	act.tap(PointOption.point(360, 715)).perform();
		act.tap(PointOption.point(530, 1250)).perform();
		//applyWait.waitForElementToBeClickable(okButton, 30).click();
	//	driver.navigate().back();
		Screenshots.takeScreenshot(driver, "User clicked ok button after filling all details");		
		test.log(Status.INFO, "User clicked ok button after filling all details");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void dragndrop() throws Exception {
		Thread.sleep(5000);
		System.out.println("Drag Start");
		act.longPress(PointOption.point(middleX, middleY))
		.moveTo(PointOption.point(leftX, middleY)).release().perform();
		System.out.println("Drop Stop");
		Screenshots.takeScreenshot(driver, "User drag event from left to right");
		test.log(Status.INFO, "User drag event from left to right");
		
	}
	
	public void click_DeleteButton() throws Exception {
		applyWait.waitForElementToBeClickable(deleteButton, 30).click();
		Screenshots.takeScreenshot(driver, "User clicked Dalete button");
		test.log(Status.INFO, "User clicked Dalete button");
	}
	
	public void click_DeleteAlert_Button() throws Exception {
		applyWait.waitForElementToBeClickable(deleteAlertButton, 30).click();
		Screenshots.takeScreenshot(driver, "User clicked Delete Alert Box button");
		test.log(Status.INFO, "User clicked Delete Alert Box button");
	}
	
	public void click_DeleteSuccessOk_Button() throws Exception {
		//applyWait.waitForElementToBeClickable(deleteAlertButton, 30).click();
		act.tap(PointOption.point(360, 715)).perform();
		Screenshots.takeScreenshot(driver, "User clicked Reminder Deleted Successfilly OK button");
		test.log(Status.INFO, "User clicked Reminder Deleted Successfilly OK button");
	}
	
	public void enter_Name_In_SearchBox(String input_Name)throws IOException {
		applyWait.waitForElementToBeClickable(searchBox, 60).click();
		applyWait.waitForElementToBeClickable(enterNameInsearchBox, 60).click();
		action.sendKeys(input_Name).build().perform();
		Screenshots.takeScreenshot(driver, "User entered "+ input_Name+" in searchbox");
		test.log(Status.INFO, "User entered "+ input_Name+" in searchbox");
		driver.navigate().back();
	}
	
	public void click_Edit_Button() throws Exception {
		applyWait.waitForElementToBeClickable(editButton, 60).click();
		Screenshots.takeScreenshot(driver, "User clicked Delete Alert Box button");
		test.log(Status.INFO, "User clicked Delete Alert Box button");
	}
	
	public int middleX;
	public int middleY;
	 int leftX;
	WebElement mobileElement;
	
	public void getcoordinate(String name) throws InterruptedException {
		System.out.println("1");
		Thread.sleep(9000);
		
		WebElement s=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View"));
		
		int count=1;
		List<MobileElement> e=s.findElements(By.xpath("//android.view.View[@index='0']"));
		//System.out.println(e.getAttribute("content-desc"));
		System.out.println("Size is "+e.size());
		for (MobileElement mobileElement : e) {
			if (mobileElement.getAttribute("content-desc") != null) {
				
			
			  if (mobileElement.getAttribute("content-desc").contains(name)) {
			
				  System.out.println(count);
			  System.out.println("Sushil"); 
			  
			   leftX = mobileElement.getLocation().getX();
			  int rightX = leftX + mobileElement.getSize().getWidth();
			  middleX = (rightX + leftX) / 2;
			  int upperY = mobileElement.getLocation().getY();
			  int lowerY = upperY + mobileElement.getSize().getHeight();
			  middleY = (upperY + lowerY) / 2;
			  System.out.println(leftX);
			  System.out.println(rightX);
			  System.out.println(middleX);
			  System.out.println(middleY);
			  System.out.println(upperY);
			  System.out.println(lowerY);
			  }
			}  
			count++; 
		}
	}

	
	public void verifyName(String name, String nameEdited) throws InterruptedException {
		
		Thread.sleep(9000);
		WebElement s=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View"));
	
		int count=1;
		List<MobileElement> e=s.findElements(By.xpath("//android.view.View[@index='0']"));
		//System.out.println(e.getAttribute("content-desc"));
		System.out.println("Size is "+e.size());
		for (MobileElement mobileElement : e) {
			if (mobileElement.getAttribute("content-desc") != null) {
				boolean b=mobileElement.getAttribute("content-desc").contains(name+nameEdited);
				System.out.println(b);
			//	Assert.assertTrue(mobileElement.getAttribute("content-desc").contains(name+nameEdited));
				try {
					System.out.println(name+nameEdited + " is verified");
					Screenshots.takeScreenshot(driver, name+" is varified");
					test.log(Status.INFO, name+" is varified");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				
			}
		}
	}
	
	public void verifyMultipleReminder() throws IOException, InterruptedException {
		Thread.sleep(9000);
	
		Boolean onDay= onDayOfOccasion.isSelected();
		Boolean oneDayBefore= oneDayBeforeOccasion.isSelected();
		Boolean oneWeekBefore= oneWeekBeforeOccasion.isSelected();
		Screenshots.takeScreenshot(driver, "All checkboxes is varified");
		System.out.println(onDay);
		//Assert.assertTrue(onDay);
	//	Assert.assertTrue(oneDayBefore);
	//	Assert.assertTrue(oneWeekBefore);
		System.out.println("On the day of occasion checkbox is verified : "+onDay);
		System.out.println("1 day Before the occasion checkbox is verified : "+oneDayBefore);
		System.out.println("1 week Before the occasion checkbox is verified : "+oneWeekBefore);
	
		test.log(Status.INFO, "On the day of occasion checkbox is verified : "+onDay);
		test.log(Status.INFO, "1 day Before the occasion checkbox is verified : "+oneDayBefore);
		test.log(Status.INFO, "1 week Before the occasion checkbox is verified : "+oneWeekBefore);	
	}
	
}
