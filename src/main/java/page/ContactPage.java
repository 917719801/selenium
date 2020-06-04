package page;
/*
添加企业微信添加成员操作
 */


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactPage extends BasePage {


    public ContactPage(RemoteWebDriver driver) {
        super(driver);
    }

    public ContactPage addMember(String username, String acctid, String mobile) {

        // By addMember =By.linkText("添加成员");

        //显式等待
        // new WebDriverWait(MainPage.driver, Duration.ofSeconds(10))
        //        .until(ExpectedConditions.elementToBeClickable(addMember));
        driver.findElement(By.linkText("添加成员")).click();
        driver.findElement(By.name("username")).sendKeys("2");
        driver.findElement(By.name("acctid")).sendKeys("2");
        driver.findElement(By.name("mobile")).sendKeys("18829781053");
        driver.findElement(By.cssSelector(".member_colRight_operationBar:nth-child(3) > .js_btn_save")).click();
        return this;

    }

}
