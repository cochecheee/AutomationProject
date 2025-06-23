package automation.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.base.Base;
import automation.utils.CommonUtils;
import automation.utils.pages.LandingPage;
import automation.utils.pages.RegisterPage;

public class TC_RF_001 extends Base{
	private WebDriver driver;
	private LandingPage landingPage;
	private RegisterPage registerPage;
	
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
		driver.findElement(By.id("input-email")).sendKeys(CommonUtils.generateNewEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("0123456789");
		driver.findElement(By.id("input-password")).sendKeys("123456");
		driver.findElement(By.id("input-confirm")).sendKeys("123456");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		
		String expectedHeading = "Your Account Has Been Created!";
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='common-success']//h1")).getText(), expectedHeading);
		
		driver.findElement(By.xpath("//a[text()='Continue']")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		
	}

}
