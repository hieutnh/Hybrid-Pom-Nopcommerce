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
import pageOjects.customerInfoPageObject;
import pageOjects.homePageObject;
import pageOjects.loginPageObject;
import pageOjects.registerPageObject;

public class Level_05_Register_Login_Generator_Page extends AbstractTest {
	WebDriver driver;
	Select select;
	String email, pass, firstname, lastname;

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

		homePage = new homePageObject(driver);
		// viết các hàm khởi tạo các class trong pageObject vào class PageGeneratorManager
		registerPage = PageGeneratorManager.getRegisterPage(driver);

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

	}

	@Test
	public void TC_02_Log_In() {
		homePage = new homePageObject(driver);
		loginPage = PageGeneratorManager.getLoginPage(driver);

		loginPage.inputToEmailTextBox(email);
		loginPage.inputToPasswordTextBox(pass);
		homePage = PageGeneratorManager.getHomePage(driver);

		Assert.assertTrue(homePage.isDisplayMyAccountLink());
		customerInfoPage = PageGeneratorManager.getCustomerInfoPage(driver);

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