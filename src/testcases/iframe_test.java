package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.testng.Assert;

public class iframe_test {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void init() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test(description = "Should the input in the iframe editable", priority = 1, enabled = true)
    public void iframe() throws InterruptedException {

        driver.get("http://localhost:7080/iframe");

        driver.switchTo().frame("mce_0_ifr");

        String theText = "This is my text";
        wait.until(ExpectedConditions.elementToBeClickable(By.id("tinymce")));
        Thread.sleep(500);
        WebElement theInput = driver.findElement(By.id("tinymce"));
        theInput.clear();
        Thread.sleep(500);
        theInput.sendKeys(theText);

        wait.until(ExpectedConditions.textToBe(By.id("tinymce"), theText));
        Assert.assertEquals(theInput.getText(), theText);

        System.out.println("The input is editabled in the iframe, the Test Passed\n");

    }

    @AfterTest
    public void endTest() {
        driver.quit();
    }
}
