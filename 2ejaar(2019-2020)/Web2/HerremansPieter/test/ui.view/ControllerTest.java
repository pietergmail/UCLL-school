package ui.view;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ControllerTest {

    // verander de url naar jouw url naam
    private static final String url = "http://localhost:8080/";
    private WebDriver driver;

    @Before
    public void setUp () {
//		 Voor Windows (vergeet "\" niet te escapen met een tweede "\")
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\...\\chromedriver.exe");
//		 Voor mac:
        System.setProperty("webdriver.chrome.driver", "~/Documents/school/school/2ejaar(2019-2020)/Web2/Chromedriver/chromedriver.exe");

        driver = new ChromeDriver();
    }

    @Test
    public void test_Count_Jade_a_geeft_1() {

        driver.get(url + "Occurences?woord=jade&letter=a");
        String antwoord = driver.findElement(By.id("antwoord")).getText();

        assertEquals("Het antwoord is: 1 keer.", antwoord);
    }

    @After
    public void tearDown () {
        driver.quit();
    }

}