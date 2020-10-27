package pageOjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.RegisterPageUI;

public class registerPageObject extends AbstractPage {
	public registerPageObject(WebDriver driver) {

		this.driver = driver;
	}

	WebDriver driver;

	public void clickToGenderRadioButton() {
		waitToElementClickAble(driver, RegisterPageUI.GENDER_RADIO_BUTTON);
		clickToElement(driver, RegisterPageUI.GENDER_RADIO_BUTTON);
	}

	public void selectDayOfBirthDropDown(String day) {
		waitToElementVisible(driver, RegisterPageUI.DAY_DROPDOWN);
		selectItemInDropdown(driver, RegisterPageUI.DAY_DROPDOWN, day);

	}

	public Object getSizeDayInlocator() {
		waitToElementVisible(driver, RegisterPageUI.DAY_DROPDOWN);
		return getAllElementInLocator(driver, RegisterPageUI.DAY_DROPDOWN);
	}

	public Object getSizeMonthInlocator() {
		waitToElementVisible(driver, RegisterPageUI.MONTH_DROPDOWN);
		return getAllElementInLocator(driver, RegisterPageUI.MONTH_DROPDOWN);
	}

	public void selectYearOfBirthDropDown(String year) {
		waitToElementVisible(driver, RegisterPageUI.YEAR_DROPDOWN);
		selectItemInDropdown(driver, RegisterPageUI.YEAR_DROPDOWN, year);

	}

	public Object getSizeYearInlocator() {
		waitToElementVisible(driver, RegisterPageUI.YEAR_DROPDOWN);
		return getAllElementInLocator(driver, RegisterPageUI.YEAR_DROPDOWN);
	}

	public void inputEmailToTextBox(String email) {
		waitToElementVisible(driver, RegisterPageUI.EMAIL_TEXBOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXBOX, email);

	}

	public void inputPassToTextBox(String pass) {
		waitToElementVisible(driver, RegisterPageUI.PASSWORD_TEXBOX);
		sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXBOX, pass);

	}

	public void inputConfirmPassToTextBox(String pass) {
		waitToElementVisible(driver, RegisterPageUI.CONFIRMPASSWORD_TEXBOX);
		sendkeyToElement(driver, RegisterPageUI.CONFIRMPASSWORD_TEXBOX, pass);

	}

	public void clickRegisterButton() {
		waitToElementClickAble(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}

	public String getRegisterSuccessMessage() {
		waitToElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_TEXT);
		return getElementText(driver, RegisterPageUI.REGISTER_SUCCESS_TEXT);
	}

	public homePageObject clickToLogOutButton() {
		waitToElementClickAble(driver, RegisterPageUI.LOGOUT_BUTTON);
		clickToElement(driver, RegisterPageUI.LOGOUT_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
	}

	public void inputToFirstName(String firstname) {
		waitToElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firstname);

	}

	public void inputToLastName(String lastname) {
		waitToElementVisible(driver, RegisterPageUI.LAST_NAEM_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.LAST_NAEM_TEXTBOX, lastname);

	}

	public void selectMonthOfBirthDropDown(String year) {
		waitToElementVisible(driver, RegisterPageUI.MONTH_DROPDOWN);
		selectItemInDropdown(driver, RegisterPageUI.MONTH_DROPDOWN, year);
	}

	

	public String errorMessageLeast6() {
		waitToElementVisible(driver, RegisterPageUI.ERROR_MESSAGE_PASS_LEAST_6);
		return getElementText(driver, RegisterPageUI.ERROR_MESSAGE_PASS_LEAST_6);
	}


}
