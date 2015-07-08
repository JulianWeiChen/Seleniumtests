package au.com.vclass.automationtests.signin;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import au.com.vclass.init.InitAndFunction;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class SignInTest {
	private static WebDriver webDriver;
	private static InitAndFunction initF = new InitAndFunction();
	static ExtentReports logger = ExtentReports.get(SignInTest.class);

	@Test(priority = 0)
	public void signInWithInvalidInfo() throws InterruptedException {
		String testName = "Sign In with Invalid Info";
		InitLog(testName);
		IAmReady();
		// Thread Wait
		Thread.sleep(2000);

		// Sign In with Invalid Testing Account
		try {
			WebElement userName = webDriver.findElement(By
					.id("signin_username"));
			userName.sendKeys(initF.invalidUserName);
			logger.log(LogStatus.INFO, "Input username: "
					+ initF.invalidUserName);
			WebElement pwd = webDriver.findElement(By.id("signin_password"));
			pwd.sendKeys(initF.invalidPassword);
			logger.log(LogStatus.INFO, "Input password: "
					+ initF.invalidPassword);
			WebElement signinBtn = webDriver.findElement(By.id("signin_btn"));
			signinBtn.click();
			logger.log(LogStatus.INFO, "Sign In...");
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.ERROR, "Sign In Exception!");
		}

		// Thread Wait
		Thread.sleep(3000);

		// Check Sign In Successfully
		WebElement elementFormDisplay = webDriver.findElement(By
				.id("modalOverlayContainer"));
		if (elementFormDisplay.getCssValue("display").equals("block")) {
			logger.log(LogStatus.PASS, "Sign In Unsuccessfully "
					+ initF.successIcon);
		} else if (elementFormDisplay.getCssValue("display").equals("none")) {
			logger.log(LogStatus.FAIL, "Sign In Successfully " + initF.failIcon);
		} else {
			logger.log(LogStatus.FAIL, "Sign In CSS display value problem "
					+ initF.failIcon);
		}

		// Maximize Window
		webDriver.manage().window().maximize();

	}

	@Test(priority = 1)
	public void signInWithValidInfo() throws InterruptedException {
		String testName = "Sign In with Valid Info";
		InitLog(testName);
		IAmReady();
		// Thread Wait
		Thread.sleep(2000);

		// Sign In with Valid Testing Account
		try {
			WebElement userName = webDriver.findElement(By
					.id("signin_username"));
			userName.sendKeys(initF.validUserName);
			logger.log(LogStatus.INFO, "Input username: " + initF.validUserName);
			WebElement pwd = webDriver.findElement(By.id("signin_password"));
			pwd.sendKeys(initF.validPassword);
			logger.log(LogStatus.INFO, "Input password: " + initF.validPassword);
			WebElement signinBtn = webDriver.findElement(By.id("signin_btn"));
			signinBtn.click();
			logger.log(LogStatus.INFO, "Sign In...");
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.ERROR, "Sign In Exception!");
		}

		// Thread Wait
		Thread.sleep(3000);

		// Check Sign In Successfully
		WebElement elementFormDisplay = webDriver.findElement(By
				.id("modalOverlayContainer"));
		if (elementFormDisplay.getCssValue("display").equals("none")) {
			logger.log(LogStatus.PASS, "Sign Successfully " + initF.successIcon);
		} else if (elementFormDisplay.getCssValue("display").equals("block")) {
			logger.log(LogStatus.FAIL, "Sign In unsuccessfully "
					+ initF.failIcon);
		} else {
			logger.log(LogStatus.FAIL, "Sign In CSS display value problem "
					+ initF.failIcon);
		}

		// Maximize Window
		webDriver.manage().window().maximize();

		// Log out
		Thread.sleep(2000);
		try {
			webDriver.findElement(By.id("logoutTabButton")).click();
			logger.log(LogStatus.INFO, "Click Log out Button");
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, "Failed to click Log out Button"
					+ initF.failIcon);
		}

		// Check Log Out Successfully
		Thread.sleep(2000);
		webDriver.get(initF.web);
		elementFormDisplay = webDriver.findElement(By
				.id("modalOverlayContainer"));
		if (elementFormDisplay.getCssValue("display").equals("block")) {
			logger.log(LogStatus.PASS, "Log out Successfully "
					+ initF.successIcon);
		} else if (elementFormDisplay.getCssValue("display").equals("none")) {
			logger.log(LogStatus.FAIL, "Log out unsuccessfully "
					+ initF.failIcon);
		} else {
			logger.log(LogStatus.FAIL, "Log out CSS display value problem "
					+ initF.failIcon);
		}

	}

	@Test(priority = 2)
	public void signInRemMe() throws InterruptedException {
		String testName = "Sign In and Remember Me";
		InitLog(testName);
		IAmReady();
		// Thread Wait
		Thread.sleep(2000);

		// Sign In and Tick Remember Me
		try {
			WebElement userName = webDriver.findElement(By
					.id("signin_username"));
			userName.sendKeys(initF.validUserName);
			logger.log(LogStatus.INFO, "Input username: " + initF.validUserName);
			WebElement pwd = webDriver.findElement(By.id("signin_password"));
			pwd.sendKeys(initF.validPassword);
			logger.log(LogStatus.INFO, "Input password: " + initF.validPassword);
			WebElement rem = webDriver.findElement(By.id("rememberMe"));
			rem.click();
			logger.log(LogStatus.INFO, "Tick Remember Me: " + rem.isSelected());
			WebElement signinBtn = webDriver.findElement(By.id("signin_btn"));
			signinBtn.click();
			logger.log(LogStatus.INFO, "Sign In...");
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.ERROR, "Sign In Exception!");
		}

		// Thread Wait
		Thread.sleep(3000);

		// Check Sign In Successfully
		WebElement elementFormDisplay = webDriver.findElement(By
				.id("modalOverlayContainer"));
		if (elementFormDisplay.getCssValue("display").equals("none")) {
			logger.log(LogStatus.PASS, "Sign In Successfully "
					+ initF.successIcon);
		} else if (elementFormDisplay.getCssValue("display").equals("block")) {
			logger.log(LogStatus.FAIL, "Sign In Unsuccessfully "
					+ initF.failIcon);
		} else {
			logger.log(LogStatus.FAIL, "Sign In CSS display value problem "
					+ initF.failIcon);
		}

		// Maximize Window
		webDriver.manage().window().maximize();

		// Log out
		Thread.sleep(2000);
		try {
			webDriver.findElement(By.id("logoutTabButton")).click();
			logger.log(LogStatus.INFO, "Click Log out Button");
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, "Failed to click Log out Button"
					+ initF.failIcon);
		}

		// Check Is Remember Me
		Thread.sleep(2000);
		webDriver.get(initF.web);
		try {
			WebElement signInBtn = webDriver.findElement(By
					.id("signin_btn"));
			if (signInBtn!=null) {
				signInBtn.click();
				logger.log(LogStatus.INFO, "Sign In Again... ");
				Thread.sleep(3000);
				elementFormDisplay = webDriver.findElement(By
						.id("modalOverlayContainer"));
				if (elementFormDisplay.getCssValue("display").equals("none")) {
					logger.log(LogStatus.PASS, "Sign In with Remember Me Successfully "
							+ initF.successIcon);
				} else if (elementFormDisplay.getCssValue("display").equals("block")) {
					logger.log(LogStatus.FAIL, "Sign In with Remember Me Unsuccessfully "
							+ initF.failIcon);
				} else {
					logger.log(LogStatus.FAIL, "CSS display value problem "
							+ initF.failIcon);
				}
			} else {
				logger.log(LogStatus.FAIL, "CSS display value problem "
						+ initF.failIcon);
			}		
		
		} catch (Exception e){
			logger.log(LogStatus.ERROR, "Sign In with Remember Me Exception! "
					+ initF.failIcon);
		}
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
			logger.log(LogStatus.ERROR, "Thread Exception!");
		}
		webDriver.manage().deleteAllCookies();
		webDriver.quit();		
		logger.endTest();
	}

	@BeforeTest
	public void beforeTest() {
		String time;
		DateFormat formatter;
		Date date = new Date();
		formatter = new SimpleDateFormat("yyMMddHHmmss");
		time = formatter.format(date);
		logger.init("SignInTest-"+time+".html", true);
	}
	
	@AfterTest
	public void afterTest() {
		
	}


	private static void InitLog(String testName) {
		logger.startTest(testName);

		// Open Chrome in a new session
		System.setProperty("webdriver.chrome.driver", initF.chromeDriverPath);
		webDriver = new ChromeDriver();
		logger.log(LogStatus.INFO, "New Chrome driver instantiated");

		webDriver.get(initF.web);
		logger.log(LogStatus.INFO, "Web application launched");

		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.ERROR, "Thread Exception!");
		}
	}

	private static void IAmReady() {
		// I'm ready Button Click
		try {
			WebElement readyBtn = webDriver.findElement(By
					.xpath("//button[contains(text(),'ready!')]"));
			readyBtn.click();
			logger.log(LogStatus.INFO, "I'm ready OK!");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "I'm ready Exception!");
		}

	}

}
