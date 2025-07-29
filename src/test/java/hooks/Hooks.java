package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.DriverFactory;

public class Hooks {

    @Before(order = 0)
    public void setUp() {
        DriverFactory.getDriver();
    }

    @AfterStep
    public void takeScreenshot(Scenario scenario) {
        byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver())
                .getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "Step Screenshot");
    }

    @After(order = 1)
    public void tearDown() {
        // Uncomment this only if you want to close browser after every scenario
        // DriverFactory.quitDriver();
    }
    
    @io.cucumber.java.AfterAll
    public static void closeDriverOnceAllTestsFinish() {
        DriverFactory.quitDriver(); // Clean up once all scenarios are done
    }
}
