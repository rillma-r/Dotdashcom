package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class dropdownPage {

    WebDriver driver;

    public dropdownPage(WebDriver driver) {
        this.driver = driver;
    }

    By dropdown = By.id("dropdown");

    public void SelectOption(String option) {
        WebElement dropdown_elem = driver.findElement(dropdown);
        Select dropdown_select = new Select(dropdown_elem);
        dropdown_select.selectByValue(option);
        dropdown_select.toString();
        dropdown_select.getFirstSelectedOption();
    }

    public String currentOption() {
        WebElement dropdown_elem = driver.findElement(dropdown);
        Select dropdown_select = new Select(dropdown_elem);
        return dropdown_select.getFirstSelectedOption().getText();
    }
}
