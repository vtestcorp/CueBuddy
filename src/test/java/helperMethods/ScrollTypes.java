package helperMethods;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class ScrollTypes {

	WebDriver driver;
	static TouchAction action;

	public ScrollTypes(WebDriver driver) {
		this.driver = driver;
		action = new TouchAction((PerformsTouchActions) driver);
	}

	public void scrollDown() throws AWTException {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}

	public void scrollUp() throws AWTException {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight);");
	}

	public void scrollByParameter(int x, int y) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(" + x + "," + y + ")");
	}

	public void scrollInToView(WebElement element) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public boolean verifyScroller() {
		String execScript = "return document.documentElement.scrollHeight>document.documentElement.clientHeight;";
		JavascriptExecutor scrollBarPresent = (JavascriptExecutor) driver;
		Boolean test = (Boolean) (scrollBarPresent.executeScript(execScript));
		return test;
	}
	
	public static void scrollToEnd() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		action.press(PointOption.point(115, 750)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(100))).moveTo(PointOption.point(115, 50)).release().perform();
	}
	
	/*
	 * public void scrollTo2(String text) { System.out.
	 * println("Scrolling to the Element which has the given text property : " +
	 * text); ((Object) driver).findElementByAndroidUIAutomator(
	 * "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
	 * + text + "\").instance(0))"); }
	 */
}