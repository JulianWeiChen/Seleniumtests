package au.com.vclass.automationtests.MainPage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

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


public class AddPageTest {
	private static WebDriver webDriver;
	// private static InitAndFunction initF = new InitAndFunction();
	private static ExtentReports logger = ExtentReports.get(SignInTest.class);
	private TestInitService initSrv = new TestInitService();
	
  @Test(priority = 0)
  public void addPageTest() throws InterruptedException{
	  logger.startTest("Start test sign in");
	  webDriver = initSrv.initialize(logger);
	  SignInService.SignIn(logger, webDriver,
				TestConstants.VALID_USER_NAME,
				TestConstants.VALID_PASSWORD, false);
	  Thread.sleep(1000);
	  SignInService.CheckSignIn(logger, webDriver, true);
	  logger.startTest("add blank page");
	  WebElement addPageBtn = webDriver.findElement(By.id("newPageToggle"));
	  try{
		  addPageBtn.click();
		  Thread.sleep(2000);
		  logger.log(LogStatus.INFO, "New Page Toggle clicked"+TestConstants.SUCCESS_ICON);
	  }catch(Exception e){
		  logger.log(LogStatus.FAIL,
					"failed to click new page toggle button"
							+ TestConstants.FAIL_ICON);
	  }
	  WebElement newPageNothing = webDriver.findElement(By.id("newPageWithNothing"));
	  try{
		  newPageNothing.click();
		  Thread.sleep(2000);
		  logger.log(LogStatus.INFO,"New Blank Page added" + TestConstants.SUCCESS_ICON);
	  }catch(Exception e){
		  logger.log(LogStatus.FAIL, "failed to add blank page" + TestConstants.FAIL_ICON);
	  }
	  logger.startTest("add lined page");
	  try{
		  addPageBtn.click();
		  Thread.sleep(2000);
		  logger.log(LogStatus.INFO, "New Page Toggle clicked"+TestConstants.SUCCESS_ICON);
	  }catch(Exception e){
		  logger.log(LogStatus.FAIL,
					"failed to click new page toggle button"
							+ TestConstants.FAIL_ICON);
	  }
	  WebElement newPageLine = webDriver.findElement(By.id("newPageWithLines"));
	  try{
		  newPageLine.click();
		  Thread.sleep(2000);
		  logger.log(LogStatus.INFO, "New lined page added" + TestConstants.SUCCESS_ICON);
	  }catch(Exception e){
		  logger.log(LogStatus.FAIL, "fail to add Lined Page" + TestConstants.FAIL_ICON);
	  }
	  logger.startTest("upload file from locally");
	  WebElement openFileBtn = webDriver.findElement(By.id("openAppendFileBtn"));
	  try{
		  openFileBtn.click();
		  Thread.sleep(2000);
		  logger.log(LogStatus.INFO, "Append file button clicked" + TestConstants.SUCCESS_ICON);
	  }catch(Exception e){
		  logger.log(LogStatus.FAIL, "fail to click append file button" + TestConstants.FAIL_ICON);
	  }
	  WebElement openFromPcBtn = webDriver.findElement(By.id("fileInput"));
	  try{
		  openFromPcBtn.sendKeys("/Users/jiangbangzhang/Desktop/graduate.pdf");
		  Thread.sleep(1000);
		  logger.log(LogStatus.INFO, "Upload from PC button Clicked" + TestConstants.SUCCESS_ICON);
		  
	  }catch(Exception e){
		  logger.log(LogStatus.FAIL, "fail to select file path" + TestConstants.FAIL_ICON);
	  }
	  Thread.sleep(1000);
	  WebElement confirmUpload = webDriver.findElement(By.id("appendFile_confirmInsertFileBtn"));
	  try{
		  confirmUpload.click();
		  logger.log(LogStatus.INFO,"Upload file to insert button clicked" + TestConstants.SUCCESS_ICON);
		  
	  }
	  catch (Exception e){
		  logger.log(LogStatus.FAIL, "fail to click insert button" + TestConstants.FAIL_ICON);
	  }
	  Thread.sleep(1000);
	  logger.startTest("Display file from PC Test");
	  WebElement pcFileThumbnail = webDriver.findElement(By.id("thumbnail4"));
	  if(pcFileThumbnail!=null){
		  logger.log(LogStatus.INFO, "File from PC displayed" + TestConstants.SUCCESS_ICON);
	  }
	  else{
		  logger.log(LogStatus.FAIL, "File from PC failed to be displayed" + TestConstants.FAIL_ICON);
	  }
  }
  

  @BeforeTest
  public void beforeTest() {
	  String time;
		DateFormat formatter;
		Date date = new Date();
		formatter = new SimpleDateFormat("yyMMdd");
		time = formatter.format(date);
		logger.init("./testreport/AddPageTest-" + time + ".html", true);
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
