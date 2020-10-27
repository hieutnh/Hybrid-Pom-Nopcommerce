package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register;

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

public class Level_08_Login extends AbstractTest {
	WebDriver driver;
	Select select;
	String email, pass, firstname, lastname, reEmail;

	// run all browsers
	@Parameters({ "Browser", "url" })
	@BeforeClass
	public void beforeClass(String BrowserName, String appUrl) {
		driver = getBrowserDriver(BrowserName, appUrl);

	}

	@Test
	public void TC_01_Log_In_Empty_Data() {
		homePage = PageGeneratorManager.getHomePage(driver);
		loginPage = homePage.clickToLoginLinkHeader();
		loginPage.clicktoLoginButton();
		String errorMessageEmptyEmail = loginPage.getTextErrorMessageByID(driver, "Email-error");
		verifyEquals(errorMessageEmptyEmail, "Please enter your email");
	}

	@Test
	public void TC_02_Log_In_Invalid_Email() {
		loginPage.inputToEmailTextBox("testfail");
		loginPage.inputToPasswordTextBox(Common_01_Register.pass);
		loginPage.clicktoLoginButton();
		String errorMessageEmptyEmail = loginPage.getTextErrorMessageByID(driver, "Email-error");
		verifyEquals(errorMessageEmptyEmail, "Wrong email");
	}
	
	@Test
	public void TC_03_Log_In_Email_Not_Register() {
		loginPage.inputToEmailTextBox("testfail@gmail.com");
		loginPage.inputToPasswordTextBox(Common_01_Register.pass);
		loginPage.clicktoLoginButton();
		String errorMessageWrongEmail = loginPage.getTextErrorMessageWrongEmailPassword();
		verifyEquals(errorMessageWrongEmail, "Login was unsuccessful. Please correct the errors and try again.\n" + "No customer account found");
	}
	
	@Test
	public void TC_03_Log_In_Pass_Empty() {
		loginPage.inputToEmailTextBox(Common_01_Register.email);
		loginPage.inputToPasswordTextBox("");
		loginPage.clicktoLoginButton();
		String errorMessageWrongEmail = loginPage.getTextErrorMessageWrongEmailPassword();
		verifyEquals(errorMessageWrongEmail, "Login was unsuccessful. Please correct the errors and try again.\n" + "The credentials provided are incorrect");
	}
	
	@Test
	public void TC_04_Log_In_Wrong_Pass() {
		loginPage.inputToEmailTextBox(Common_01_Register.email);
		loginPage.inputToPasswordTextBox("123457");
		loginPage.clicktoLoginButton();
		String errorMessageWrongEmail = loginPage.getTextErrorMessageWrongEmailPassword();
		verifyEquals(errorMessageWrongEmail, "Login was unsuccessful. Please correct the errors and try again.\n" + "The credentials provided are incorrect");
	}

	@Test
	public void TC_05_Log_In_Success() {
		loginPage = homePage.clickToLoginLinkHeader();
		loginPage.inputToEmailTextBox(Common_01_Register.email);
		loginPage.inputToPasswordTextBox(Common_01_Register.pass);
		homePage = loginPage.clicktoLoginButton();

		Assert.assertTrue(homePage.isDisplayMyAccountLink());
		customerInfoPage = homePage.clickToMyAccountLink();
	}

	
	public void TC_03_My_Account() {
		Assert.assertTrue(customerInfoPage.isSeclectedGenderMaleRadio());
		Assert.assertEquals(customerInfoPage.getFirstNameInTexBox(), firstname);
		Assert.assertEquals(customerInfoPage.getLastNameInTexBox(), lastname);
		Assert.assertEquals(customerInfoPage.getTextInDaytTextBox(), "1");
		Assert.assertEquals(customerInfoPage.getTextInMonthtTextBox(), "May");
		Assert.assertEquals(customerInfoPage.getTextInYearTextBox(), "1980");
	}

	
	public void TC_04_Switch_Page() {
		addressPage = customerInfoPage.clickToAddressLink(driver);
		ordersPage = addressPage.clickToOrderLink(driver);
		myProductPage = ordersPage.clickToMyProductPageLink(driver);
		customerInfoPage = myProductPage.clickToCustomerInfoPage(driver);
		rewardPointsPage = customerInfoPage.clickToRewardPoints(driver);
		stockSubscriptionsPage = rewardPointsPage.clickToStockSubcriptions(driver);
		customerInfoPage = rewardPointsPage.clickToCustomerInfoPage(driver);

	}

	
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