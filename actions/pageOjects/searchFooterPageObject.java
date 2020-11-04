package pageOjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.searchFooterPageUI;

public class searchFooterPageObject extends AbstractPage {
	public searchFooterPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	WebDriver driver;

	public void clickToSearchButtonKeyword() {
		waitToElementClickAble(driver, searchFooterPageUI.SEARCH_KEYWORD_BUTTON);
		clickToElement(driver, searchFooterPageUI.SEARCH_KEYWORD_BUTTON);
	}

	public void inputItemNotExist(String value) {
		waitToElementVisible(driver, searchFooterPageUI.SEARCH_KEYWORK_TEXTBOX);
		sendkeyToElement(driver, searchFooterPageUI.SEARCH_KEYWORK_TEXTBOX, value);
	}

	public String getTextErrorMessageEmptySearch() {
		waitToElementVisible(driver, searchFooterPageUI.ERROR_MESSAGE_SEARCH_EMPTY);
		return getElementText(driver, searchFooterPageUI.ERROR_MESSAGE_SEARCH_EMPTY);
	}

	public Object getSizeItemDisplayed() {
		waitToElementVisible(driver, searchFooterPageUI.NUMBER_ITEM_DISPLAY);
		return getElements(driver, searchFooterPageUI.NUMBER_ITEM_DISPLAY).size();
	}

}
