package au.com.vclass.testservice.init;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import au.com.vclass.constants.TestConstants;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class TestInitService {
	public WebDriver initialize(ExtentReports logger) {
		//logger.startTest(testName);

		// Open Chrome in a new session
		System.setProperty("webdriver.chrome.driver",
				TestConstants.CHROME_DRIVER_PATH);
		WebDriver webDriver = new ChromeDriver();
		logger.log(LogStatus.INFO, "New Chrome driver instantiated");

		webDriver.get(TestConstants.WEB_URL);
		logger.log(LogStatus.INFO, "Web application launched");

		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.ERROR, "Thread Exception!");
		}
		// Maximize Window
		webDriver.manage().window().maximize();
		return webDriver;
	}

	public static void IAmReady(ExtentReports logger, WebDriver webDriver) {
		// I'm ready Button Click
		try {
			WebElement readyBtn = webDriver.findElement(By
					.xpath("//button[contains(text(),'ready!')]"));
			readyBtn.click();
			logger.log(LogStatus.INFO, "I'm ready OK!");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "I'm ready Exception!");
		}

	}
}
