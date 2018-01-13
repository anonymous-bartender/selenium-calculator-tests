package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends BaseClass {

	String username;
	String password;

	@FindBy(css="input[type='text']")
	WebElement txtUsername;

	@FindBy (css="input[type='password']")
	WebElement txtPassword;

	@FindBy (css="button")
	WebElement btnLogin;

	public Login (WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	public void setCredentials(String username, String password) {
		this.username=username;
		this.password=password;
	}

	public boolean performLogin() {

		try {
			txtUsername.sendKeys(username);
			txtPassword.sendKeys(password);
			btnLogin.click();
		} catch(Exception e) {
			return false;
		}

		return true;
	}

}
