package testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.context_menuPage;

public class context_menu_test {

    WebDriver driver;

    @BeforeTest
    public void init() {
        driver = new ChromeDriver();
    }

    @Test(description = "Should the dialog displayed after right click", priority = 1, enabled = true)
    public void context_menuClick() throws InterruptedException {

        driver.get("http://localhost:7080/context_menu");

        context_menuPage context_menu = new context_menuPage(driver);

        context_menu.clickcontext_menu();

        if (driver.switchTo().alert() != null) {
            System.out.println("The Context Menu is displayed, the Test Passed\n");
            Thread.sleep(500);
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
            System.out.println("The Message was closed, the Test Passed\n");
        }

        Thread.sleep(500);

    }

    @AfterTest
    public void endTest() {
        driver.quit();
    }
}
