package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    private By cartItem = By.className("inventory_item_name");
    private By continueShoppingBtn = By.id("continue-shopping");
    private By menuButton = By.id("react-burger-menu-btn");
    private By logoutLink = By.id("logout_sidebar_link");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCartItemText() {
        return driver.findElement(cartItem).getText();
    }

    public void clickContinueShopping() {
        driver.findElement(continueShoppingBtn).click();
    }

    public void logout() {
        driver.findElement(menuButton).click();
        try { Thread.sleep(500); } catch (InterruptedException e) {}
        driver.findElement(logoutLink).click();
    }
}
