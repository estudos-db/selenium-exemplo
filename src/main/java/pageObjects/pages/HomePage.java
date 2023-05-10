package pageObjects.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage {
    private WebDriver driver;
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

//    By usernameField = By.id("user-name");
    public void setUsernameField(String username){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(this.username));
        this.username.sendKeys(username);
    }
    public void setPasswordField(String password){
        this.password.sendKeys(password);
    }
    public void submitLogin(){
        this.loginButton.click();
    }
}
