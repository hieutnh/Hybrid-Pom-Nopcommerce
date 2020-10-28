package pageOjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AbstractPageUI;
import pageUIs.AddressesPageUI;

public class addressesPageObject extends AbstractPage {
	WebDriver driver;

	public addressesPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectToDropDownCountry(String itemValue) {
		waitToElementVisible(driver, AddressesPageUI.SELECT_DROPDOWN_COUNTRY);
		selectItemInDropdown(driver, AddressesPageUI.SELECT_DROPDOWN_COUNTRY, itemValue);
	}

}