package stepDefinition;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtility.DataBaseUtility;
import genericUtility.ExcelUtility;
import genericUtility.FileUtility;
import genericUtility.IPathConstant;
import genericUtility.JavaUtility;
import genericUtility.WebDriverUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pomRepository.CampaignInformation;
import pomRepository.CampaignPage;
import pomRepository.CreatingNewCampaignPage;
import pomRepository.CreatingNewOpportunityPage;
import pomRepository.CreatingNewOrganizationPage;
import pomRepository.HomePage;
import pomRepository.LoginPage;
import pomRepository.OpportunitiesPage;
import pomRepository.OpportunityInformationPage;
import pomRepository.OrganizationInformationPage;
import pomRepository.OrganizationsPage;
import runner.TestRunnerClass;

public class ToCreateOpportunity {
	WebDriver driver;
	public ToCreateOpportunity() {
		this.driver = TestRunnerClass.driver;
	}
	
	int randomNo = JavaUtility.generateRandomNumber(10000);
	
	
	@Given("The user has created Organization")
	public void the_user_has_created_organization() throws EncryptedDocumentException, IOException {
		// TestData
		String organizationName = ExcelUtility.fetchStringDataFromExcelSheet(IPathConstant.OPPORTUNITY_SHEET_NAME, 1, 0)
				+ randomNo;
		
		// Object Creating
		HomePage home = new HomePage(driver);

		OrganizationsPage organization = new OrganizationsPage(driver);
		CreatingNewOrganizationPage createOrganization = new CreatingNewOrganizationPage(driver);
		OrganizationInformationPage organizationInfo = new OrganizationInformationPage(driver);
		
		home.clickOnOrganizationModule();
		organization.clickOrganizationPlusButton();
		createOrganization.enterOrganizationName(organizationName);
		createOrganization.clickOnSaveButton();
		String actualOrganizationName = organizationInfo.verifyOrganizationDetails(organizationName);
		Assert.assertTrue(actualOrganizationName.contains(organizationName));
		System.out.println("Pass: the organization has been created");

	}

	@And("The user has created Campaign")
	public void the_user_has_created_campaign() throws EncryptedDocumentException, IOException {
		HomePage home = new HomePage(driver);
		CampaignPage campaign = new CampaignPage(driver);
		CreatingNewCampaignPage createCampaign = new CreatingNewCampaignPage(driver);
		CampaignInformation campaignInfo = new CampaignInformation(driver);
		String campaignName = ExcelUtility.fetchStringDataFromExcelSheet(IPathConstant.OPPORTUNITY_SHEET_NAME, 3, 0);

		home.clickOnCampaignsModule();
		campaign.clickOnCampignPlusButton();
		createCampaign.enterCampaignName(campaignName);
		createCampaign.clickOnSaveButton();
		String actualCampaignName = campaignInfo.verifyCampaignDetails(campaignName);
		Assert.assertTrue(actualCampaignName.contains(campaignName));
		System.out.println("Pass: the Campaign has been created");

	}

	@When("The user Creates Opportunity")
	public void the_user_creates_opportunity() throws EncryptedDocumentException, IOException {
		String opportunityName = ExcelUtility.fetchStringDataFromExcelSheet(IPathConstant.OPPORTUNITY_SHEET_NAME, 5, 0);
		String organizationName = ExcelUtility.fetchStringDataFromExcelSheet(IPathConstant.OPPORTUNITY_SHEET_NAME, 1, 0)
				+ randomNo;
		String organizationLookUpPageTitle = ExcelUtility.fetchStringDataFromExcelSheet(IPathConstant.OPPORTUNITY_SHEET_NAME,
				5, 1);
		String campaingLookUpPageTitle = ExcelUtility.fetchStringDataFromExcelSheet(IPathConstant.OPPORTUNITY_SHEET_NAME, 5,
				2);
		
		String campaignName = ExcelUtility.fetchStringDataFromExcelSheet(IPathConstant.OPPORTUNITY_SHEET_NAME, 3, 0);

		HomePage home = new HomePage(driver);
		OpportunitiesPage opportunity = new OpportunitiesPage(driver);
		CreatingNewOpportunityPage createOpportunity = new CreatingNewOpportunityPage(driver);

		
		home.clickOnOpportunityModule();
		opportunity.clickOnOpportunityPlusButton();
		createOpportunity.enterOpportunityName(opportunityName);
		createOpportunity.enterOrganizationDetailsFromRelatedToLookUpPage(organizationLookUpPageTitle,
				organizationName);
		createOpportunity.enterCampaingsDetailsFromCampaignSourceLookUpPage(campaingLookUpPageTitle, campaignName);
		createOpportunity.clickOnSaveButton();

	}

	@Then("The Opportunity details is verified")
	public void the_opportunity_details_is_verified() throws EncryptedDocumentException, IOException {
		String opportunityName = ExcelUtility.fetchStringDataFromExcelSheet(IPathConstant.OPPORTUNITY_SHEET_NAME, 5, 0);
		OpportunityInformationPage opportunityInfo = new OpportunityInformationPage(driver);

		String actualOpportuntityName = opportunityInfo.verifyOpportunityDetails(opportunityName);
		Assert.assertTrue(actualOpportuntityName.contains(opportunityName));
		System.out.println("Pass: the Opportunity has been created");
	}

}
