package config;

public class DefineConstants {
	// Test data file Path
	public static final String Path_TestData = "";

	// Application URL
	public static final String URL = "http://p5app.p5email.com/";

//	 http://p5beta.plumb5.com/p5-newdesign/manage-campaigns.html
	
	// Explicit Wait Time
	public static final int explicitWait_10 = 10;
	
	public static final int explicitWait_20 = 20;
	
	public static final int explicitWait_30 = 30;

	public static final int explicitWait_60 = 60;

	public static final String PROJECT_PATH = System.getProperty("user.dir");

	public static final String PROJECT_OS = System.getProperty("os.name");
	
	public static final String browser = "android";

	public static final String TestData_Folder = "Test_Data";

		
	public static final String Reminder_TestData_Folder = "Reminder";

	public static final String There_is_no_data_for_this_view = "There is no data for this view";
	
	// Desired Capabilities
	
	public static final String Desired_Capabilities = TestData_Folder + "//" + Reminder_TestData_Folder + "//" + "DesiredCapabilities.json";
	
	// Reminder Module Json file
	public static final String TC_01_Create_Reminder = TestData_Folder + "//" + Reminder_TestData_Folder + "//" + "TC_01_Create_Reminder.json";
	public static final String TC_02_Login_With_Valid_Credentials = TestData_Folder + "//" + Reminder_TestData_Folder + "//"+ "TC_02_Login_With_Valid_Credentials.json";
	public static final String TC_03_Sign_Up = TestData_Folder + "//" + Reminder_TestData_Folder + "//"+ "TC_03_Sign_Up.json";
	public static final String TC_04_Change_Password = TestData_Folder + "//" + Reminder_TestData_Folder + "//"+ "TC_04_Change_Password.json";
	public static final String TC_05_Logout = TestData_Folder + "//" + Reminder_TestData_Folder + "//"+ "TC_05_Logout.json";
	public static final String TC_06_Delete_Reminder = TestData_Folder + "//" + Reminder_TestData_Folder + "//" + "TC_06_Delete_Reminder.json";
	public static final String TC_07_Edit_Reminder = TestData_Folder + "//" + Reminder_TestData_Folder + "//" + "TC_07_Edit_Reminder.json";
	public static final String TC_08_Multiple_Reminder = TestData_Folder + "//" + Reminder_TestData_Folder + "//" + "TC_08_Multiple_Reminder.json";
	public static final String TC_09_Check_50_FreeReminders = TestData_Folder + "//" + Reminder_TestData_Folder + "//" + "TC_09_Check_50_FreeReminders.json";
	public static final String TC_10_Search_Reminder = TestData_Folder + "//" + Reminder_TestData_Folder + "//" + "TC_10_Search_Reminder.json";
	public static final String TC_11_ForgotPassword = TestData_Folder + "//" + Reminder_TestData_Folder + "//" + "TC_10_Search_Reminder.json";
			
}