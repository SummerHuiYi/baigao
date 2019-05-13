package page;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Select;

import base.BasePage;
public class SearchPage extends BasePage{
	
	@FindBy(id="course_search")
	private WebElement course_search;//输入地区名称
	@FindBy(className="selectBox-arrow")
	private WebElement selectBox_arrow;// 时间
	@FindBy(linkText="全天")
	private WebElement dateTime;//被选中的时间
	@FindBy(css=".search_table tbody tr td:nth-child(4) .selectBox-arrow")
	private WebElement money;//价格
	@FindBy(linkText="不限")
	private WebElement howMuch;//被选中的价格
	@FindBy(id="hp_search")
	private WebElement hp_search;//搜索
	@FindBy(className="view_map")
	private WebElement view_map;//查看地图；用于判断是否查询成功
	//**************************下面element是订单的element
	private WebElement site;//场地
	@FindBy(className="book_a")
	private WebElement book_a;//预订
	@FindBy(css="#play_time ~ a")
	private WebElement play_time;//具体时间段
	@FindBy(linkText="17:45-18:00")
	private WebElement play_time_value;//具体时间段的值
	@FindBy(css="#player_num ~ a")
	private WebElement player_num;//打球人数
	@FindBy(linkText="3")
	private WebElement player_num_value;//打球人数的值
	@FindAll({@FindBy(css="input[name='player_names[]']")})
	private List<WebElement> player_names;//打球人姓名
	@FindBy(id="co_name")
	private WebElement co_name;//联系人
	@FindBy(id="co_mobile")
	private WebElement co_mobile;//手机号码
	@FindBy(id="my_balance")
	private WebElement last_balance;//账号余额
	@FindBy(css="label[for='pay-3']")
	private WebElement pay_3;//支付宝
	@FindBy(id="pay-1")
	private WebElement pay_1;//银联
	@FindBy(id="pay-7")
	private WebElement pay_7;//visa
	@FindBy(id="c_agree")
	private WebElement c_agree;//我已阅读
	@FindBy(id="co_set_order")
	private WebElement co_set_order;//提交订单
	@FindBy(id="book")
	private WebElement book;//继续订购
	@FindBy(className="order_ok")
	private WebElement order_ok;//支付成功
	
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
	
	public void site(String text) {
		site=this.elm(By.linkText(text),this.toString(),"高尔夫球场_搜索","场地");
		this.click(site, this.toString(), "高尔夫球场_订单", text);
	}
	public void book_a() {
		this.click(book_a, this.toString(), "高尔夫球场_订单", "预订");
	}
	
	public void play_time() {
			this.click(play_time, this.toString(),"高尔夫球场_订单","具体时间段");
	}
	public void play_time_value() {
		this.click(play_time_value, this.toString(),"高尔夫球场_订单","具体时间段的值");
}
	public void player_num(String pn) {
		this.click(player_num, this.toString(),"高尔夫球场_订单","打球人数");
	}
	public void player_num_value(String pn) {
		this.click(player_num_value, this.toString(),"高尔夫球场_订单","打球人数的值");
	}
	public void player_names(String pns,String separator) {
		String[] pnsS=pns.split(separator);
		try{
			int i=0;
			for(WebElement e:player_names) {
				this.sendkeys(e, pnsS[i], this.toString(), "高尔夫球场_订单", "打球人姓名");
				i++;
			}
		}catch (Exception e) {
			System.out.println("打球人姓名出现异常");
		}
		
	}
	public void co_name(String cn) {
		this.sendkeys(co_name, cn, this.toString(), "高尔夫球场_订单", "联系人");
	}
	public void co_mobile(String cm) {
		this.sendkeys(co_mobile, cm, this.toString(),  "高尔夫球场_订单", "手机号码");
	}
	public void last_balance() {
		this.click(last_balance, this.toString(), "高尔夫球场_订单", "账号余额");
	}
	public void pay_3() {
		this.click(pay_3, this.toString(), "高尔夫球场_订单", "支付宝");
	}
	public void pay_1() {
		this.click(pay_1, this.toString(), "高尔夫球场_订单", "银联");
	}
	public void pay_7() {
		this.click(pay_7, this.toString(), "高尔夫球场_订单", "visa");
	}
	public void c_agree() {
		this.click(c_agree, this.toString(), "高尔夫球场_订单", "我已阅读");
	}
	public void co_set_order() {
		this.click(co_set_order, this.toString(), "高尔夫球场_订单", "提交订单");
	}
	public void book() {
		this.click(book, this.toString(), "高尔夫球场_订单", "继续订购");
	}
	public boolean order_ok() {
		return doesWebElementExist(order_ok, this.toString(), "高尔夫球场_订单", "支付成功");
	}
}
