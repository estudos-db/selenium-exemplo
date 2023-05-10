package buy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import fluentPageObjects.pages.HomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import utils.BaseTest;

class FluentOrderTest extends BaseTest {
    final WebDriver driver = getDriver();
    HomePage homePage;

    @BeforeEach
    void initSession() {
        homePage = new HomePage(driver);
    }

    @DisplayName("Compra de produto com sucesso")
    @Test
    void testOrderSuccessfully() {
        String finalMessage = homePage.login("standard_user", "secret_sauce")
            .addBackpackToCart()
            .checkout()
            .fillInformation("Antonio", "Da Silva", "9602785")
            .finish()
            .getSuccessMessage();

        assertEquals(finalMessage, "Thank you for your order!");
    }
}
