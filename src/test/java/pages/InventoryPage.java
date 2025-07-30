package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

    WebDriver driver;

    private By productTitle = By.className("title");
    private By addToCartBtn = By.id("add-to-cart-sauce-labs-backpack");
    private By cartIcon = By.className("shopping_cart_link");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean getPageTitle() {
        return driver.findElement(productTitle).isDisplayed();
    }

    public void addToCart() {
        driver.findElement(addToCartBtn).click();
    }

    public void clickCartIcon() {
        driver.findElement(cartIcon).click();
    }
}
