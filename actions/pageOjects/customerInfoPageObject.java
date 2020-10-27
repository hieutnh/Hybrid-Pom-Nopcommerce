package pageOjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.CustomerInfoPageUI;

public class customerInfoPageObject extends AbstractPage {
	WebDriver driver;

	public customerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getFirstNameInTexBox() {
		waitToElementVisible(driver, CustomerInfoPageUI.FIRST_NAME_TEXTBOX);
		return getElementAttribute(driver, CustomerInfoPageUI.FIRST_NAME_TEXTBOX, "value");
	}

	public String getLastNameInTexBox() {
		waitToElementVisible(driver, CustomerInfoPageUI.LAST_NAME_TEXTBOX);
		return getElementAttribute(driver, CustomerInfoPageUI.LAST_NAME_TEXTBOX, "value");
	}

	public String getTextInDaytTextBox() {
		waitToElementVisible(driver, CustomerInfoPageUI.DAY_DROPDOWN);
		return getSelectedItemInDropdown(driver, CustomerInfoPageUI.DAY_DROPDOWN);
	}

	public String getTextInMonthtTextBox() {
		waitToElementVisible(driver, CustomerInfoPageUI.MONTH_DROPDOWN);
		return getSelectedItemInDropdown(driver, CustomerInfoPageUI.MONTH_DROPDOWN);
	}

	public String getTextInYearTextBox() {
		waitToElementVisible(driver, CustomerInfoPageUI.YEAR_DROPDOWN);
		return getSelectedItemInDropdown(driver, CustomerInfoPageUI.YEAR_DROPDOWN);
	}

	public boolean isSeclectedGenderMaleRadio() {
		waitToElementVisible(driver, CustomerInfoPageUI.GENDER_RADIO_BUTTON);
		return isElementDisplayed(driver, CustomerInfoPageUI.GENDER_RADIO_BUTTON);
	}

	public void inputFirstNameTextBox(String value) {
		waitToElementVisible(driver, CustomerInfoPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, CustomerInfoPageUI.FIRST_NAME_TEXTBOX, value);
	}

	public void inputLastNameTextBox(String value) {
		waitToElementVisible(driver, CustomerInfoPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, CustomerInfoPageUI.LAST_NAME_TEXTBOX, value);
	}

	public void selectDayDropDown(String itemValue) {
		waitToElementVisible(driver, CustomerInfoPageUI.DAY_DROPDOWN);
		selectItemInDropdown(driver, CustomerInfoPageUI.DAY_DROPDOWN, itemValue);
	}

	public void selectMonthDropDown(String itemValue) {
		waitToElementVisible(driver, CustomerInfoPageUI.MONTH_DROPDOWN);
		selectItemInDropdown(driver, CustomerInfoPageUI.MONTH_DROPDOWN, itemValue);
	}

	public void selectYearDropDown(String itemValue) {
		waitToElementVisible(driver, CustomerInfoPageUI.YEAR_DROPDOWN);
		selectItemInDropdown(driver, CustomerInfoPageUI.YEAR_DROPDOWN, itemValue);
	}

	public void SeclectedGenderMaleRadio() {
		waitToElementVisible(driver, CustomerInfoPageUI.GENDER_RADIO_BUTTON);
		clickToElement(driver, CustomerInfoPageUI.GENDER_RADIO_BUTTON);
	}

}
