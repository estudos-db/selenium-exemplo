package fluentPageObjects.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class CheckoutPage {
    private final WebDriver driver;
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

    public CheckoutPage fillInformation(String firstName, String lastName, String postalCode) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        postalCodeField.sendKeys(postalCode);
        continueButton.click();
        return this;
    }

    public FinishPage finish(){
        finishButton.click();
        return new FinishPage(driver);
    }
}
