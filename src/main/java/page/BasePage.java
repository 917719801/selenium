package page;
/*
将公共方法提取
 */

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {

    WebDriverWait wait;
    RemoteWebDriver driver;

    public BasePage(RemoteWebDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver, 10);

    }


    public BasePage() {
        driver = new ChromeDriver();
        //隐式等待5秒
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }

    public void quit() {
        driver.quit();
    }

    public void click(By by) {

        wait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();

    }

    public void sendKeys(By by, String content) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).sendKeys(content);

    }

}
