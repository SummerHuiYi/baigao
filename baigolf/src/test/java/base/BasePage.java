package base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//封装了使用方法
public class BasePage {
	private WebDriver driver;
	private final int timeOut=3;
	public BasePage() {}
	public BasePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, timeOut) , this);
	}

	public void sendkeys(WebElement element,String value,String className,String functionName,String inputBox) {
		try {
			waitExplicit(element);
			element.clear();
			element.sendKeys(value);
			Log.info("类："+className+"；功能："+functionName+"；信息：找到‘"+inputBox+"’输入框");
		}catch (Exception e) {
			ImagesFile.setImage(driver, className, functionName, "没有找到‘"+inputBox+"’输入框");
			Log.error("类："+className+"；功能："+functionName+"；信息：没有找到‘"+inputBox+"’输入框");
		}
	
	}
	public void click(WebElement element,String className,String functionName,String button) {
		try {
			waitExplicit(element);
			element.click();
			Log.info("类："+className+"；功能："+functionName+"；信息：找到‘"+button+"’按钮");
		}catch (Exception e) {
			ImagesFile.setImage(driver, className, functionName, "没有找到‘"+button+"’按钮");
			Log.error("类："+className+"；功能："+functionName+"；信息：没有找到‘"+button+"’按钮");
		}
		
	}
	public void clickAndHold(WebElement element,String className,String functionName,String clickHold) {
		try {
			waitExplicit(element);
			Actions action=new Actions(driver);
			action.clickAndHold(element).perform();
			Log.info("类："+className+"；功能："+functionName+"；信息：找到‘"+clickHold+"’控件");
		}catch (Exception e) {
			ImagesFile.setImage(driver, className, functionName, "没有找到‘"+clickHold+"’控件");
			Log.error("类："+className+"；功能："+functionName+"；信息：没有找到‘"+clickHold+"’控件");			
		}		
	}
	//判断是否找到了元素
	public boolean doesWebElementExist(WebElement element,String className,String functionName,String elementName) {
		try {
			waitExplicit(element);
			Log.info("类："+className+"；功能："+functionName+"；信息：找到‘"+elementName+"’元素");
			return true;
		}catch (Exception e) {
			Log.warn("类："+className+"；功能："+functionName+"；信息：没有找到‘"+elementName+"’元素");
			return false;
		}	
	}
	//显式等待
	public void waitExplicit(WebElement element) {
		new WebDriverWait(driver, timeOut).until(ExpectedConditions.visibilityOf(element));
	}
}
