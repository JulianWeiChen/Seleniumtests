package au.com.vclass.automationtests.draw;

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
import au.com.vclass.testservice.draw.EraserService;
import au.com.vclass.testservice.draw.NavigatePageService;
import au.com.vclass.testservice.draw.PenColorService;
import au.com.vclass.testservice.draw.PenThicknessService;
import au.com.vclass.testservice.draw.ZoomAndScaleService;
import au.com.vclass.testservice.init.TestInitService;
import au.com.vclass.testservice.signin.SignInService;

import com.relevantcodes.extentreports.ExtentReports;

public class DrawTest {
	private WebDriver webDriver;
	private static ExtentReports logger = ExtentReports.get(DrawTest.class);
	private TestInitService initSrv = new TestInitService();

	@BeforeTest
	public void beforeTest() throws ParseException, InterruptedException {
		String time;
		DateFormat formatter;
		Date date = new Date();
		formatter = new SimpleDateFormat("yyMMdd");
		time = formatter.format(date);
		logger.init("./testreport/DrawTest-" + time + ".html", true);
		
		//String testName = "Sign In with Valid Info";
		logger.startTest("Sign In with Valid Info");
		webDriver = initSrv.initialize(logger);
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

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {

	}
	
	@AfterMethod
	public void afterMethod() throws InterruptedException {
		
	}
	
	@Test(priority = 0)
	public void penThickness() throws InterruptedException {
		logger.startTest("Pen thickness Tests Start");
		PenThicknessService.PenThickness(webDriver, logger);
		logger.endTest();
	}

	@Test(priority = 1)
	public void penColor() throws InterruptedException {
		logger.startTest("Pen color Test");
		PenColorService.PenColor(webDriver, logger);
		logger.endTest();
	}

	@Test(priority = 2)
	public void pageNavigation() throws InterruptedException {
		logger.startTest("Page navigation Test");
		NavigatePageService.NavigatePage(webDriver, logger);
		logger.endTest();
	}

	@Test(priority = 3)
	public void zoomAndScale() throws InterruptedException {
		logger.startTest("Zoom and Scale Test");
		ZoomAndScaleService.ZoomAndScale(webDriver, logger);
		logger.endTest();
	}
	
	@Test(priority = 4)
	public void eraserAndClearPage() throws InterruptedException {
		logger.startTest("Eraser Test Start");
		EraserService.Eraser(webDriver, logger);
		logger.endTest();
	}


}
