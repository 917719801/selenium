package testcase;
/*
企业微信使用cookie实现免登录后添加人员
 */

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import page.ContactPage;
import page.MainPage;

public class TestContact {
    static MainPage main;
    static ContactPage contact;

    @BeforeAll
    public static void beforeall() {
        main = new MainPage();
        contact = main.toContact();
    }

    @Test
    void testAddMember() {

        main.toContact().addMember("3", "3", "15609223996");

    }

    @AfterAll
    public static void afterAll() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        main.quit();
    }
}
