package utils;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

public class Browserstack {

	private String USERNAME = "arghajitb1";
	private String AUTOMATE_KEY = "VN9HDQ9AGqCs3914x4VX";
	private String BROWSER_NAME;
	private String BROWSER_VERSION;
	private String OS_NAME;
	private String OS_VERSION;
	private String RESOLUTION;
	
	private final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
	private Browserstack() {
		//deprecated
	}

	public Browserstack(String USERNAME, String AUTOMATE_KEY) {
		this.USERNAME = USERNAME;
		this.AUTOMATE_KEY = AUTOMATE_KEY;
	}
	
	public void setBROWSER_NAME(String BROWSER_NAME) {this.BROWSER_NAME = BROWSER_NAME;}
	public void setBROWSER_VERSION(String BROWSER_VERSION) {this.BROWSER_VERSION = BROWSER_VERSION;}
	public void setOS_NAME(String OS_NAME) {this.OS_NAME = OS_NAME;}
	public void setOS_VERSION(String OS_VERSION) {this.OS_VERSION = OS_VERSION;}
	public void setRESOLUTION(String RESOLUTION) {this.RESOLUTION = RESOLUTION; }
	
	public DesiredCapabilities getCapabilities() {
		DesiredCapabilities caps = new DesiredCapabilities();
		
	    caps.setCapability("browser", BROWSER_NAME);
	    caps.setCapability("browser_version", BROWSER_VERSION);
	    caps.setCapability("os", OS_NAME);
	    caps.setCapability("os_version", OS_VERSION);
	    caps.setCapability("resolution", RESOLUTION);
	    
	    return caps;
	}
	
	public URL getInstance() {
		
		try {
		return new URL(URL);
		} catch(MalformedURLException me) {
			System.out.println("Remote URL is not right: "+URL);
			me.printStackTrace();
			return null;
		}
	}
}
