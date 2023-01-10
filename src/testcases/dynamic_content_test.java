package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;
import org.testng.Assert;

import pages.dynamic_contentPage;

public class dynamic_content_test {

    WebDriver driver;

    @BeforeTest
    public void init() {
        driver = new ChromeDriver();
    }

    @Test(description = "Should the content in page change dynamically", priority = 1, enabled = true)
    public void dynamic_content_validation() throws IOException, InterruptedException {
        driver.get("http://localhost:7080/dynamic_content");

        Thread.sleep(500);

        dynamic_contentPage dynamiccontent = new dynamic_contentPage(driver);

        String imagesPathBefore = dynamiccontent.imageColumn();
        String textBefore = dynamiccontent.textColumn();

        driver.get("http://localhost:7080/dynamic_content");
        String imagesPathAfter = dynamiccontent.imageColumn();
        String textAfter = dynamiccontent.textColumn();

        Assert.assertNotEquals(imagesPathBefore, imagesPathAfter);
        Assert.assertNotEquals(textBefore, textAfter);

        imagesPathBefore = imagesPathAfter;
        textBefore = textAfter;

        Thread.sleep(500);
        driver.get("http://localhost:7080/dynamic_content");

        imagesPathAfter = dynamiccontent.imageColumn();
        textAfter = dynamiccontent.textColumn();

        Assert.assertNotEquals(imagesPathBefore, imagesPathAfter);
        Assert.assertNotEquals(textBefore, textAfter);
        Thread.sleep(500);
        System.out.println("The content of page is updated dynamically, the Test Passed\n");

    }

    @AfterTest
    public void endTest() {
        driver.quit();
    }
}
