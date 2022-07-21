package com.demo.day04;

import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;
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
 * @Create: 2020-10-10 21:35
 * @Desc： 手势操作-多点触摸
 **/
public class MultiSwipeTest {
    private AndroidDriver androidDriver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "127.0.0.1:62001");
        desiredCapabilities.setCapability("appPackage", "com.baidu.BaiduMap");
        desiredCapabilities.setCapability("appActivity", "com.baidu.baidumaps.WelcomeScreen");
        desiredCapabilities.setCapability("noReset",true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        androidDriver = new AndroidDriver(remoteUrl, desiredCapabilities);
        //隐式等待
        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test() throws InterruptedException {
        Thread.sleep(5000);
        for (int i = 0; i < 10; i++) {
            pinch();
            Thread.sleep(2000);
        }
    }

    /**
     * 放大
     */
    public void zoom() {
        //手指1
        TouchAction action1 = new TouchAction(androidDriver);
        //手指2
        TouchAction action2 = new TouchAction(androidDriver);
        int y = androidDriver.manage().window().getSize().getHeight();
        int x = androidDriver.manage().window().getSize().getWidth();
        //zoom 放大
        PointOption pointA = PointOption.point(x / 5, y / 5);
        PointOption pointB = PointOption.point(x * 2 / 5, y * 2 / 5);
        PointOption pointC = PointOption.point(x * 3 / 5, y * 3 / 5);
        PointOption pointD = PointOption.point(x * 4 / 5, y * 4 / 5);
        // 放大 = B -> A & C -> D
        //注意：同时操作不需要perform
        action1.press(pointB).moveTo(pointA).release();
        action2.press(pointC).moveTo(pointD).release();
        //创建多次触碰对象
        MultiTouchAction multiTouchAction = new MultiTouchAction(androidDriver);
        //添加触碰操作
        multiTouchAction.add(action1);
        multiTouchAction.add(action2);
        //一起执行多个操作
        multiTouchAction.perform();
    }

    public void pinch() {
        //手指1
        TouchAction action1 = new TouchAction(androidDriver);
        //手指2
        TouchAction action2 = new TouchAction(androidDriver);
        int y = androidDriver.manage().window().getSize().getHeight();
        int x = androidDriver.manage().window().getSize().getWidth();
        //缩小
        PointOption pointA = PointOption.point(x / 5, y / 5);
        PointOption pointB = PointOption.point(x * 2 / 5, y * 2 / 5);
        PointOption pointC = PointOption.point(x * 3 / 5, y * 3 / 5);
        PointOption pointD = PointOption.point(x * 4 / 5, y * 4 / 5);
        // 缩小 = A -> B & D -> C
        //注意：同时操作不需要perform
        action1.press(pointA).moveTo(pointB).release();
        action2.press(pointD).moveTo(pointC).release();
        //创建多次触碰对象
        MultiTouchAction multiTouchAction = new MultiTouchAction(androidDriver);
        //添加触碰操作
        multiTouchAction.add(action1);
        multiTouchAction.add(action2);
        //完成操作
        multiTouchAction.perform();
    }



    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        androidDriver.quit();
    }

}
