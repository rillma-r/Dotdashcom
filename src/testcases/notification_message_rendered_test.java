package testcases;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.testng.Assert;

public class notification_message_rendered_test {

    WebDriver driver;

    @BeforeTest
    public void init() {
        driver = new ChromeDriver();
    }

    @Test(description = "Should the notification rendered with random message", priority = 1, enabled = true)
    public void notification_render() throws InterruptedException {

        driver.get("http://localhost:7080/notification_message_rendered");

        Random num = new Random();
        int times = num.nextInt(10);
        while (times > 0) {
            driver.findElement(By.linkText("Click here")).click();
            times--;
        }

        String s = driver.findElement(By.id("flash")).getText();
        if (s.contains("Action successful")) {
            Assert.assertTrue(true);
        } else if (s.contains("Action unsuccesful, please try again")) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

        Thread.sleep(500);
        System.out.println("The notification message render Test Passed\n");

    }

    @AfterTest
    public void endTest() {
        driver.quit();
    }
}
