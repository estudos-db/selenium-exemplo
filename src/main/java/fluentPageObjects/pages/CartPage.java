package fluentPageObjects.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class CartPage {
    private final WebDriver driver;
    public CartPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
    }

    @FindBy(xpath = "//button[contains(text(), 'Checkout')]")
    WebElement checkoutButton;

    public CheckoutPage checkout() {
        checkoutButton.click();
        return new CheckoutPage(driver);
    }
}
