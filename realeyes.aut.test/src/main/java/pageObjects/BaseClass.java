package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BaseClass {
	
	
	WebDriver driver;
	
	public BaseClass (WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public String getURL() {
		return driver.getCurrentUrl();
	}
	
	public WebElement WaitforVisibleElement(WebElement e, int TimeOut, int interval) throws Exception {

		WebDriverWait wait= new WebDriverWait(driver,30000);  
		return wait.withTimeout(TimeOut, TimeUnit.SECONDS)
		.pollingEvery(interval, TimeUnit.MILLISECONDS)
		.ignoring(NoSuchElementException.class)
		.ignoring(StaleElementReferenceException.class)
		.ignoring(ElementNotVisibleException.class)
		.until(ExpectedConditions.visibilityOf(e));

	}

	public void WaitforVisible(WebElement e) throws Exception {

		int TimeOut=5, interval=100;
		
		WebDriverWait wait= new WebDriverWait(driver,30000);  
		wait.withTimeout(TimeOut, TimeUnit.SECONDS)
		.pollingEvery(interval, TimeUnit.MILLISECONDS)
		.ignoring(NoSuchElementException.class)
		.ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.visibilityOf(e));

	}
	
	public WebElement WaitforVisibleElement(WebElement e) throws Exception {
		
		int TimeOut=5, interval=100;

		WebDriverWait wait= new WebDriverWait(driver,30000);  
		return wait.withTimeout(TimeOut, TimeUnit.SECONDS)
		.pollingEvery(interval, TimeUnit.MILLISECONDS)
		.ignoring(NoSuchElementException.class)
		.ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.visibilityOf(e));

	}

}
