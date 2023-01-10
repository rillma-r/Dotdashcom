package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;
import org.testng.Assert;

import pages.drag_and_dropPage;

public class drag_and_drop_test {

    WebDriver driver;

    @BeforeTest
    public void init() {
        driver = new ChromeDriver();
    }

    @Test(description = "Should the Column A Drag from left to right over Column B", priority = 1, enabled = true)
    public void dragAndDropLefttoRigth() throws IOException, InterruptedException {

        driver.get("http://localhost:7080/drag_and_drop");

        drag_and_dropPage draganddrop = new drag_and_dropPage(driver);

        draganddrop.drag_and_drop("#column-a", "#column-b");

        Thread.sleep(500);

        String ExpectedText = "BA";
        Assert.assertEquals(ExpectedText, draganddrop.currentHeaders());

        System.out.println("The Drag and Drop from left to right was done, the Test Passed\n");
    }

    @Test(description = "Should the Column A Drag from left to right over Column B", priority = 1, enabled = true)
    public void dragAndDropRigthtoLeft() throws IOException, InterruptedException {

        driver.get("http://localhost:7080/drag_and_drop");

        drag_and_dropPage draganddrop = new drag_and_dropPage(driver);

        draganddrop.drag_and_drop("#column-b", "#column-a");

        Thread.sleep(500);

        String ExpectedText = "BA";
        Assert.assertEquals(ExpectedText, draganddrop.currentHeaders());

        System.out.println("The Drag and Drop from right to left was done, the Test Passed\n");

    }

    @AfterTest
    public void endTest() {
        driver.quit();
    }
}
