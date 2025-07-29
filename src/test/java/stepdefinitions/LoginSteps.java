package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.DriverFactory;
import utils.ConfigReader;
import org.testng.Assert;

public class LoginSteps {

    WebDriver driver = DriverFactory.getDriver();
    LoginPage loginPage;

    @Given("user is on the SauceDemo login page")
    public void user_is_on_login_page() {
        driver.get(ConfigReader.get("baseUrl"));
        loginPage = new LoginPage(driver);
    }

    @When("user logs in with username {string} and password {string}")
    public void user_logs_in(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    @Then("user should be redirected to the inventory page")
    public void redirected_to_inventory_page() {
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
    }
}