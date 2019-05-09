package buss;

import static org.testng.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

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
import handle.SearchPageHandle;
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
		SearchPageHandle searchPageHandle=new SearchPageHandle(driver, PageFactory.initElements(driver,SearchPage.class));
;		//搜索地区或高尔夫球场
		searchPageHandle.course_search(courseSearch);
		//日期
		Date date=new Date(); 
		SimpleDateFormat ft=new SimpleDateFormat("yyyy-MM-dd"); 
		//无法利用Finby自定义数据初始化element
		//使用javascript写入今天
		((JavascriptExecutor)driver).executeScript("$('input[id=datetimepicker]').attr('readonly',false).val('"+ft.format(
				  date)+"')");
		//时间
		searchPageHandle.selectBox_arrow();
		searchPageHandle.dateTime();
		//价格
		searchPageHandle.money();
		searchPageHandle.howMuch();
		//点击搜索
		searchPageHandle.hp_search();
		//判断是否搜索成功
		assertEquals(searchPageHandle.view_map(), true);
		
	}
	@DataProvider
	public Object[][] search_data() {
		return ExcelUtil.getExcelDate("SearchBuss");
	}
	@AfterMethod
	public void quit() {
		super.quit(SearchBuss.class.getName());
	}
}
