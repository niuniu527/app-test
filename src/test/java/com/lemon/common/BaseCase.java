package com.lemon.common;

import com.lemon.common.Constants;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Project: auto_app
 * @Site: http://www.lemonban.com
 * @Forum: http://testingpai.com
 * @Copyright: 2020 版权所有 湖南省零檬信息技术有限公司
 * @Author: luojie
 * @Create: 2020-10-15 20:21
 * @Desc： Case父类
 **/
public class BaseCase {

    private static Logger logger = Logger.getLogger(BaseCase.class);

    public AndroidDriver androidDriver;

    public void openApp() throws MalformedURLException {
        logger.info("====================打开app==========================");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", Constants.PLATFORM_NAME);
        desiredCapabilities.setCapability("deviceName", Constants.DEVICE_NAME);
        desiredCapabilities.setCapability("appPackage", Constants.APP_PACKAGE);
        desiredCapabilities.setCapability("appActivity", Constants.APP_ACTIVITY);
        URL remoteUrl = new URL(Constants.REMOTE_URL);
        androidDriver = new AndroidDriver(remoteUrl, desiredCapabilities);
    }

    public void quit() {
        try {
            logger.info("====================关闭app==========================");
            Thread.sleep(3000);
            androidDriver.quit();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
