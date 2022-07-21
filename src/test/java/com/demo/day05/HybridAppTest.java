package com.demo.day05;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
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
 * @Create: 2020-10-13 20:24
 * @Desc： 混合app应用网页元素测试
 **/
public class HybridAppTest {
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
        androidDriver.findElement(MobileBy.xpath("//*[@text='柠檬社区']")).click();
        //进入了混合页面 -> web页面里面
        //当前实在原生app -> web页面里面
        Thread.sleep(2000);
        System.out.println(androidDriver.getContextHandles());
        //切换到 WEBVIEW_com.lemon.lemonban
        androidDriver.context("WEBVIEW_com.lemon.lemonban");
        //进入web页面
        //点击注册按钮
        androidDriver.findElement(MobileBy.xpath("//span[contains(text(),'注册')]")).click();
        //输入手机号码
        androidDriver.findElement(MobileBy.id("userPhone")).sendKeys("13323234545");
        //输入验证码
        androidDriver.findElement(MobileBy.id("captcha")).sendKeys("abcd");
        //点击注册
        androidDriver.findElement(MobileBy.id("verifyRegister")).click();
        //切换回原生appcontext
        androidDriver.context("NATIVE_APP");
        //点击x
        androidDriver.findElement(MobileBy.className("android.widget.ImageButton")).click();
        //点击确定
        androidDriver.findElement(MobileBy.id("com.lemon.lemonban:id/tv_sure")).click();
    }




    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        androidDriver.quit();
    }

}
