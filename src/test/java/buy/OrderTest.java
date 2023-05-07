package buy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import pageObjects.components.SecondaryHeaderComponent;
import pageObjects.pages.*;
import utils.BaseTest;

public class OrderTest extends BaseTest {
    private WebDriver driver = this.getDriver();

    @DisplayName("Compra de produto com sucesso")
    @Test
    public void testOrderSuccessfully() {
        HomePage homePage = new HomePage(driver);
        homePage.setUsernameField("standard_user");
        homePage.setPasswordField("secret_sauce");
        InventoryPage inventoryPage = homePage.submitLogin();
        SecondaryHeaderComponent secondaryHeaderComponent = new SecondaryHeaderComponent(driver);
        Assertions.assertEquals(secondaryHeaderComponent.getHeaderText(), "Products");

        inventoryPage.clickAddToCartButton();
        CartPage cartPage = inventoryPage.clickCartButton();
        Assertions.assertEquals(secondaryHeaderComponent.getHeaderText(), "Your Cart");

        CheckoutPage checkoutPage = cartPage.clickCheckoutButton();
        Assertions.assertEquals(secondaryHeaderComponent.getHeaderText(), "Checkout: Your Information");

        checkoutPage.setFirstNameField("Antonio");
        checkoutPage.setLastNameField("Da Silva");
        checkoutPage.setPostalCodeField("9602785");
        checkoutPage.clickCheckoutButton();
        FinishPage finishPage = checkoutPage.clickFinishButton();
        Assertions.assertEquals(finishPage.getSuccessMessage(), "Thank you for your order!");
    }
}
