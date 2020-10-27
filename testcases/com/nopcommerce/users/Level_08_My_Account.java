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
import pageOjects.customerInfoPageObject;
import pageOjects.homePageObject;
import pageOjects.loginPageObject;
import pageOjects.myProductReviewsPageObject;
import pageOjects.ordersPageObject;
import pageOjects.registerPageObject;
import pageOjects.rewardPointsPageObject;
import pageOjects.stockSubscriptionsObject;

public class Level_08_My_Account extends AbstractTest {
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
	public void TC_01_Login() {
		homePage = PageGeneratorManager.getHomePage(driver);
		loginPage = homePage.clickToLoginLinkHeader();
		loginPage.inputToEmailTextBox(Common_01_Register.email);
		loginPage.inputToPasswordTextBox(Common_01_Register.pass);
		homePage = loginPage.clicktoLoginButton();

	}

	@Test
	public void TC_02_My_Account() throws Exception {
		customerInfoPage = homePage.clickToMyAccountLink();
		customerInfoPage.SeclectedGenderMaleRadio();
		customerInfoPage.inputFirstNameTextBox("Automation");
		customerInfoPage.inputLastNameTextBox("Fc");
		customerInfoPage.selectDayDropDown("1");
		customerInfoPage.selectMonthDropDown("January");
		customerInfoPage.selectYearDropDown("1999");
		customerInfoPage.InputTextBoxByID(driver, "automationfc.vn@gmail.com", "Email");
		customerInfoPage.InputTextBoxByID(driver, "Automation FC", "Company");
		customerInfoPage.clickButtonByValue(driver, "Save");

		verifyTrue(customerInfoPage.isSeclectedGenderMaleRadio());
		verifyEquals(customerInfoPage.getFirstNameInTexBox(), "Automation");
		verifyEquals(customerInfoPage.getLastNameInTexBox(), "Fc");
		verifyEquals(customerInfoPage.getTextInDaytTextBox(), "1");
		verifyEquals(customerInfoPage.getTextInMonthtTextBox(), "January");
		verifyEquals(customerInfoPage.getTextInYearTextBox(), "1999");
		verifyEquals((customerInfoPage.getTextCompanyTextBox(driver, "Email")), "automationfc.vn@gmail.com");
//		verifyEquals((customerInfoPage.getTextCompanyTextBox(driver, "Email")), "automationfc.vn@gmail.com");
//		verifyEquals((customerInfoPage.getTextCompanyTextBox(driver, "Company")), "Automation Fc");
		

	}

	
	public void TC_03_Addresses() {
		addressPage = customerInfoPage.clickToAddressLink(driver);
		addressPage.clickButtonByValue(driver, "Add new");
		addressPage.InputTextBoxByID(driver, "Automation", "Address_FirstName");
		addressPage.InputTextBoxByID(driver, "FC", "Address_LastName");
		addressPage.InputTextBoxByID(driver, "automationfc.vn@gmail.com", "Address_Email");
		addressPage.InputTextBoxByID(driver, "Automation FC", "Address_Company");
		addressPage.selectToDropDownCountry("Viet Nam");
		addressPage.InputTextBoxByID(driver, "HCM City", "Address_City");
		addressPage.InputTextBoxByID(driver, "15/2 Dien Bien Phu", "Address_Address1");
		addressPage.InputTextBoxByID(driver, "20000", "Address_ZipPostalCode");
		addressPage.InputTextBoxByID(driver, "0987654125", "Address_PhoneNumber");
		addressPage.clickButtonByValue(driver, "Save");
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