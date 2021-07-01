package src.test.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase{

    public static WebDriver driver;

    @BeforeTest
    @Parameters({"browser"})
    public static void OpenDriver(@Optional("chrome") String browserName) {

        if (browserName.equalsIgnoreCase( "chrome")){
            System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }

        else if (browserName.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://evernote.com/");
    }

    @AfterTest
    public void Closedriver(){
        driver.quit();
    }
}
