package genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IRetryAnalyserImplementationClass implements IRetryAnalyzer {
	int count = 0;
	int limit = 2;
	
	public boolean retry(ITestResult result) {
		while(count<limit) {
			count ++;
			return true;
		}
		
		return false;
	}

}
