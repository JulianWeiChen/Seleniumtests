package au.com.vclass.testservice.meeting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.Select;

import au.com.vclass.constants.TestConstants;
import au.com.vclass.testservice.draw.*;
//import junit.framework.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
//import com.thoughtworks.selenium.Wait;

public class MeetingTabService {

	public static void MeetingTab(WebDriver driver, ExtentReports logger)
			throws InterruptedException {

		WebElement element;
		// Navigate to meeting tab
		try {
			driver.findElement(By.id("meetingsTabButton")).click();
			logger.log(LogStatus.INFO, "Click meeting tab button");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Failed to click metting tab button"
					+ TestConstants.FAIL_ICON);
		}
		try {
			element = driver
					.findElement(By
							.xpath("//div[@id = 'meetingsOverlayTab' and @class = 'tab-pane active']"));
			logger.log(LogStatus.PASS, "Navigate to meeting tab successfully"
					+ TestConstants.SUCCESS_ICON);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Navigate to meeting tab unsuccessfuly"
					+ TestConstants.FAIL_ICON);
		}
	}
	
	public static void AddMeeting(WebDriver driver, ExtentReports logger) 
			throws InterruptedException{
			WebElement element;
			
		try{
			driver.findElement(By.linkText("Schedule a Meeting")).click();
			logger.log(LogStatus.INFO, "Clicked scheduled a meeting" + TestConstants.SUCCESS_ICON);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='scheduleNewMeetingTab']/div/div/form/div[2]/div/div/input")).sendKeys("AutoTestMeeting");
			logger.log(LogStatus.INFO, "Added Meeting Name for auto testing" + TestConstants.SUCCESS_ICON);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='scheduleNewMeetingTab']/div/div/form/div[3]/div[1]/div/div/input")).sendKeys("02/02/2027");
			logger.log(LogStatus.INFO, "Added Meeting Start date for auto testing" + TestConstants.SUCCESS_ICON);
			Thread.sleep(2000);	
			driver.findElement(By.xpath("//*[@id='scheduleNewMeetingTab']/div/div/form/div[3]/div[3]/div")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='scheduleNewMeetingTab']/div/div/form/div[3]/div[3]/div/div/div")).click();
			Thread.sleep(1000);
			logger.log(LogStatus.INFO, "Added Meeting end time for auto testing" + TestConstants.SUCCESS_ICON);
			driver.findElement(By.xpath("//*[@id='scheduleNewMeetingTab']/div/div/form/div[3]/div[4]/div/div/input")).sendKeys("02/02/2027");
			logger.log(LogStatus.INFO, "Added Meeting end date for auto testing" + TestConstants.SUCCESS_ICON);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='scheduleNewMeetingTab']/div/div/form/div[4]/div[1]/div/div")).click();
			driver.findElement(By.xpath("//*[@id='scheduleNewMeetingTab']/div/div/form/div[4]/div[1]/div/div[1]/div")).click();
			Thread.sleep(2000);
			//driver.findElement(By.xpath("//*[@id='scheduleNewMeetingTab']/div/div/form/div[4]/div[1]/div/div/div/ul/li[3]")).click();;
										 //*[@id="scheduleNewMeetingTab"]/div/div/form/div[4]/div[1]/div/div/div/ul/li[3]
			logger.log(LogStatus.INFO, "Added meeting participant" + TestConstants.SUCCESS_ICON);
			Thread.sleep(10000);
			driver.findElement(By.xpath("//*[@id='scheduleNewMeetingTab']/div/div/form/div[6]/div/button")).click();
			logger.log(LogStatus.INFO, "Added Meeting Detail to the DB" + TestConstants.SUCCESS_ICON);
			Connection conn = null;
			try{
				conn = DriverManager.getConnection("jdbc:mysql://192.168.1.23/vclass","root","hels2nk2");
			}catch (SQLException e) {
				System.out.println("Connection Failed! Check output console");
				e.printStackTrace();
				return;
			}
			int meeting = 0;
			try{
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from meetings where name = 'AutoTestMeeting'");
				if(rs.next()){
					//rs.next();
					meeting = rs.getInt("mid");
					logger.log(LogStatus.INFO, "Insert into DB successfully" + TestConstants.SUCCESS_ICON);
				}
				else{
					logger.log(LogStatus.FAIL, "Insert into DB unsuccessfully" + TestConstants.FAIL_ICON);
				}
				conn.close();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
			logger.log(LogStatus.INFO, "Start Clicked to delete" + TestConstants.SUCCESS_ICON);
			driver.findElement(By.xpath("//a[@href='#meetingsListTab']")).click();
			Thread.sleep(1000);
			logger.log(LogStatus.INFO, "Clicked all my meeting tab to delete" + TestConstants.SUCCESS_ICON);
			driver.findElement(By.xpath("//tr[@id='upcomingMeetingTemplate' and @data-meeting='" + meeting + "']")).click();;
			logger.log(LogStatus.INFO, "Found the entry for Auto Test Meeting" + TestConstants.SUCCESS_ICON);
			
			/*
			 * Code to update meeting details
			 */
			
			// insert code here
			driver.findElement(By.xpath("//*[@id='upcomingMeetingTemplate']/td[1]/a[text()='AutoTestMeeting']")).click();
			logger.log(LogStatus.INFO, "Clicked link to the Meeting to edit it" + TestConstants.SUCCESS_ICON);
			driver.findElement(By.xpath("//*[@id='editMeetingOverlay']/div/div/form/div[2]/div/div/input")).sendKeys("_UPDATED");
			logger.log(LogStatus.INFO, "New name entered" + TestConstants.SUCCESS_ICON);
			driver.findElement(By.xpath("//*[@id='editMeetingOverlay']/div/div/form/div[7]/div/button")).click();
			logger.log(LogStatus.INFO, "Updated the meeting name" + TestConstants.SUCCESS_ICON);
			/*
			 * check with the DB to see if update succeed 
			 */
			try{
				conn = DriverManager.getConnection("jdbc:mysql://192.168.1.23/vclass","root","hels2nk2");
			}catch (SQLException e) {
				System.out.println("Connection Failed! Check output console");
				e.printStackTrace();
				return;
			}
			try{
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from meetings where name = 'AutoTestMeeting_UPDATED'");
				if(rs.next()){
					//rs.next();
					logger.log(LogStatus.INFO, "Update Meeting Name Successfully" + TestConstants.SUCCESS_ICON);
				}
				else{
					logger.log(LogStatus.FAIL, "Update Meeting Name unsuccessfully" + TestConstants.FAIL_ICON);
				}
				conn.close();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			/*
			 * About to click "start meeting button" 
			 */
			Thread.sleep(2000);
			driver.findElement(By.xpath("//tr[@id='upcomingMeetingTemplate' and @data-meeting='" + meeting + "']")).click();;
			logger.log(LogStatus.INFO, "Found the entry for Auto Test Meeting" + TestConstants.SUCCESS_ICON);
			driver.findElement(By.xpath("//*[@id='upcomingMeetingTemplate' and @data-meeting='"+meeting+"']/td[7]/div/button[1]")).click();
			logger.log(LogStatus.INFO, "Click Start Meeting and Switch to Meeting Button" + TestConstants.SUCCESS_ICON);
			/*
			 * Check Editor tab active or not
			 */
			Thread.sleep(2000);
			if(driver.findElement(By.xpath("//*[@id='thumbnailTabs']/ul/li[2]")).getAttribute("class").equals("active")){
				logger.log(LogStatus.INFO, "Successfully switch to editor page" + TestConstants.SUCCESS_ICON);
			}
			else{
				logger.log(LogStatus.FAIL, "Switch to editor page unsuccessful" + TestConstants.FAIL_ICON);
			}
			/*
			 * Start to Draw Page 
			 */
			/*
			 * Add some Pages Tests
			 * 
			 */
			logger.startTest("Add Some Pages");
			  WebElement addPageBtn = driver.findElement(By.id("newPageToggle"));
			  try{
				  addPageBtn.click();
				  Thread.sleep(2000);
				  logger.log(LogStatus.INFO, "New Page Toggle clicked"+TestConstants.SUCCESS_ICON);
			  }catch(Exception e){
				  logger.log(LogStatus.FAIL,
							"failed to click new page toggle button"
									+ TestConstants.FAIL_ICON);
			  }
			  WebElement newPageNothing = driver.findElement(By.id("newPageWithNothing"));
			  try{
				  newPageNothing.click();
				  Thread.sleep(2000);
				  if(driver.findElements(By.id("thumbnail2")).size()>0){
					  logger.log(LogStatus.INFO,"New Blank Page Added" + TestConstants.SUCCESS_ICON);
				  }
				  else{
					  logger.log(LogStatus.FAIL,"New Blank Page Add Not Successfully" + TestConstants.FAIL_ICON);
				  }
				  addPageBtn.click();
				  driver.findElement(By.id("newPageWithLines")).click();
				  Thread.sleep(1000);
				  if(driver.findElements(By.id("thumbnail3")).size()>0){
					  logger.log(LogStatus.INFO,"New lined Page Added" + TestConstants.SUCCESS_ICON);
				  }
				  else{
					  logger.log(LogStatus.FAIL,"New lined Page Add Not Successfully" + TestConstants.FAIL_ICON);
				  }
				  driver.findElement(By.id("openAppendFileBtn")).click();
				  driver.findElement(By.id("fileInput")).sendKeys("/Users/jiangbangzhang/Desktop/graduate.pdf");
				  Thread.sleep(1000);
				  driver.findElement(By.id("appendFile_confirmInsertFileBtn")).click();
				  Thread.sleep(1000);
				  if(driver.findElements(By.id("thumbnail4")).size()>0){
					  logger.log(LogStatus.INFO,"File from destop added" + TestConstants.SUCCESS_ICON);
				  }
				  else{
					  logger.log(LogStatus.FAIL,"File from destop added fail" + TestConstants.FAIL_ICON);
				  }
				  driver.findElement(By.id("openAppendFileBtn")).click();
				  driver.findElement(By.id("openFromDriveBtn")).click();
				  Thread.sleep(2000);
				  if(driver.findElements(By.xpath("//tr[td[text()='graduate.pdf']]")).size()>0){
						//Found the graduate.pdf entry and click
						driver.findElement(By.xpath("//tr[td[text()='graduate.pdf']]")).click();
						//Clicked the insert file button
						driver.findElement(By.xpath("//tr[td[text()='graduate.pdf']]//button[@class='btn btn-default openFileBtn']")).click();
						//choose to delete the entry
						driver.findElement(By.id("appendFile_confirmInsertFileBtn")).click();
						Thread.sleep(2000);
						if(driver.findElements(By.id("thumbnail5")).size()>0){
							  logger.log(LogStatus.INFO,"File from drive added" + TestConstants.SUCCESS_ICON);
						  }
						  else{
							  logger.log(LogStatus.FAIL,"File from drive added fail" + TestConstants.FAIL_ICON);
						  }
					}
				  else{
					  logger.log(LogStatus.FAIL,"Could Not Find Drive File" + TestConstants.FAIL_ICON);
				  }
			  }catch(Exception e){
				  logger.log(LogStatus.FAIL, "Error Message: " + e.getMessage() + TestConstants.FAIL_ICON);
			  }
			
			logger.startTest("Pen thickness Tests Start");
			PenThicknessService.PenThickness(driver, logger);
			logger.endTest();
			logger.startTest("Pen color Test");
			PenColorService.PenColor(driver, logger);
			logger.endTest();
			logger.startTest("Page navigation Test");
			NavigatePageService.NavigatePage(driver, logger);
			logger.endTest();
			logger.startTest("Zoom and Scale Test");
			ZoomAndScaleService.ZoomAndScale(driver, logger);
			logger.endTest();
			logger.startTest("Eraser Test Start");
			EraserService.Eraser(driver, logger);
			logger.endTest();
			// Need to click "leave meeting" button 
			driver.findElement(By.xpath("//*[@id='leaveMeetingBtn']")).click();
			logger.log(LogStatus.INFO, "Leave Meeting Button Found and clicked");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='nextMeetingMissingTab']/div/p/a")).click();
			logger.log(LogStatus.INFO, "Clicked Next Meeting button to navi to Meeting Label");
			/*
			 * To delete auto test meeting
			 */
			logger.startTest("Delete AutoTestMeeting");
			driver.findElement(By.id("meetingsTabButton")).click();
			logger.log(LogStatus.INFO, "Click meeting tab button");
			driver.findElement(By.xpath("//a[@href='#meetingsListTab']")).click();
			Thread.sleep(1000);
			logger.log(LogStatus.INFO, "Clicked all my meeting tab" + TestConstants.SUCCESS_ICON);
			driver.findElement(By.xpath("//tr[@id='upcomingMeetingTemplate' and @data-meeting='"+meeting+"']")).click();
			logger.log(LogStatus.INFO, "Find the entry for auto test meeting" + TestConstants.SUCCESS_ICON);
			driver.findElement(By.xpath("//tr[@id='upcomingMeetingTemplate' and @data-meeting='"+meeting+"']/td[@class]//button[@class='btn btn-default dropdown-toggle']")).click();;
			logger.log(LogStatus.INFO, "Clicked pull down button" + TestConstants.SUCCESS_ICON);
			driver.findElement(By.xpath("//tr[@id='upcomingMeetingTemplate' and @data-meeting='"+meeting+"']/td[@class]//ul[@class]/li/a[@data-l10n-id='meetingsEnd']")).click();
			logger.log(LogStatus.INFO, "Clicked delete meeting button" + TestConstants.SUCCESS_ICON);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='endMeetingConfirmation']/td/div/div[2]/button")).click();
			try{
				conn = DriverManager.getConnection("jdbc:mysql://192.168.1.23/vclass","root","hels2nk2");
			}catch (SQLException e) {
				System.out.println("Connection Failed! Check output console");
				e.printStackTrace();
				return;
			}
			try{
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from meetings where name = 'AutoTestMeeting_UPDATED'");
				if(!rs.next()){
					//rs.next();
					logger.log(LogStatus.INFO, "Deleted Auto Test Meeting(UPDATED) Successfully" + TestConstants.SUCCESS_ICON);
				}
				else{
					logger.log(LogStatus.FAIL, "Deleted Auto Test Meeting(UPDATED) Unsuccessfully" + TestConstants.FAIL_ICON);
				}
				conn.close();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}catch(Exception e){
			logger.log(LogStatus.FAIL, "Could Not Schedule A Meeting, Please Contact Brad. System Error Message: " + e.getMessage()+ TestConstants.FAIL_ICON);
		}
	}
}
