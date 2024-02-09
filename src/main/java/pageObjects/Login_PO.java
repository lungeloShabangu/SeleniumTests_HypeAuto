package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Global_Vars;

public class Login_PO extends Base_PO {

    private @FindBy(xpath = "//input[@type='text' and @id='text']") WebElement username_TextField;
    private @FindBy(xpath = "//input[@type='password' and @id='password']") WebElement  password_TextField;
    private @FindBy(xpath = "//*[@type='submit' and @id='login-button']") WebElement  submit_Button;

    public Login_PO() {
        super();
    }
    public void navigateToWebDriveUniversity_LoginPage() {
        navigateTo_URL(Global_Vars.WEBDRIVER_UNIVERSITY_HOMEPAGE+"/Login-Portal/index.html");
    }
   //METHODS
    public void setUsername(String username) {
        sendKeys(username_TextField, username);
    }
    public void setPassword(String password) {
        sendKeys(password_TextField, password);
    }
    public void clickSubmit() {
        clickElement(submit_Button);
    }
    public void validate_SuccessfulLoginMessage(){
        waitForAlert_And_ValidateText("validation succeeded");
    }
    public void validate_UnsuccessfulLoginMessage(){
        waitForAlert_And_ValidateText("validation failed");
    }

    public void validate_LoginMessage(String actualText){
        waitForAlert_And_ValidateText(actualText);
    }
}
