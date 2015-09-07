package au.com.vclass.testservice.draw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import au.com.vclass.constants.TestConstants;
import au.com.vclass.util.DrawUtil;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class EraserService {
	public static void Eraser(WebDriver driver, ExtentReports logger)
			throws InterruptedException {

		Thread.sleep(2000);

		// Eraser
		try {
			driver.findElement(By.id("eraserModelToggle")).click();
			driver.findElement(By.id("eraserStroke")).click();
			logger.log(LogStatus.INFO, "Chose eraser toggle");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL,
					"Failed to choose eraser toggle"
							+ TestConstants.FAIL_ICON);
		}

		Thread.sleep(2000);
		try {
			DrawUtil.draw(driver, 140, 200, 250, 250);
			logger.log(LogStatus.PASS,
					"Successfully eraser a line"
							+ TestConstants.SUCCESS_ICON);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL,
					"Failed to eraser a line");
		}
		
		// Clear Page
		Thread.sleep(2000);
		try {
			driver.findElement(By.id("eraserModelToggle")).click();
			driver.findElement(By.id("eraserAll")).click();
			logger.log(LogStatus.PASS, "Successfully clear the page");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL,
					"Failed to clear the page"
							+ TestConstants.FAIL_ICON);
		}

	}
}
