package pageObjects;

import driver.DriverFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Global_Vars;

import java.sql.Driver;
import java.time.Duration;

public class Base_PO {

    public Base_PO(){
        //initializes all our Page Objects since they are going to inherit this class
        PageFactory.initElements(getDrive(), this);
    }

    public WebDriver getDrive(){
        return DriverFactory.getDriver();
    }

    public String generateRandomNumber(int num){

        return RandomStringUtils.randomNumeric(num);
    }


    public void navigateTo_URL(String url){

        getDrive().get(url);
    }

    public boolean scrollToElement(WebElement elements) {
        String elementXpath= elements.getText();
        try {
            WebElement element = getDrive().findElement(By.xpath(elementXpath));
            ((JavascriptExecutor) getDrive()).executeScript("arguments[0].scrollIntoView(true);", element);
            return true;
        } catch (Exception e) {
            e.getMessage();
            return false;
        }

    }

    public void sendKeys(By by, String keys){

        WebDriverWait wait = new WebDriverWait(getDrive(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(keys);
    }
    public void sendKeys(By by, String keys, int waitTime){

        WebDriverWait wait = new WebDriverWait(getDrive(), Duration.ofSeconds(waitTime));
        wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(keys);
    }

    public void sendKeys(WebElement element, String keys){

        WebDriverWait wait = new WebDriverWait(getDrive(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(keys);
    }
    public void waitAndSendKeys(WebElement element, String keys, int waitTime){

        WebDriverWait wait = new WebDriverWait(getDrive(), Duration.ofSeconds(waitTime));
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(keys);
    }

    public void waitAndClickElement(By by,int waitTime){

        WebDriverWait wait = new WebDriverWait(getDrive(), Duration.ofSeconds(waitTime));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
        }
    public void waitFor(By by,int waitTime){

        WebDriverWait wait = new WebDriverWait(getDrive(), Duration.ofSeconds(waitTime));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }
    public void waitFor(WebElement element,int waitTime){

        WebDriverWait wait = new WebDriverWait(getDrive(), Duration.ofSeconds(waitTime));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitAndClickElement(WebElement element,int waitTime){

        WebDriverWait wait = new WebDriverWait(getDrive(), Duration.ofSeconds(waitTime));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    public void clickElement(By by){

        WebDriverWait wait = new WebDriverWait(getDrive(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }
    public void clickElement(WebElement element){

        WebDriverWait wait = new WebDriverWait(getDrive(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    public void waitForAlert_And_ValidateText(String expectedText){

        WebDriverWait wait = new WebDriverWait(getDrive(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.alertIsPresent());

        //extract text from alert box
        String alertMessageText=getDrive().switchTo().alert().getText();
        Assert.assertEquals(alertMessageText, expectedText);
    }
}
