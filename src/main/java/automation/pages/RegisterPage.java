package automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	
	public void enterFirstName(String firstNameText) {
		firstNameField.sendKeys(firstNameText);
	}
	
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	public void enterLastName(String lastName) {
		lastNameField.sendKeys(lastName);
	}
	
	@FindBy(id="input-email")
	private WebElement emailField;
	public void enterEmail(String email) {
		emailField.sendKeys(email);
	}
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	public void enterTelephone(String telephone) {
		telephoneField.sendKeys(telephone);
	}
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}
	
	@FindBy(id="input-confirm")
	private WebElement confirmField;
	public void enterConfirmPassword(String confirmPassword) {
		confirmField.sendKeys(confirmPassword);
	}
	
	@FindBy(name="agree")
	private WebElement privacyPolicyCB;
	public void checkPrivacyPolicy() {
		privacyPolicyCB.click();
	}

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;
	public AccountSuccessPage clickOnContinueBtn() {
		continueButton.click();
		return new AccountSuccessPage(driver);
	}
	
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	public WebElement newsLetterOption;
	public void checkNewsLetterOption() {
		newsLetterOption.click();
	}
	
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarning;
	public String getFirstNameWarning() {
		return firstNameWarning.getText();
	}
	
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarning;
	public String getLastNameWarning() {
		return lastNameWarning.getText();
	}
	
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarning;
	public String getEmailWarning() {
		return emailWarning.getText();
	}
	
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarning;
	public String getTelephoneWarning() {
		return telephoneWarning.getText();
	}
	
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarning;
	public String getPasswordWarning() {
		return passwordWarning.getText();
	}
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement privacyPolicyWarning;
	public String getPrivacyPolicyWarning() {
		return privacyPolicyWarning.getText();
	}
}
