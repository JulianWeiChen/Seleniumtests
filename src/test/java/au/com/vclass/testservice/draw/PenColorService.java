package au.com.vclass.testservice.draw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import au.com.vclass.constants.TestConstants;
import au.com.vclass.util.DrawUtil;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class PenColorService {

	public static void PenColor(WebDriver driver, ExtentReports logger)
			throws InterruptedException {

		Thread.sleep(2000);

		// Choose Highlight Pen Thickness1 Toggle and Draw
		try {
			driver.findElement(By.id("highLightPenToggle")).click();
			driver.findElement(By.id("highLightPenThickness1")).click();
			logger.log(LogStatus.INFO, "Chose highlight pen thickness1 toggle");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL,
					"Failed to choose highlight pen thickness1 toggle"
							+ TestConstants.FAIL_ICON);
		}

		try {
			DrawUtil.draw(driver, 140, 200, 250, 250);
			logger.log(LogStatus.PASS,
					"Successfully chose highlight pen thickness1 to draw a line"
							+ TestConstants.SUCCESS_ICON);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL,
					"Failed to draw with highlight pen thickness1");
		}

		// Choose Highlight Pen Thickness2 Toggle and Draw
		Thread.sleep(2000);
		try {
			driver.findElement(By.id("highLightPenToggle")).click();
			driver.findElement(By.id("highLightPenThickness2")).click();
			logger.log(LogStatus.INFO, "Chose highlight pen thickness2 toggle");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL,
					"Failed to choose highlight pen thickness2 toggle"
							+ TestConstants.FAIL_ICON);
		}

		try {
			DrawUtil.draw(driver, 300, 200, 200, 200);
			logger.log(LogStatus.PASS,
					"Successfully chose highlight pen thickness2 to draw a line"
							+ TestConstants.SUCCESS_ICON);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL,
					"Failed to draw with highlight pen thickness2");
		}

		// Choose Red Color Picker and Draw
		Thread.sleep(2000);
		try {
			driver.findElement(By.id("highLightPenToggle")).click();
			driver.findElement(
					By.xpath("//div[contains(@class, 'colorPicker-picker') and contains(@style, 'background-color: rgb(0, 0, 0)')]"))
					.click();
			logger.log(LogStatus.INFO, "Chose color picker");

		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Failed to choose color picker" + e.getLocalizedMessage()
					+ TestConstants.FAIL_ICON);
		}

		Thread.sleep(2000);
		try {
			//driver.findElement(By.xpath("//div[contains(@class, 'colorPicker-swatch highLightColorPicker-swatch') and contains(@style, 'border-color: rgb(89, 143, 239)) and contains(@style, 'background-color: rgb(255, 0, 0)')]")).click();
			driver.findElement(By.xpath("//*[@id='colorPicker_palette-2']/div[13]")).click();
			logger.log(LogStatus.INFO, "Chose pen color RED");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Failed to choose pen color RED" + e.getMessage()
					+ TestConstants.FAIL_ICON);
		}

		Thread.sleep(2000);
		try {
			DrawUtil.draw(driver, 40, 100, 100, 100);
			logger.log(LogStatus.PASS,
					"Successfully chose red pen to draw a line"
							+ TestConstants.SUCCESS_ICON);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Failed to draw with red pen");
		}

	}

}
