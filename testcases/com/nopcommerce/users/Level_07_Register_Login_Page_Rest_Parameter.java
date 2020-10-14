package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageOjects.PageGeneratorManager;
import pageOjects.addressesPageObject;
import pageOjects.customerInfoPageObject;
import pageOjects.homePageObject;
import pageOjects.loginPageObject;
import pageOjects.myProductReviewsPageObject;
import pageOjects.ordersPageObject;
import pageOjects.registerPageObject;
import pageOjects.rewardPointsPageObject;
import pageOjects.stockSubscriptionsObject;

public class Level_07_Register_Login_Page_Rest_Parameter extends AbstractTest {
	WebDriver driver;
	Select select;
	String email, pass, firstname, lastname;

	//run all browsers
	@Parameters("Browser")
	@BeforeClass
	public void beforeClass(String BrowserName) {
		driver = getBrowserDriver(BrowserName);

		firstname = "test";
		lastname = "thoima";
		email = "testthoima" + getRanDom() + "@gmail.com";
		pass = "123456";

	}

	@Test
	public void TC_01_Register() {
		homePage = PageGeneratorManager.getHomePage(driver);
		registerPage = homePage.clickToRegisterLink();

		registerPage.clickToGenderRadioButton();

		registerPage.inputToFirstName(firstname);

		registerPage.inputToLastName(lastname);

		registerPage.selectDayOfBirthDropDown("1");
		Assert.assertEquals(registerPage.getSizeDayInlocator(), 32);

		registerPage.selectMonthOfBirthDropDown("May");
		Assert.assertEquals(registerPage.getSizeMonthInlocator(), 13);

		registerPage.selectYearOfBirthDropDown("1980");
		Assert.assertEquals(registerPage.getSizeYearInlocator(), 112);

		registerPage.inputEmailToTextBox(email);
		registerPage.inputPassToTextBox(pass);
		registerPage.inputConfirmPassToTextBox(pass);
		registerPage.clickRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		homePage = registerPage.clickToLogOutButton();

	}

	@Test
	public void TC_02_Log_In() {
		loginPage = homePage.clickToLoginButton();
		loginPage.inputToEmailTextBox(email);
		loginPage.inputToPasswordTextBox(pass);
		homePage = loginPage.clicktoLoginButton();

		Assert.assertTrue(homePage.isDisplayMyAccountLink());
		customerInfoPage = homePage.clickToMyAccountLink();
	}

	@Test
	public void TC_03_My_Account() {
		Assert.assertTrue(customerInfoPage.isSeclectedGenderMaleRadio());
		Assert.assertEquals(customerInfoPage.getFirstNameInTexBox(), firstname);
		Assert.assertEquals(customerInfoPage.getLastNameInTexBox(), lastname);
		Assert.assertEquals(customerInfoPage.getTextInDaytTextBox(), "1");
		Assert.assertEquals(customerInfoPage.getTextInMonthtTextBox(), "May");
		Assert.assertEquals(customerInfoPage.getTextInYearTextBox(), "1980");
	}

	@Test
	public void TC_04_Switch_Page() {
		addressPage = customerInfoPage.clickToAddressLink(driver);
		ordersPage = addressPage.clickToOrderLink(driver);
		myProductPage = ordersPage.clickToMyProductPageLink(driver);
		customerInfoPage = myProductPage.clickToCustomerInfoPage(driver);
		rewardPointsPage = customerInfoPage.clickToRewardPoints(driver);
		stockSubscriptionsPage = rewardPointsPage.clickToStockSubcriptions(driver);
		customerInfoPage = rewardPointsPage.clickToCustomerInfoPage(driver);

		
	}
	
	@Test
	public void TC_04_Rest_Parameter_Solution_1() {
		addressPage = (addressesPageObject) customerInfoPage.clickToAllLinkMyAccount1(driver, "Addresses");
		ordersPage = (ordersPageObject) addressPage.clickToAllLinkMyAccount1(driver, "Orders");
		myProductPage = (myProductReviewsPageObject) ordersPage.clickToAllLinkMyAccount1(driver, "My product reviews");
		customerInfoPage = (customerInfoPageObject) myProductPage.clickToAllLinkMyAccount1(driver, "Customer info");
		rewardPointsPage = (rewardPointsPageObject) customerInfoPage.clickToAllLinkMyAccount1(driver, "Reward points");
		stockSubscriptionsPage = (stockSubscriptionsObject) rewardPointsPage.clickToAllLinkMyAccount1(driver, "Back in stock subscriptions");
		customerInfoPage = (customerInfoPageObject) rewardPointsPage.clickToAllLinkMyAccount1(driver, "Customer info");
		ordersPage = (ordersPageObject) customerInfoPage.clickToAllLinkMyAccount1(driver, "Orders");
		
	}
	
	@Test
	public void TC_04_Rest_Parameter_Solution_2() {
		customerInfoPage.clickToAllLinkMyAccount2(driver, "Addresses");
		addressPage = PageGeneratorManager.getAddresesPage(driver);
		
		addressPage.clickToAllLinkMyAccount2(driver, "Orders");
		ordersPage = PageGeneratorManager.getOrderPage(driver);
		
		ordersPage.clickToAllLinkMyAccount2(driver, "My product reviews");
		myProductPage = PageGeneratorManager.getMyProductReviewsPage(driver);
		
		myProductPage.clickToAllLinkMyAccount2(driver, "Customer info");
		customerInfoPage = PageGeneratorManager.getCustomerInfoPage(driver);
		
		customerInfoPage.clickToAllLinkMyAccount2(driver, "Reward points");
		rewardPointsPage = PageGeneratorManager.getRewardPointsPage(driver);
		
		rewardPointsPage.clickToAllLinkMyAccount2(driver, "Back in stock subscriptions");
		stockSubscriptionsPage = PageGeneratorManager.getStockSubscriptionsPage(driver);
		
		rewardPointsPage.clickToAllLinkMyAccount2(driver, "Customer info");
		customerInfoPage = PageGeneratorManager.getCustomerInfoPage(driver);
		
		customerInfoPage.clickToAllLinkMyAccount2(driver, "Orders");
		ordersPage = PageGeneratorManager.getOrderPage(driver);

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

}