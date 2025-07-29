package hooks;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.DriverFactory;
import utils.ExtentReportManager;

public class ExtentHooks {

    private static ExtentReports extent = ExtentReportManager.getInstance();
    private static ThreadLocal<ExtentTest> scenarioThread = new ThreadLocal<>();

    @Before
    public void beforeScenario(Scenario scenario) {
        ExtentTest test = extent.createTest(scenario.getName());
        scenarioThread.set(test);
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        TakesScreenshot ts = (TakesScreenshot) DriverFactory.getDriver();
        String base64 = ts.getScreenshotAs(OutputType.BASE64);
        
        if (scenario.isFailed()) {
            scenarioThread.get().fail("Step failed").addScreenCaptureFromBase64String(base64, "Failed Screenshot");
        } else {
            scenarioThread.get().info("Step passed").addScreenCaptureFromBase64String(base64, "Step Screenshot");
        }
    }

    @After
    public void afterScenario() {
        extent.flush();
    }
}
