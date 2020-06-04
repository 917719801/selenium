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

import static org.junit.jupiter.api.Assertions.assertEquals;

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

        String username=contact.addMember("3", "3", "18829781053").search("3").getUserName();
        assertEquals(username,"3");

    }

    @Test
    void testSearch() {

        contact.search("3").delete();


    }
    @Test
    void testImportFile(){
        contact.importFile(this.getClass().getResource("/通讯录批量导入模板.xlsx"));

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
