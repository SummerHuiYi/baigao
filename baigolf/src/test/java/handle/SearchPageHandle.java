package handle;
import org.openqa.selenium.WebDriver;
import base.BasePage;
import page.SearchPage;

public class SearchPageHandle extends BasePage{
	public SearchPage searchPage;
	public SearchPageHandle() {
		searchPage=new SearchPage();
	}
	
	public SearchPageHandle(WebDriver driver,SearchPage searchPage) {
		super(driver);
		this.searchPage=searchPage;
	}
	
	public void course_search(String value) {
		this.sendkeys(searchPage.getCourse_search(), value,SearchPageHandle.class.getName(),"高尔夫球场_搜索","地区名称");
	}
	public void selectBox_arrow() {
		this.click(searchPage.getSelectBox_arrow(),SearchPageHandle.class.getName(),"高尔夫球场_搜索","时间");
	}
	public void dateTime() {
		this.click(searchPage.getDateTime(),SearchPageHandle.class.getName(),"高尔夫球场_搜索","被选中的时间");
	}
	public void money() {
		this.click(searchPage.getMoney(),SearchPageHandle.class.getName(),"高尔夫球场_搜索","价格");
	}
	public void howMuch() {
		this.click(searchPage.getHowMuch(),SearchPageHandle.class.getName(),"高尔夫球场_搜索","被选中的价格");
	}
	public void hp_search() {
		this.click(searchPage.getHp_search(),SearchPageHandle.class.getName(),"高尔夫球场_搜索","提交搜索");
	}
	public boolean view_map() {
		return this.doesWebElementExist(searchPage.getView_map(),SearchPageHandle.class.getName(),"高尔夫球场_搜索","查看地图");
	}
}
