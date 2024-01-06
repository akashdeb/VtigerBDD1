package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesPage {

	public OpportunitiesPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@alt=\"Create Opportunity...\"]")
	private WebElement opportunityPlusButton;

	public WebElement getCampaignPlusButton() {
		return opportunityPlusButton;
	}
	
	public void clickOnOpportunityPlusButton() {
		opportunityPlusButton.click();
	}


}
