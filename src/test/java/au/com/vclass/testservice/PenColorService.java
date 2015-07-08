package au.com.vclass.testservice;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import au.com.vclass.init.InitAndFunction;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class PenColorService {

	public void penColor(WebDriver driver, ExtentReports logger,
			InitAndFunction i) throws InterruptedException {

		Thread.sleep(2000);

		logger.startTest("Pen color Test");
		try {
			driver.findElement(
					By.xpath("//div[contains(@class, 'colorPickerContainer') and @title='Pen Color']"))
					.click();
			logger.log(LogStatus.INFO, "Chose pen color toggle");

		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Failed to choose pen color toggle" + i.failIcon);
		}

		Thread.sleep(2000);
		try {
			driver.findElement(
					By.xpath("//div[contains(@class, 'colorPicker-swatch penColorPicker-swatch') and contains(@style, 'background-color: rgb(255, 0, 0)')]"))
					.click();
			logger.log(LogStatus.INFO, "Chose pen color RED");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Failed to choose pen color RED" + i.failIcon);
		}
		
		Thread.sleep(2000);
		try {
			i.draw(driver, 40, 100, 100, 100);
			logger.log(LogStatus.PASS, "Successfully chose red pen to draw a line" + i.successIcon);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Failed to draw with red pen");
		}
		
		logger.endTest();

	}
	
}
