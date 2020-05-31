package Selenium;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class seleniumTest01 {
    public static WebDriver driver;
    public static WebDriverWait wait;
    @BeforeAll
    public static void initData(){
        System.setProperty("webdriver.chrome.driver", "D:\\WebDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    @Test
    public void startSelenium(){


       // WebDriver wd= new InternetExplorerDriver();
        //System.setProperty("webdriver.ie.driver", "D:\\WebDriver\\IEDriverServer.exe");
        //System.setProperty("webdriver.gecko.driver", "D:\\geckodriver-v0.25.0-win64\\geckodriver.exe");

        driver.get("https://home.testing-studio.com/");
        driver.findElement(By.xpath("/html/body/section/div/div[1]/header/div/div/div[2]/span/button[2]/span")).click();
    }



    @AfterAll
    public static  void  afterall(){
        driver.quit();
    }


}
