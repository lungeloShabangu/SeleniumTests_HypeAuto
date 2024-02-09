package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.Global_Vars;

public class Contact_Us_PO extends Base_PO{

    public Contact_Us_PO(){
        super();
    }
    private @FindBy(xpath = "//input[@name='first_name']") WebElement firstName_TextField;
    private @FindBy(xpath = "//input[@name='last_name']") WebElement lastName_TextField;
    private @FindBy(xpath = "//input[@name='email']") WebElement emailAddress_TextField;
    private @FindBy(xpath = "//textarea[@name='message']") WebElement comment_TextArea;
    private @FindBy(xpath = "//input[@class='contact_button' and @type='submit']") WebElement submit_Button;
    private @FindBy(xpath = "//*[contains(text(), 'Thank You for your Message!')]") WebElement output_Text;

    public void navigateToContactUsPage(){navigateTo_URL(Global_Vars.WEBDRIVER_UNIVERSITY_HOMEPAGE+"/Contact-Us/contactus.html");}
    public void setFirstName(String firstName){
        sendKeys(firstName_TextField, firstName);
    }
    public void setLastName(String lastName){
        sendKeys(lastName_TextField, lastName);
    }
    public void setEmailAddress(String emailAddress){
        sendKeys(emailAddress_TextField, emailAddress);
    }
    public void setComment(String comment){
        sendKeys(comment_TextArea, comment);
    }
    public void clickSubmitButton(){
        clickElement(submit_Button);
    }

    public void validate_Success_Submission_Text(){
        waitFor(output_Text,10);
        Assert.assertEquals(output_Text.getText(), "Thank You for your Message!");
    }
}
