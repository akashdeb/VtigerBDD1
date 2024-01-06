package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	
	public OrganizationsPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@alt=\"Create Organization...\"]")
	private WebElement organizationPlusButton;

	public WebElement getOrganizationPlusButton() {
		return organizationPlusButton;
	}
	
	
	public void clickOrganizationPlusButton() {
		organizationPlusButton.click();
	}

}
