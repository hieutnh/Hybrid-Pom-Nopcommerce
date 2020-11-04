package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register;

import commons.AbstractTest;
import pageOjects.PageGeneratorManager;
import pageOjects.addressesPageObject;
import pageOjects.changePasswordPageObject;
import pageOjects.customerInfoPageObject;
import pageOjects.homePageObject;
import pageOjects.loginPageObject;
import pageOjects.myProductReviewsPageObject;
import pageOjects.ordersPageObject;
import pageOjects.registerPageObject;
import pageOjects.rewardPointsPageObject;
import pageOjects.searchFooterPageObject;
import pageOjects.stockSubscriptionsObject;

public class Level_09_Search extends AbstractTest {
	WebDriver driver;
	Select select;
	String email, pass, firstname, lastname, reEmail;

	// run all browsers
	@Parameters({ "Browser", "url" })
	@BeforeClass
	public void beforeClass(String BrowserName, String appUrl) {
		driver = getBrowserDriver(BrowserName, appUrl);

		homePage = PageGeneratorManager.getHomePage(driver);

		loginPage = homePage.clickToLoginLinkHeader();

		loginPage.inputToEmailTextBox(Common_01_Register.email);
		loginPage.inputToPasswordTextBox(Common_01_Register.pass);
		homePage = loginPage.clicktoLoginButton();

	}

	@Test
	public void TC_01_Search_With_Empty_Data() {
		searchFooterPage = homePage.clickSearchFooter();
		searchFooterPage.clickToSearchButtonKeyword();
		verifyEquals(searchFooterPage.getTextErrorMessageEmptySearch(), "Search term minimum length is 3 characters");
		
	}

	@Test
	public void TC_02_Search_With_Data_Not_Exist() {
		searchFooterPage.inputItemNotExist("macbook 2050");
		searchFooterPage.clickToSearchButtonKeyword();
		verifyEquals(searchFooterPage.getTextErrorMessageEmptySearch(), "No products were found that matched your criteria.");
		
	}
	
	@Test
	public void TC_03_Search_With_Data_Exist() {
		searchFooterPage.inputItemNotExist("Lenovo");
		searchFooterPage.clickToSearchButtonKeyword();
		verifyEquals(searchFooterPage.getSizeItemDisplayed(), 2);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	customerInfoPageObject customerInfoPage;
	homePageObject homePage;
	loginPageObject loginPage;
	registerPageObject registerPage;
	addressesPageObject addressPage;
	ordersPageObject ordersPage;
	myProductReviewsPageObject myProductPage;
	rewardPointsPageObject rewardPointsPage;
	stockSubscriptionsObject stockSubscriptionsPage;
	changePasswordPageObject changePasswordPage;
	searchFooterPageObject searchFooterPage;

}