package au.com.vclass.automationtests.meeting;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import au.com.vclass.constants.TestConstants;
import au.com.vclass.testservice.EraserService;
import au.com.vclass.testservice.NavigatePageService;
import au.com.vclass.testservice.PenColorService;
import au.com.vclass.testservice.PenThicknessService;
import au.com.vclass.testservice.SignInService;
import au.com.vclass.testservice.TestInitService;
import au.com.vclass.testservice.ZoomAndScaleService;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class MeetingTest {
	private WebDriver webDriver;
	private static ExtentReports logger = ExtentReports.get(MeetingTest.class);
	private TestInitService initSrv = new TestInitService();

	@BeforeTest
	public void beforeTest() throws ParseException, InterruptedException {
		String time;
		DateFormat formatter;
		Date date = new Date();
		formatter = new SimpleDateFormat("yyMMdd");
		time = formatter.format(date);
		logger.init("./testreport/MeetingTest-" + time + ".html", true);
		
		String testName = "Sign In with Valid Info";
		webDriver = initSrv.initialize(testName, logger);
		// Thread Wait
		Thread.sleep(2000);
		TestInitService.IAmReady(logger, webDriver);

		// Thread Wait
		Thread.sleep(2000);

		// Sign In with Valid Testing Account
		SignInService.SignIn(logger, webDriver,
				TestConstants.VALID_USER_NAME,
				TestConstants.VALID_PASSWORD, false);

		// Thread Wait
		Thread.sleep(3000);

		// Check Sign In Successfully
		SignInService.CheckSignIn(logger, webDriver, true);

		webDriver.manage().window().maximize(); // Have to maximize or modify the
												// window size to get contents
												// shown
		logger.endTest();

	}

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {

	}

	@Test(priority = 0)
	public void scheduleMeeting() throws InterruptedException {
		//PenThicknessService.PenThickness(webDriver, logger);

	}

	@Test(priority = 1, enabled=false)
	public void penColor() throws InterruptedException {
		PenColorService.PenColor(webDriver, logger);
	}

	@Test(priority = 2, enabled=false)
	public void pageNavigation() throws InterruptedException {
		NavigatePageService.NavigatePage(webDriver, logger);
	}

	@Test(priority = 3, enabled=false)
	public void zoomAndScale() throws InterruptedException {
		ZoomAndScaleService.ZoomAndScale(webDriver, logger);
	}
	
	@Test(priority = 4, enabled=false)
	public void eraserAndClearPage() throws InterruptedException {
		EraserService.Eraser(webDriver, logger);
	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		
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
		// Check log out if successful
		SignInService.CheckSignOut(logger, webDriver);
		
		// Thread Wait
		Thread.sleep(2000);

		webDriver.quit();
		logger.endTest();
	}
}
