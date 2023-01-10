package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class context_menuPage {

    WebDriver driver;

    public context_menuPage(WebDriver driver) {
        this.driver = driver;
    }

    By hot_spot = By.id("hot-spot");

    public void clickcontext_menu() {

        Actions action = new Actions(driver);
        action.contextClick(driver.findElement(hot_spot)).perform();
    }

}
