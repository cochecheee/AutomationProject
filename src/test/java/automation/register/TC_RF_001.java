package automation.register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_RF_001 {

	public static void verifyRegisterWithMandatoryFields(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		//		Set up		
		// // thời gian chờ tối đa cho element xuất hiện
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		
		// click dropdown button
		driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[2]/a/span[1]")).click();
		driver.findElement(By.linkText("Register")).click();
		
		driver.findElement(By.id("input-firstname")).sendKeys("Co");
		driver.findElement(By.id("input-lastname")).sendKeys("cheche");
		driver.findElement(By.id("input-email")).sendKeys(generateNewEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("0123456789");
		driver.findElement(By.id("input-password")).sendKeys("123456");
		driver.findElement(By.id("input-confirm")).sendKeys("123456");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
	}
	
	public static String generateNewEmail() {
		String noSpaceDateString = new Date().toString().replaceAll("\\s", "");
		String noSpaceAndnoColonsDateString = noSpaceDateString.replaceAll("\\:", "");
		String emailWithTimeStamp = noSpaceAndnoColonsDateString + "@gmail.com";
		return emailWithTimeStamp;
	}

}
