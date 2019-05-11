package base;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
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

		//判断登录成功&&user.contains(loginPage.getUser_account().getText())
		if(loginPage.user_account()) return true;
		else return false;
	}	
}
