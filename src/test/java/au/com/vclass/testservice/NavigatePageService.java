package au.com.vclass.testservice;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import au.com.vclass.init.InitAndFunction;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class NavigatePageService {
	
	public void navigatePage(WebDriver driver, ExtentReports logger,
			InitAndFunction i) throws InterruptedException {

		Thread.sleep(2000);

		logger.startTest("Page navigation Test");
		
		// Next page
		try {
			driver.findElement(By.id("next")).click();
			logger.log(LogStatus.PASS, "Navigate to next page successfully" + i.successIcon);
			
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Unsuccessfully to next page" + i.failIcon);
		}
		
		
		// Previous page
		Thread.sleep(2000);
		try {
			driver.findElement(By.id("previous")).click();
			logger.log(LogStatus.PASS, "Navigate to previous page successfully" + i.successIcon);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Unsuccessfully to previous page" + i.failIcon);
		}
		
		//Navigate to Page 3
		Thread.sleep(2000);
		try {
			WebElement element = driver.findElement(By.id("pageNumber"));
			//Have to clear the default page number here
			element.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"3");
			Thread.sleep(2000);
			element.sendKeys(Keys.ENTER);
			logger.log(LogStatus.PASS, "Navigate to Page 3 successfully" + i.successIcon);
			
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Unsuccessfully to Page 3" + i.failIcon);
		}
		
		//Navigate to last page
		Thread.sleep(2000);
		try {
			driver.findElement(By.id("lastPage")).click();
			logger.log(LogStatus.PASS, "Navigate to last page successfully" + i.successIcon);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Unsuccessfully to last page" + i.failIcon);
		}
		
		//Navigate to first page
		Thread.sleep(2000);
		try {
			driver.findElement(By.id("firstPage")).click();
			logger.log(LogStatus.PASS, "Navigate to first page successfully" + i.successIcon);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Unsuccessfully to first page" + i.failIcon);
		}
		
		logger.endTest();
	
	}

}
