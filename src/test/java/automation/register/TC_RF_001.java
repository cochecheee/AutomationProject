package automation.register;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.base.Base;
import automation.utils.CommonUtils;
import automation.pages.AccountPage;
import automation.pages.AccountSuccessPage;
import automation.pages.LandingPage;
import automation.pages.RegisterPage;

public class TC_RF_001 extends Base{
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
	
	@Test
	public void verifyRegisterWithMandatoryFields() {
		
		registerPage.enterFirstName("Co");
		registerPage.enterLastName("cheche");
		registerPage.enterEmail(CommonUtils.generateNewEmail());
		registerPage.enterTelephone("012345604");
		registerPage.enterPassword("123456");
		registerPage.enterConfirmPassword("123456");
		
		registerPage.checkPrivacyPolicy();
		accountSuccessPage = registerPage.clickOnContinueBtn();
		
		Assert.assertTrue(accountSuccessPage.isLogoutDisplayed());
		
		String expectedHeading = "Your Account Has Been Created!";
		
		Assert.assertEquals(accountSuccessPage.getPageHeadingText(), expectedHeading);
		
		accountPage = accountSuccessPage.clickOnContinue();
		Assert.assertTrue(accountPage.isAccountPageDisplayed());
		
	}

}
