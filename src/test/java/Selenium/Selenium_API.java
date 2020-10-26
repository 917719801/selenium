package Selenium;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Selenium_API {
    public static WebDriver driver;
    public static WebDriverWait wait;
    @BeforeAll
    public static void initData() {
        System.setProperty("webdriver.chrome.driver", "D:\\webdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    @Test
    public void visitUrl(){

        String baseUrl = "https://www.sogou.com/";
        //第一种访问方式
        driver.get(baseUrl);
    }
    @Test
    void visitURL2() throws InterruptedException {
        String baseUrl = "https://www.sogou.com/";
        //第二种访问方式
        driver.navigate().to(baseUrl);
    }
    @Test
    void visitRecentURL(){
        String baseUrl1 = "https://www.sogou.com/";
        String baseUrl2 = "https://www.baidu.com/";
        driver.navigate().to(baseUrl1);//先访问搜狗
        driver.navigate().to(baseUrl2);//再访问百度
        driver.navigate().back();//再返回搜狗

    }

}
