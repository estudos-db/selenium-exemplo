package pageObjects.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class CheckoutPage {
    WebDriver driver;
    public CheckoutPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
    }

    @FindBy(id = "first-name")
    WebElement firstNameField;
    @FindBy(id = "last-name")
    WebElement lastNameField;
    @FindBy(xpath = "//input[@name='postalCode']")
    WebElement postalCodeField;
    @FindBy(id = "continue")
    WebElement continueButton;
    @FindBy(id = "finish")
    WebElement finishButton;
    public void setFirstNameField(String firstname) {
        this.firstNameField.sendKeys(firstname);
    }
    public void setLastNameField(String lastname) {
        this.lastNameField.sendKeys(lastname);
    }
    public void setPostalCodeField(String postalcode) {
        this.postalCodeField.sendKeys(postalcode);
    }
    public void clickCheckoutButton() {
        this.continueButton.click();
    }
    public FinishPage clickFinishButton(){
        this.finishButton.click();
        return new FinishPage(driver);
    }
}
