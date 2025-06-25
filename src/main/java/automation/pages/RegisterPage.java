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
	public WebElement continueButton;
	public AccountSuccessPage clickOnContinueBtn() {
		continueButton.click();
		return new AccountSuccessPage(driver);
	}
}
