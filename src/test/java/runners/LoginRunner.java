package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = {"classpath:features"}, glue = {"stepDefinations"},
        tags = "@Login", monochrome = true, dryRun = false,
        plugin = {"pretty", "html:target/cucumber", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class LoginRunner extends AbstractTestNGCucumberTests {
    WebDriver driver;

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}

