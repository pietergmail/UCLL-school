package view;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BookShopTest extends TestCase {
    private WebDriver driver;

    @Before
    protected void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "D:\\backup\\UCLL\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @After
    public void tearDown() {
        driver.quit();
    }



    @Test
    public void test_navigate_to_form(){
        driver.get("http://localhost:8080/bookForm.jsp");
        String title = driver.getTitle();
        assertEquals("Book Info",title);
    }
    @Test
    public void test_leaving_all_fields_blank(){
        driver.get("http://localhost:8080/bookForm.jsp");
        WebElement submut = driver.findElement(By.id("calculate"));
        submut.click();

        String p = driver.findElement(By.tagName("p")).getText();
        assertEquals(p, "Vul alle velden in.");
    }
    @Test
    public void test_juiste_input_geef_juiste_output(){
        driver.get("http://localhost:8080/bookForm.jsp");
        driver.findElement(By.id("title")).clear();
        driver.findElement(By.id("title")).sendKeys("Alles Komt Goed");

        driver.findElement(By.id("price")).clear();
        driver.findElement(By.id("price")).sendKeys("10");

        driver.findElement(By.id("number")).clear();
        driver.findElement(By.id("number")).sendKeys("7");

        driver.findElement(By.id("calculate")).click();

        assertEquals(driver.findElement(By.tagName("p")).getText(), "Voor 7 exemplaren van het boek Alles Komt Goed moet je €70 betalen.");


    }



}
