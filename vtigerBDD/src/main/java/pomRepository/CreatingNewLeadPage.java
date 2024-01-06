package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewLeadPage {
	
	WebDriver driver;

	public CreatingNewLeadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(name = "salutationtype")
	private WebElement leadSalutationDropDown;
	
	@FindBy(name = "firstname")
	private WebElement firstNameTextField;
	
	@FindBy(name = "lastname")
	private WebElement lastnameTextField;
	
	@FindBy(name = "company")
	private WebElement companyTextField;

	@FindBy(xpath = "//input[@value=\"T\"]")
	private WebElement assignToGroupRadioButton;
	
	@FindBy(name = "assigned_group_id")
	private WebElement assignedToDropdown;
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveButton;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getLeadSalutationDropDown() {
		return leadSalutationDropDown;
	}

	public WebElement getFirstNameTextField() {
		return firstNameTextField;
	}

	public WebElement getLastnameTextField() {
		return lastnameTextField;
	}

	public WebElement getCompanyTextField() {
		return companyTextField;
	}

	public WebElement getAssignToGroupRadioButton() {
		return assignToGroupRadioButton;
	}

	public WebElement getAssignedToDropdown() {
		return assignedToDropdown;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	
	public void selectLeadSalutation(String salutation) {
		
		Select select=new Select(leadSalutationDropDown);
		select.selectByVisibleText(salutation);
	}
	
	public void enterLeadFirstName(String firstName) {
		firstNameTextField.sendKeys(firstName);
	}
	
	public void enterLeadLastName(String lastName) {
		lastnameTextField.sendKeys(lastName);
	}
	
	public void enterLeadCompanyName(String companyName) {
		companyTextField.sendKeys(companyName);
	}
	
	public void clickOnAssignedToGroupRadioButton() {
		assignToGroupRadioButton.click();
	}
	
	public void selectFromAssignedToGroupDropDown(String assignedTo) {
		
		Select select = new Select(assignedToDropdown);
		select.selectByVisibleText(assignedTo);
	}
	
	public void clickOnSaveButton() {
		saveButton.click();
	}
	
	
	
}
