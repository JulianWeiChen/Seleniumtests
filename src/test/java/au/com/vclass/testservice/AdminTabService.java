package au.com.vclass.testservice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import au.com.vclass.constants.TestConstants;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class AdminTabService {
	public static void AdminTab(WebDriver driver, ExtentReports logger) throws InterruptedException {
		WebElement element;
		Thread.sleep(2000);
		logger.startTest("Admin Tests Start");
		// Navigate to admin tab
		try {
			driver.findElement(By.id("adminTabButton")).click();
			logger.log(LogStatus.INFO, "Click admin tab button");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Failed to click admin tab button"
					+ TestConstants.FAIL_ICON);
		}
		try {
			element = driver
					.findElement(By
							.xpath("//div[@id = 'adminTab' and @class = 'tab-pane active']"));
			logger.log(LogStatus.PASS, "Navigate to admin tab successfully"
					+ TestConstants.SUCCESS_ICON);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Navigate to admin tab unsuccessfuly"
					+ TestConstants.FAIL_ICON);
		}
	}
}
