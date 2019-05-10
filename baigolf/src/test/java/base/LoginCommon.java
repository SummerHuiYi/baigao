package base;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import handle.LoginPageHandle;
import page.LoginPage;

public class LoginCommon {
	
	public boolean login(String webUrl,String user,String paw,String expectedResult,WebDriver driver) {
		driver.get(webUrl);
		LoginPage loginPage=new LoginPage(driver);
		loginPage.zhanghao();
		loginPage.denglu();
		loginPage.user(user);
		loginPage.password(paw);
		loginPage.blue_btn();
		//判断登录成功
		if(loginPage.user_account()&&user.equals(loginPage.getUser_account().getText())) return true;
		else return false;
	}	
}
