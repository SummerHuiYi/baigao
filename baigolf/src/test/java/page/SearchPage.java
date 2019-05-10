package page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.BasePage;
public class SearchPage extends BasePage{
	
	@FindBy(id="course_search")
	private WebElement course_search;//输入地区名称
	@FindBy(className="selectBox-arrow")
	private WebElement selectBox_arrow;// 时间
	@FindBy(linkText="上午")
	private WebElement dateTime;//被选中的时间
	@FindBy(css=".search_table tbody tr td:nth-child(4) .selectBox-arrow")
	private WebElement money;//价格
	@FindBy(linkText="500 - 800")
	private WebElement howMuch;//被选中的价格
	@FindBy(id="hp_search")
	private WebElement hp_search;//搜索
	@FindBy(className="view_map")
	private WebElement view_map;//查看地图；用于判断是否查询成功
	
	
	public SearchPage() {}
	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	public void course_search(String value) {
		this.sendkeys(course_search, value,this.toString(),"高尔夫球场_搜索","地区名称");
	}
	public void selectBox_arrow() {
		this.click(selectBox_arrow,this.toString(),"高尔夫球场_搜索","时间");
	}
	public void dateTime() {
		this.click(dateTime,this.toString(),"高尔夫球场_搜索","被选中的时间");
	}
	public void money() {
		this.click(money,this.toString(),"高尔夫球场_搜索","价格");
	}
	public void howMuch() {
		this.click(howMuch,this.toString(),"高尔夫球场_搜索","被选中的价格");
	}
	public void hp_search() {
		this.click(hp_search,this.toString(),"高尔夫球场_搜索","提交搜索");
	}
	public boolean view_map() {
		return this.doesWebElementExist(view_map,this.toString(),"高尔夫球场_搜索","查看地图");
	}
	
}
