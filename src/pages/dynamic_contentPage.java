package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class dynamic_contentPage {

    WebDriver driver;

    public dynamic_contentPage(WebDriver driver) {
        this.driver = driver;
    }

    By imageColumnLocator = By.xpath("//div/img");
    By textColumnLocator = By.xpath("//div[@class='large-10 columns']");

    public String imageColumn() {
        String s = "";
        List<WebElement> images = driver.findElements(imageColumnLocator);
        for (WebElement image : images) {
            s = s + image.getAttribute("src");
        }

        return s;
    }

    public String textColumn() {
        String s = "";
        List<WebElement> texts = driver.findElements(textColumnLocator);
        for (WebElement text : texts) {
            s = s + text.getText();
        }

        return s;
    }
}
