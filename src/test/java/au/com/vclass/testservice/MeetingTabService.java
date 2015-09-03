package au.com.vclass.testservice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import au.com.vclass.constants.TestConstants;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class MeetingTabService {

	public static void MeetingTab(WebDriver driver, ExtentReports logger)
			throws InterruptedException {

		WebElement element;
		Thread.sleep(2000);
		logger.startTest("Meeting Tests Start");
		// Navigate to meeting tab
		try {
			driver.findElement(By.id("meetingsTabButton")).click();
			logger.log(LogStatus.INFO, "Click meeting tab button");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Failed to click metting tab button"
					+ TestConstants.FAIL_ICON);
		}
		try {
			element = driver
					.findElement(By
							.xpath("//div[@id = 'meetingsOverlayTab' and @class = 'tab-pane active']"));
			logger.log(LogStatus.PASS, "Navigate to meeting tab successfully"
					+ TestConstants.SUCCESS_ICON);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Navigate to meeting tab unsuccessfuly"
					+ TestConstants.FAIL_ICON);
		}
	}
}
