package genericUtility;
/**
 * 
 * @author Akash Deb
 *
 */
public interface IPathConstant {
	
	String PROPERTY_FILE_PATH = "./src/test/resources/testData/vtigerPropertyData.properties";
	String EXCEL_DATA_PATH = "./src/test/resources/testData/vtigerTestData.xlsx";
	
	String LEAD_SHEET_NAME = "Lead";
	String OPPORTUNITY_SHEET_NAME = "Opportunity";
	
	int IMPLICIT_WAIT = 20;
	int EXPLICIT_WAIT = 20;
	
	String BROWSER_KEY = "browser";
	String URL_KEY = "url";
	String USERNAME_KEY = "username";
	String PASSWORD_KEY = "password";
	
	String BROWSER_VALUE_CHROME = "chrome";
	String BROWSER_VALUE_FIREFOX = "firefox";
	String BROWSER_VALUE_EDGE = "edge";
	
	String DATA_BASE_URL = "jdbc:mysql://localhost:3306/vtiger";
	String DATA_BASE_USERNAME = "root";
	String DATA_BASE_PASSWORD = "root";
	
	String HTML_REPORT_KEY = "html:target/test-output/html-report/cucumber-reports"+JavaUtility.generateSystemDateAndTime();




	

}
