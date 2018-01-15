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

			driver = BROWSER.Chrome();
			driver.navigate().to(BASE_URL);
	}

	@Test (testName = "Verify the multiplication operation")
	public void multiply() {
	
			login = new Login(driver);
			login.setCredentials("testuser", "testpassword");
			assertEquals("Logged into system",login.performLogin(),true);
			calculator = new Calculator(driver);
			assertEquals(Operation.MULTIPLY(calculator, "45", "10"),"450");

	}

	@Test (testName = "Verify that number divided by zero show message")
	public void dividebyzero() {

		login = new Login(driver);
		login.setCredentials("testuser", "testpassword");
		assertEquals("Logged into system",login.performLogin(),true);
		calculator = new Calculator(driver);
		assertEquals(Operation.DIVISION(calculator, "45", "0"),"Cannot divide by 0");

	}

	@AfterMethod
	public void _teardown() {

			driver.quit();

	}


}
