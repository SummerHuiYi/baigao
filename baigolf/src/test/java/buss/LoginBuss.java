package buss;

import static org.testng.Assert.assertEquals;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import base.DriverBase;
import base.ExcelUtil;
import base.ImagesFile;
import base.Log;
import page.LoginPage;

public class LoginBuss extends DriverBase{
	@Parameters({"urlNode","browser","version","platform"})
	@BeforeMethod
	public void initializingDriver(String urlNode,String browser,String version,String platform) {
		getWebDriver(urlNode, browser, version, platform,LoginBuss.class.getName());	
	}
	
	@Test(dataProvider="longin_data")
	public void login(String caseID,String webUrl,String testData,String expectedResult ) {
		Map<String,String> map=ExcelUtil.analysisData(testData, ",", ":");
		String user="";
		String paw="";
		if(map.get("用户名")!=null) user=map.get("用户名");
		if(map.get("密码")!=(null)) paw=map.get("密码");
		driver.get(webUrl);
		LoginPage loginPage=new LoginPage(driver);
		loginPage.zhanghao();
		loginPage.denglu();
		loginPage.user(user);
		loginPage.password(paw);
		loginPage.blue_btn();
		//判断登录成功&&user.contains(loginPage.getUser_account().getText())
		if(loginPage.user_account()) {
			Log.info("类："+LoginBuss.class.getName()+"；功能：百高-登录；信息：第"+caseID+"用例，登录成功");
			assertEquals(true, true);
		}else {
			if(loginPage.getPrompt_text().getText().equals(expectedResult)) {
				Log.info("类："+LoginBuss.class.getName()+"；功能：百高-登录；信息：第"+caseID+"用例，验证登录失败-成功");
				assertEquals(true, true);
			}
			else {
				ImagesFile.setImage(driver, LoginBuss.class.getName(), "百高-登录", "第"+caseID+"用例，验证登录失败-失败");
				Log.error("类："+LoginBuss.class.getName()+"；功能：百高-登录；信息：第"+caseID+"用例，验证登录失败-失败");
				assertEquals(false, true);
			}
		}

	}
	@DataProvider
	public Object[][] longin_data() {
		return ExcelUtil.getExcelDate("LoginBuss");
	}
	
	@AfterMethod
	public void quit() {
		super.quit(LoginBuss.class.getName());
	}
}