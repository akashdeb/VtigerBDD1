package pomRepository;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebDriverUtility;

public class CreatingNewOpportunityPage {
	
	WebDriver driver;
	
	public CreatingNewOpportunityPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		}

	
	@FindBy(name = "potentialname")
	private WebElement opportunityNameTextField;
	
	@FindBy(xpath = "//select[@id=\"related_to_type\"]/../..//img")
	private WebElement relatedToOrganizationLookUpButton;
	
	@FindBy(xpath = "//input[@name=\"campaignname\"]/..//img")
	private WebElement campaingSourceLookUpButton;
	
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveButton;
	
	@FindBy(name = "search_text")
	private WebElement organizationSearchTextField;
	
	@FindBy(name = "search")
	private WebElement organizationSearchButton;
	
	@FindBy(name = "search_text")
	private WebElement campaignSearchTextField;
	
	@FindBy(name = "search")
	private WebElement campaignSearchButton;
	

	public WebElement getOpportunityNameTextField() {
		return opportunityNameTextField;
	}


	public WebElement getRelatedToOrganizationLookUpButton() {
		return relatedToOrganizationLookUpButton;
	}


	public WebElement getCampaingSourceLookUpButton() {
		return campaingSourceLookUpButton;
	}


	public WebElement getSaveButton() {
		return saveButton;
	}
	
	
	
	public WebElement getOrganizationSearchTextField() {
		return organizationSearchTextField;
	}


	public WebElement getOrganizationSearchButton() {
		return organizationSearchButton;
	}


	
	
	public WebDriver getDriver() {
		return driver;
	}


	public WebElement getCampaignSearchTextField() {
		return campaignSearchTextField;
	}


	public WebElement getCampaignSearchButton() {
		return campaignSearchButton;
	}


	public void enterOpportunityName(String opportunityName) {
		opportunityNameTextField.sendKeys(opportunityName);
	}
	
	public void enterOrganizationDetailsFromRelatedToLookUpPage(String lookUpPageTitle, String organizationName) {
		String parentPageTitle = driver.getTitle();
		relatedToOrganizationLookUpButton.click();
		
		WebDriverUtility.switchToWindow(driver, lookUpPageTitle);
		
		organizationSearchTextField.sendKeys(organizationName);
		organizationSearchButton.click();
		
		driver.findElement(By.xpath("//a[text()='"+organizationName+"']")).click();
		
		WebDriverUtility.switchToWindow(driver, parentPageTitle);
				
	}
	
	public void enterCampaingsDetailsFromCampaignSourceLookUpPage(String lookUpPageTitle, String campaignName) {
		String parentPageTitle = driver.getTitle();
		campaingSourceLookUpButton.click();
		
		WebDriverUtility.switchToWindow(driver, lookUpPageTitle);
		
		campaignSearchTextField.sendKeys(campaignName);
		campaignSearchButton.click();
		
		driver.findElement(By.xpath("//a[text()='"+campaignName+"']")).click();
		
		WebDriverUtility.switchToWindow(driver, parentPageTitle);
				
	}
	
	public void clickOnSaveButton() {
		saveButton.click();
	}
	
	
	
}
