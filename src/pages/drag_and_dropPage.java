package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class drag_and_dropPage {

    WebDriver driver;

    public drag_and_dropPage(WebDriver driver) {
        this.driver = driver;
    }

    By columns = By.id("columns");

    public void drag_and_drop(String source, String target) throws IOException, InterruptedException {
        File currentPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath());
        String filePath = currentPath + "/../src/pages/dnd.js";
        StringBuffer buffer = new StringBuffer();
        String line;
        BufferedReader br;
        br = new BufferedReader(new FileReader(filePath));

        while ((line = br.readLine()) != null)
            buffer.append(line);

        String javaScript = buffer.toString();
        javaScript = javaScript + "$('" + source + "').simulateDragDrop({ dropTarget: '" + target + "'});";
        ((JavascriptExecutor) driver).executeScript(javaScript);
        br.close();

    }

    public String currentHeaders() {
        String s = "";

        List<WebElement> columns = driver.findElements(By.xpath("//*[@class='column']"));
        for (WebElement header : columns) {
            s = s + header.getText();
        }
        return s;
    }
}
