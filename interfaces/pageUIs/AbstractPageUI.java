package pageUIs;

public class AbstractPageUI {
	//Nhiều locator để chuyển page (cách 1)
	public static final String ORDER_LINK = "//div[@class='listbox']//a[text()='Orders']";
	public static final String CUSTOMER_INFO_LINK = "//a[text()='Customer info']";
	public static final String My_Product_Review_LINK = "//a[text()='My product reviews']";
	public static final String ADDRESSES_LINK = "//div[@class='listbox']//a[text()='Addresses']";
	public static final String REWARD_POINTS_LINK = "//a[text()='Reward points']";
	public static final String STOCK_SUBCRIPTIONS = "//a[text()='Back in stock subscriptions']";
	
	public static final String UPLOAD_FILE_TYPE = "//input[@type='file']";
	
	//Dùng 1 locator duy nhất để chuyển page (cách 2)
	public static final String DYNAMIC_LINK_LIST_MY_ACCOUNT = "//div[@class='listbox']//a[text()='%s']";

	public static final String DYNAMIC_ERROR_MESSAGE_TEXT = "//span[@id='%s']";
	
	public static final String DYNAMIC_BUTTON_BY_VALUE = "//input[@value='%s']";
	
	public static final String DYNAMIC_CUSTOMERINFO_TEXTBOX = "//div[@class='inputs']//input[@id='%s']";
	
	public static final String DYNAMIC_LIST_LINK_HEADER = "//div[@class='header-links']//a[text()='My account']";
}
