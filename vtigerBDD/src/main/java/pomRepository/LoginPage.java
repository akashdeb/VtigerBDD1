package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This class is an object repository containing all elements present in Login page
 * @author Akash Deb
 *
 */
public class LoginPage {
	//Contructor for LoginPage
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Identifying all elements on Login Page
	@FindBy(name = "user_name")
	private WebElement usernameTextField;
	
	@FindBy(name = "user_password")
	private WebElement passwordTextField;
	
	@FindBy(id = "submitButton")
	private WebElement loginButton;

	
	//getters methods
	public WebElement getUsernameTextField() {
		return usernameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	/**
	 * This method perform login action on the Login Page
	 * @param username
	 * @param password
	 */
	public void loginAction(String username, String password) {
		
		usernameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		loginButton.click();

	}
	
	
	
	

}
