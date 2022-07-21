package com.lemon.common;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * @Project: auto_app
 * @Site: http://www.lemonban.com
 * @Forum: http://testingpai.com
 * @Copyright: 2020 版权所有 湖南省零檬信息技术有限公司
 * @Author: luojie
 * @Create: 2020-10-15 20:35
 * @Desc： PO页面父类
 **/
public class BasePage {

    private static Logger logger = Logger.getLogger(BasePage.class);

    public AndroidDriver androidDriver;

    public BasePage(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
    }

    /**
     * 等待元素可见
     * @param by
     */
    public WebElement waitElementVisible(By by) {
        logger.info("元素定位信息：" + by);
        WebDriverWait wait = new WebDriverWait(androidDriver,10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    /**
     * 等待元素可点击
     * @param by
     */
    public WebElement waitElementClickable(By by) {
        logger.info("元素定位信息：" + by);
        WebDriverWait wait = new WebDriverWait(androidDriver,10);
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    /**
     * 等待元素存在
     * @param by
     */
    public WebElement waitElementPresence(By by) {
        logger.info("元素定位信息：" + by);
        WebDriverWait wait = new WebDriverWait(androidDriver,10);
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    /**
     * 点击android回退按钮
     */
    public void pressBack() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        KeyEvent keyEvent = new KeyEvent(AndroidKey.BACK);
        androidDriver.pressKey(keyEvent);
    }

    /**
     * 获取 toast文本信息
     * @param toastText
     * @return
     */
    public String getToastText(String toastText) {
        return waitElementPresence(MobileBy.xpath("//*[contains(@text,'" + toastText + "')]")).getText();
    }

    /**
     * 输入文本
     * @param by
     * @param password
     */
    public void input(By by,String password) {
        waitElementVisible(by).sendKeys(password);
    }

    /**
     * 获取元素文本
     * @param by
     * @return
     */
    public String getText(By by) {
        return waitElementVisible(by).getText();
    }

    /**
     * 点击元素
     * @param by
     */
    public void click(By by) {
        waitElementClickable(by).click();
    }

    /**
     * 向左滑动
     * @param times     滑动间隔时间，单位是毫秒
     */
    public void swipeLeft(long times) {
        int width = androidDriver.manage().window().getSize().getWidth();
        int height = androidDriver.manage().window().getSize().getHeight();
        TouchAction touchAction = new TouchAction(androidDriver);
        PointOption startPoint = PointOption.point(width * 3 / 4,height / 2);
        PointOption endPoint = PointOption.point(width * 1 / 4,height / 2) ;
        //滑动决定因素：滑动距离 滑动时间
        //设置间隔时间
        Duration duration = Duration.ofMillis(times);
        //构建waitOptions对象
        WaitOptions waitOptions = WaitOptions.waitOptions(duration);
        touchAction.press(startPoint).waitAction(waitOptions).moveTo(endPoint).release().perform();
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
}
