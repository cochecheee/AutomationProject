package automation.utils.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// create element
	
	// Dropdown Menu
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;

	public void clickOnAccountDropDownMenu() {
		myAccountDropMenu.click();
	}
	
	//Register Option
	@FindBy(linkText="Register")
	private WebElement registerOption;
	
	public RegisterPage clickOnRegisterOption() {
		registerOption.click();
		return new RegisterPage(driver);
	}
}
