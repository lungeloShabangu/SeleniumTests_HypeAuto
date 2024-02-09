package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = {"classpath:features"}, glue = {"stepDefinations"},
        tags = "@contact-us", monochrome = true, dryRun = false,
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"})
public class MainRunner extends AbstractTestNGCucumberTests {
    /*dry run doesnt run the selenium code in your steps, Runs the steps
     * monochrome formats and makes code on the console readable
     * plugin helps gives more info in the console
     * webdriver
     * webdriver123
     * Validate successful and unsuccessful login
     * */
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}

