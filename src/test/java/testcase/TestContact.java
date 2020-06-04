package testcase;
/*
企业微信使用cookie实现免登录后添加人员
 */

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import page.MainPage;

public class TestContact {
    @Test
    void testAddMember(){
        MainPage main=new MainPage();
        main.toContact().addMember("3","3","15609223996");

    }
    @AfterAll
    public  static  void afterAll(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MainPage.driver.quit();
    }
}
