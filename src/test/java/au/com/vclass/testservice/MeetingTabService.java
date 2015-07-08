package au.com.vclass.testservice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import au.com.vclass.init.InitAndFunction;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class MeetingTabService {
	
	public void meetingTab(WebDriver driver, ExtentReports logger, InitAndFunction i) throws InterruptedException {
		
		WebElement element;
		Thread.sleep(2000);
		logger.startTest("Meeting Tests Start");
		// Navigate to meeting tab
		try {
			driver.findElement(By.id("meetingsTabButton")).click();
			logger.log(LogStatus.INFO, "Click meeting tab button");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Failed to click metting tab button" + i.failIcon);
		}
		try {
			element = driver.findElement(By.xpath("//div[@id = 'meetingsOverlayTab' and @class = 'tab-pane active']"));
			logger.log(LogStatus.PASS, "Navigate to meeting tab successfully" + i.successIcon);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Navigate to meeting tab unsuccessfuly" + i.failIcon);
		}
	}
}
