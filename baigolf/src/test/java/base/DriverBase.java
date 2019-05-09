package base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

//封装了驱动
public class DriverBase {
	protected WebDriver driver;
	public DriverBase() {}
	public WebDriver getWebDriver(String urlNode,String browser, String version, String platform,String className) {
		Log.startTestCase(className);
		DesiredCapabilities dc=desiredCapabilities(browser,version,platform);
		try {
			this.driver=new RemoteWebDriver(new URL(urlNode),new DesiredCapabilities(browser,version,Platform.WINDOWS));			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		return this.driver;
	}

	public DesiredCapabilities desiredCapabilities(String browser, String version,String platform) {
		switch (Integer.parseInt(platform)) {
		case 1:
			return new DesiredCapabilities(browser,version,Platform.WINDOWS);
		case 2:
			return new DesiredCapabilities(browser,version,Platform.LINUX);
		case 3:
			return new DesiredCapabilities(browser,version,Platform.MAC);
		default:
			return new DesiredCapabilities(browser,version,Platform.WINDOWS);
		}
	}
	public void quit(String className) {
		driver.quit();
		Log.endTestCase(className);
	}
	
}
