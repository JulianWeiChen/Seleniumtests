package au.com.vclass.testservice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import au.com.vclass.constants.TestConstants;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class NavigatePageService {

	public static void NavigatePage(WebDriver driver, ExtentReports logger)
			throws InterruptedException {

		Thread.sleep(2000);

		logger.startTest("Page navigation Test");

		// Next page
		try {
			driver.findElement(By.id("next")).click();
			logger.log(LogStatus.PASS, "Navigate to next page successfully"
					+ TestConstants.SUCCESS_ICON);

		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Unsuccessfully to next page"
					+ TestConstants.FAIL_ICON);
		}

		// Previous page
		Thread.sleep(2000);
		try {
			driver.findElement(By.id("previous")).click();
			logger.log(LogStatus.PASS, "Navigate to previous page successfully"
					+ TestConstants.SUCCESS_ICON);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Unsuccessfully to previous page"
					+ TestConstants.FAIL_ICON);
		}

		// Navigate to Page 3
		Thread.sleep(2000);
		try {
			WebElement element = driver.findElement(By.id("pageNumber"));
			// Have to clear the default page number here
			element.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), "3");
			Thread.sleep(2000);
			element.sendKeys(Keys.ENTER);
			logger.log(LogStatus.PASS, "Navigate to Page 3 successfully"
					+ TestConstants.SUCCESS_ICON);

		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Unsuccessfully to Page 3"
					+ TestConstants.FAIL_ICON);
		}

		// Navigate to last page
		Thread.sleep(2000);
		try {
			driver.findElement(By.id("lastPage")).click();
			logger.log(LogStatus.PASS, "Navigate to last page successfully"
					+ TestConstants.SUCCESS_ICON);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Unsuccessfully to last page"
					+ TestConstants.FAIL_ICON);
		}

		// Navigate to first page
		Thread.sleep(2000);
		try {
			driver.findElement(By.id("firstPage")).click();
			logger.log(LogStatus.PASS, "Navigate to first page successfully"
					+ TestConstants.SUCCESS_ICON);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Unsuccessfully to first page"
					+ TestConstants.FAIL_ICON);
		}

		logger.endTest();

	}

}
