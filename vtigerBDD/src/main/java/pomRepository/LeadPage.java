package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadPage {
	
	WebDriver driver;

	public LeadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(xpath = "//img[@title=\"Create Lead...\"]")
	private WebElement leadPlusButton;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getLeadPlusButton() {
		return leadPlusButton;
	}
	
	public void clickOnLeadPlusButton() {
		leadPlusButton.click();
	}


}
