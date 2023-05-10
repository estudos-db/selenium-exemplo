package buy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.pages.CartPage;
import pageObjects.pages.CheckoutPage;
import pageObjects.pages.FinishPage;
import pageObjects.pages.HomePage;
import pageObjects.pages.InventoryPage;
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

        inventoryPage.clickAddToCartButton();
        CartPage cartPage = inventoryPage.clickCartButton();

        CheckoutPage checkoutPage = cartPage.clickCheckoutButton();

        checkoutPage.setFirstNameField("Antonio");
        checkoutPage.setLastNameField("Da Silva");
        checkoutPage.setPostalCodeField("9602785");
        checkoutPage.clickCheckoutButton();
        FinishPage finishPage = checkoutPage.clickFinishButton();
        Assertions.assertEquals(finishPage.getSuccessMessage(), "Thank you for your order!");
    }
}
