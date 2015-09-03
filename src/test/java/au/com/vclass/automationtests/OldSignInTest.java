package au.com.vclass.automationtests;


public class OldSignInTest {
//	private static WebDriver driver;
//	private static ExtentReports logger = ExtentReports.get(OldSignInTest.class);
//	static InitAndFunction i = new InitAndFunction();
//
//	@BeforeTest
//	public void beforeTest() throws ParseException {
//		String time;
//		DateFormat formatter;
//		Date date = new Date();
//		formatter = new SimpleDateFormat("yyMMddHHmmss");
//		time = formatter.format(date);
//		time = "";  //////////////// For debug
//		logger.init("SigninReport" + time + ".html", true);		
//	}
//
//	@BeforeMethod
//	public void beforeMethod() {
//		
//	}
//	
//	/*	1. Log in with valid info
//	 * 	2. Log out
//	 */
//	@Test(priority = 0)
//	public void signInWithValidInfo() throws InterruptedException {
//		
//		String testName = "Sign In with valid info";
//		preMethod(testName);
//		
//		Thread.sleep(2000);
//		String validUserName = i.validUserName;
//		String validPassword = i.validPassword;
//		try {
//			driver.findElement(By.id("signin_username")).sendKeys(validUserName);
//			logger.log(LogStatus.INFO, "Enter valid username");
//		} catch (Exception e) {
//			logger.log(LogStatus.FAIL, "Cannot fill in signin_username" + i.failIcon);
//		}
//		try {
//			driver.findElement(By.id("signin_password")).sendKeys(validPassword);
//			logger.log(LogStatus.INFO, "Enter valid password");
//		} catch (Exception e) {
//			logger.log(LogStatus.FAIL, "Cannot fill in signin_password" + i.failIcon);
//		}
//		try {
//			driver.findElement(By.id("signin_btn")).click();
//			logger.log(LogStatus.INFO, "Click Sign in Button");
//		} catch (Exception e) {
//			logger.log(LogStatus.FAIL, "Cannot click Sin in Button" + i.failIcon);
//		}
//		
//		
//		Thread.sleep(2000);
//		//Check if Sign in successfully
//		WebElement elementFormDisplay = driver.findElement(By.id("modalOverlayContainer"));
//		if(elementFormDisplay.getCssValue("display").equals("none")) {
//			logger.log(LogStatus.PASS, "Log in Successfully " + i.successIcon);
//		}
//		else if(elementFormDisplay.getCssValue("display").equals("block")) {
//			logger.log(LogStatus.FAIL, "Log in unsuccessfully " + i.failIcon);
//		}
//		else {
//			logger.log(LogStatus.FAIL, "Log in CSS display value problem " + i.failIcon);
//		}
//		
//		driver.manage().window().maximize(); // Have to maximize or modify the window size to get contents shown
//		
//		
//		
//		// Log out
//		Thread.sleep(2000);
//		try {
//			driver.findElement(By.id("logoutTabButton")).click();
//			logger.log(LogStatus.INFO, "Click Log out Button");
//		} catch (Exception e) {
//			logger.log(LogStatus.FAIL, "Failed to click Log out Button" + i.failIcon);
//		}
//		
//		//Check log out if successful
//		Thread.sleep(2000);
//		driver.get(i.web);
//		elementFormDisplay = driver.findElement(By.id("modalOverlayContainer"));
//		if(elementFormDisplay.getCssValue("display").equals("block")) {
//			logger.log(LogStatus.PASS, "Log out Successfully " + i.successIcon);
//		}
//		else if(elementFormDisplay.getCssValue("display").equals("none")) {
//			logger.log(LogStatus.FAIL, "Log out unsuccessfully " + i.failIcon);
//		}
//		else {
//			logger.log(LogStatus.FAIL, "Log out CSS display value problem " + i.failIcon);
//		}
//		
//		
//		
//	}
//	
//	//Log in with invalid info
//	@Test(priority = 1)
//	public void signInWithInvalidInfo() throws InterruptedException {
//		String testName = "Sign In with invalid info";
//		preMethod(testName);
//		
//		Thread.sleep(2000);
//		String invalidUserName = i.invalidUserName;
//		String invalidPassword = i.invalidPassword;
//		try {
//			driver.findElement(By.id("signin_username")).sendKeys(invalidUserName);
//			logger.log(LogStatus.INFO, "Enter valid username");
//		} catch (Exception e) {
//			logger.log(LogStatus.FAIL, "Cannot fill in signin_username" + i.failIcon);
//		}
//		try {
//			driver.findElement(By.id("signin_password")).sendKeys(invalidPassword);
//			logger.log(LogStatus.INFO, "Enter valid password");
//		} catch (Exception e) {
//			logger.log(LogStatus.FAIL, "Cannot fill in signin_password" + i.failIcon);
//		}
//		try {
//			driver.findElement(By.id("signin_btn")).click();
//			logger.log(LogStatus.INFO, "Click Sign in Button");
//		} catch (Exception e) {
//			logger.log(LogStatus.FAIL, "Cannot click Sin in Button" + i.failIcon);
//		}
//		
//		Thread.sleep(2000);
//		//Check if Sign in failed
//		WebElement elementFormDisplay = driver.findElement(By.id("modalOverlayContainer"));
//		if(elementFormDisplay.getCssValue("display").equals("block")) {
//			logger.log(LogStatus.PASS, "Log in Unsuccessfully " + i.successIcon);
//		}
//		else if(elementFormDisplay.getCssValue("display").equals("none")) {
//			logger.log(LogStatus.FAIL, "Log in successfully " + i.failIcon);
//		}
//		else {
//			logger.log(LogStatus.FAIL, "Log in CSS display value problem " + i.failIcon);
//		}
//	}
//
//	@AfterMethod
//	public void afterMethod() {
//
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		 driver.quit();
//		logger.endTest();
//
//	}
//
//	@AfterTest
//	public void afterTest() {
//		
//	}
//	
//	static private void preMethod(String testName) {
//		logger.startTest(testName);
//		System.setProperty("webdriver.chrome.driver", i.chromeDriverPath);
//		
//	
//		
//		driver = new ChromeDriver();
//		
//		logger.log(LogStatus.INFO, "New Chrome driver instantiated");
//		driver.get(i.web);
//
//		logger.log(LogStatus.INFO, "Web application launched");
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		driver.findElement(By.xpath("//button[contains(text(),'ready!')]"))
//				.click();
//	}
//	
}
