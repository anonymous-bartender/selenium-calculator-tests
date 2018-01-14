package pageObjects;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Calculator extends BaseClass{

	//findby buttons and fields

	@FindBy(css="span.result-val")
	WebElement resultOutput;

	@FindBy(css = ".buttons>button")
	List<WebElement> btnCalculator;

	@FindBy(css = ".buttons>select")
	WebElement cmbOperations;

	public Calculator (WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);	
	}

	public void setOperator(String operator) {
		Select op = new Select(cmbOperations);
		op.selectByValue(operator);
	}

	public void sendKeys(String number) {
		for(int i =0;i<number.length();i++) {
			for(WebElement e:btnCalculator) {
				char s = e.getText().trim().charAt(0);
				char r = number.charAt(i);

				if(s==r) {
					System.out.println("clicked");
					//e.click();
					/*
					 * selenium click() will fail because of the 
					 * overlay status bar containing the logout button.
					 */
					((JavascriptExecutor)driver).executeScript("arguments[0].click();", e);
					break;
				}
			}
		}
	}


	public String getOutput() {
		String output;
		try {
			output = WaitforVisibleElement(resultOutput).getText();
		} catch (Exception e1) {
			output = "Result not found on time.";
			e1.printStackTrace();
		}

		return output;
	}

	public boolean clear( ) {
		try {
			sendKeys("c");
			return true;
		}catch(Exception e) {return false;}
	}

	public String getAlertMessage() {
		Alert alert = driver.switchTo().alert();
		String value = alert.getText();
		alert.accept();
		return value;
	}
}
