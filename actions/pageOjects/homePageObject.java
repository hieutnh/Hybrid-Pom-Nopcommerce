package pageOjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.HomePageUI;

public class homePageObject extends AbstractPage {
	WebDriver driver;

	public homePageObject(WebDriver driver) {
		//lấy biến toàn cục vô biến cục bộ
		this.driver = driver;
	}

	public registerPageObject clickToRegisterLink() {
		waitToElementClickAble(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}

	public loginPageObject clickToLoginLinkHeader() {
		waitToElementClickAble(driver, HomePageUI.LOGIN_LINK_HEADER);
		clickToElement(driver, HomePageUI.LOGIN_LINK_HEADER);
		return PageGeneratorManager.getLoginPage(driver);

	}

	public boolean isDisplayMyAccountLink() {
		waitToElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
	}

	public customerInfoPageObject clickToMyAccountLink() {
		waitToElementClickAble(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getCustomerInfoPage(driver);
	}

	public searchFooterPageObject clickSearchFooter() {
		waitToElementClickAble(driver, HomePageUI.SEARCH_FOOTER_LINK);
		clickToElement(driver, HomePageUI.SEARCH_FOOTER_LINK);
		return PageGeneratorManager.getsearchFooterPage(driver);
	}

}
