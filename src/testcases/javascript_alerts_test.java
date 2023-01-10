package testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.testng.Assert;

public class javascript_alerts_test {

    WebDriver driver;

    @BeforeTest
    public void init() {
        driver = new ChromeDriver();
    }

    @Test(description = "Should the javascript alert displayed", priority = 1, enabled = true)
    public void jsAlert() throws InterruptedException {

        driver.get("http://localhost:7080/javascript_alerts");

        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        Alert alert = driver.switchTo().alert();

        alert.accept();
        String expectedText = "You successfuly clicked an alert";
        Thread.sleep(500);
        Assert.assertEquals(driver.findElement(By.id("result")).getText(), expectedText);

        System.out.println("The JS alert is displayed, the Test Passed\n");

    }

    @Test(description = "Should the javascript Alert is confirmed", priority = 1, enabled = true)
    public void jsConfirm() throws InterruptedException {

        driver.get("http://localhost:7080/javascript_alerts");

        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        Alert alert = driver.switchTo().alert();

        alert.accept();
        String expectedText = "You clicked: Ok";
        Thread.sleep(500);
        Assert.assertEquals(driver.findElement(By.id("result")).getText(), expectedText);

        System.out.println("The JS alert is confirmed, the Test Passed\n");

    }

    @Test(description = "Should the javascript alert admit a prompt message", priority = 1, enabled = true)
    public void jsPrompt() throws InterruptedException {

        driver.get("http://localhost:7080/javascript_alerts");

        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("my message");

        alert.accept();
        String expectedText = "You entered: my message";
        Thread.sleep(500);
        Assert.assertEquals(driver.findElement(By.id("result")).getText(), expectedText);

        System.out.println("The JS alert is prompted, the Test Passed\n");

    }

    @AfterTest
    public void endTest() {
        driver.quit();
    }
}
