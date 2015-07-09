package au.com.vclass.init;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;



public class InitAndFunction {

	public final String web = "http://192.168.1.32/git/WebApp/web/cviewer5.html";
	//public final String web = "http://localhost/WebApp/WebApp/web/cviewer5.html";
	public final String chromeDriverPath = "/usr4/workspace4test/Seleniumtests/chromedriver";
	
	public final String validUserName = "julian@vclass.com.au";
	public final String validPassword = "julianpw";
	public final String invalidUserName = "julian@vclass.com";
	public final String invalidPassword = "gg";
	
	public final String successIcon = " <span class='label success'>success</span>";
	public final String failIcon = " <span class='label failure'>fail</span>";
	public final String warningIcon = " <span class='label warn'>warning</span>";
	//public String invalidPassword1_1 = "yu";
	//public CharSequence invalidPassword1_2 = "uu";
	//public String invalidPassword2 = "uuuuuuuu";
	//public String invalidPassword3 = "123";
	//public String invalidPassword4 = "Yu";
	//public String initValidPassword = "Yu123456";
	
	// Custom assertTrue function, add fail to log file
	public void customerAssertT(boolean condition, ExtentReports logger) throws Throwable {
		try {
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			logger.log(LogStatus.FAIL, e.getMessage() + failIcon);
			throw e;
		}
	}
	
	// Custom assertFalse function, add fail to log file
	public void customerAssertF(boolean condition, ExtentReports logger) throws Throwable {
		try {
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			logger.log(LogStatus.FAIL, e.getMessage() + failIcon);
			throw e;
		}
	}
	
	public void draw(WebDriver driver, int x1, int y1, int x2, int y2) {
		Actions moveCell = new Actions(driver);

		moveCell.build();
		// moveCell.moveByOffset(20, 20);//move mouse to upper left corner of
		// graph
		moveCell.moveByOffset(x1, y1);// move mouse to cell we want to move
		moveCell.clickAndHold();// select cell and hold it
		moveCell.moveByOffset(x2, y2);// drag cell
		moveCell.release();// drop it
		moveCell.perform();// run this set of actions
	}
	
}
