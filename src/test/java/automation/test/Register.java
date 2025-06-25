package automation.test;

import org.openqa.selenium.By;
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
		
		driver.findElement(By.id("input-firstname")).sendKeys("Co");
		driver.findElement(By.id("input-lastname")).sendKeys("cheche");
		driver.findElement(By.id("input-email")).sendKeys(CommonUtils.generateNewEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("0123456789");
		driver.findElement(By.id("input-password")).sendKeys("123456");
		driver.findElement(By.id("input-confirm")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		
		String expectedHeading = "Your Account Has Been Created!";
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='common-success']//h1")).getText(), expectedHeading);
		
		driver.findElement(By.xpath("//a[text()='Continue']")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
	}

}
