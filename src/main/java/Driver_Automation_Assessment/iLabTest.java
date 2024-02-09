package Driver_Automation_Assessment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Base_PO;
import utils.Global_Vars;

import java.util.Random;

public class iLabTest extends Base_PO {

    private @FindBy(xpath = "//a[contains(text(),'South Africa')]") WebElement southAfricaLink;
    private @FindBy(xpath = "(//*[contains(text(),'Current Openings')]/..//ul//li)[1]") WebElement firstAvailableJob;
    private @FindBy(xpath = "//input[@name='firstname']") WebElement firstName;
    private @FindBy(xpath = "//input[@name='lastname']") WebElement lastName;
    private @FindBy(xpath = "//input[@name='email']") WebElement emailAddress;
    private @FindBy(xpath = "//input[@name='phone']") WebElement phoneNumber;
    private @FindBy(xpath = "//textarea[@name='message']") WebElement message;//input[@value='Submit']
    private @FindBy(xpath = "//input[@value='Submit']") WebElement submitButton;

    @BeforeTest
    public void navigateToCareers(){
        navigateTo_URL("https://www.ilabquality.com/career-opportunities/");
    }

    @Test
    public void applyNow() {
        //Clicking on South Africa Link
        scrollToElement(southAfricaLink);
        clickElement(southAfricaLink);

        //Clicking the first available Job
        scrollToElement(firstAvailableJob);
        clickElement(firstAvailableJob);

        //Setting First name
        sendKeys(firstName, "Lungelo");
        scrollToElement(firstName);

        //Setting Last name
        scrollToElement(lastName);
        sendKeys(lastName,"Shabangu");

        //Setting Email
        scrollToElement(emailAddress);
        sendKeys(emailAddress, "automationAssessment@iLABQuality.com");

        //Setting phone number
        scrollToElement(phoneNumber);
        sendKeys(phoneNumber, generateRandomNumber());
        //Setting message
        sendKeys(message, "I would like to work at iLAB because it is a good company to grow and expand my career and experience");
        //Clicking Submit Button
        clickElement(submitButton);
    }

    public String generateRandomNumber(){
        Random random=new Random();
        int n1= random.nextInt(9999);
        int n2=random.nextInt(9999);
        String n3="081";
        String sumFormat=n3+" "+n2+" "+n1;
       // System.out.println("Generated Number "+sumFormat);
        return sumFormat;
    }
}
