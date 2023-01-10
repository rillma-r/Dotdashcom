package testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.dynamic_controlsPage;

public class dynamic_controls_test {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void init() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test(description = "Should the button Remove displayed, and checkbox visible", priority = 1, enabled = true)
    public void dynamic_controls_checkbox() throws IOException, InterruptedException {
        driver.get("http://localhost:7080/dynamic_controls");

        dynamic_controlsPage dynamic_control = new dynamic_controlsPage(driver);

        dynamic_control.buttonAddRemoveClick();
        wait.until(ExpectedConditions.invisibilityOf(dynamic_control.theLoading()));
        dynamic_control.buttonAddRemoveClick();
        wait.until(ExpectedConditions.invisibilityOf(dynamic_control.theLoading()));
        String s = dynamic_control.currentButtonAddRemove();
        System.out.println(s);

        if (s.compareTo("Remove") == 0) {

            wait.until(ExpectedConditions.visibilityOf(dynamic_control.theCheckbox()));
            System.out.println("The checkbox is visible, the Test Passed");
        }
    }

    @Test(description = "Should the button Add displayed, and checkbox invisible", priority = 1, enabled = true)
    public void dynamic_controls_Nocheckbox() throws IOException, InterruptedException {
        driver.get("http://localhost:7080/dynamic_controls");

        dynamic_controlsPage dynamic_control = new dynamic_controlsPage(driver);

        dynamic_control.buttonAddRemoveClick();
        wait.until(ExpectedConditions.invisibilityOf(dynamic_control.theLoading()));
        String s = dynamic_control.currentButtonAddRemove();
        System.out.println(s);

        if (s.compareTo("Add") == 0) {

            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkbox")));
            System.out.println("The checkbox is hidden, the Test Passed");
        }
    }

    @Test(description = "Should the button Enable displayed, and the Input disabled", priority = 1, enabled = true)
    public void dynamic_controls_input_disabled() throws IOException, InterruptedException {
        driver.get("http://localhost:7080/dynamic_controls");

        dynamic_controlsPage dynamic_control = new dynamic_controlsPage(driver);

        dynamic_control.buttonEnableDisableClick();
        wait.until(ExpectedConditions.invisibilityOf(dynamic_control.theLoading()));
        dynamic_control.buttonEnableDisableClick();
        wait.until(ExpectedConditions.invisibilityOf(dynamic_control.theLoading()));
        String s = dynamic_control.currentButtonEnableDisable();
        System.out.println(s);

        if (s.compareTo("Enable") == 0) {

            wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(dynamic_control.theInput())));
            System.out.println("The input is disabled, the Test Passed");
        }
    }

    @Test(description = "Should the button Disable displayed, and Input enabled", priority = 1, enabled = true)
    public void dynamic_controls_input_enabled() throws IOException, InterruptedException {
        driver.get("http://localhost:7080/dynamic_controls");

        dynamic_controlsPage dynamic_control = new dynamic_controlsPage(driver);

        dynamic_control.buttonEnableDisableClick();
        wait.until(ExpectedConditions.invisibilityOf(dynamic_control.theLoading()));
        String s = dynamic_control.currentButtonEnableDisable();
        System.out.println(s);

        if (s.compareTo("Disable") == 0) {

            wait.until(ExpectedConditions.elementToBeClickable(dynamic_control.theInput()));
            System.out.println("The input is enabled, the Test Passed");
        }
    }

    @AfterTest
    public void endTest() {
        driver.quit();
    }
}
