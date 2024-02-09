package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.Base_PO;
import pageObjects.Login_PO;

import static driver.DriverFactory.getDriver;

public class Login_Steps extends Base_PO {

    private WebDriver driver = getDriver();
    private Login_PO login_po;

    public Login_Steps(Login_PO login_po){
        this.login_po=login_po;
    }
    @Given("Access to webdriver university login page")
    public void access_to_webdriver_university_login_page() {
       login_po.navigateToWebDriveUniversity_LoginPage();
    }

    @When("I enter username {word}")
    public void i_enter_username(String userName) {
        login_po.setUsername(userName);
    }

    @When("I enter a username {word}")
    public void i_enter_a_username_webdriver(String userName) {
        login_po.setUsername(userName);
        }

    @When("I enter password {word}")
    public void i_enter_password(String password) {
        login_po.setPassword(password);
       }

    @When("I click login button")
    public void i_click_login_button() {
       login_po.clickSubmit();
   }

    @Then("Pop up appears to validate success")
    public void pop_up_appears_to_validate_success() {
        login_po.validate_SuccessfulLoginMessage();
    }

    @Then("Pop up appears to validate unsuccess")
    public void pop_up_appears_to_validate_unsuccess() {
        login_po.validate_UnsuccessfulLoginMessage();
        }

    @Then("I should be presented with the following Login validation {}")
    public void i_should_be_presented_with_the_following_login_validation(String validationMessage) {
       login_po.validate_LoginMessage(validationMessage);
    }
}
