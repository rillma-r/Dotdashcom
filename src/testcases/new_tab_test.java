package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.testng.Assert;

public class new_tab_test {

    WebDriver driver;

    @BeforeTest
    public void init() {
        driver = new ChromeDriver();
    }

    @Test(description = "Should the new tab be opened", priority = 1, enabled = true)
    public void new_tab() throws InterruptedException {

        driver.get("http://localhost:7080/windows");

        String sourceWindow = driver.getWindowHandle();
        driver.findElement(By.linkText("Click Here")).click();

        for (String windowHandle : driver.getWindowHandles()) {
            if (!sourceWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        Thread.sleep(500);
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).getText().contains("New Window"));
        System.out.println("The new tab was opened, the Test Passed\n");

    }

    @AfterTest
    public void endTest() {
        driver.quit();
    }
}
