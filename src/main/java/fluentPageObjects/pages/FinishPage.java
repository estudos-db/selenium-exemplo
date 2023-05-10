package fluentPageObjects.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class FinishPage {
    public FinishPage(WebDriver driver){
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
    }

    @FindBy(className = "complete-header")
    WebElement getSuccessMessage;

    public String getSuccessMessage(){
        return getSuccessMessage.getText();
    }
}
