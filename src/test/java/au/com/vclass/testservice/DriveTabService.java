package au.com.vclass.testservice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import au.com.vclass.constants.TestConstants;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class DriveTabService {
	public static void DriveTab(WebDriver driver, ExtentReports logger) throws InterruptedException {
		WebElement element;
		Thread.sleep(2000);
		logger.startTest("Drive Tests Start");
		// Navigate to drive tab
		try {
			driver.findElement(By.id("driveTabButton")).click();
			logger.log(LogStatus.INFO, "Click drive tab button");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Failed to click drive tab button" + TestConstants.FAIL_ICON);
		}
		try {
			element = driver.findElement(By.xpath("//div[@id = 'driveTab' and @class = 'tab-pane active']"));
			logger.log(LogStatus.PASS, "Navigate to drive tab successfully" + TestConstants.SUCCESS_ICON);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Navigate to drive tab unsuccessfuly" + TestConstants.FAIL_ICON);
		}
	}
}
