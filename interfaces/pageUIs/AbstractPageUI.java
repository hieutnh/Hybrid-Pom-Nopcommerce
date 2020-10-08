package pageUIs;

public class AbstractPageUI {
	//Nhiều locator để chuyển page (cách 1)
	public static final String ORDER_LINK = "//div[@class='listbox']//a[text()='Orders']";
	public static final String CUSTOMER_INFO_LINK = "//a[text()='Customer info']";
	public static final String My_Product_Review_LINK = "//a[text()='My product reviews']";
	public static final String ADDRESSES_LINK = "//div[@class='listbox']//a[text()='Addresses']";
	public static final String REWARD_POINTS_LINK = "//a[text()='Reward points']";
	public static final String STOCK_SUBCRIPTIONS = "//a[text()='Back in stock subscriptions']";
	
	//Dùng 1 locator duy nhất để chuyển page (cách 2)
	public static final String DYNAMIC_LINK = "//div[@class='listbox']//a[text()='%s']";

}
