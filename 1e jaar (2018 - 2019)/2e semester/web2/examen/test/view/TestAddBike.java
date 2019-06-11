package view;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;


public class TestAddBike {
	
	private WebDriver driver;
	String url = "http://localhost:8080/";

	@Before
	public void setUp() throws Exception {
//		 Voor Windows (vergeet "\" niet te escapen met een tweede "\")
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\herre\\Documents\\UCLL\\1e jaar (2018 - 2019)\\2e semester\\web2\\chromedriver\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get(url+"bikeAdd.jsp");
	}

    @Test
    public void test_add_bike_with_wrong_price(){
        WebElement itemid = driver.findElement(By.id("itemId"));
        itemid.clear();
        Random r = new Random();
        itemid.sendKeys("itemid" + r.nextInt(1)+100);

        WebElement brand = driver.findElement(By.id("brand"));
        brand.clear();
        brand.sendKeys("brand");

        WebElement cat = driver.findElement(By.id("category"));
        cat.clear();
        cat.sendKeys("ROAD");

        WebElement desc = driver.findElement(By.id("description"));
        desc.clear();
        desc.sendKeys("description");

        WebElement price = driver.findElement(By.id("price"));
        price.clear();
        price.sendKeys("-10");

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();

        Assert.assertEquals("No valid price", driver.findElement(By.className("error")).getText());


    }

    @Test
    public void test_add_bike(){
        WebElement itemid = driver.findElement(By.id("itemId"));
        itemid.clear();
        Random r = new Random();
        itemid.sendKeys("itemid" + r.nextInt(1)+100);


        WebElement brand = driver.findElement(By.id("brand"));
        brand.clear();
        brand.sendKeys("brand");

        WebElement cat = driver.findElement(By.id("category"));
        cat.clear();
        cat.sendKeys("ROAD");

        WebElement desc = driver.findElement(By.id("description"));
        desc.clear();
        desc.sendKeys("description");

        WebElement price = driver.findElement(By.id("price"));
        price.clear();
        price.sendKeys("10");

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();

        Assert.assertEquals("Overview Bikes", driver.getTitle());
        // Webelement array van LI?
        //TODO test_werkende afwerken

    }

    @After
	public void clean() {
		driver.quit();
	}


}
