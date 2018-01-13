package utils;

import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;

public class BROWSER {

	private static String CHROME_binary_win32 = "/src/main/resources/Drivers/Windows/chromedriver.exe";
	private static String CHROME_binary_mac = "";
	private static String FIREFOX_binary="";
	private static int IMPLICIT_WAIT_SECONDS = 20;

	public static WebDriver Chrome() {
		String chrome_binary =System.getProperty("user.dir")+(System.getenv("os").contains("Windows")?
				CHROME_binary_win32:CHROME_binary_mac);
		System.setProperty("webdriver.chrome.driver", chrome_binary);
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_SECONDS, TimeUnit.SECONDS);
		return driver;	
	}

	public static WebDriver Firefox() {
		return null;
	}

	public static WebDriver Safari() {
		return null;
	}

	public static WebDriver BrowserStack(String platform, String os, String browser, String version) {

		WebDriver driver = null;
		return driver;
	}


}
