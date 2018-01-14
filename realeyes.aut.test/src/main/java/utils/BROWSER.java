package utils;

import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BROWSER {

	private static String CHROME_binary_win32 = "/src/main/resources/Drivers/Windows/chromedriver_x32.exe";
	private static String CHROME_binary_mac ="/src/main/resources/Drivers/Mac/chromedriver_x64.exe";
	private static String CHROME_binary_nix = "/src/main/resources/Drivers/Linux/chromedriver_x64.exe";
	private static String FIREFOX_binary_win64="/src/main/resources/Drivers/Windows/geckodriver.exe";
	private static String FIREFOX_binary_mac="/src/main/resources/Drivers/Mac/geckodriver.exe";
	private static String FIREFOX_binary_nix="/src/main/resources/Drivers/Linux/geckodriver.exe";
	private static int IMPLICIT_WAIT_SECONDS = 10;

	private static String USER_DIR = System.getProperty("user.dir");
	private static String USER_OS = System.getenv("os");

	public static WebDriver Chrome() {
		String chrome_binary =USER_DIR+
				(USER_OS.contains("Windows")?CHROME_binary_win32
						:(USER_OS.contains("osx")?CHROME_binary_mac
								:CHROME_binary_nix));
		System.setProperty("webdriver.chrome.driver", chrome_binary);
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_SECONDS, TimeUnit.SECONDS);
		return driver;	
	}

	public static WebDriver Firefox() {

		String firefox_binary=USER_DIR+
				(USER_OS.contains("Windows")?FIREFOX_binary_win64
						:(USER_OS.contains("osx")?FIREFOX_binary_mac
								:FIREFOX_binary_nix));

		System.setProperty("webdriver.gecko.driver",firefox_binary);
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");

		//FirefoxProfile firefoxProfile = new FirefoxProfile();
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_SECONDS, TimeUnit.SECONDS);

		return driver;

	}

	public static WebDriver Safari() {
		return null;
	}

	public static WebDriver Remote(Browserstack browserstack) {

		WebDriver driver = new RemoteWebDriver(browserstack.getInstance(),
				browserstack.getCapabilities());
		driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_SECONDS, TimeUnit.SECONDS);
		return driver;
	}


}
