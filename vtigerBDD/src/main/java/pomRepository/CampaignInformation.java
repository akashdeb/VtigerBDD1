package pomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CampaignInformation {
	WebDriver driver;
	public CampaignInformation(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public String verifyCampaignDetails(String campaignName) {
		return driver.findElement(By.xpath("//span[contains(text(), '"+campaignName+"')]")).getText();

	}

}
