package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class dynamic_loadingPage {

    WebDriver driver;
    WebDriverWait wait;

    public dynamic_loadingPage(WebDriver driver) {
        this.driver = driver;
    }

    By helloWorld = By.xpath("//h4[contains(text(),'Hello World!')]");
    By loading = By.id("loading");
    By start = By.xpath("//button[contains(text(),'Start')]");

    public void clickStart() {
        driver.findElement(start).click();
    }

    public WebElement theStart() {
        return driver.findElement(start);
    }

    public WebElement theLoading() {
        return driver.findElement(loading);
    }

    public String HelloWorld() {
        return driver.findElement(helloWorld).getText();
    }
}
