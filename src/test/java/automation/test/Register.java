package automation.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import automation.base.Base;
import automation.utils.pages.AccountPage;
import automation.utils.pages.AccountSuccessPage;
import automation.utils.pages.LandingPage;
import automation.utils.pages.RegisterPage;

public class Register extends Base {

	private WebDriver driver;
	private LandingPage landingPage;
	private RegisterPage registerPage;
	private AccountSuccessPage accountSuccessPage;
	private AccountPage accountPage;
	
	@BeforeMethod
	public void setup() {
		
		// choosing driver
		driver = openBrowserAndApplication();
		landingPage = new LandingPage(driver);
		
		landingPage.clickOnAccountDropDownMenu();
		registerPage = landingPage.clickOnRegisterOption();
	}
	
	@AfterTest
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}

}
