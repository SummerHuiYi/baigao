package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import base.BasePage;

public class LoginPage {
	@FindBy(linkText="账号")
	private WebElement zhanghao;//账号按钮
	@FindBy(xpath="/html/body/div[2]/div/div[2]/ul/li[5]/div/div/a[1]/div")
	private WebElement denglu;//登录按钮
	@FindBy(id="user_name")
	private WebElement user; //用户输入框
	@FindBy(id="password")
	private WebElement password; //密码输入框
	@FindBy(className="blue_btn")
	private WebElement blue_btn; //提交按钮
	@FindBy(className="user-account")
	private WebElement user_account; //用户信息的element
	@FindBy(id="prompt_text")
	private WebElement prompt_text;//没有登录成功的element
	
	public WebElement getZhanghao() {
		return zhanghao;
	}
	public WebElement getDenglu() {
		return denglu;
	}
	public WebElement getUser() {
		return user;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getBlue_btn() {
		return blue_btn;
	}
	public WebElement getUser_account() {
		return user_account;
	}
	public WebElement getPrompt_text() {
		return prompt_text;
	}
}
