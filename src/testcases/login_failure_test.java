package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LoginPage;

public class login_failure_test {

    WebDriver driver;

    @BeforeTest
    public void init() {
        driver = new ChromeDriver();
    }

    @Test(description = "Should the invalid Login raises error", priority = 1, enabled = true)
    public void invalid_login() throws InterruptedException {

        driver.get("http://localhost:7080/login");

        LoginPage login = new LoginPage(driver);

        login.clickLogin();

        String ExpectedText = "Your username is invalid!";
        String s = login.errorMessage();
        Assert.assertTrue(s.contains(ExpectedText));

        System.out.println("The login fails, the Test Passed\n");

        Thread.sleep(500);

    }

    @AfterTest
    public void endTest() {
        driver.quit();
    }
}
