package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.dropdownPage;

public class dropdown_test {

    WebDriver driver;

    @BeforeTest
    public void init() {
        driver = new ChromeDriver();
    }

    @Test(description = "Should the Option 1 will be selected", priority = 1, enabled = true)
    public void dropdownOption1() throws IOException, InterruptedException {

        driver.get("http://localhost:7080/dropdown");

        dropdownPage dropdown = new dropdownPage(driver);

        dropdown.SelectOption("1");

        Thread.sleep(500);

        String ExpectedText = "Option 1";
        String s = dropdown.currentOption();

        Assert.assertEquals(s, ExpectedText);
        System.out.println("The Option 1 is selected, the Test Passed\n");

    }

    @Test(description = "Should the Option 2 will be selected", priority = 1, enabled = true)
    public void dropdownOption2() throws IOException, InterruptedException {

        driver.get("http://localhost:7080/dropdown");

        dropdownPage dropdown = new dropdownPage(driver);

        dropdown.SelectOption("2");

        Thread.sleep(500);
        String ExpectedText = "Option 2";
        String s = dropdown.currentOption();

        Assert.assertEquals(s, ExpectedText);
        System.out.println("The Option 2 is selected, the Test Passed\n");

    }

    @AfterTest
    public void endTest() {
        driver.quit();
    }
}
