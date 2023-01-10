package testcases;

import java.io.File;
import java.io.IOException;
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

public class upload_test {

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

    @Test(description = "Should the file upload", priority = 1, enabled = true)
    public void file_upload() throws InterruptedException {

        driver.get("http://localhost:7080/upload");

        WebElement browseFile = driver.findElement(By.id("file-upload"));

        Thread.sleep(500);

        String uploadPath = System.getProperty("user.dir");

        String expectedFileName = "myuploadfile.txt";
        try {
            File myfile = new File(uploadPath + "\\" + expectedFileName);
            if (myfile.createNewFile()) {
                browseFile.sendKeys(uploadPath + "\\" + expectedFileName);
                driver.findElement(By.id("file-submit")).click();
            }

            Assert.assertEquals(driver.findElement(By.id("uploaded-files")).getText(), expectedFileName);
            if (myfile.exists()) {
                Assert.assertTrue(myfile.exists());
                System.out.println("The file was uploaded, the Test Passed\n");
                myfile.delete();
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @AfterTest
    public void endTest() {
        driver.quit();
    }
}
