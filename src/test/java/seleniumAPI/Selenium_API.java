package seleniumAPI;
/*
1.驱动浏览器访问网址
2.浏览器窗口操作
 */

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Selenium_API {
    public static WebDriver driver;
    public static WebDriverWait wait;
    String baseUrl = "https://www.sogou.com/";

    @BeforeAll
    public static void initData() {
//        System.setProperty("webdriver.chrome.driver", "D:\\webdriver\\chromedriver.exe");
//        driver = new ChromeDriver();
        System.setProperty("webdriver.gecko.driver", "D:\\WebDriver\\geckodriver.exe");
        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void visitUrl() {

        String baseUrl = "https://www.sogou.com/";
        //第一种访问方式
        driver.get(baseUrl);
    }

    @Test
    void visitURL2() throws InterruptedException {
        String baseUrl = "https://www.sogou.com/";
        //第二种访问方式
        driver.navigate().to(baseUrl);
    }

    @Test
    void visitRecentURL() {
        String baseUrl1 = "https://www.sogou.com/";
        String baseUrl2 = "https://www.baidu.com/";
        driver.navigate().to(baseUrl1);//先访问搜狗
        driver.navigate().to(baseUrl2);//再访问百度
        driver.navigate().back();//再返回搜狗
        driver.navigate().forward();//从搜狗页面跳转到百度页面，模拟浏览器前进按钮
        driver.navigate().refresh();//刷新当前页面
    }

    @Test
    void operateBrowser() {
        String baseUrl = "https://www.sogou.com/";
        //设置浏览器在屏幕中的坐标150,150
        Point point = new Point(150, 150);
        //设置浏览器的大小为长500宽500
        Dimension dimension = new Dimension(500, 500);
        driver.manage().window().setPosition(point);
        driver.manage().window().setSize(dimension);
        //打印浏览器在屏幕中的位置及大小
        System.out.println(driver.manage().window().getPosition());
        System.out.println(driver.manage().window().getSize());
        //浏览器窗口最大化
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test
    void getTitle() {
        driver.get(baseUrl);
        //获取浏览器title属性
        String title = driver.getTitle();
        System.out.println(title);
        //断言title属性与"搜狗搜索引擎 - 上网从搜狗开始"是否一致
        Assert.assertEquals("搜狗搜索引擎 - 上网从搜狗开始", title);

    }

    @Test
    void getPageSource() {
        driver.get(baseUrl);
        //调用driver的getpageSource方法获取源代码
        String pageSource = driver.getPageSource();
        System.out.println(pageSource);
        //断言页面的源码中是否包含“购物”两个关键字，以此判断页面内容是否正确
        Assert.assertTrue(pageSource.contains("购物"));
    }

    @Test
    void getCurrentPageURL() {
        driver.get(baseUrl);
        //调用driver的getCurrentUrl方法获取URL地址
        String CurrentPageUrl = driver.getCurrentUrl();
        System.out.println(CurrentPageUrl);
        Assert.assertEquals(baseUrl, CurrentPageUrl);
    }

    @Test
    void clearInputBoxText() {
        driver.get("D:\\ideaworkspace\\selenium\\bin\\clear.html");
        //清除文本框中的默认文字
        driver.findElement(By.id("text")).clear();
        //等待3S方便查看效果
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void sendTextToInputBoxText() {
        driver.get("D:\\ideaworkspace\\selenium\\bin\\clear.html");
        driver.findElement(By.id("text")).clear();
        //向输入框输入指定内容
        driver.findElement(By.id("text")).sendKeys("输入指定内容");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void clickButton() {
        driver.get("D:\\ideaworkspace\\selenium\\bin\\clear.html");
        //点击ID为button的元素
        driver.findElement(By.id("button")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void doubleClick() {
        driver.get("D:\\ideaworkspace\\selenium\\bin\\doubleclick.html");
        //声明action对象
        Actions builder = new Actions(driver);
        //使用doubleclick方法在输入元素中进行双击操作
        builder.doubleClick(driver.findElement(By.id("inputBox"))).build().perform();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    void operateDropList(){
        driver.get("E:\\ideawork\\selenium\\bin\\droplist.html");
        //使用name属性找到页面上name属性为fruit的下拉列表元素
        Select dropList=new Select(driver.findElement(By.name("fruit")));
        //ismultiple标识下拉列表是否允许多选，被页面是一个单选下拉列表，所以此函数返回结果实false
        Assert.assertFalse(dropList.isMultiple());
        //getFirstSelectedOption().getText()方法表示获取当前被选中的下拉列表选项文本
        //断言当前选中的选项文本是否是桃子
        Assert.assertEquals("桃子",dropList.getFirstSelectedOption().getText());
        //selectByIndex方法表示选中下拉列表的第四个选项，即猕猴桃选项

        dropList.selectByIndex(3);
        Assert.assertEquals("猕猴桃",dropList.getFirstSelectedOption().getText());
//        //selectByValue方法表示使用下拉列表选项的value属性进行操作，“shanzha"是选项的属性值
        dropList.selectByValue("shanzha");
        Assert.assertEquals("山楂",dropList.getFirstSelectedOption().getText());
        //selectByVisibleText方法表示通过选项的文字进行选中
        dropList.selectByVisibleText("荔枝");
        Assert.assertEquals("荔枝",dropList.getFirstSelectedOption().getText());

    }


    @AfterAll
    public static void afterall() {
        driver.quit();
    }

}
