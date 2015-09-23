package au.com.vclass.testservice.drive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.*;

import com.gargoylesoftware.htmlunit.WebWindow;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import au.com.vclass.constants.TestConstants;

public class driveHelper {
	
	public static void DriveTab(WebDriver driver, ExtentReports logger) throws InterruptedException{
		try {
			driver.findElement(By.id("driveTabButton")).click();
			logger.log(LogStatus.INFO, "Click drive tab button");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Failed to click admin tab button"
					+ TestConstants.FAIL_ICON);
		}
		try {
			WebElement element;
			element = driver
					.findElement(By.xpath("//div[@id = 'driveOverlayTab' and @class = 'tab-pane active']"));
			logger.log(LogStatus.PASS, "Navigate to drive tab successfully"
					+ TestConstants.SUCCESS_ICON);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Navigate to drive tab unsuccessfuly"
					+ TestConstants.FAIL_ICON);
		}
	}
	public static void allMyFile(WebDriver driver, ExtentReports logger) throws InterruptedException{
		
		try{
			driver.findElement(By.xpath("//*[@id='driveTab']//a[@href='#driveFilesTab']")).click();
			logger.log(LogStatus.INFO, "Navi to All My files view" + TestConstants.SUCCESS_ICON);
			/*
			 * if the element found 
			 */
			if(driver.findElements(By.xpath("//tr[td[text()='graduate.pdf']]")).size()>0){
				Thread.sleep(2000);
				//Found the graduate.pdf entry and click
				driver.findElement(By.xpath("//tr[td[text()='graduate.pdf']]")).click();
				Thread.sleep(2000);
				//Clicked the drop down button
				driver.findElement(By.xpath("//tr[td[text()='graduate.pdf']]//button[@class='btn btn-default dropdown-toggle']")).click();
				Thread.sleep(2000);
				//choose to delete the entry
				driver.findElement(By.xpath("//tr[td[text()='graduate.pdf']]//li[3]")).click();
				//confirm delete
				Thread.sleep(2000);
				//driver.findElement(By.xpath("//*[@id='fileDeleteConfirmation192']/td/div/div[2]/button")).click();
				driver.findElement(By.xpath("//tr[@class='fileDeleteConfirmation']//button[@data-l10n-id='filesDeleteConfirm']")).click();	
				logger.log(LogStatus.INFO, "Deleted previously file Successfully" + TestConstants.SUCCESS_ICON);
			}
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("TabDrive.localFileOpenMode='upload';");
			driver.findElement(By.xpath("//*[@id='fileInput' and @class='fileInput']")).sendKeys("/Users/jiangbangzhang/Desktop/graduate.pdf");;
			Thread.sleep(1000);
			int divCount = driver.findElements(By.xpath("//*[@id='driveFilesTab_failToUpload']")).size();
			Boolean cannotUpload = true;
			for(int i = 0; i< divCount; i++){
				if(driver.findElements(By.xpath("//*[@id='driveFilesTab_failToUpload']")).get(i).getAttribute("class").equals("alert alert-warning alert-dismissible")){
					logger.log(LogStatus.FAIL, "Could Not Upload File" + TestConstants.FAIL_ICON);
					cannotUpload = false;
					break;
				}
			}
			if(cannotUpload == true){
				logger.log(LogStatus.INFO, "Upload File Successfully" + TestConstants.SUCCESS_ICON);
			}
		}catch(Exception e){
			logger.log(LogStatus.FAIL, "Error Message: " + e.getMessage() + TestConstants.FAIL_ICON);
		}
	}

}
