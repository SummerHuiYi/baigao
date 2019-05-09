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
		LoginPageHandle loginPageHandle=new LoginPageHandle(driver,PageFactory.initElements(driver, LoginPage.class));
		loginPageHandle.zhanghao();
		loginPageHandle.denglu();
		loginPageHandle.user(user);
		loginPageHandle.password(paw);
		loginPageHandle.blue_btn();
		//判断登录成功
		if(loginPageHandle.user_account()&&user.equals(loginPageHandle.getUser_account().getText())) return true;
		else return false;
	}	
}
