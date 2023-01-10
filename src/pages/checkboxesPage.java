package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class checkboxesPage {

    WebDriver driver;

    public checkboxesPage(WebDriver driver) {
        this.driver = driver;
    }

    By checkbox = By.xpath("//input[@type='checkbox']");

    public void selectAllCheckboxes() {
        List<WebElement> allcheckboxes = driver.findElements(checkbox);
        for (org.openqa.selenium.WebElement cb : allcheckboxes) {
            if (cb.isSelected() == false) {
                cb.click();
            }

        }
    }

    public boolean allchecked() {
        List<WebElement> allcheckboxes = driver.findElements(checkbox);
        boolean check = true;
        for (org.openqa.selenium.WebElement cb : allcheckboxes) {
            check = check && cb.isSelected();
        }
        return check;
    }

    public void unselectAllCheckboxes() {
        List<WebElement> allcheckboxes = driver.findElements(checkbox);
        for (org.openqa.selenium.WebElement cb : allcheckboxes) {
            if (cb.isSelected() == true) {
                cb.click();
            }

        }
    }

}
