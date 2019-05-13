package buss;

import static org.testng.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
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
import base.LoginCommon;
import page.SearchPage;

public class SearchBuss extends DriverBase{
	@Parameters({"urlNode","browser","version","platform"})
	@BeforeMethod
	public void initializingDriver(String urlNode,String browser,String version,String platform) {
		getWebDriver(urlNode, browser, version, platform,SearchBuss.class.getName());
	}
	@Test(dataProvider="search_data")
	private void search(String caseID,String webUrl,String testData,String expectedResult) throws InterruptedException {
		LoginCommon login=new LoginCommon();
		Map<String,String> map=ExcelUtil.analysisData(testData, ",", ":");
		String user="";
		String paw="";
		String courseSearch="广州";
		if(map.get("用户名")!=null) user=map.get("用户名");
		if(map.get("密码")!=(null)) paw=map.get("密码");
		if(map.get("搜索地区或高尔夫球场")!=(null)) courseSearch=map.get("搜索地区或高尔夫球场");
		//判断用户是否登录成功
		boolean b=login.login(webUrl, user, paw, expectedResult, driver);
		if(!b) {
			ImagesFile.setImage(driver, SearchBuss.class.getName(), "高尔夫球场-搜索", "第"+caseID+"用例，登录失败");
			Log.error("类："+SearchBuss.class.getName()+"；功能：高尔夫球场-搜索；信息：第"+caseID+"用例，登录失败");
			assertEquals(false, true);
		}else { 
			Log.info("类："+SearchBuss.class.getName()+"；功能：高尔夫球场-搜索；信息：第"+caseID+"用例，登录成功");
			assertEquals(true, true);
		}
		SearchPage searchPage=new SearchPage(driver);
		//搜索地区或高尔夫球场
		searchPage.course_search(courseSearch);
		//日期
		Date date=new Date(); 
		SimpleDateFormat ft=new SimpleDateFormat("yyyy-MM-dd"); 
		//无法利用Finby自定义数据初始化element
		//使用javascript写入今天
		((JavascriptExecutor)driver).executeScript("$('input[id=datetimepicker]').attr('readonly',false).val('"+ft.format(
				  date)+"')");
		//时间
		searchPage.selectBox_arrow();
		searchPage.dateTime();
		//价格
		searchPage.money();
		searchPage.howMuch();
		//点击搜索
		searchPage.hp_search();
		//判断是否搜索成功
		assertEquals(searchPage.view_map(), true);
		orderForm(searchPage,map);
		
	}
	
	public void orderForm(SearchPage searchPage,Map<String,String> map) {
		//获取当前窗口
		String wh1=driver.getWindowHandle();
		String site=map.get("场地");
		//点击你订购的场地
		searchPage.site(site);
		Set<String> handles=driver.getWindowHandles();
		//判断是否场地的窗口
		for(String handle:handles) {
			if(!wh1.equals(handle)) {
				driver.switchTo().window(handle);
				//点击定扣
				searchPage.book_a();
			}
		}
		//具体时段
		String pt="";
		if(map.get("具体时段")!=null) {
			pt=map.get("具体时段");
		}
		searchPage.play_time();
		//具体时段的值
		searchPage.play_time_value();
		//打球人数
		String pn=null;
		if(map.get("打球人数")!=null) {
			pn=map.get("打球人数");
		}
		searchPage.player_num(pn);
		//打球人数的值
		searchPage.player_num_value(pn);
		//打球人姓名
		String pns=null;
		if(map.get("打球人姓名")!=null) {
			pns=map.get("打球人姓名");
		}
		searchPage.player_names(pns, "、");
		//联系人
		String cn=null;
		if(map.get("联系人")!=null) {
			cn=map.get("联系人");
		}
		searchPage.co_name(cn);
		//手机号码
		String cm=null;
		if(map.get("手机号码")!=null) {
			cm=map.get("手机号码");
		}
		searchPage.co_mobile(cm);
		//账号余额
		if(map.get("账号余额")!=null) {
			searchPage.last_balance();
		}
		//支付宝
		if(map.get("支付宝")!=null) {
			searchPage.pay_3();
		}
		//银联
		if(map.get("银联")!=null) {
			searchPage.pay_1();
		}
		//visa
		if(map.get("visa")!=null) {
			searchPage.pay_7();
		}
		//我已阅读
		searchPage.c_agree();
		//提交订单
		searchPage.co_set_order();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//继续订购
		searchPage.book();
		//支付成功
		boolean order_ok=searchPage.order_ok();
		assertEquals(order_ok, true);
	}
	
	@DataProvider
	public Object[][] search_data() {
		return ExcelUtil.getExcelDate("SearchBuss");
	}
	@AfterMethod
	public void quit() {
//		super.quit(SearchBuss.class.getName());
	}
}
