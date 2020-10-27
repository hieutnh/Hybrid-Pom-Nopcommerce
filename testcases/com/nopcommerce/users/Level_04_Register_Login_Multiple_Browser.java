package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.AbstractTest;
import pageOjects.customerInfoPageObject;
import pageOjects.homePageObject;
import pageOjects.loginPageObject;
import pageOjects.registerPageObject;

public class Level_04_Register_Login_Multiple_Browser extends AbstractTest {
	WebDriver driver;
	Select select;
	String email, pass, firstname, lastname;

	@Parameters({ "Browser", "url" })
	@BeforeClass
	public void beforeClass(String BrowserName, String appUrl) {
		driver = getBrowserDriver(BrowserName, appUrl);

		firstname = "test";
		lastname = "thoima";
		email = "testthoima" + getRanDom() + "@gmail.com";
		pass = "123456";

	}

	@Test
	public void TC_01_Register() {
		homePage = new homePageObject(driver);
		homePage.clickToRegisterLink();

		registerPage = new registerPageObject(driver);
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
		registerPage.clickToLogOutButton();

		homePage = new homePageObject(driver);

	}

	@Test
	public void TC_02_Log_In() {
		homePage.clickToLoginLinkHeader();

		loginPage = new loginPageObject(driver);
		loginPage.inputToEmailTextBox(email);
		loginPage.inputToPasswordTextBox(pass);
		loginPage.clicktoLoginButton();

		homePage = new homePageObject(driver);
		Assert.assertTrue(homePage.isDisplayMyAccountLink());
		homePage.clickToMyAccountLink();

		customerInfoPage = new customerInfoPageObject(driver);
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

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	customerInfoPageObject customerInfoPage;
	homePageObject homePage;
	loginPageObject loginPage;
	registerPageObject registerPage;

}