package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//封装了使用方法
public class BasePage {
	protected WebDriver driver;
	private final int timeOut=10;
	public BasePage() {}
	public BasePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver , this);
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
	public WebElement elm(By by,String className,String functionName,String elment) {
		WebElement el=null;
		try {
			el=driver.findElement(by);
			waitExplicit(el);
			Log.info("类："+className+"；功能："+functionName+"；信息：找到‘"+elment+"’element");
		}catch (Exception e){
			ImagesFile.setImage(driver, className, functionName, "没有找到‘"+elment+"’element");
			Log.error("类："+className+"；功能："+functionName+"；信息：没有找到‘"+elment+"’element");
		}
		
		return el;
		
	}
	public void selectText(WebElement element,String text,String className,String functionName,String sT) {
		try {
			waitExplicit(element);
			Select select =new Select(element);
			select.deselectByVisibleText(text);
			Log.info("类："+className+"；功能："+functionName+"；信息：找到‘"+sT+"’下拉栏");
		}catch (Exception e){
			ImagesFile.setImage(driver, className, functionName, "没有找到‘"+sT+"’下拉栏");
			Log.error("类："+className+"；功能："+functionName+"；信息：没有找到‘"+sT+"’下拉栏");
		}
	}
	public void selectIndex(WebElement element,String text,String className,String functionName,String sI) {
		try {
			waitExplicit(element);
			Select select =new Select(element);
			select.deselectByIndex(Integer.parseInt(text));
			Log.error("类："+className+"；功能："+functionName+"；信息：找到‘"+sI+"’下拉栏");
		}catch (Exception e){
			ImagesFile.setImage(driver, className, functionName, "没有找到‘"+sI+"’下拉栏");
			Log.error("类："+className+"；功能："+functionName+"；信息：没有找到‘"+sI+"’下拉栏");
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
