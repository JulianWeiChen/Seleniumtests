package au.com.vclass.automationtests.signin;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import au.com.vclass.automationtests.signin.SignInTest;
import au.com.vclass.constants.TestConstants;
import au.com.vclass.testservice.init.TestInitService;
import au.com.vclass.testservice.signin.SignInService;

public class ChangePasswordTest {
	private static WebDriver webDriver;
	// private static InitAndFunction initF = new InitAndFunction();
	private static ExtentReports logger = ExtentReports.get(SignInTest.class);
	private TestInitService initSrv = new TestInitService();
	
  @Test
  public void ChangePassword() throws InterruptedException {
	  logger.startTest("Start test sign in");
	  webDriver = initSrv.initialize(logger);
	  SignInService.SignIn(logger, webDriver,
				TestConstants.VALID_USER_NAME,
				TestConstants.VALID_PASSWORD, false);
	  Thread.sleep(1000);
	  SignInService.CheckSignIn(logger, webDriver, true);
	  logger.startTest("Change Password Test");
	  WebElement settingBtn = webDriver.findElement(By.id("accountTabButton"));
	  try{
		  settingBtn.click();
		  WebElement changePassword = webDriver.findElement(By.linkText("Change Password"));
		  changePassword.click();
		  logger.log(LogStatus.INFO, "Changed to setting tab"+TestConstants.SUCCESS_ICON);
	  }catch(Exception e){
		  logger.log(LogStatus.FAIL, "fail to change to setting tab" + TestConstants.FAIL_ICON);
	  }
	  Thread.sleep(1000);
	  WebElement currentPW = webDriver.findElement(By.id("userPasswordInput"));
	  WebElement changePW = webDriver.findElement(By.id("changePasswordPassword"));
	  WebElement confirmPW = webDriver.findElement(By.id("changePasswordConfirm"));
	  WebElement confirmBtn = webDriver.findElement(By.id("save_new_password_btn2"));
	  try{
		  currentPW.sendKeys("julianpw");
		  changePW.sendKeys("1Aaaaaaa");
		  confirmPW.sendKeys("1Aaaaaaa");
		  Thread.sleep(1000);
		  confirmBtn.click();
		  logger.log(LogStatus.INFO,"Changed Password" + TestConstants.SUCCESS_ICON);
		  Thread.sleep(3000);
	  }catch(Exception e){
		  logger.log(LogStatus.FAIL, "failed to change password " + TestConstants.FAIL_ICON);
	  }
	  logger.startTest("sign out to log in again");
	  SignInService.SignOut(logger, webDriver);
	  Thread.sleep(2000);
	  logger.startTest("use new name to sign in");
	  SignInService.SignIn(logger, webDriver, TestConstants.VALID_USER_NAME, TestConstants.CHANGED_PASSWORD, false);
	  Thread.sleep(1000);
	  SignInService.CheckSignIn(logger, webDriver, true);
	  logger.log(LogStatus.INFO, "log in again using new password successful" + TestConstants.SUCCESS_ICON);
  }
  @BeforeTest
  public void beforeTest() {
	  String time;
		DateFormat formatter;
		Date date = new Date();
		formatter = new SimpleDateFormat("yyMMdd");
		time = formatter.format(date);
		logger.init("./testreport/ChangePasswordTest-" + time + ".html", true);
  }

  @AfterTest
  public void afterTest() {
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

}
