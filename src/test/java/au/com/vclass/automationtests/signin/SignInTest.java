package au.com.vclass.automationtests.signin;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import au.com.vclass.constants.TestConstants;
import au.com.vclass.testservice.init.TestInitService;
import au.com.vclass.testservice.signin.SignInService;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class SignInTest {
	private static WebDriver webDriver;
	// private static InitAndFunction initF = new InitAndFunction();
	private static ExtentReports logger = ExtentReports.get(SignInTest.class);
	private TestInitService initSrv = new TestInitService();

	@BeforeTest
	public void beforeTest() {
		String time;
		DateFormat formatter;
		Date date = new Date();
		formatter = new SimpleDateFormat("yyMMdd");
		time = formatter.format(date);
		logger.init("./testreport/SignInTest-" + time + ".html", true);
	}
	
	@AfterTest
	public void afterTest() {

	}
	
	@BeforeMethod
	public void beforeMethod() {
		// logger.init("SignInTest.html", true);
	}

	@AfterMethod
	public void afterMethod() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.ERROR, "SignInTest AfterMethod Thread Exception!!!"
					+ TestConstants.FAIL_ICON
					+ TestConstants.FAIL_ICON + "\n" + e.getMessage());
		}
		webDriver.manage().deleteAllCookies();
		webDriver.quit();
		logger.endTest();
	}
	
	@Test(priority = 0)
	public void signInWithInvalidInfo() throws InterruptedException {
		logger.startTest("Sign In with Invalid Info");
		//String testName = "Sign In with Invalid Info";
		webDriver = initSrv.initialize(logger);		
		// Thread Wait
		Thread.sleep(2000);		
		//TestInitService.IAmReady(logger, webDriver);

		// Thread Wait
		Thread.sleep(2000);

		// Sign In with Invalid Testing Account
		SignInService.SignIn(logger, webDriver,
				TestConstants.INVALID_USER_NAME,
				TestConstants.INVALID_PASSWORD, false);

		// Thread Wait
		Thread.sleep(3000);

		// Check Sign In Successfully
		SignInService.CheckSignIn(logger, webDriver, false);
	}

	@Test(priority = 1)
	public void signInWithValidInfo() throws InterruptedException {
		logger.startTest("Sign In with Valid Info");
		//String testName = "Sign In with Valid Info";
		webDriver = initSrv.initialize(logger);
		// Thread Wait
		Thread.sleep(2000);		
		//TestInitService.IAmReady(logger, webDriver);

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

		// Maximize Window
		webDriver.manage().window().maximize();

		// Thread Wait
		Thread.sleep(2000);

		// Log out
		SignInService.SignOut(logger, webDriver);

		// Thread Wait
		Thread.sleep(2000);

		// Check Log Out Successfully
		SignInService.CheckSignOut(logger, webDriver);
	}

	@Test(priority = 2)
	public void signInRemMe() throws InterruptedException {
		//String testName = "Sign In and Remember Me";
		logger.startTest("Sign In and Remember Me");
		webDriver = initSrv.initialize(logger);
		// Thread Wait
		Thread.sleep(2000);		
		//TestInitService.IAmReady(logger, webDriver);
		
		// Thread Wait
		Thread.sleep(2000);

		// Sign In and Tick Remember Me
		SignInService.SignIn(logger, webDriver,
				TestConstants.VALID_USER_NAME,
				TestConstants.VALID_PASSWORD, true);

		// Thread Wait
		Thread.sleep(3000);

		// Check Sign In Successfully
		SignInService.CheckSignIn(logger, webDriver, true);

		// Maximize Window
		webDriver.manage().window().maximize();

		// Thread Wait
		Thread.sleep(3000);

		// Log out
		SignInService.SignOut(logger, webDriver);

		// Thread Wait
		Thread.sleep(2000);
		
		// Check Is Remember Me
		SignInService.CheckSignInAgain(logger, webDriver);		
	}

}
