package runner;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtility.FileUtility;
import genericUtility.IPathConstant;
import genericUtility.JavaUtility;
import genericUtility.WebDriverUtility;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import pomRepository.HomePage;
import pomRepository.LoginPage;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\java\\features",
glue = {"stepDefinition"},
plugin = {"pretty", "html:target/test-output/html-report/cucumber-reports", "json:target/test-output/json-report/cucumber.json", "junit:target/test-output/xml-report/cucumber.xml" })
public class TestRunnerClass {

	
	public static WebDriver driver;
	
	@BeforeClass
	public static void setUp() throws IOException {
		
		String browser=FileUtility.fetchDataFromPropertFile(IPathConstant.BROWSER_KEY);
		String url=FileUtility.fetchDataFromPropertFile(IPathConstant.URL_KEY);
		String username=FileUtility.fetchDataFromPropertFile(IPathConstant.USERNAME_KEY);
		String password=FileUtility.fetchDataFromPropertFile(IPathConstant.PASSWORD_KEY);
		
		if(browser.equals(IPathConstant.BROWSER_VALUE_CHROME)) {
			driver = new ChromeDriver();
		}
		
		else if(browser.equals(IPathConstant.BROWSER_VALUE_FIREFOX)) {
			driver = new FirefoxDriver();
		}
		
		else if(browser.equals(IPathConstant.BROWSER_VALUE_EDGE)) {
			driver = new EdgeDriver();
		}
		System.out.println("The Browser has been launched");
		WebDriverUtility.maximizeTheWindow(driver);
		WebDriverUtility.waitForElement(driver);
		driver.get(url);
		System.out.println("The URL is navigated");
		
		
		LoginPage login = new LoginPage(driver);
		login.loginAction(username, password);
		System.out.println("The User has Logged in");
		
	}
	
	@AfterClass
	public static void tearDown() {
		HomePage home = new HomePage(driver);
		home.signOutAction();
		System.out.println("The User has logged out");
		
		driver.quit();
		System.out.println("The Browser has closed");
	}
}
