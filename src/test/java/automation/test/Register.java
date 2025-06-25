package automation.test;

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
	
	@Test(priority = 1)
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
	
	@Test(priority=2)
	public void verifyRegisterWithAllFields() {
		registerPage.enterFirstName("Co");
		registerPage.enterLastName("cheche");
		registerPage.enterEmail(CommonUtils.generateNewEmail());
		registerPage.enterTelephone("01235434232");
		registerPage.enterPassword("123456");
		registerPage.enterConfirmPassword("123456");
		
		registerPage.checkNewsLetterOption();
		registerPage.checkPrivacyPolicy();
		accountSuccessPage = registerPage.clickOnContinueBtn();
		
		Assert.assertTrue(accountSuccessPage.isLogoutDisplayed());
		
		String expectedHeading = "Your Account Has Been Created!";
		
		Assert.assertEquals(accountSuccessPage.getPageHeadingText(), expectedHeading);
		
		accountPage = accountSuccessPage.clickOnContinue();
		Assert.assertTrue(accountPage.isAccountPageDisplayed());
	}
	
	@Test(priority = 3)
	public void verifyRegisterWithoutFillFields() {
		// click on continue button
		registerPage.clickOnContinueBtn();
		
		String firstNameWarning = "First Name must be between 1 and 32 characters!";
		String lastNameWarning = "Last Name must be between 1 and 32 characters!";
		String emailWarning = "E-Mail Address does not appear to be valid!";
		String telephoneWarning = "Telephone must be between 3 and 32 characters!";
		String passwordWarning = "Password must be between 4 and 20 characters!";
		String privacyPolicyWarning = "Warning: You must agree to the Privacy Policy!";
		
		// "//input[@id='input-firstname']/following-sibling::div"
		Assert.assertEquals(registerPage.getFirstNameWarning(), firstNameWarning);
		Assert.assertEquals(registerPage.getLastNameWarning(), lastNameWarning);
		Assert.assertEquals(registerPage.getEmailWarning(), emailWarning);
		Assert.assertEquals(registerPage.getTelephoneWarning(), telephoneWarning);
		Assert.assertEquals(registerPage.getPasswordWarning(), passwordWarning);
		Assert.assertEquals(registerPage.getPrivacyPolicyWarning(), privacyPolicyWarning);
		
	}

}
