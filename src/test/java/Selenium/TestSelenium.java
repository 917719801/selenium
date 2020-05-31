package Selenium;
/*
使用cookie实现免登陆
 */

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;

public class TestSelenium {
    WebDriver driver;

    @Test
    public void testSelenium() throws InterruptedException {
        //复用浏览器
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");
        driver = new ChromeDriver();
        driver.get("https://work.weixin.qq.com/wework_admin/frame");
        //获取cookie
        //driver.manage().getCookies();
        //打印获取的cookie
        //System.out.println(driver.manage().getCookies());
        driver.get("https://work.weixin.qq.com/wework_admin/frame");
        Thread.sleep(5000);
    }

    public void loadCookie() {
        //读取cookie内容
        try {
            FileReader fileReader = new FileReader("cookie.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, ";");
                String name = tokenizer.nextToken();
                String value = tokenizer.nextToken();
                String domain = tokenizer.nextToken();
                String path = tokenizer.nextToken();
                //将expiry的string格式转换为日期格式
                Date expiry = null;
                String dt = tokenizer.nextToken();
                if (!dt.equals("null")) {
                    SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
                    expiry = sdf.parse(dt);
                }
                //把String转换为Boolean
                boolean isSecure = Boolean.parseBoolean(tokenizer.nextToken());
                Cookie cookie = new Cookie(name, value, domain, path, expiry, isSecure);
                driver.manage().addCookie(cookie);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void SaveCookie() {
        try {
            //保存获取的cookie内容到cookie.txt
            File file = new File("cookie.txt");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Cookie cookie : driver.manage().getCookies()) {
            /*获取所有的cookie内容
            cookie.getName();
            cookie.getValue();
            cookie.getDomain();
            cookie.getPath();
            cookie.getExpiry();
            cookie.isSecure();
            */
                bufferedWriter.write(cookie.getName() + ";" +
                        cookie.getValue() + ";" +
                        cookie.getDomain() + ";" +
                        cookie.getPath() + ";" +
                        cookie.getExpiry() + ";" +
                        cookie.isSecure());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

