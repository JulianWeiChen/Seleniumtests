package au.com.vclass.testservice;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import au.com.vclass.init.InitAndFunction;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class PenThicknessService {
	
	public void penThickness(WebDriver driver, ExtentReports logger, InitAndFunction i) throws InterruptedException {
		Thread.sleep(2000);

		logger.startTest("Pen thickness Tests Start");
		// Test pen thickness 1
		try {
			driver.findElement(By.id("normalPenToggle")).click();
			logger.log(LogStatus.INFO, "Chose pen toggle(pen Thickness 1)");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL,
					"failed to choose pen toggle(pen Thickness 1) "
							+ i.failIcon);
		}

		Thread.sleep(2000);
		try {
			driver.findElement(By.id("normalPenThickness1")).click();
			logger.log(LogStatus.INFO, "Chose pen Thickness 1");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "failed to choose pen Thickness 1 "
					+ i.failIcon);
		}

		Thread.sleep(2000);
		try {
			i.draw(driver, 40, 40, 100, 100);
			logger.log(LogStatus.PASS, "Pass pen Thickness 1 tests "
					+ i.successIcon);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "failed to draw with pen Thickness 1 "
					+ i.failIcon);
		}

		// Test pen thickness 2
		Thread.sleep(2000);
		try {
			driver.findElement(By.id("normalPenToggle")).click();
			logger.log(LogStatus.INFO, "Chose pen toggle(pen Thickness 2)");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL,
					"failed to choose pen toggle(pen Thickness 2) "
							+ i.failIcon);
		}
		Thread.sleep(2000);
		try {
			driver.findElement(By.id("normalPenThickness2")).click();
			logger.log(LogStatus.INFO, "Chose pen Thickness 2");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "failed to choose pen Thickness 2 "
					+ i.failIcon);
		}
		Thread.sleep(2000);
		try {
			i.draw(driver, 40, 40, 40, 100);
			logger.log(LogStatus.PASS, "Pass pen Thickness 2 tests "
					+ i.successIcon);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "failed to draw with pen Thickness 2 "
					+ i.failIcon);
		}

		// Test pen thickness 3
		Thread.sleep(2000);
		try {
			driver.findElement(By.id("normalPenToggle")).click();
			logger.log(LogStatus.INFO, "Chose pen toggle(pen Thickness 3)");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL,
					"failed to choose pen toggle(pen Thickness 3) "
							+ i.failIcon);
		}
		Thread.sleep(2000);
		try {
			driver.findElement(By.id("normalPenThickness3")).click();
			logger.log(LogStatus.INFO, "Chose pen Thickness 3");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "failed to choose pen Thickness 3 "
					+ i.failIcon);
		}
		Thread.sleep(2000);
		try {
			i.draw(driver, 40, 100, 100, 100);
			logger.log(LogStatus.PASS, "Pass pen Thickness 3 tests "
					+ i.successIcon);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "failed to draw with pen Thickness 3 "
					+ i.failIcon);
		}

		// Test pen thickness 4
		Thread.sleep(2000);
		try {
			driver.findElement(By.id("normalPenToggle")).click();
			logger.log(LogStatus.INFO, "Chose pen toggle(pen Thickness 4)");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL,
					"failed to choose pen toggle(pen Thickness 4) "
							+ i.failIcon);
		}
		Thread.sleep(2000);
		try {
			driver.findElement(By.id("normalPenThickness4")).click();
			logger.log(LogStatus.INFO, "Chose pen Thickness 4");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "failed to choose pen Thickness 4 "
					+ i.failIcon);
		}
		Thread.sleep(2000);
		try {
			i.draw(driver, 40, 100, 100, 100);
			logger.log(LogStatus.PASS, "Pass pen Thickness 4 tests "
					+ i.successIcon);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "failed to draw with pen Thickness 4 "
					+ i.failIcon);
		}

		logger.endTest();

	}

}
