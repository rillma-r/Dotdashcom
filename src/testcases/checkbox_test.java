package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.checkboxesPage;

public class checkbox_test {
    WebDriver driver;

    @BeforeTest
    public void init() {
        driver = new ChromeDriver();
    }

    @Test(description = "Should the checkboxes are selected", priority = 1, enabled = true)
    public void select_checkbox() throws InterruptedException {

        driver.get("http://localhost:7080/checkboxes");

        checkboxesPage checkbox = new checkboxesPage(driver);

        checkbox.selectAllCheckboxes();

        Assert.assertTrue(checkbox.allchecked());
        System.out.println("All checkboxes are selected, the Test Passed\n");

        Thread.sleep(500);

    }

    @Test(description = "Should the checkboxes are unselected", priority = 1, enabled = true)
    public void unselect_checkbox() throws InterruptedException {

        driver.get("http://localhost:7080/checkboxes");

        checkboxesPage checkbox = new checkboxesPage(driver);

        checkbox.unselectAllCheckboxes();

        Assert.assertTrue(!checkbox.allchecked());
        System.out.println("All checkboxes are unselected, the Test Passed\n");

        Thread.sleep(500);
    }

    @AfterTest
    public void endTest() {
        driver.quit();
    }
}
