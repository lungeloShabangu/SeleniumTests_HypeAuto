package stepDefinations.base;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks {

    private WebDriver driver;

    public void setup(){
        //Pointing to the exe chromedriver
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/driver/drivers/chromedriver.exe");

        //Waits for the entire page to load
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
    }

    public void tearDown(){
        driver.quit();
    }
    public String generateRandomNumber(int num){

        return RandomStringUtils.randomNumeric(num);
    }
}
