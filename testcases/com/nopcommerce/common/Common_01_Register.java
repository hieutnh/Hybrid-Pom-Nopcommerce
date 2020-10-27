package com.nopcommerce.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
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

public class Common_01_Register extends AbstractTest {
	WebDriver driver;
	Select select;
	public static String email, pass, firstname, lastname, reEmail;

	// run all browsers
	@Parameters({ "Browser", "url" })
	@BeforeTest
	public void beforeClass(String BrowserName, String appUrl) {
		driver = getBrowserDriver(BrowserName, appUrl);

		firstname = "test";
		lastname = "thoima";
		email = "testthoima" + getRanDom() + "@gmail.com";
		pass = "123456";
		reEmail = "testthoima@gmail.com";
	}

	@Test
	public void TC_01_Register_Empty_Data() {
		homePage = PageGeneratorManager.getHomePage(driver);
		registerPage = homePage.clickToRegisterLink();
		registerPage.clickRegisterButton();
		String FirstName_error = registerPage.getTextErrorMessageByID(driver, "FirstName-error");
		verifyEquals(FirstName_error, "First name is required.");

		String LastName_error = registerPage.getTextErrorMessageByID(driver, "LastName-error");
		verifyEquals(LastName_error, "Last name is required.");

		String Email_error = registerPage.getTextErrorMessageByID(driver, "Email-error");
		verifyEquals(Email_error, "Email is required.");

		String Password_error = registerPage.getTextErrorMessageByID(driver, "Password-error");
		verifyEquals(Password_error, "Password is required.");

		String ConfirmPassword_error = registerPage.getTextErrorMessageByID(driver, "ConfirmPassword-error");
		verifyEquals(ConfirmPassword_error, "Password is required.");

	}

	@Test
	public void TC_02_Register_Wrong_Email() {
		registerPage.clickToGenderRadioButton();

		registerPage.inputToFirstName(firstname);

		registerPage.inputToLastName(lastname);

		registerPage.selectDayOfBirthDropDown("1");
		Assert.assertEquals(registerPage.getSizeDayInlocator(), 32);

		registerPage.selectMonthOfBirthDropDown("May");
		Assert.assertEquals(registerPage.getSizeMonthInlocator(), 13);

		registerPage.selectYearOfBirthDropDown("1980");
		Assert.assertEquals(registerPage.getSizeYearInlocator(), 112);

		registerPage.inputEmailToTextBox("taotest");
		registerPage.inputPassToTextBox(pass);
		registerPage.inputConfirmPassToTextBox(pass);
		registerPage.clickRegisterButton();
		String ConfirmPassword_error = registerPage.getTextErrorMessageByID(driver, "Email-error");
		verifyEquals(ConfirmPassword_error, "Wrong email");
	}

	@Test
	public void TC_03_Register_Pass_At_Least_6() {
		registerPage.inputEmailToTextBox(email);
		
		registerPage.inputPassToTextBox("1");
		registerPage.inputConfirmPassToTextBox("1");
		registerPage.clickRegisterButton();
		String Password_At_Least_6 = registerPage.errorMessageLeast6();
		verifyEquals(Password_At_Least_6, "Password must meet the following rules:\n" + "must have at least 6 characters");
		
	}
	@Test
	public void TC_04_Register_Succes() {
		registerPage.inputToFirstName(firstname);

		registerPage.inputToLastName(lastname);

		registerPage.inputEmailToTextBox(email);
		registerPage.inputPassToTextBox(pass);
		registerPage.inputConfirmPassToTextBox(pass);
		registerPage.clickRegisterButton();
		homePage = registerPage.clickToLogOutButton();
		removeDriver();
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