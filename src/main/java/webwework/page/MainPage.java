package webwework.page;
/*
使用cookie登录企业微信，
cookie可以使用复用浏览器获取（未实现）
 */

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;

public class MainPage extends BasePage {

    public MainPage() {
        super();
        String url = "https://work.weixin.qq.com/wework_admin/frame";

        driver.get(url);
        driver.manage().deleteAllCookies();

        driver.manage().addCookie(new Cookie("wwrtx.i18n_lan", "zh"));
        driver.manage().addCookie(new Cookie("wwrtx.ref", "direct"));
        driver.manage().addCookie(new Cookie("wwrtx.refid", "9097355491903240"));
        driver.manage().addCookie(new Cookie("ww_rtkey", "5725545429"));
        driver.manage().addCookie(new Cookie("_ga", "GA1.2.347845463.1591281104"));
        driver.manage().addCookie(new Cookie("_gid", "GA1.2.938006567.1591281104"));
        driver.manage().addCookie(new Cookie("wwrtx.ltype", "1"));
        driver.manage().addCookie(new Cookie("wxpay.corpid", "1970325060135325"));
        driver.manage().addCookie(new Cookie("wxpay.vid", "1688853383145960"));
        driver.manage().addCookie(new Cookie("wwrtx.vst", "CGBkwPPiqcn3XdqK4O8BbMAH2ZOALutHtxvG1SNZnAD1SmeUuq5lk6pncb9g5x1er17D21rZBD-EYPXt-deGSAShhzReZmE29Wd027N6L_Yg0-eZ48HcoP5dSqfVKMZhh2a5RIC6HATkce-3OnetR9M7OweuGp7SlG-EcXy9Kwyo1o8vT1D6Yn-yz_6fL0QU8xj18BdKOx-7-fu-jZ4PXpbdw5kT1azfGxXPx-OIaZGVs720gS3L7V_by1oGeae305rtnctgEXzZ_toKr0TH2w"));
        driver.manage().addCookie(new Cookie("wwrtx.vid", "1688853383145960"));
        driver.manage().addCookie(new Cookie("wwrtx.logined", "true"));
        driver.manage().addCookie(new Cookie("_gat", "1"));
        driver.manage().addCookie(new Cookie("wwrtx.d2st", "a6996964"));
        driver.manage().addCookie(new Cookie("wwrtx.sid", "FupFbNM-h5n3bltodzQEUYNUplNApVJONg0_aeF7bMZQOo1zoHv5iycj4qpIxErc"));


        driver.get(url);

    }



    public ContactPage toContact() {
        click(By.cssSelector("#menu_contacts"));
        // driver.findElement(By.cssSelector("#menu_contacts")).click();
        return new ContactPage(driver);

    }


}
