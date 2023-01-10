package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.testng.Assert;

public class hovers_test {

    WebDriver driver;
    
    @BeforeTest
    public void init() {
        driver = new ChromeDriver();
    }

    @Test(description = "Should the mouse houver over images show the details", priority = 1, enabled = true)
    public void hovers() throws InterruptedException {

        driver.get("http://localhost:7080/hovers");

        List<WebElement> images = driver.findElements(By.xpath("//div[@class='figure']"));
        Actions action = new Actions(driver);

        for (WebElement image : images) {
            action.moveToElement(image).perform();
            Thread.sleep(500);
            Assert.assertTrue(image.findElement(By.xpath(".//div[@class='figcaption']")).isDisplayed());
        }

        System.out.println("The mouse hover works, the Test Passed\n");

    }

    @AfterTest
    public void endTest() {
        driver.quit();
    }
}
