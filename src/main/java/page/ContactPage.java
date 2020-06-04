package page;
/*
添加企业微信添加成员操作
 */


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactPage {
    public ContactPage addMember(String username, String acctid, String mobile){
       // By addMember =By.linkText("添加成员");

        //显式等待
       // new WebDriverWait(MainPage.driver, Duration.ofSeconds(10))
        //        .until(ExpectedConditions.elementToBeClickable(addMember));
        MainPage.driver.findElement(By.linkText("添加成员")).click();
        MainPage.driver.findElement(By.name("username")).sendKeys("2");
        MainPage.driver.findElement(By.name("acctid")).sendKeys("2");
        MainPage.driver.findElement(By.name("mobile")).sendKeys("18829781053");
        MainPage.driver.findElement(By.cssSelector(".member_colRight_operationBar:nth-child(3) > .js_btn_save")).click();
        return this;

    }

}
