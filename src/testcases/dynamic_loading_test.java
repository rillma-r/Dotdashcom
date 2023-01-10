package testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.dynamic_loadingPage;

public class dynamic_loading_test {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void init() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test(description = "Should the button Start hidden after click, and Hello Wordl displayed", priority = 1, enabled = true)
    public void dynamic_loading_Start() throws IOException, InterruptedException {
        driver.get("http://localhost:7080/dynamic_loading/2");

        dynamic_loadingPage dynamic_control = new dynamic_loadingPage(driver);

        dynamic_control.clickStart();
        wait.until(ExpectedConditions.invisibilityOf(dynamic_control.theLoading()));
        String ExpectedText = "Hello World!";
        String s = dynamic_control.HelloWorld();
        Assert.assertTrue(s.contains(ExpectedText));

        System.out.println("Hello World! is displayed, the Test Passed\n");
    }

    @AfterTest
    public void endTest() {
        driver.quit();
    }
}
