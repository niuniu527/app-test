package com.demo.day03;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @Project: auto_app
 * @Site: http://www.lemonban.com
 * @Forum: http://testingpai.com
 * @Copyright: 2020 版权所有 湖南省零檬信息技术有限公司
 * @Author: luojie
 * @Create: 2020-09-29 20:50
 * @Desc： App元素定位
 **/
public class ElementLocator {

    private AndroidDriver androidDriver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "127.0.0.1:62001");
        desiredCapabilities.setCapability("appPackage", "com.lemon.lemonban");
        desiredCapabilities.setCapability("appActivity", "com.lemon.lemonban.activity.WelcomeActivity");

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        androidDriver = new AndroidDriver(remoteUrl, desiredCapabilities);
        //隐式等待
        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test() throws InterruptedException {
        //id（resource-id）定位，App是允许resource-id相同，如果有相同的resource-id，那么获取第一个元素。
//        androidDriver.findElement(MobileBy.id("com.lemon.lemonban:id/category_title")).click();
        //text 定位 AndroidUIAutomator()里面传入的java代码，只能用双引号。
//        androidDriver.findElement(MobileBy.AndroidUIAutomator
//                ("new UiSelector().text(\"全程班\")")).click();
        //className 类似于Web tagName 找的元素类型
//        WebElement element = androidDriver.findElement(MobileBy.className("android.widget.TextView"));
//        String text = element.getText();
//        System.out.println(text);
        //XPATH                                   //input[@name='xxxx']
//        androidDriver.findElement(MobileBy.xpath("//android.widget.TextView[@text='全程班']")).click();
//        androidDriver.findElement(MobileBy.xpath
//                ("//android.widget.FrameLayout[@resource-id='com.lemon.lemonban:id/navigation_tiku']")).click();
        //accessibility id 定位（读取的是元素的 content-desc属性）
//        androidDriver.findElement(MobileBy.AccessibilityId("我的柠檬")).click();
        //x，y点击方式 web 鼠标操作
//        Thread.sleep(3000);
//        TouchAction touchAction = new TouchAction(androidDriver);
//        PointOption pointOption = PointOption.point(445,1539);
//        touchAction.press(pointOption).release().perform();

        //toast 元素定位
        androidDriver.findElement(MobileBy.xpath
                ("//android.widget.FrameLayout[@resource-id='com.lemon.lemonban:id/navigation_tiku']")).click();
        androidDriver.findElement(MobileBy.id("com.lemon.lemonban:id/button_go_login")).click();
        androidDriver.findElement(MobileBy.id("com.lemon.lemonban:id/et_mobile")).sendKeys("13223233434");
        androidDriver.findElement(MobileBy.id("com.lemon.lemonban:id/et_password")).sendKeys("123456");
        androidDriver.findElement(MobileBy.id("com.lemon.lemonban:id/btn_login")).click();

//        String text = androidDriver.findElement(MobileBy.xpath("//*[@text='错误的账号信息']")).getText();
//        System.out.println(text);
        WebDriverWait wait = new WebDriverWait(androidDriver,5);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//*[@text='错误的账号信息']")));
        String text = element.getText();
        System.out.println(text);

    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        androidDriver.quit();
    }
}
