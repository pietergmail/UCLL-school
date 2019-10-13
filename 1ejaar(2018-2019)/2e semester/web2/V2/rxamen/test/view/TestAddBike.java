package view;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAddBike {
	
	private WebDriver driver;
	String url = "http://localhost:8080/";

	@Before
	public void setUp() throws Exception {
//		 Voor Windows (vergeet "\" niet te escapen met een tweede "\")
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\u0076465\\OneDrive - UC Leuven-Limburg\\UCLL\\1819 SEM 2\\WEB 2\\extra\\Herhalingsoefening\\Gegeven\\chromedriver.exe");
//		 Voor mac:
//		System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
		driver = new ChromeDriver();
		driver.get(url+"bikeAdd.jsp");
	}
	
	@After
	public void clean() {
		driver.quit();
	}


}
