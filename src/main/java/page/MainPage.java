package page;
/*
使用cookie登录企业微信，
cookie可以使用复用浏览器获取（未实现）
 */

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

public class MainPage extends BasePage {

    public MainPage() {
        super();
        String url = "https://work.weixin.qq.com/wework_admin/frame";

        driver.get(url);
        driver.manage().deleteAllCookies();

        driver.manage().addCookie(new Cookie("wwrtx.i18n_lan", "zh"));
        driver.manage().addCookie(new Cookie("wwrtx.ref", "direct"));
        driver.manage().addCookie(new Cookie("wwrtx.refid", "9097355493256822"));
        driver.manage().addCookie(new Cookie("ww_rtkey", "6767381315"));
        driver.manage().addCookie(new Cookie("_ga", "GA1.2.24987997.1591278857"));
        driver.manage().addCookie(new Cookie("_gid", "GA1.2.1765389199.1591278857"));
        driver.manage().addCookie(new Cookie("_gat", "1"));
        driver.manage().addCookie(new Cookie("wwrtx.d2st", "a2816483"));
        driver.manage().addCookie(new Cookie("wwrtx.sid", "FupFbNM-h5n3bltodzQEUavUuh-og05_3KQAvcMbKtCVOJSpwmN0Ka2hpWLZL1aH"));
        driver.manage().addCookie(new Cookie("wwrtx.ltype", "1"));
        driver.manage().addCookie(new Cookie("wxpay.corpid", "1970325060135325"));
        driver.manage().addCookie(new Cookie("wxpay.vid", "1688853383145960"));
        driver.manage().addCookie(new Cookie("wwrtx.vst", "m-bj_h6-UXUz8briopc0bPc9XaP5G2BzyreDEXMmtB8KVASB7tI6UYyjlEsqpadm2_56nzPz6XlW_Auv-jUcTenq86e_CewKdbboXjZnjDvLWpA9sogdJpczD1yMWI_I76Ucot5Xf8hOzVO1NHNedF6wQxeEkbpEqoq2W0xLBGOkGIUjsIFBiGmJoEzlHVNZSkGqF-p0kDXOpjb7RcZR97fMdjwSd-GQxYrINVZDXpZNDcgmKnPNYU4o61-3hFL3zfZE_silUdKG9kkoVFh3cw"));
        driver.manage().addCookie(new Cookie("wwrtx.vid", "1688853383145960"));
        driver.manage().addCookie(new Cookie("wwrtx.logined", "true"));


        driver.get(url);

    }


    public ContactPage toContact() {
        click(By.cssSelector("#menu_contacts"));
        // driver.findElement(By.cssSelector("#menu_contacts")).click();
        return new ContactPage(driver);

    }


}
