package au.com.vclass.automationtests;


public class NewTest {
//	public WebDriver driver;
//	InitAndFunction i = new InitAndFunction();
//	static ExtentReports logger = ExtentReports.get(CombineTest.class);
//
//	@BeforeTest
//	public void beforeTest() throws ParseException, InterruptedException {
//		String time;
//		DateFormat formatter;
//		Date date = new Date();
//		formatter = new SimpleDateFormat("yyMMddHHmmss");
//		time = formatter.format(date);
//		time = ""; // ////////////
//		logger.init("NewTest" + time + ".html", true);
//
//		// /////////////////////
//		String testName = "Sign In with valid info";
//		logger.startTest(testName);
//
//		// Open Chrome in a new session
//		System.setProperty("webdriver.chrome.driver", i.chromeDriverPath);
//		driver = new ChromeDriver();
//
//		logger.log(LogStatus.INFO, "New Chrome driver instantiated");
//		driver.get(i.web);
//		// Thread.sleep(700);
//		// driver.get("javascript:localStorage.clear();");
//		logger.log(LogStatus.INFO, "Web application launched");
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		driver.findElement(By.xpath("//button[contains(text(),'ready!')]"))
//				.click();
//
//		Thread.sleep(2000);
//		String validUserName = i.validUserName;
//		String validPassword = i.validPassword;
//		try {
//			driver.findElement(By.id("signin_username"))
//					.sendKeys(validUserName);
//			logger.log(LogStatus.INFO, "Enter valid username");
//		} catch (Exception e) {
//			logger.log(LogStatus.FAIL, "Cannot fill in signin_username"
//					+ i.failIcon);
//		}
//		try {
//			driver.findElement(By.id("signin_password"))
//					.sendKeys(validPassword);
//			logger.log(LogStatus.INFO, "Enter valid password");
//		} catch (Exception e) {
//			logger.log(LogStatus.FAIL, "Cannot fill in signin_password"
//					+ i.failIcon);
//		}
//		try {
//			driver.findElement(By.id("signin_btn")).click();
//			logger.log(LogStatus.INFO, "Click Sign in Button");
//		} catch (Exception e) {
//			logger.log(LogStatus.FAIL, "Cannot click Sin in Button"
//					+ i.failIcon);
//		}
//
//		Thread.sleep(3000);
//		// Check if Sign in successfully
//		WebElement elementFormDisplay = driver.findElement(By
//				.id("modalOverlayContainer"));
//		if (elementFormDisplay.getCssValue("display").equals("none")) {
//			logger.log(LogStatus.PASS, "Log in Successfully " + i.successIcon);
//		} else if (elementFormDisplay.getCssValue("display").equals("block")) {
//			driver.get(i.web);
//			logger.log(LogStatus.FAIL, "Log in unsuccessfully " + i.failIcon);
//		} else {
//			logger.log(LogStatus.FAIL, "Log in CSS display value problem "
//					+ i.failIcon);
//		}
//
//		
//
//		driver.manage().window().maximize(); // Have to maximize or modify the
//												// window size to get contents
//												// shown
//		logger.endTest();
//
//	}
//
//	@BeforeMethod
//	public void beforeMethod() throws InterruptedException {
//
//	}
//	
//	@Test
//	public void meetingTest() throws InterruptedException {
////		MeetingTabService meetingTabService = new MeetingTabService();
////		meetingTabService.meetingTab(driver, logger, i);
////		AdminTabService adminTabService = new AdminTabService();
////		adminTabService.adminTab(driver, logger, i);
////		DriveTabService driveTabService = new DriveTabService();
////		driveTabService.driveTab(driver, logger, i);
//		AccountTabService accountTabService = new AccountTabService();
//		accountTabService.accountTab(driver, logger, i);
//	}
//	
//	@AfterMethod
//	public void afterMethod() throws InterruptedException {
//
//	}
//
//	@AfterTest
//	public void afterTest() throws InterruptedException {
//		// Log out
//		Thread.sleep(2000);
//		String testName = "Sign off with valid info";
//		logger.startTest(testName);
//
//		try {
//			driver.findElement(By.id("logoutTabButton")).click();
//			logger.log(LogStatus.INFO, "Click Log out Button");
//		} catch (Exception e) {
//			logger.log(LogStatus.FAIL, "Failed to click Log out Button"
//					+ i.failIcon);
//		}
//
//		// Check log out if successful
//		Thread.sleep(2000);
//		driver.get(i.web);
//		WebElement elementFormDisplay = driver.findElement(By
//				.id("modalOverlayContainer"));
//		if (elementFormDisplay.getCssValue("display").equals("block")) {
//			logger.log(LogStatus.PASS, "Log out Successfully " + i.successIcon);
//		} else if (elementFormDisplay.getCssValue("display").equals("none")) {
//			logger.log(LogStatus.FAIL, "Log out unsuccessfully " + i.failIcon);
//		} else {
//			logger.log(LogStatus.FAIL, "Log out CSS display value problem "
//					+ i.failIcon);
//		}
//
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		driver.quit();
//		logger.endTest();
//	}
//	
//	
}
