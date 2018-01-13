package tests;

import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
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

	@BeforeTest
	public void _setup() {

		driver = BROWSER.Chrome();
		driver.navigate().to(BASE_URL);
	}

	@Test (description = "")
	public void multiply() {
		login = new Login(driver);
		login.setCredentials("testuser", "testpassword");
		assertEquals("Logged into system",login.performLogin(),true);
		calculator = new Calculator(driver);
		assertEquals(Operation.MULTIPLY(calculator, "45", "10"),"450");
	}
	
	@Test (description = "")
	public void devidebyzero() {
		login = new Login(driver);
		login.setCredentials("testuser", "testpassword");
		assertEquals("Logged into system",login.performLogin(),true);
		calculator = new Calculator(driver);
		assertEquals(Operation.DEVISION(calculator, "45", "0"),"Cannot devide by 0");
		//calculator.sendKeys("45698712.236");
	}
	
	@AfterTest
	public void _teardown() {
		driver.quit();
	}

}
