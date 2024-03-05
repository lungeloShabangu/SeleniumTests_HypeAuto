package Case_Study_Tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelDataReader;
import utils.Global_Vars;

public class Booker {
    WebDriver driver;
    @Test(dataProvider = "testData")
    public void yourTest(String username, String password, String EmailAddress, String FirstName, String LastName) {

        System.out.println("Username:\t"+username+"\nPassword:\t"+password+"\nFirstName:\t"+FirstName+"\nLastName:\t"+LastName+"\nEmail Address:\t"+EmailAddress);
//         Set up WebDriver and navigate to the login page
        driver = new ChromeDriver();
        driver.get("http://live.techpanda.org/index.php/customer/account/login/");

        // Find username and password fields and perform login
        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.id("pass")).sendKeys(password);
        driver.findElement(By.id("send2")).click();
    }
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    @DataProvider(name = "testData")
    public Object[][] testData() {
        String filePath = Global_Vars.ROOT_PATH + "/TestData/TestData.xlsx";
        String sheetName = "Login";
        return ExcelDataReader.readExcelData(filePath, sheetName);
    }
}
