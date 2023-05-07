package pageObjects.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecondaryHeaderComponent {
    private WebDriver driver;
    public SecondaryHeaderComponent(WebDriver driver){
        this.driver = driver;
    }
    By getHeaderTitle = By.className("title");

    public String getHeaderText(){
        return driver.findElement(getHeaderTitle).getText();
    }
}
