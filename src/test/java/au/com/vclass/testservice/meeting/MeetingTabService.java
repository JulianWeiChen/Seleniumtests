package au.com.vclass.testservice.meeting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import au.com.vclass.constants.TestConstants;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.thoughtworks.selenium.Wait;

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
			driver.findElement(By.xpath("//*[@id='scheduleNewMeetingTab']/div/div/form/div[4]/div[1]/div/div[1]/div")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='scheduleNewMeetingTab']/div/div/form/div[4]/div[1]/div/div[1]/div/div/ul/li[3]")).click();;
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
			 * About to click "start meeting button" 
			 */
			//*[@id="upcomingMeetingTemplate"]/td[7]/div/button[1]
			driver.findElement(By.xpath("//*[@id='upcomingMeetingTemplate and @data-meeting='"+meeting+"']/td[7]/div/button[1]")).click();
			logger.log(LogStatus.INFO, "Click Start Meeting and Switch to Meeting Button" + TestConstants.SUCCESS_ICON);
			driver.findElement(By.xpath("//tr[@id='upcomingMeetingTemplate' and @data-meeting='"+meeting+"']/td[@class]//button[@class='btn btn-default dropdown-toggle']")).click();;
			logger.log(LogStatus.INFO, "Clicked pull down button" + TestConstants.SUCCESS_ICON);
			driver.findElement(By.xpath("//tr[@id='upcomingMeetingTemplate' and @data-meeting='"+meeting+"']/td[@class]//ul[@class]/li/a[@data-l10n-id='meetingsEnd']")).click();
			logger.log(LogStatus.INFO, "Clicked delete meeting button" + TestConstants.SUCCESS_ICON);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='endMeetingConfirmation']/td/div/div[2]/button")).click();
			logger.log(LogStatus.INFO, "Successfully deleted the auto testing case" + TestConstants.SUCCESS_ICON);
		}catch(Exception e){
			logger.log(LogStatus.FAIL, "Could Not Schedule A Meeting " + e.getMessage()+ TestConstants.FAIL_ICON);
		}
	}
}
