package au.com.vclass.testservice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import au.com.vclass.init.InitAndFunction;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class AccountTabService {

	public void accountTab(WebDriver driver, ExtentReports logger, InitAndFunction i) throws InterruptedException {
		WebElement element;
		Thread.sleep(2000);
		logger.startTest("Account Tests Start");
		// Navigate to account tab
		try {
			driver.findElement(By.id("accountTabButton")).click();
			logger.log(LogStatus.INFO, "Click account tab button");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Failed to click account tab button" + i.failIcon);
		}
		try {
			element = driver.findElement(By.xpath("//div[@id = 'accountTab' and @class = 'tab-pane active']"));
			logger.log(LogStatus.PASS, "Navigate to account tab successfully" + i.successIcon);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Navigate to account tab unsuccessfuly" + i.failIcon);
		}
	}
	
}
