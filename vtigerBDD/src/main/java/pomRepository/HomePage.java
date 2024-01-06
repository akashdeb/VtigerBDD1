package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(linkText = "Leads")
	private WebElement leadsModule;

	@FindBy(linkText = "Organizations")
	private WebElement organizationsModule;

	@FindBy(linkText = "Contacts")
	private WebElement contactsModule;

	@FindBy(linkText = "Opportunities")
	private WebElement opportunitiesModule;

	@FindBy(linkText = "Products")
	private WebElement productsModule;

	@FindBy(linkText = "More")
	private WebElement moreDropdownButton;

	@FindBy(linkText = "Campaigns")
	private WebElement campaignsModule;

	@FindBy(linkText = "Projects")
	private WebElement projectsModule;

	@FindBy(linkText = "Vendors")
	private WebElement vendorsModule;

	@FindBy(linkText = "Invoice")
	private WebElement invoiceModule;

	@FindBy(linkText = "Sales Order")
	private WebElement salesOrderModule;

	@FindBy(linkText = "Quotes")
	private WebElement quotesModule;

	@FindBy(xpath = "//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement administratorIcon;

	@FindBy(linkText = "Sign Out")
	private WebElement signOutOption;

	public WebElement getLeadsModule() {
		return leadsModule;
	}

	public WebElement getOrganizationsModule() {
		return organizationsModule;
	}

	public WebElement getContactsModule() {
		return contactsModule;
	}

	public WebElement getOpportunitiesModule() {
		return opportunitiesModule;
	}

	public WebElement getProductsModule() {
		return productsModule;
	}

	public WebElement getMoreDropdownButton() {
		return moreDropdownButton;
	}

	public WebElement getCampaignsModule() {
		return campaignsModule;
	}

	public WebElement getProjectsModule() {
		return projectsModule;
	}

	public WebElement getVendorsModule() {
		return vendorsModule;
	}

	public WebElement getInvoiceModule() {
		return invoiceModule;
	}

	public WebElement getSalesOrderModule() {
		return salesOrderModule;
	}

	public WebElement getQuotesModule() {
		return quotesModule;
	}

	public WebElement getAdministratorIcon() {
		return administratorIcon;
	}

	public WebElement getSignOutOption() {
		return signOutOption;
	}

	public void clickOnLeadsModule() {
		leadsModule.click();
	}

	public void clickOnOrganizationModule() {
		organizationsModule.click();
	}

	public void clickOnContactModule() {
		contactsModule.click();
	}

	public void clickOnOpportunityModule() {
		opportunitiesModule.click();
	}

	public void clickOnProductsModule() {
		productsModule.click();
	}

	public void clickOnCampaignsModule() {

		Actions action = new Actions(driver);
		action.moveToElement(moreDropdownButton).perform();
		action.click(campaignsModule).perform();

	}

	public void clickOnProjectModule() {

		Actions action = new Actions(driver);
		action.moveToElement(moreDropdownButton).perform();
		action.click(projectsModule);

	}

	public void clickOnVendorModule() {

		Actions action = new Actions(driver);
		action.moveToElement(moreDropdownButton).perform();
		action.click(vendorsModule).perform();

	}

	public void clickOnInvoiceModule() {

		Actions action = new Actions(driver);
		action.moveToElement(moreDropdownButton).perform();
		action.click(invoiceModule).perform();

	}

	public void clickOnSalesOrderModule() {

		Actions action = new Actions(driver);
		action.moveToElement(moreDropdownButton).perform();
		action.click(salesOrderModule).perform();

	}

	public void clickOnQuotesModule() {

		Actions action = new Actions(driver);
		action.moveToElement(moreDropdownButton).perform();
		action.click(quotesModule).perform();

	}
	
	public void signOutAction() {
		Actions action=new Actions(driver);
		action.moveToElement(administratorIcon).perform();
		action.click(signOutOption).perform();
	}

}
