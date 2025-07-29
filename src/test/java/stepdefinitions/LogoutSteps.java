package stepdefinitions;

import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import utils.DriverFactory;

public class LogoutSteps {

    WebDriver driver = DriverFactory.getDriver();
    CartPage cartPage;

    @And("user clicks on continue shopping")
    public void click_continue_shopping() {
        cartPage = new CartPage(driver);
        cartPage.clickContinueShopping();
    }

    @And("user logs out successfully")
    public void user_logs_out() {
        cartPage.logout();
    }
}
