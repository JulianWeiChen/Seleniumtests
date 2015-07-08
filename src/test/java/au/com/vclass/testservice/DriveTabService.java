package au.com.vclass.testservice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import au.com.vclass.init.InitAndFunction;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class DriveTabService {
	public void driveTab(WebDriver driver, ExtentReports logger, InitAndFunction i) throws InterruptedException {
		WebElement element;
		Thread.sleep(2000);
		logger.startTest("Drive Tests Start");
		// Navigate to drive tab
		try {
			driver.findElement(By.id("driveTabButton")).click();
			logger.log(LogStatus.INFO, "Click drive tab button");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Failed to click drive tab button" + i.failIcon);
		}
		try {
			element = driver.findElement(By.xpath("//div[@id = 'driveTab' and @class = 'tab-pane active']"));
			logger.log(LogStatus.PASS, "Navigate to drive tab successfully" + i.successIcon);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Navigate to drive tab unsuccessfuly" + i.failIcon);
		}
	}
}
