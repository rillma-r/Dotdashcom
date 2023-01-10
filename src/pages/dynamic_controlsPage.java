package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class dynamic_controlsPage {

    WebDriver driver;
    WebDriverWait wait;

    public dynamic_controlsPage(WebDriver driver) {
        this.driver = driver;
    }

    By buttonAddRemove = By.xpath("//form[@id='checkbox-example']/button");
    By buttonEnableDisable = By.xpath("//form[@id='input-example']/button");
    By loading = By.id("loading");
    By checkbox = By.id("checkbox");
    By input = By.xpath("//input[@type='text']");

    public String currentButtonAddRemove() {
        return driver.findElement(buttonAddRemove).getText();
    }

    public String currentButtonEnableDisable() {
        return driver.findElement(buttonEnableDisable).getText();
    }

    public void buttonAddRemoveClick() {
        driver.findElement(buttonAddRemove).click();
    }

    public void buttonEnableDisableClick() {
        driver.findElement(buttonEnableDisable).click();
    }

    public WebElement theCheckbox() {
        return driver.findElement(checkbox);
    }

    public WebElement theLoading() {
        return driver.findElement(loading);
    }

    public WebElement theInput() {
        return driver.findElement(input);
    }
}
