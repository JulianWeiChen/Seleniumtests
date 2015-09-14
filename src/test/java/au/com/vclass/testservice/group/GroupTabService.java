package au.com.vclass.testservice.group;

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

import com.gargoylesoftware.htmlunit.WebConsole.Logger;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.thoughtworks.selenium.webdriven.commands.Click;

public class GroupTabService {
	private static int autoTestGroupID = -1;
	private static int autoTestUserID = -1;
	
	public static void ManageTab(WebDriver driver, ExtentReports logger)
			throws InterruptedException{
		try {
			driver.findElement(By.id("adminTabButton")).click();
			logger.log(LogStatus.INFO, "Click admin tab button");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Failed to click admin tab button"
					+ TestConstants.FAIL_ICON);
		}
		try {
			WebElement element;
			element = driver
					.findElement(By
							.xpath("//div[@id = 'adminOverlayTab' and @class = 'tab-pane active']"));
			logger.log(LogStatus.PASS, "Navigate to admin tab successfully"
					+ TestConstants.SUCCESS_ICON);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Navigate to admin tab unsuccessfuly"
					+ TestConstants.FAIL_ICON);
		}
		
	}
	
	public static void AddGroup(WebDriver driver, ExtentReports logger)
			throws InterruptedException {
		try{
			driver.findElement(By.xpath("//*[@id='groupsTabButton']/a")).click();
			logger.log(LogStatus.INFO, "Group tab clicked" + TestConstants.SUCCESS_ICON);
			driver.findElement(By.xpath("//*[@id='addGroupButton']")).click();
			logger.log(LogStatus.INFO, "Add Group button clicked" + TestConstants.SUCCESS_ICON);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='addGroupRow']/td[1]/div/input")).sendKeys("AutoTestGroup");
			logger.log(LogStatus.INFO, "Group name input box found" + TestConstants.SUCCESS_ICON);
			driver.findElement(By.xpath("//*[@id='addGroupRow']/td[6]/button")).click();
			logger.log(LogStatus.INFO, "Auto Test Group Added");
			Connection conn;
			try{
				conn = DriverManager.getConnection("jdbc:mysql://192.168.1.23/vclass","root","hels2nk2");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from groups where name = 'AutoTestGroup'");
				if(rs.next()){
					//rs.next();
					autoTestGroupID = rs.getInt("gid");
					logger.log(LogStatus.INFO, "Search DB successfully and found target" + TestConstants.SUCCESS_ICON);
				}
				else{
					logger.log(LogStatus.FAIL, "Search DB unsuccessfully" + TestConstants.FAIL_ICON);
				}
				conn.close();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}catch(Exception e){
			logger.log(LogStatus.FAIL, "Failed to find the groups tab button" + e.getMessage()+ TestConstants.FAIL_ICON);
		}
	}
	
	public static void AddUser(WebDriver driver, ExtentReports logger)
			throws InterruptedException{
		try{
		driver.findElement(By.xpath("//*[@id='usersTabButton']/a")).click();
		logger.log(LogStatus.INFO, "Add user Tab clicked" + TestConstants.SUCCESS_ICON);
		driver.findElement(By.xpath("//*[@id='addUserButton']")).click();
		logger.log(LogStatus.INFO, "Add user button found and clicked" + TestConstants.SUCCESS_ICON);
		driver.findElement(By.xpath("//*[@id='addUserRow']/td[1]/div/input")).sendKeys("AutoTestUser");
		logger.log(LogStatus.INFO, "Added User name to the field" + TestConstants.SUCCESS_ICON);
		driver.findElement(By.xpath("//*[@id='addUserRow']/td[2]/div/input")).sendKeys("AutoTestUser@Brad");
		logger.log(LogStatus.INFO, "Added User email to the field" + TestConstants.SUCCESS_ICON);
		driver.findElement(By.xpath("//*[@id='addUserRow']/td[7]/button")).click();
		logger.log(LogStatus.INFO, "Added User to the Database" + TestConstants.SUCCESS_ICON);
		Thread.sleep(2000);

		//driver.findElement(By.xpath("//*[@id='userManagementTab']/div/div/div[12]/div[2]/div/div/button")).click();
		driver.findElement(By.xpath("//*[@id='userManagementTab']/div/div/div[12]/div[2]/div/div")).click();

		Thread.sleep(2000);
		logger.log(LogStatus.INFO, "User filter clicked " + TestConstants.SUCCESS_ICON);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id='userManagementTab']/div/div/div[12]/div[2]/div/div/div/ul/li[3]")).click();
		logger.log(LogStatus.INFO, "Pending user selected" + TestConstants.SUCCESS_ICON);
		}catch(Exception e){
			logger.log(LogStatus.FAIL, e.getMessage()+ TestConstants.FAIL_ICON);
		}
		Connection conn;
		try{
			conn = DriverManager.getConnection("jdbc:mysql://192.168.1.23/vclass","root","hels2nk2");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from users where name = 'AutoTestUser'");
			if(rs.next()){
			//	rs.next();
				autoTestUserID = rs.getInt("uid");
				logger.log(LogStatus.INFO, "Search DB successfully and found target" + TestConstants.SUCCESS_ICON);
			}
			else{
				logger.log(LogStatus.FAIL, "Search DB unsuccessfully" + TestConstants.FAIL_ICON);
			}
			conn.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public static void AddAndDeleteUserToGroup(WebDriver driver, ExtentReports logger)
			throws InterruptedException{
		// including checking the add button is disabled 
		try{
		driver.findElement(By.xpath("//*[@id='groupsTabButton']/a")).click();
		logger.log(LogStatus.INFO, "Group tab clicked" + TestConstants.SUCCESS_ICON);
		driver.findElement(By.xpath("//*[@id='groupRowTemplate']/td[5]/a[@data-group='" + autoTestGroupID + "']")).click();
		logger.log(LogStatus.INFO, "Add Group User Button Clicked" + TestConstants.SUCCESS_ICON);
		driver.findElement(By.xpath("//*[@id='editGroupRolesRow']/td/div[1]/div[1]/div[1]/div[1]/div/button")).click();
		logger.log(LogStatus.INFO, "Choose User to Add Button Clicked" + TestConstants.SUCCESS_ICON);
		driver.findElement(By.xpath("//*[@id='editGroupRolesRow']/td/div[1]/div[1]/div[1]/div[1]/div//*/li//*[text()='" + "AutoTestUser" + "']")).click();
		logger.log(LogStatus.INFO, "Chose the AutoTestUser to be added in" + TestConstants.SUCCESS_ICON);
		driver.findElement(By.xpath("//*[@id='editGroupAddBtn']")).click();
		logger.log(LogStatus.INFO, "Added AutoTestUser" + TestConstants.SUCCESS_ICON);
		Thread.sleep(2000);
		if(!driver.findElement(By.xpath("//*[@id='editGroupAddBtn']")).getAttribute("class").equals("btn btn-default disabled")){
			logger.log(LogStatus.FAIL, "Add Button Doesn't Change" + TestConstants.FAIL_ICON);
		}
		else{
			logger.log(LogStatus.INFO, "Added Button Disabled " + TestConstants.SUCCESS_ICON);
		}
		}catch(Exception e){
			logger.log(LogStatus.FAIL, e.getMessage()+ TestConstants.FAIL_ICON);
		}
		Connection conn;
		try{
			conn = DriverManager.getConnection("jdbc:mysql://192.168.1.23/vclass","root","hels2nk2");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from roles where uid = '" + autoTestUserID + "' and rowid = '" + autoTestGroupID+"'");
			if(!rs.next()){
				logger.log(LogStatus.FAIL, "Search DB unsuccessfully cannot find the row just inserted" + TestConstants.FAIL_ICON);
			}
			else{
				logger.log(LogStatus.INFO, "Added row found" + TestConstants.SUCCESS_ICON);
			}
			conn.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		driver.findElement(By.xpath("//*[@id='userBadgeTemplate' and @data-user='"+autoTestUserID + "']/span[@class='removeBtn glyphicon glyphicon-remove']")).click();
		logger.log(LogStatus.INFO, "Deleted test user from group" + TestConstants.SUCCESS_ICON);
		try{
			conn = DriverManager.getConnection("jdbc:mysql://192.168.1.23/vclass","root","hels2nk2");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from roles where uid = '" + autoTestUserID + "' and rowid = '" + autoTestGroupID +"'");
			if(rs.next()){
				logger.log(LogStatus.FAIL, "The entry has not been deleted" + TestConstants.FAIL_ICON);
			}
			else{
				logger.log(LogStatus.INFO, "the row has been deleted" + TestConstants.SUCCESS_ICON);
				Thread.sleep(2000);
			}
			conn.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		/*
		 * from now on, first set user password and then delete user and group
		 * 
		 */
		try{
			driver.findElement(By.xpath("//*[@id='usersTabButton']/a")).click();
			logger.log(LogStatus.INFO, "Add user Tab clicked" + TestConstants.SUCCESS_ICON);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='userRowTemplate' and @data-user='" + autoTestUserID + "']")).click();
			driver.findElement(By.xpath("//*[@id='userRowTemplate' and @data-user='" + autoTestUserID + "']/td[7]/div/button[2]")).click();
			logger.log(LogStatus.INFO, "Clicked pull down button" + TestConstants.SUCCESS_ICON);
			driver.findElement(By.xpath("//*[@id='userRowTemplate']/td[7]/div/ul/li[1]/a[@data-user='" + autoTestUserID + "']")).click();
			logger.log(LogStatus.INFO, "Clicked delete user button" + TestConstants.SUCCESS_ICON);
			driver.findElement(By.xpath("//*[@id='deleteUserConfirmation']/td/div/div[3]/button")).click();
			logger.log(LogStatus.INFO, "Clicked confirmed button delete user successfully" + TestConstants.SUCCESS_ICON);
			
		}catch(Exception e){
			logger.log(LogStatus.FAIL, e.getMessage() + TestConstants.FAIL_ICON);
		}
	}
	
	public static void AddAndDeleteGroupFromUser(WebDriver driver, ExtentReports logger)
			throws InterruptedException{
		// including checking the add button is disabled
		
	}
	
}
