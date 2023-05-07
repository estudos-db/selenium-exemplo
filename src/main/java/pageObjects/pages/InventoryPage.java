package pageObjects.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class InventoryPage {
    private WebDriver driver;
    public InventoryPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
    }
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addToCartButton;
    @FindBy(className =  "shopping_cart_link")
    WebElement cartButton;
    public void clickAddToCartButton() {
        this.addToCartButton.click();
    }
    public CartPage clickCartButton() {
        this.cartButton.click();
        return new CartPage(driver);
    }
}
