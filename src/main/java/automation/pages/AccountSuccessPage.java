package automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {
	private WebDriver driver;
	
	public AccountSuccessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Logout")
	private WebElement logOutOption;
	public boolean isLogoutDisplayed() {
		return logOutOption.isDisplayed();
	}
	
	@FindBy(xpath = "//div[@id='common-success']//h1")
	private WebElement pageHeading;
	public String getPageHeadingText() {
		return pageHeading.getText();
	}
	
	@FindBy(xpath="//a[text()='Continue']")
	private WebElement continueButton;
	public AccountPage clickOnContinue() {
		continueButton.click();
		return new AccountPage(driver);
	}
}
