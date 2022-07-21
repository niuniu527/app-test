package com.demo.day04;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * @Project: auto_app
 * @Site: http://www.lemonban.com
 * @Forum: http://testingpai.com
 * @Copyright: 2020 版权所有 湖南省零檬信息技术有限公司
 * @Author: luojie
 * @Create: 2020-10-10 20:12
 * @Desc： 滑动测试类
 **/
public class SwipeTest2 {

    private AndroidDriver androidDriver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "127.0.0.1:62001");
        desiredCapabilities.setCapability("appPackage", "com.xxzb.fenwoo");
        desiredCapabilities.setCapability("appActivity", "com.xxzb.fenwoo.activity.addition.WelcomeActivity");
        //启动app时，不清楚用户信息
        desiredCapabilities.setCapability("noReset",true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        androidDriver = new AndroidDriver(remoteUrl, desiredCapabilities);
        //隐式等待
        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test() throws InterruptedException {
        //滑动操作 = 点击屏幕某一个点 + 移动 + 松开
        //点击点：365 170  拖动点 365 966
        Thread.sleep(3000);
//        for (int i = 0; i < 3; i++) {
//            swipeLeft(500);
//        }

    }


    /**
     * 九宫格解锁，连续滑动
     */
    public void unlock9() {
        WebElement element = androidDriver.findElement(MobileBy.id("com.xxzb.fenwoo:id/lpv_password"));
        //元素x坐标值
        int x = element.getLocation().getX();
        //元素y坐标值
        int y = element.getLocation().getY();
        //元素高度
        int h = element.getSize().getHeight();
        //元素宽度
        int w = element.getSize().getWidth();
        TouchAction touchAction = new TouchAction(androidDriver);
        // x + w / 6,y + h / 6
        PointOption point1 = PointOption.point(x + w / 6,y + h / 6);
        // x + w / 2,y + h / 6
        PointOption point2 = PointOption.point(x + w / 2,y + h / 6);
        // x + w * 5 / 6,y + h / 6
        PointOption point3 = PointOption.point(x + w * 5 / 6,y + h / 6);
        // x + w / 2,y + h / 2
        PointOption point4 = PointOption.point(x + w / 2,y + h / 2);
        // x + w / 6,y + h * 5 / 6
        PointOption point5 = PointOption.point(x + w / 6,y + h * 5 / 6);
        // x + w / 2,y + h * 5 / 6
        PointOption point6 = PointOption.point(x + w / 2,y + h * 5 / 6);
        // x + w * 5 / 6,y + h * 5 / 6
        PointOption point7 = PointOption.point(x + w * 5 / 6,y + h * 5 / 6);
        touchAction.press(point1).moveTo(point2).moveTo(point3).moveTo(point4).moveTo(point5)
                .moveTo(point6).moveTo(point7).release().perform();
    }


    /**
     * 向下滑动
     * @param times     滑动间隔时间，单位是毫秒
     */
    public void swipeDown(long times) {
        int width = androidDriver.manage().window().getSize().getWidth();
        int height = androidDriver.manage().window().getSize().getHeight();
        TouchAction touchAction = new TouchAction(androidDriver);
        PointOption startPoint = PointOption.point(width / 2,height * 1 / 4);
        PointOption endPoint = PointOption.point(width / 2,height * 3 / 4) ;
        //滑动决定因素：滑动距离 滑动时间
        //设置间隔时间
        Duration duration = Duration.ofMillis(times);
        //构建waitOptions对象
        WaitOptions waitOptions = WaitOptions.waitOptions(duration);
        touchAction.press(startPoint).waitAction(waitOptions).moveTo(endPoint).release().perform();
    }

    /**
     * 向上滑动
     * @param times     滑动间隔时间，单位是毫秒
     */
    public void swipeUp(long times) {
        int width = androidDriver.manage().window().getSize().getWidth();
        int height = androidDriver.manage().window().getSize().getHeight();
        TouchAction touchAction = new TouchAction(androidDriver);
        PointOption startPoint = PointOption.point(width / 2,height * 3 / 4);
        PointOption endPoint = PointOption.point(width / 2,height * 1 / 4) ;
        //滑动决定因素：滑动距离 滑动时间
        //设置间隔时间
        Duration duration = Duration.ofMillis(times);
        //构建waitOptions对象
        WaitOptions waitOptions = WaitOptions.waitOptions(duration);
        touchAction.press(startPoint).waitAction(waitOptions).moveTo(endPoint).release().perform();
    }

    /**
     * 向左滑动
     * @param times     滑动间隔时间，单位是毫秒
     */
    public void swipeLeft(long times) {
        int width = androidDriver.manage().window().getSize().getWidth();
        int height = androidDriver.manage().window().getSize().getHeight();
        TouchAction touchAction = new TouchAction(androidDriver);
        PointOption startPoint = PointOption.point(width * 4 / 5,height / 2);
        PointOption endPoint = PointOption.point(width * 1 / 5,height / 2) ;
        //滑动决定因素：滑动距离 滑动时间
        //设置间隔时间
        Duration duration = Duration.ofMillis(times);
        //构建waitOptions对象
        WaitOptions waitOptions = WaitOptions.waitOptions(duration);
        touchAction.press(startPoint).waitAction(waitOptions).moveTo(endPoint).release().perform();
    }

    /**
     * 向右滑动
     * @param times     滑动间隔时间，单位是毫秒
     */
    public void swipeRight(long times) {
        int width = androidDriver.manage().window().getSize().getWidth();
        int height = androidDriver.manage().window().getSize().getHeight();
        TouchAction touchAction = new TouchAction(androidDriver);
        PointOption startPoint = PointOption.point(width * 1 / 4,height / 2);
        PointOption endPoint = PointOption.point(width * 3 / 4,height / 2) ;
        //滑动决定因素：滑动距离 滑动时间
        //设置间隔时间
        Duration duration = Duration.ofMillis(times);
        //构建waitOptions对象
        WaitOptions waitOptions = WaitOptions.waitOptions(duration);
        touchAction.press(startPoint).waitAction(waitOptions).moveTo(endPoint).release().perform();
    }


    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        androidDriver.quit();
    }


}
