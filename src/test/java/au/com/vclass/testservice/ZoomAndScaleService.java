package au.com.vclass.testservice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import au.com.vclass.init.InitAndFunction;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class ZoomAndScaleService {
	
	public void zoomAndScale(WebDriver driver, ExtentReports logger,
			InitAndFunction i) throws InterruptedException {
		
		//Zoom in twice
		
		Thread.sleep(2000);
		logger.startTest("Zoom and Scale Test");
		
		WebElement elementZoomIn = null;
		try {
			elementZoomIn = driver.findElement(By.id("zoomIn"));
			elementZoomIn.click();
			logger.log(LogStatus.PASS, "Zoom in once" + i.successIcon);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Failed to first time zoom in" + i.failIcon);
		}
		
		Thread.sleep(2000);
		try {
			elementZoomIn.click();
			logger.log(LogStatus.PASS, "Zoom in again" + i.successIcon);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Failed to second time zoom in" + i.failIcon);
		}
		
		//Zoom out twice
		
		Thread.sleep(2000);
		WebElement elementZoomOut = null;
		try {
			elementZoomOut = driver.findElement(By.id("zoomOut"));
			elementZoomOut.click();
			logger.log(LogStatus.PASS, "Zoom out once" + i.successIcon);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Failed to first time zoom out" + i.failIcon);
		}
		
		Thread.sleep(2000);
		try {
			elementZoomOut.click();
			logger.log(LogStatus.PASS, "Zoom out again" + i.successIcon);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Failed to second time zoom out" + i.failIcon);
		}
		
		//Scale selector changes
		
		Thread.sleep(2000);
		WebElement elementSelector = null;
		try {
			elementSelector = driver.findElement(By.id("scaleSelectContainer"));
			elementSelector.click();
			Thread.sleep(2000);
			driver.findElement(By.id("pageWidthOption")).click();
			logger.log(LogStatus.PASS, "Changed to scale width successfully" + i.successIcon);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Failed to choose scale width" + i.failIcon);
		}
		
		
		Thread.sleep(2000);
		try {
			elementSelector = driver.findElement(By.id("scaleSelectContainer"));
			elementSelector.click();
			Thread.sleep(2000);
			driver.findElement(By.id("pageFitOption")).click();
			logger.log(LogStatus.PASS, "Changed to scale height successfully" + i.successIcon);
			
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Failed to choose scale height" + i.failIcon);
		}
		
		Thread.sleep(2000);
		try {
			elementSelector = driver.findElement(By.id("scaleSelectContainer"));
			elementSelector.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//option[contains(@value, 0.50)]")).click();
			logger.log(LogStatus.PASS, "Changed to 50% scale successfully" + i.successIcon);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Failed to choose 50% scale" + i.failIcon);
		}
		
		logger.endTest();
		
		
	}

}
