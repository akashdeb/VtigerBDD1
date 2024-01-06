package stepDefinition;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
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
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pomRepository.CreatingNewLeadPage;
import pomRepository.HomePage;
import pomRepository.LeadInformationPage;
import pomRepository.LeadPage;
import pomRepository.LoginPage;
import runner.TestRunnerClass;

public class TestToCreateALead {
	public WebDriver driver;
	
	public TestToCreateALead() {
		
		this.driver = TestRunnerClass.driver;
	}
	
	
	@Given("The user has logged in to the application")
	public void the_user_has_logged_in_to_the_application() {

		System.out.println("The user is on the Home page");
				
	}

	@When("The user goes to the create lead module")
	public void the_user_goes_to_the_create_lead_module() {
		//POM Object Creating
		HomePage home = new HomePage(driver);
		LeadPage lead = new LeadPage(driver);
		
		//Test Script
		home.clickOnLeadsModule();
		
		lead.clickOnLeadPlusButton();
	}

	@Then("The user fills up the lead information")
	public void the_user_fills_up_the_lead_information() throws EncryptedDocumentException, IOException {
		
		String leadSalutation = ExcelUtility.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEET_NAME, 1, 0);
		String leadFirstName = ExcelUtility.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEET_NAME, 1, 1);
		String leadLastName = ExcelUtility.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEET_NAME, 1, 2);
		String leadCompanyName = ExcelUtility.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEET_NAME, 1, 3);
		String leadAssignedTo = ExcelUtility.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEET_NAME, 1, 4);
		
		CreatingNewLeadPage createLead = new CreatingNewLeadPage(driver);		
		createLead.selectLeadSalutation(leadSalutation);
		createLead.enterLeadFirstName(leadFirstName);
		createLead.enterLeadLastName(leadLastName);
		createLead.enterLeadCompanyName(leadCompanyName);
		createLead.clickOnAssignedToGroupRadioButton();
		createLead.selectFromAssignedToGroupDropDown(leadAssignedTo);
		createLead.clickOnSaveButton();
	}

	@Then("The user verifies the lead informarion")
	public void the_user_verifies_the_lead_informarion() throws EncryptedDocumentException, IOException {
		
		String leadLastName = ExcelUtility.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEET_NAME, 1, 2);

		LeadInformationPage leadInfo = new LeadInformationPage(driver);
		String actualLeadLastName = leadInfo.verifyLeadInfo(leadLastName);
		
		//Verification
		Assert.assertTrue(actualLeadLastName.contains(leadLastName));
		System.out.println("Pass: the Lead has been created");
		
	}

}
