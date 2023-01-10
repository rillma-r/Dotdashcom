package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LoginPage;

public class login_success_test {

    WebDriver driver;

    @BeforeTest
    public void init() {
        driver = new ChromeDriver();
    }

    @Test(description = "Should the Login succed", priority = 1, enabled = true)
    public void login_succed() throws InterruptedException {

        driver.get("http://localhost:7080/login");

        LoginPage login = new LoginPage(driver);

        login.enterUserName("tomsmith");
        login.enterPassword("SuperSecretPassword!");

        login.clickLogin();

        String ExpectedText = "Secure Area";
        Assert.assertEquals(ExpectedText, login.secureAreaText());

        System.out.println("The Login was success, the Test Passed\n");

        Thread.sleep(500);

    }

    @AfterTest
    public void endTest() {
        driver.quit();
    }
}
