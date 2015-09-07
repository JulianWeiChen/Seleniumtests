package au.com.vclass.testservice.draw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import au.com.vclass.constants.TestConstants;
import au.com.vclass.util.DrawUtil;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class PenThicknessService {

	public static void PenThickness(WebDriver driver, ExtentReports logger)
			throws InterruptedException {
		Thread.sleep(2000);

		// Test pen thickness 1
		try {
			driver.findElement(By.id("normalPenToggle")).click();
			logger.log(LogStatus.INFO, "Chose pen toggle(pen Thickness 1)");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL,
					"failed to choose pen toggle(pen Thickness 1) "
							+ TestConstants.FAIL_ICON);
		}

		Thread.sleep(2000);
		try {
			driver.findElement(By.id("normalPenThickness1")).click();
			logger.log(LogStatus.INFO, "Chose pen Thickness 1");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "failed to choose pen Thickness 1 "
					+ TestConstants.FAIL_ICON);
		}

		Thread.sleep(2000);
		try {
			DrawUtil.draw(driver, 40, 40, 100, 100);
			logger.log(LogStatus.PASS, "Pass pen Thickness 1 tests "
					+ TestConstants.SUCCESS_ICON);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "failed to draw with pen Thickness 1 "
					+ TestConstants.FAIL_ICON);
		}

		// Test pen thickness 2
		Thread.sleep(2000);
		try {
			driver.findElement(By.id("normalPenToggle")).click();
			logger.log(LogStatus.INFO, "Chose pen toggle(pen Thickness 2)");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL,
					"failed to choose pen toggle(pen Thickness 2) "
							+ TestConstants.FAIL_ICON);
		}
		Thread.sleep(2000);
		try {
			driver.findElement(By.id("normalPenThickness2")).click();
			logger.log(LogStatus.INFO, "Chose pen Thickness 2");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "failed to choose pen Thickness 2 "
					+ TestConstants.FAIL_ICON);
		}
		Thread.sleep(2000);
		try {
			DrawUtil.draw(driver, 40, 40, 40, 100);
			logger.log(LogStatus.PASS, "Pass pen Thickness 2 tests "
					+ TestConstants.SUCCESS_ICON);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "failed to draw with pen Thickness 2 "
					+ TestConstants.FAIL_ICON);
		}

		// Test pen thickness 3
		Thread.sleep(2000);
		try {
			driver.findElement(By.id("normalPenToggle")).click();
			logger.log(LogStatus.INFO, "Chose pen toggle(pen Thickness 3)");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL,
					"failed to choose pen toggle(pen Thickness 3) "
							+ TestConstants.FAIL_ICON);
		}
		Thread.sleep(2000);
		try {
			driver.findElement(By.id("normalPenThickness3")).click();
			logger.log(LogStatus.INFO, "Chose pen Thickness 3");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "failed to choose pen Thickness 3 "
					+ TestConstants.FAIL_ICON);
		}
		Thread.sleep(2000);
		try {
			DrawUtil.draw(driver, 40, 100, 100, 100);
			logger.log(LogStatus.PASS, "Pass pen Thickness 3 tests "
					+ TestConstants.SUCCESS_ICON);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "failed to draw with pen Thickness 3 "
					+ TestConstants.FAIL_ICON);
		}

		// Test pen thickness 4
		Thread.sleep(2000);
		try {
			driver.findElement(By.id("normalPenToggle")).click();
			logger.log(LogStatus.INFO, "Chose pen toggle(pen Thickness 4)");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL,
					"failed to choose pen toggle(pen Thickness 4) "
							+ TestConstants.FAIL_ICON);
		}
		Thread.sleep(2000);
		try {
			driver.findElement(By.id("normalPenThickness4")).click();
			logger.log(LogStatus.INFO, "Chose pen Thickness 4");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "failed to choose pen Thickness 4 "
					+ TestConstants.FAIL_ICON);
		}
		Thread.sleep(2000);
		try {
			DrawUtil.draw(driver, 40, 100, 100, 100);
			logger.log(LogStatus.PASS, "Pass pen Thickness 4 tests "
					+ TestConstants.SUCCESS_ICON);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "failed to draw with pen Thickness 4 "
					+ TestConstants.FAIL_ICON);
		}
	}

}
