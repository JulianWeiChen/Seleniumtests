package au.com.vclass.automationtests.drive;


import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

import au.com.vclass.automationtests.meeting.MeetingTest;
import au.com.vclass.constants.TestConstants;
import au.com.vclass.testservice.init.TestInitService;
import au.com.vclass.testservice.signin.SignInService;
import au.com.vclass.testservice.drive.driveHelper;
import au.com.vclass.testservice.group.*;

import org.testng.annotations.BeforeTest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;


public class uploadFileTest {
	private WebDriver webDriver;
	private static ExtentReports logger = ExtentReports.get(MeetingTest.class);
	private TestInitService initSrv = new TestInitService();
	
  @Test
  public void f() throws InterruptedException {
	  GroupTabService.ManageTab(webDriver, logger);
	  Thread.sleep(2000);
	  logger.startTest("Navi to drive Tab");
	  driveHelper.DriveTab(webDriver, logger);
	  Thread.sleep(2000);
	  logger.startTest("Start to upload file");
	  driveHelper.allMyFile(webDriver, logger);
	  Thread.sleep(1000);
  }
  @BeforeTest
  public void beforeTest() throws ParseException, InterruptedException {
		String time;
		DateFormat formatter;
		Date date = new Date();
		formatter = new SimpleDateFormat("yyMMdd");
		time = formatter.format(date);
		logger.init("./testreport/uploadFileTest-" + time + ".html", true);
		//String testName = "Sign In with Valid Info";
		logger.startTest("Sign In with Valid Info");
		webDriver = initSrv.initialize(logger);
		// Thread Wait
		Thread.sleep(2000);
		//TestInitService.IAmReady(logger, webDriver);

		// Thread Wait

		// Sign In with Valid Testing Account
		SignInService.SignIn(logger, webDriver,
				TestConstants.VALID_USER_NAME,
				TestConstants.VALID_PASSWORD, false);

		// Thread Wait
		Thread.sleep(2000);

		// Check Sign In Successfully
		SignInService.CheckSignIn(logger, webDriver, true);

		webDriver.manage().window().maximize(); // Have to maximize or modify the
												// window size to get contents
												// shown
		logger.endTest();

	}	


  @AfterTest
  public void afterTest() throws InterruptedException {
		// Thread Wait
		Thread.sleep(2000);
		String testName = "Sign off with valid info";
		logger.startTest(testName);

		// Log out
		SignInService.SignOut(logger, webDriver);
		
		// Thread Wait
		Thread.sleep(2000);

		webDriver.quit();
		logger.endTest();
	}

}
