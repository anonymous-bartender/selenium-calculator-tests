package tests;

import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import appModules.Operation;
import pageObjects.Calculator;
import pageObjects.Login;
import utils.BROWSER;

public class TestSet1 {

	String BASE_URL = "https://webautomationhw.realeyesit.com/";
	WebDriver driver;
	Login login;
	Calculator calculator;


	@BeforeMethod
	public void _setup() {

		try {
			driver = BROWSER.Chrome();
			driver.navigate().to(BASE_URL);
		} catch(Exception e) {exception(e);}
	}

	@Test (testName = "Verify the multiplication operation")
	public void multiply() {
		try {		
			login = new Login(driver);
			login.setCredentials("testuser", "testpassword");
			assertEquals("Logged into system",login.performLogin(),true);
			calculator = new Calculator(driver);
			assertEquals(Operation.MULTIPLY(calculator, "45", "10"),"450");
		} catch(Exception e) {exception(e);}
	}

	@Test (testName = "Verify that number divided by zero show message")
	public void dividebyzero() {
		try {
		login = new Login(driver);
		login.setCredentials("testuser", "testpassword");
		assertEquals("Logged into system",login.performLogin(),true);
		calculator = new Calculator(driver);
		assertEquals(Operation.DIVISION(calculator, "45", "0"),"Cannot divide by 0");
	} catch(Exception e) {exception(e);}
	}

	@AfterMethod
	public void _teardown() {
		try {
			driver.quit();
		} catch(Exception e) {exception(e);}
	}

	private void exception(Exception e) {
		System.out.println("EXCEPTION OCCURRED");
		e.printStackTrace();
		assertEquals(false,true);
	}

}
