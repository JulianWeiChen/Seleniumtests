package au.com.vclass.testservice.signin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import au.com.vclass.constants.TestConstants;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class SignInService {
	public static void SignIn(ExtentReports logger, WebDriver webDriver,
			String userStr, String pwdStr, boolean isRemMe) {
		try {
			// Sign In with Invalid Testing Account
			WebElement userName = webDriver.findElement(By
					.id("signin_username"));
			userName.sendKeys(userStr);
			logger.log(LogStatus.INFO, "Input username: " + userStr);
			WebElement pwd = webDriver.findElement(By.id("signin_password"));
			pwd.sendKeys(pwdStr);
			logger.log(LogStatus.INFO, "Input password: " + pwdStr);
			if (isRemMe) {
				WebElement rem = webDriver.findElement(By.id("rememberMe"));
				rem.click();
				logger.log(LogStatus.INFO,
						"Tick Remember Me: " + rem.isSelected());
			}
			WebElement signinBtn = webDriver.findElement(By.id("signin_btn"));
			signinBtn.click();
			logger.log(LogStatus.INFO, "Sign In...");
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, "Sign In Exception!"
					+ TestConstants.FAIL_ICON
					+ TestConstants.FAIL_ICON + "\n" + e.getMessage());
		}
	}

	public static void CheckSignIn(ExtentReports logger, WebDriver webDriver,
			boolean isValid) {
		try {
			// Check Sign In Successfully with 'isValid' User Name and Password
			WebElement elementFormDisplay = webDriver.findElement(By
					.id("modalOverlayContainer"));
			if (elementFormDisplay.getCssValue("display").equals("block")) {
				logger.log(isValid ? LogStatus.FAIL : LogStatus.PASS,
						"Sign In Unsuccessfully "
								+ (isValid ? TestConstants.FAIL_ICON
										: TestConstants.SUCCESS_ICON));
			} else if (elementFormDisplay.getCssValue("display").equals("none")) {
				logger.log(isValid ? LogStatus.PASS : LogStatus.FAIL,
						"Sign In Successfully "
								+ (isValid ? TestConstants.SUCCESS_ICON
										: TestConstants.FAIL_ICON));
			} else {
				logger.log(LogStatus.FAIL, "Sign In CSS display value problem "
						+ TestConstants.FAIL_ICON);
			}
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, "Check Sign In Exception!"
					+ TestConstants.FAIL_ICON
					+ TestConstants.FAIL_ICON + "\n" + e.getMessage());
		}
	}

	public static void CheckSignInAgain(ExtentReports logger,
			WebDriver webDriver) {
		try {
			webDriver.get(TestConstants.WEB_URL);
			WebElement signInBtn = webDriver.findElement(By.id("signin_btn"));
			if (signInBtn != null) {
				signInBtn.click();
				logger.log(LogStatus.INFO, "Sign In Again... ");
				Thread.sleep(3000);
				WebElement elementFormDisplay = webDriver.findElement(By
						.id("modalOverlayContainer"));
				if (elementFormDisplay.getCssValue("display").equals("none")) {
					logger.log(LogStatus.PASS,
							"Sign In with Remember Me Successfully "
									+ TestConstants.SUCCESS_ICON);
				} else if (elementFormDisplay.getCssValue("display").equals(
						"block")) {
					logger.log(LogStatus.FAIL,
							"Sign In with Remember Me Unsuccessfully "
									+ TestConstants.FAIL_ICON);
				} else {
					logger.log(LogStatus.FAIL, "CSS display value problem "
							+ TestConstants.FAIL_ICON);
				}
			} else {
				logger.log(LogStatus.FAIL, "CSS display value problem "
						+ TestConstants.FAIL_ICON);
			}

		} catch (Exception e) {
			logger.log(LogStatus.ERROR, "Sign In with Remember Me Exception!"
					+ TestConstants.FAIL_ICON
					+ TestConstants.FAIL_ICON + "\n" + e.getMessage());
		}
	}

	public static void SignOut(ExtentReports logger, WebDriver webDriver) {
		try {
			webDriver.findElement(By.id("logoutTabButton")).click();
			logger.log(LogStatus.INFO, "Click Log out Button");

		} catch (Exception e) {
			logger.log(LogStatus.ERROR, "Sign Out Exception!"
					+ TestConstants.FAIL_ICON
					+ TestConstants.FAIL_ICON + "\n" + e.getMessage());
		}
	}

	public static void CheckSignOut(ExtentReports logger, WebDriver webDriver) {
		try {
			webDriver.get(TestConstants.WEB_URL);
			WebElement elementFormDisplay = webDriver.findElement(By
					.id("modalOverlayContainer"));
			if (elementFormDisplay.getCssValue("display").equals("block")) {
				logger.log(LogStatus.PASS, "Log out Successfully "
						+ TestConstants.SUCCESS_ICON);
			} else if (elementFormDisplay.getCssValue("display").equals("none")) {
				logger.log(LogStatus.FAIL, "Log out unsuccessfully "
						+ TestConstants.FAIL_ICON);
			} else {
				logger.log(LogStatus.FAIL, "Log out CSS display value problem "
						+ TestConstants.FAIL_ICON);
			}
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, "Check Sign Out Exception!"
					+ TestConstants.FAIL_ICON
					+ TestConstants.FAIL_ICON + "\n" + e.getMessage());
		}

	}
}
