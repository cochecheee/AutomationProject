package automation.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.base.Base;
import automation.utils.CommonUtils;

public class TC_RF_003 extends Base {
	private WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		// choosing driver
		driver = openBrowserAndApplication();		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
	}
	
	@AfterTest
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}
	
	@Test
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
