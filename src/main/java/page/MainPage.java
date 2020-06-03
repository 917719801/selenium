package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

public class MainPage {
    public  static WebDriver driver;

    public MainPage() {
        String url = "https://work.weixin.qq.com/wework_admin/frame";
        driver = new ChromeDriver();
        //隐式等待5秒
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().deleteAllCookies();

        driver.manage().addCookie(new Cookie("wwrtx.i18n_lan", "zh"));
        driver.manage().addCookie(new Cookie("wwrtx.ref", "direct"));
        driver.manage().addCookie(new Cookie("wwrtx.refid", "909735549810537"));
        driver.manage().addCookie(new Cookie("ww_rtkey", "9961697925"));
        driver.manage().addCookie(new Cookie("_ga", "GA1.2.373260356.1591193611"));
        driver.manage().addCookie(new Cookie("_gid", "GA1.2.1323011829.1591193611"));
        driver.manage().addCookie(new Cookie("wwrtx.d2st", "a1614513"));
        driver.manage().addCookie(new Cookie("wwrtx.sid", "FupFbNM-h5n3bltodzQEUWs28zxUpXCXqC-mCCosV-gH8-h8JDCNLAi1Hmg6yHV8"));
        driver.manage().addCookie(new Cookie("wwrtx.ltype", "1"));
        driver.manage().addCookie(new Cookie("wxpay.corpid", "1970325060135325"));
        driver.manage().addCookie(new Cookie("wxpay.vid", "1688853383145960"));
        driver.manage().addCookie(new Cookie("wwrtx.vst", "YnliCEwx3dcho78V9E89lvnCYM2HRJoJN_oUh6LG_1gdd2CPdnSL2elOHUf43toM7xUz2PmOpqdh7rrWGNfpqspDQtJdtLFfdifJkQb-N_balarVFs4-lSIfDvGMFSA2WYFkvU78YvaGFUkOqn3OZ2LKudTcBDRVsbrh9cp9nXk4LjZjJkke6A7zbIUCjPaVoDSvknp0Nqt2Q8pE0ALoSf6di1OhBDHvNhsH8XSAM_4LlMopX3QW-mkW7KoCwV1Iofu5UBnpF3HKOKQJvhcU3w"));
        driver.manage().addCookie(new Cookie("wwrtx.vid", "1688853383145960"));
        driver.manage().addCookie(new Cookie("wwrtx.logined", "true"));
        driver.manage().addCookie(new Cookie("_gat", "1"));


                driver.get(url);

    }


    public ContactPage toContact() {

        driver.findElement(By.cssSelector("#menu_contacts")).click();
        return new ContactPage();

    }
}
