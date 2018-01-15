package tests;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import appModules.Operation;
import pageObjects.Calculator;
import pageObjects.Login;
import utils.BROWSER;
import utils.Browserstack;

public class TestSet2 {

	String USERNAME = "USERNAME";
	String AUTOMATE_KEY="PASS-KEY";
	String BASE_URL = "https://webautomationhw.realeyesit.com/";

	WebDriver driver;
	Login login;
	Calculator calculator;

	@BeforeMethod
	public void _setup() {

		Browserstack bs = new  Browserstack(USERNAME, AUTOMATE_KEY);
		bs.setBROWSER_NAME("Firefox");
		bs.setBROWSER_VERSION("54.0");
		bs.setOS_NAME("OS X");
		bs.setOS_VERSION("Sierra");
		bs.setRESOLUTION("1920x1080");

		driver = BROWSER.Remote(bs);
		driver.navigate().to(BASE_URL);


	}

	@Test(testName="Verify addition operation over Remote")
	public void verifyBSint() {
		login = new Login(driver);
		login.setCredentials("testuser", "testpassword");
		assertEquals("Logged into system",login.performLogin(),true);
		calculator = new Calculator(driver);
		assertEquals(Operation.ADDITION(calculator, "45", "10"),"55");
	}

	@AfterMethod
	public void _teardown() {
		driver.quit();
	}
}
