package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.testng.Assert;

public class floating_menu_test {

    WebDriver driver;

    @BeforeTest
    public void init() {
        driver = new ChromeDriver();
    }

    @Test(description = "Should the menu floats over contain", priority = 1, enabled = true)
    public void floating_menu() throws InterruptedException {

        driver.get("http://localhost:7080/floating_menu");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");

        Thread.sleep(1500);

        Assert.assertTrue(driver.findElement(By.id("menu")).isDisplayed());

        System.out.println("The menu floats over contain, the Test Passed\n");
    }

    @AfterTest
    public void endTest() {
        driver.quit();
    }
}
