package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    
    By usrName = By.id("username");
    By pswd = By.id("password");
    By loginButton = By.xpath("//button[@type='submit']");
    By errorFlash = By.xpath("//div[@id='flash']");
    By secureArea = By.xpath("//h2[contains(text(),'Secure Area')]");

    public void enterUserName(String user) {
        driver.findElement(usrName).sendKeys(user);
    }

    public void enterPassword(String pass) {
        driver.findElement(pswd).sendKeys(pass);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public String secureAreaText() {
        return driver.findElement(secureArea).getText();
    }

    public String errorMessage() {
        return driver.findElement(errorFlash).getText();
    }
}
