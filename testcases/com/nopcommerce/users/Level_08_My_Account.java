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
		homePage.clickLinkHeader(driver, "My account");
		customerInfoPage = PageGeneratorManager.getCustomerInfoPage(driver);
		
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
		verifyEquals((customerInfoPage.getTextCompanyTextBox(driver, "value", "Email")), "automationfc.vn@gmail.com");
		verifyEquals(customerInfoPage.getTextCompanyTextBox(driver, "value", "Company"), "Automation FC");
		

	}

	@Test
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
	
	@Test
	public void TC_04_Change_Password() {
		addressPage.clickToAllLinkMyAccount2(driver, "Change password");
		changePasswordPage = PageGeneratorManager.getchangePasswordPage(driver);
		changePasswordPage.InputTextBoxByID(driver, Common_01_Register.pass, "OldPassword");
		changePasswordPage.InputTextBoxByID(driver, "1234567", "NewPassword");
		changePasswordPage.InputTextBoxByID(driver, "1234567", "ConfirmNewPassword");
		changePasswordPage.clickButtonByValue(driver, "Change password");

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

}