package seleniumAPI;
/*
1.驱动浏览器访问网址
2.浏览器窗口操作
 */

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    void operateDropList() {
        driver.get("E:\\ideawork\\selenium\\bin\\droplist.html");
        //使用name属性找到页面上name属性为fruit的下拉列表元素
        Select dropList = new Select(driver.findElement(By.name("fruit")));
        //ismultiple标识下拉列表是否允许多选，被页面是一个单选下拉列表，所以此函数返回结果实false
        Assert.assertFalse(dropList.isMultiple());
        //getFirstSelectedOption().getText()方法表示获取当前被选中的下拉列表选项文本
        //断言当前选中的选项文本是否是桃子
        Assert.assertEquals("桃子", dropList.getFirstSelectedOption().getText());
        //selectByIndex方法表示选中下拉列表的第四个选项，即猕猴桃选项
        dropList.selectByIndex(3);
        Assert.assertEquals("猕猴桃", dropList.getFirstSelectedOption().getText());
        //selectByValue方法表示使用下拉列表选项的value属性进行操作，“shanzha"是选项的属性值
        dropList.selectByValue("shanzha");
        Assert.assertEquals("山楂", dropList.getFirstSelectedOption().getText());
        //selectByVisibleText方法表示通过选项的文字进行选中
        dropList.selectByVisibleText("荔枝");
        Assert.assertEquals("荔枝", dropList.getFirstSelectedOption().getText());

    }

    @Test
    void checkSelectText() {
        driver.get("E:\\ideawork\\selenium\\bin\\droplist.html");
        Select dropList = new Select(driver.findElement(By.name("fruit")));
        //声明一个list对象存储下拉列表中有期望出现的选项文字，并通过泛型<String>限定list
        //对象中的存储对象类型是String，Arrays。asList表示将一个数组转换为一个list对象
        List<String> expect_options = Arrays.asList((new String[]{"桃子", "西瓜", "橘子", "猕猴桃", "山楂", "荔枝"}));
        //声明一个新list对象，用于存取从页面上获取的所有选项文字
        List<String> actual_options = new ArrayList<String>();
        //dropList.getOptions方法用去获取页面上下拉列表中所有选项对象，
        // actual_options.add方法用户将实际打开页面中的每个选项添加到actual_options列表中
        for (WebElement option : dropList.getOptions()) {
            actual_options.add(option.getText());
        }
        //断言期望对象和实际对象的数组值是否完全一致
        Assert.assertEquals(expect_options.toArray(), actual_options.toArray());

    }

    @Test
    void operateMultipleOptionDropList() {
        driver.get("E:\\ideawork\\selenium\\bin\\multiple.html");
        //获取下拉列表元素
        Select dropList = new Select(driver.findElement(By.name("fruit")));
        //判断下拉列表是否支持多选
        Assert.assertTrue(dropList.isMultiple());
        //选择对应选项
        dropList.selectByIndex(3);
        dropList.selectByValue("shanzha");
        dropList.selectByVisibleText("荔枝");
        //取消所有选项的选中状态
        dropList.deselectAll();
        //依次点击
        dropList.selectByIndex(3);
        dropList.selectByValue("shanzha");
        dropList.selectByVisibleText("荔枝");
        //依次取消
        dropList.deselectByIndex(3);
        dropList.deselectByValue("shanzha");
        dropList.deselectByVisibleText("山楂");
    }

    @Test
    void operateRadio() {
        driver.get("E:\\ideawork\\selenium\\bin\\radio.html");
        //查找属性为“Berry”的单选按钮对象
        WebElement radioOption = driver.findElement(By.xpath("//input[@value='berry']"));
//        //判断次单选按钮是否处于未选中状态，未选中则调用click方法选中次单选按钮
        if (!radioOption.isSelected()) {
            radioOption.click();
        }
//        //断言属性为“berry”的单选按钮是否处于选中状态
        Assert.assertTrue(radioOption.isSelected());
        //查找name属性值为“fruit”的所有单选按钮对象，并存储到一个list容器中
        List<WebElement> fruits = driver.findElements(By.name("fruit"));
        //使用for循环将list容器中的按钮遍历一遍，查找value值为“watermelon”的按钮，如果查找到该按钮未处于选中状态则调用click方法进行点击
        for (WebElement fruit : fruits) {
            if (fruit.getAttribute("value").equals("watermelon")) {
                if (!fruit.isSelected()) {
                    fruit.click();
                    //断言是否选中
                    Assert.assertTrue(fruit.isSelected());
                    break;
                }
            }
        }
    }

    @Test
    void operateCheckBox() {
        driver.get("E:\\ideawork\\selenium\\bin\\checkbox.html");
        WebElement orangeCheckbox = driver.findElement(By.xpath("//input[@value='berry']"));
        if (!orangeCheckbox.isSelected()) {
            orangeCheckbox.click();
        }
        Assert.assertTrue(orangeCheckbox.isSelected());
        if (orangeCheckbox.isSelected()) {
            orangeCheckbox.click();
        }
        Assert.assertFalse(orangeCheckbox.isSelected());
        List<WebElement> checkboxs = driver.findElements(By.name("fruit"));
        //遍历list容器中的所有复选框元素，调用click方法点击复选框，让全部复选框处于选中状态
        for (WebElement checkbox : checkboxs) {
            checkbox.click();
        }
    }

    @Test
    void isElementTextPresent() {
        driver.get("E:\\ideawork\\selenium\\bin\\elementtext.html");
        //使用xpath找到第一个p元素
        WebElement text = driver.findElement(By.xpath("//p[1]"));
        //获取p元素标签的文字内容
        String contentText = text.getText();
        //判断p标签的文字内容是否与期望值一致
        Assert.assertEquals("《光荣之路》", contentText);
        //判断p标签的文字内容是否包含”光荣之路“
        Assert.assertTrue(contentText.contains("光荣之路"));
        //判断p标签文字内容是否以“《光荣”开头
        Assert.assertTrue(contentText.startsWith("《光荣"));
        //判断p标签文字内容是否以"之路》"结尾
        Assert.assertTrue(contentText.endsWith("之路》"));
    }

    @Test
    void executeJavaScript() {
        driver.get(baseUrl);
        //声明一个javaScript执行器对象
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //调用executeScript方法执行JavaScript脚本return document.title
        String title = (String) js.executeScript("return document.title");
        Assert.assertEquals("搜狗搜索引擎 - 上网从搜狗开始", title);
        //document.getElementById('stb')是JavaScript代码，表示获取页面的搜索按钮对象
        //return button.value表示返回搜索按钮上的文字
        String SerachButtonText=(String)js.executeScript("var button=document.getElementById('stb');return button.value");
        System.out.println(SerachButtonText);
    }
    @Test
    void dragpageElement(){
        //需重新找网址
        driver.get("http://jqueryui.com/resouces/demos/draggable/scroll.html");
        //找到页面上第一个能被拖拽的方案页面对象
        WebElement draggable=driver.findElement(By.id("braggable"));
        //向下拖动10个像素，共拖动5次
        for (int i =0;i<5;i++){
            //10 表示元素的纵坐标向下移动10个像素，0表示元素的横坐标不变
            new Actions(driver).dragAndDropBy(draggable,0,10).build().perform();
        }
        //向右拖动10个像素，共拖动5次
        for (int i=0;i<5;i++){
            //10表示元素的横向坐标向右移动10个像素，0表示元素的纵坐标不变
            new Actions(driver).dragAndDropBy(draggable,10,0).build().perform();
        }
    }


    @AfterAll
    public static void afterall() {
        driver.quit();
    }

}
