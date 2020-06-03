package testcase;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import page.ContactPage;
import page.MainPage;

public class TestContact {
    static MainPage main;
    static ContactPage contact;

    @BeforeAll
    static void beforeall() {
        main = new MainPage();
        contact = main.toContact();
    }

    @Test
    void testAddMember() {

        contact.addMember("3", "3", "18829781053");
    }

    @Test
    void testSearch() {

        contact.search("3").delete();
    }


    @AfterAll
    public static void afterAll() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MainPage.driver.quit();
    }
}
