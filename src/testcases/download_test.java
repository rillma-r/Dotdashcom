package testcases;

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.testng.Assert;

public class download_test {

    WebDriver driver;

    @BeforeTest
    public void init() {
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", System.getProperty("user.dir"));
        chromePrefs.put("download.prompt_for_download", false);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        driver = new ChromeDriver(options);
    }

    @Test(description = "Should the file download", priority = 1, enabled = true)
    public void download() throws InterruptedException {

        driver.get("http://localhost:7080/download");

        WebElement downloadlink = driver.findElement(By.xpath("//a[contains(text(),'some-file.txt')]"));

        downloadlink.click();
        Thread.sleep(500);

        String downloadPath = System.getProperty("user.dir");

        String expectedFileName = "some-file.txt";
        File file = new File(downloadPath + "\\" + expectedFileName);

        if (file.exists()) {
            Assert.assertTrue(file.exists());
            System.out.println("The file was downloaded, the Test Passed\n");
            file.delete();
        }

    }

    @AfterTest
    public void endTest() {
        driver.quit();
    }
}
