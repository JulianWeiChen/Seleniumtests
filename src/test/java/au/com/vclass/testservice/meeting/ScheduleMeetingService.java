package au.com.vclass.testservice.meeting;

import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import au.com.vclass.constants.TestConstants;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class ScheduleMeetingService {
	public static void ScheduleMeeting(WebDriver driver, ExtentReports logger)
			throws InterruptedException {

		Thread.sleep(2000);
		// Click Schedule a meeting link
		try {
			driver.findElement(By.linkText("Schedule a meeting")).click();
			logger.log(LogStatus.INFO, "Click Schedule a meeting link");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL,
					"Failed to click Schedule a meeting link "
							+ TestConstants.FAIL_ICON + TestConstants.FAIL_ICON
							+ "\n" + e.getMessage());
		}

		Thread.sleep(2000);
		// Input meeting information
		try {
			driver.findElement(By.id("meetingNameInput")).sendKeys("AutoTestMeeting");
			String mDate = Calendar.DAY_OF_MONTH + "/" + Calendar.MONTH + "/" + Calendar.YEAR; 
			driver.findElement(By.id("meetingStartDateInput")).sendKeys(mDate);
			driver.findElement(By.id(""));
			
			
			
			logger.log(LogStatus.PASS, "Successfully eraser a line"
					+ TestConstants.SUCCESS_ICON);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Failed to eraser a line");
		}

		// Clear Page
		Thread.sleep(2000);
		try {
			driver.findElement(By.id("eraserModelToggle")).click();
			driver.findElement(By.id("eraserAll")).click();
			logger.log(LogStatus.PASS, "Successfully clear the page");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Failed to clear the page"
					+ TestConstants.FAIL_ICON);
		}

		logger.endTest();
	}
}
