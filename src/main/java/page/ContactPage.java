package page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactPage {
    By addMember = By.linkText("添加成员");
    By delete = By.linkText("删除");


    public ContactPage addMember(String username, String acctid, String mobile) {
        // By addMember =By.linkText("添加成员");

        //显式等待，就算可点击也有一定的概率点击不成功
        new WebDriverWait(MainPage.driver, 10)
                .until(ExpectedConditions.elementToBeClickable(addMember));
        while (MainPage.driver.findElements(addMember).size() > 0) {
            MainPage.driver.findElement(addMember).click();
        }

        MainPage.driver.findElement(By.name("username")).sendKeys(username);
        MainPage.driver.findElement(By.name("acctid")).sendKeys(acctid);
        MainPage.driver.findElement(By.name("mobile")).sendKeys(mobile);
        MainPage.driver.findElement(By.cssSelector(".member_colRight_operationBar:nth-child(3) > .js_btn_save")).click();
        return this;

    }

    //搜索用户
    public ContactPage search(String keyword) {

        MainPage.driver.findElement(By.id("memberSearchInput")).sendKeys(keyword);
        new WebDriverWait(MainPage.driver, 10)
                .until(ExpectedConditions.elementToBeClickable(delete));

        return this;
    }

    //删除用户
    public ContactPage delete() {
        //显示等待不行是只能加死等
      /*  try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        MainPage.driver.findElement(delete).click();
        MainPage.driver.findElement(By.linkText("确认")).click();
        MainPage.driver.findElement(By.id("clearMemberSearchInput")).click();
        return this;

    }

}
