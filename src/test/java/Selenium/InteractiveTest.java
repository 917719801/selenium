package Selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class InteractiveTest {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions actions;

    @BeforeAll
    public static void initData() {
        //System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "D:\\WebDriver\\geckodriver.exe");
        //  driver = new ChromeDriver();
        driver = new FirefoxDriver();
        actions = new Actions(driver) ;
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

  /*  @Test
    public void  clickTest() throws InterruptedException {
        driver.get("http://sahitest.com/demo/clicks.htm");

        actions.click(driver.findElement(By.xpath("//input[@value='click me']")));
        actions.doubleClick(driver.findElement(By.xpath("//input[@value='dbl click me']")));
        actions.contextClick(driver.findElement(By.xpath("//input[@value='right click me']")));
        actions.perform();
        Thread.sleep(5000);
    }*/
    @Test
    public  void moveTest() throws InterruptedException {
        driver.get("https://www.baidu.com/");
        actions.moveToElement(driver.findElement(By.id("s-usersetting-top")));
        actions.perform();
        Thread.sleep(5000);

    }


    @AfterAll
    public static void tearDown() {
        driver.quit();
    }


}