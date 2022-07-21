package com.demo.day01;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Project: auto_app
 * @Site: http://www.lemonban.com
 * @Forum: http://testingpai.com
 * @Copyright: 2020 版权所有 湖南省零檬信息技术有限公司
 * @Author: luojie
 * @Create: 2020-09-23 20:47
 * @Desc： 第一个App案例
 **/
public class AppDemo {
    public static void main(String[] args) throws MalformedURLException {
        //注意:执行代码之前，必须adb连上的设备，执行adb connect 127.0.0.1:62001
        //配置设备的信息
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //1、设备平台
        capabilities.setCapability("platformName","Android");
        //2、设备名称
        capabilities.setCapability("deviceName","127.0.0.1:62001");
        //3、app包名
        capabilities.setCapability("appPackage","com.lemon.lemonban");
        //4、app activity 名称
        capabilities.setCapability("appActivity","com.lemon.lemonban.activity.WelcomeActivity");
        //把信息传给Appium Server
        //Appium Server接口地址
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        //创建 Android 驱动
        AndroidDriver driver = new AndroidDriver(url,capabilities);
    }
}
