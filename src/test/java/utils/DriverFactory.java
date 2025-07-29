package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
    public static WebDriver getDriver() {
        ChromeOptions options = new ChromeOptions();

        // ✅ These arguments are essential for CI pipelines like GitHub Actions
        options.addArguments("--headless=new"); // Required for Chrome 109+
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-extensions");
        options.addArguments("--remote-allow-origins=*");

        // ✅ Remove user-data-dir if you're setting it
        // options.addArguments("--user-data-dir=/some/path"); ← REMOVE if exists

        return new ChromeDriver(options);
    }
}
