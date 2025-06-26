package automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewsLetterPage {
	WebDriver driver;
	
	public NewsLetterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//ul[@class='breadcrumb']//a[text()='Newsletter']")
	private WebElement newsLetterBreadCrumb;
	public boolean isNewsLetterPageDisplayed() {
		return newsLetterBreadCrumb.isDisplayed();
	}
	
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	private WebElement subcribingOption;
	public boolean isSubcribingOptionSelected() {
		return subcribingOption.isSelected();
	}
}
