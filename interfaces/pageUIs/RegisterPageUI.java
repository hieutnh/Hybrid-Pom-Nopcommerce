package pageUIs;

public class RegisterPageUI {
	public static final String GENDER_RADIO_BUTTON = "//input[@id='gender-male']";
	public static final String FIRST_NAME_TEXTBOX = "//input[@id='FirstName']";
	public static final String LAST_NAEM_TEXTBOX = "//input[@id='LastName']";
	public static final String DAY_DROPDOWN = "//select[@name='DateOfBirthDay']";
	public static final String MONTH_DROPDOWN = "//select[@name='DateOfBirthMonth']";
	public static final String YEAR_DROPDOWN = "//select[@name='DateOfBirthYear']";
	public static final String EMAIL_TEXBOX = "//input[@id='Email']";
	public static final String PASSWORD_TEXBOX = "//input[@id='Password']";
	public static final String CONFIRMPASSWORD_TEXBOX = "//input[@id='ConfirmPassword']";
	public static final String REGISTER_BUTTON = "//input[@id='register-button']";
	public static final String REGISTER_SUCCESS_TEXT = "//div[@class='result']";
	public static final String LOGOUT_BUTTON = "//a[contains(text(),'Log out')]";
	
	public static final String ERROR_MESSAGE_EMAIL_ALREADY_TEXT = "//div[contains(@class,'message-error')]//li";
	public static final String ERROR_MESSAGE_PASS_LEAST_6 = "//p[contains(text(),'Password')]//ancestor::span[@class='field-validation-error']";
	
	
	
	

}
