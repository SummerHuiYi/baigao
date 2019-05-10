package buss;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class TestBuss {
	
	@Test
	public void test() {
		DesiredCapabilities dc=new DesiredCapabilities("chrome", "73.0.3683.103", Platform.WINDOWS);
		try {
			WebDriver driver=new RemoteWebDriver(new URL("http://192.168.100.7:5555/wd/hub"), dc);
			driver.manage().window().maximize();
			driver.get("http://www.baidu.com/");
			driver.findElement(By.id("kw")).sendKeys("jenkins");
			driver.findElement(By.id("su")).click();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
