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
        String url = "https://work.weixin.qq.com/wework_admin/frame";
        driver = new ChromeDriver();
        //隐式等待5秒
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().deleteAllCookies();

        driver.manage().addCookie(new Cookie("wwrtx.i18n_lan", "zh"));
        driver.manage().addCookie(new Cookie("wwrtx.ref", "direct"));
        driver.manage().addCookie(new Cookie("wwrtx.refid", "41798050431130991"));
        driver.manage().addCookie(new Cookie("ww_rtkey", "4739512104"));
        driver.manage().addCookie(new Cookie("_ga", "GA1.2.1631225281.1591021129"));
        driver.manage().addCookie(new Cookie("_gid", "GA1.2.1734151336.1591021129"));
        driver.manage().addCookie(new Cookie("_gat", "1"));
        driver.manage().addCookie(new Cookie("wwrtx.d2st", "a6961376"));
        driver.manage().addCookie(new Cookie("wwrtx.sid", "FupFbNM-h5n3bltodzQEUfITWkuEHLjrirgoPX924_Kby86MgySzY6etkSjA3Gp8"));
        driver.manage().addCookie(new Cookie("wwrtx.ltype", "1"));
        driver.manage().addCookie(new Cookie("wxpay.corpid", "1970325060135325"));
        driver.manage().addCookie(new Cookie("wxpay.vid", "1688853383145960"));
        driver.manage().addCookie(new Cookie("wwrtx.vst", "TqfHd0WheO0Re9NEIhh5Yl5ShpEbZLRCDPSs7UV_IlkvDjqNrbmhNJ0YtSjo1ys1loalg30M67cyxmu0agdN-kmhZjZdlhAoLxpZ0irtgiHDVb2lSsSghrtzDnpONWZxNMP1ToqopBnzAt13TOOqHXHoGdh9j8QrBdcal3bQIGAB-aAuDG_gqbLt7wujMz8P-S-R2JQsXOnF4T3xqENLuVGXUuJv2B4j8WqmYJ9zHZ8nEoyvtmpZRnB2RlCoOj4tU5u89_39sFOM6hnM7bUGkg"));
        driver.manage().addCookie(new Cookie("wwrtx.vid", "1688853383145960"));
        driver.manage().addCookie(new Cookie("wwrtx.logined", "true"));

        driver.get(url);

    }


    public ContactPage toContact() {

        driver.findElement(By.cssSelector("#menu_contacts")).click();
        return new ContactPage(driver);

    }

}
