package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.InventoryPage;
import pages.CartPage;
import utils.DriverFactory;
import org.testng.Assert;

public class CartSteps {

    WebDriver driver = DriverFactory.getDriver();
    InventoryPage inventoryPage;
    CartPage cartPage;

    @And("user adds a backpack to the cart")
    public void add_backpack_to_cart() {
        inventoryPage = new InventoryPage(driver);
        inventoryPage.addToCart();
    }

    @And("user clicks on cart icon")
    public void click_cart_icon() {
        inventoryPage.clickCartIcon();
    }

    @Then("cart should contain {string}")
    public void cart_should_contain_item(String expectedProduct) {
        cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.getCartItemText(), expectedProduct);
    }
}
