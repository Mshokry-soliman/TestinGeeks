package src.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Log In")
    public WebElement logIn;

    @FindBy(id = "username")
    public WebElement email;

    @FindBy(id = "loginButton")
    public WebElement loginBtn;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "responseMessageRow")
    public WebElement responsemessage;

    public void UserLogin() throws InterruptedException {
        logIn.click();
        email.sendKeys("testinggeeks@gmail.com");
        loginBtn.click();
        Thread.sleep(2000);
        password.sendKeys("T@g123456");
    }
}
