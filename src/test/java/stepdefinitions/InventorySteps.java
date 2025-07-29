package stepdefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.InventoryPage;
import utils.DriverFactory;
import org.testng.Assert;

public class InventorySteps {

    WebDriver driver = DriverFactory.getDriver();
    InventoryPage inventoryPage;

    @Then("user should see the inventory page with product list")
    public void user_should_see_product_list() {
        inventoryPage = new InventoryPage(driver);
        Assert.assertEquals(inventoryPage.getPageTitle(), "Products");
    }
}
