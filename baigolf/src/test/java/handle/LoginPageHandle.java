package handle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import base.BasePage;
import page.LoginPage;


public class LoginPageHandle extends BasePage{
	public LoginPage loginPage;
	
	public LoginPageHandle() {
		loginPage=new LoginPage();
	}
	
	public LoginPageHandle(WebDriver driver,LoginPage loginPage) {
		super(driver);
		this.loginPage=loginPage;
	}	
	//模拟鼠标移动到账号元素上
	public void zhanghao() {
		this.clickAndHold(loginPage.getZhanghao(),LoginPageHandle.class.getName(),"登录功能","账号");
	}
	//点击登录按钮
	public void denglu() {
		this.click(loginPage.getDenglu(),LoginPageHandle.class.getName(),"登录功能","登录");
	}
	//输入用户名信息
	public void user(String value) {
		this.sendkeys(loginPage.getUser(), value,LoginPageHandle.class.getName(),"登录功能","用户名");
	}
	//输入密码
	public void password(String value) {
		this.sendkeys(loginPage.getPassword(), value,LoginPageHandle.class.getName(),"登录功能","密码");
	}
	//登录
	public void blue_btn() {
		this.click(loginPage.getBlue_btn(),LoginPageHandle.class.getName(),"登录功能","提交登录");
	}
	//判断用户名是否存在
	public boolean user_account() {
		return this.doesWebElementExist(loginPage.getUser_account(),LoginPageHandle.class.getName(),"登录功能","判断用户名");
	}
	//返回用户名信息元素
	public WebElement getUser_account() {
		return loginPage.getUser_account();
	}
	//返回没有登录成功元素
	public WebElement getPrompt_text() {
		return loginPage.getPrompt_text();
	}
}
