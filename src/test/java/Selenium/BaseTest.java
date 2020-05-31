package Selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseTest {
    public  static WebDriver driver;

    @BeforeAll
    public static  void intaData(){
        String browserName = System.getenv("browser");
        if("chrome".equals(browserName)){
          System.setProperty("webdriver.chrome.driver", "D:\\WebDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        }else if("firefox".equals(browserName)){
            System.setProperty("webdriver.gecko.driver", "D:\\WebDriver\\geckodriver.exe");
            driver = new FirefoxDriver();

        }else if("ie".equals(browserName)){
            System.setProperty("webdriver.ie.driver","D:\\WebDriver\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }

    }

    @AfterAll
    public static void  tearDown(){
        driver.quit();
    }


}