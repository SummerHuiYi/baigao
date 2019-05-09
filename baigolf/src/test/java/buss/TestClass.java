package buss;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestClass {
	 @Test
	public void test() {
		System.setProperty("webdriver.chrome.driver", "src/test/java/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1,  TimeUnit .MINUTES);
		driver.get("https://www.baigolf.com/");
		WebElement se=driver.findElement(By.cssSelector("select[name='time']"));
		((JavascriptExecutor)driver).executeScript("$('.test').attr('display','block').css('display','block')");
		Select select=new Select(se);
		select.selectByIndex(2);
	}
}
