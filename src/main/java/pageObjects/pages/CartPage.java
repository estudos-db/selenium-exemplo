package pageObjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class CartPage {
    WebDriver driver;
    public CartPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
    }
    @FindBy(id = "checkout")
    WebElement checkoutButton;

    public CheckoutPage clickCheckoutButton() {
        this.checkoutButton.click();
        return new CheckoutPage(driver);
    }
}
