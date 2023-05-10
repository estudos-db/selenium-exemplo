package fluentPageObjects.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage {
    private final WebDriver driver;

    public HomePage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
    }

    @FindBy(id = "user-name")
    WebElement username;
    @FindBy(name = "password")
    WebElement password;
    @FindBy(css = ".login-box .submit-button")
    WebElement loginButton;

    public InventoryPage login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.loginButton.click();
        return new InventoryPage(driver);
    }
}
