package pageOjects;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

	public static homePageObject getHomePage(WebDriver driver) {
		return new homePageObject(driver);
	}

	public static registerPageObject getRegisterPage(WebDriver driver) {
		return new registerPageObject(driver);
	}

	public static loginPageObject getLoginPage(WebDriver driver) {
		return new loginPageObject(driver);
	}

	public static customerInfoPageObject getCustomerInfoPage(WebDriver driver) {
		return new customerInfoPageObject(driver);
	}

	public static addressesPageObject getAddresesPage(WebDriver driver) {
		return new addressesPageObject(driver);
	}

	public static myProductReviewsPageObject getMyProductReviewsPage(WebDriver driver) {
		return new myProductReviewsPageObject(driver);
	}

	public static ordersPageObject getOrderPage(WebDriver driver) {
		return new ordersPageObject(driver);
	}

	public static rewardPointsPageObject getRewardPointsPage(WebDriver driver) {
		return new rewardPointsPageObject(driver);
	}

	public static stockSubscriptionsObject getStockSubscriptionsPage(WebDriver driver) {
		return new stockSubscriptionsObject(driver);
	}
	
	public static changePasswordPageObject getchangePasswordPage(WebDriver driver) {
		return new changePasswordPageObject(driver);
	}
	
	public static searchFooterPageObject getsearchFooterPage(WebDriver driver) {
		return new searchFooterPageObject(driver);
	}

}
