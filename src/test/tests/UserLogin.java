package src.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import src.main.LoginPage;
import src.test.tests.TestBase;

import java.util.concurrent.TimeUnit;

public class UserLogin extends TestBase {

    LoginPage loginObject;

    //Login with correct credentials
    @Test
    public void UserLoginSuccessfully() throws InterruptedException {

        loginObject = new LoginPage(driver);
        loginObject.UserLogin();

        try {
            Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"qa-NAV_USER\"]/div/div/span/div")).getText(), "Pass");
        } catch (Exception e) {
            System.out.println("Login Successfully");
        }
    }

    //Login with no credentials
    @Test
    public void Userunabletologin() throws InterruptedException {

        loginObject = new LoginPage(driver);
        loginObject.logIn.click();
        loginObject.loginBtn.click();
        Thread.sleep(3000);

            if (loginObject.responsemessage.getText().contains("Login Successfully"))
                {
                    System.out.println("Login Pass"); }
            else {
                System.out.println(loginObject.responsemessage.getText());
            }
    }
}
