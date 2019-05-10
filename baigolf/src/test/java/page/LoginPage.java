package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import base.BasePage;
import net.bytebuddy.implementation.bind.annotation.Super;

public class LoginPage extends BasePage{
	@FindBy(linkText="账号")
	@CacheLookup //加入缓存，更新值的时候先从缓存中取
	private WebElement zhanghao;//账号按钮
	@FindBy(xpath="/html/body/div[2]/div/div[2]/ul/li[5]/div/div/a[1]/div")
	@CacheLookup //加入缓存，更新值的时候先从缓存中取
	private WebElement denglu;//登录按钮
	@FindBy(id="user_name")
	@CacheLookup //加入缓存，更新值的时候先从缓存中取
	private WebElement user; //用户输入框
	@FindBy(id="password")
	@CacheLookup //加入缓存，更新值的时候先从缓存中取
	private WebElement password; //密码输入框
	@FindBy(className="blue_btn")
	@CacheLookup //加入缓存，更新值的时候先从缓存中取
	private WebElement blue_btn; //提交按钮
	@FindBy(className="user-account")
	@CacheLookup //加入缓存，更新值的时候先从缓存中取
	private WebElement user_account; //用户信息的element
	@FindBy(id="prompt_text")
	@CacheLookup //加入缓存，更新值的时候先从缓存中取
	private WebElement prompt_text;//没有登录成功的element
	
	public LoginPage() {}
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	//模拟鼠标移动到账号元素上
		public void zhanghao() {
			this.clickAndHold(zhanghao,this.toString(),"登录功能","账号");
		}
		//点击登录按钮
		public void denglu() {
			this.click(denglu,this.toString(),"登录功能","登录");
		}
		//输入用户名信息
		public void user(String value) {
			this.sendkeys(user, value,this.toString(),"登录功能","用户名");
		}
		//输入密码
		public void password(String value) {
			this.sendkeys(password, value,this.toString(),"登录功能","密码");
		}
		//登录
		public void blue_btn() {
			this.click(blue_btn,this.toString(),"登录功能","提交登录");
		}
		//判断用户名是否存在
		public boolean user_account() {
			return this.doesWebElementExist(user_account,this.toString(),"登录功能","判断用户名");
		}
		//返回用户名信息元素
		public WebElement getUser_account() {
			return user_account;
		}
		//返回没有登录成功元素
		public WebElement getPrompt_text() {
			return prompt_text;
		}
}
