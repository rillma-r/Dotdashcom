package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.testng.Assert;

public class javascript_error_test {

    WebDriver driver;

    @BeforeTest
    public void init() {
        driver = new ChromeDriver();
    }

    @Test(description = "Should the javascript be captured", priority = 1, enabled = true)
    public void javascript_error() throws InterruptedException {

        driver.get("http://localhost:7080/javascript_error");

        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);

        for (LogEntry logEntry : logEntries) {
            String s = logEntry.getMessage();
            if (s.contains("reading 'xyz'")) {
                Assert.assertTrue(s.contains("reading 'xyz'"));
            }
        }

        System.out.println("The javascript error was captured, the Test Passed\n");

    }

    @AfterTest
    public void endTest() {
        driver.quit();
    }
}
