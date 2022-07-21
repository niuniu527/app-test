package com.demo.day05;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Project: auto_app
 * @Site: http://www.lemonban.com
 * @Forum: http://testingpai.com
 * @Copyright: 2020 版权所有 湖南省零檬信息技术有限公司
 * @Author: luojie
 * @Create: 2020-10-13 21:21
 * @Desc： 微信小程序测试
 **/
public class WechatTest {

    private AndroidDriver androidDriver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "08e7c5997d2a");
        desiredCapabilities.setCapability("appPackage", "com.tencent.mm");
        desiredCapabilities.setCapability("appActivity", "com.tencent.mm.ui.LauncherUI");
        //不清除掉微信的数据 **一定记得加！！！不清除微信的数据**
        desiredCapabilities.setCapability("noReset", true);
        // 支持X5内核应用自动化配置
        desiredCapabilities.setCapability("recreateChromeDriverSessions", true);
        // ChromeOptions使用来定制启动选项，因为在appium中切换context识别webview的时候,
        // 把com.tencent.mm:toolsmp的webview识别成com.tencent.mm的webview.
        // 所以为了避免这个问题，加上androidProcess: com.tencent.mm:toolsmp
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("androidProcess", "com.tencent.mm:appbrand0");
        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
        // 初始化会默认将chrome浏览器打开，需要将Browser置为空
        desiredCapabilities.setBrowserName("");
        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
        androidDriver = new AndroidDriver(remoteUrl, desiredCapabilities);
        //隐式等待
        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test() throws InterruptedException {
        Thread.sleep(10000);
        //向下滑动，显示出小程序界面
        swipeDown(1000);
        //点击柠檬班小程序图标
        androidDriver.findElement(MobileBy.xpath("//*[@text='柠檬班软件…']")).click();
        Thread.sleep(10000);
//        System.out.println(androidDriver.getContextHandles());
//        [NATIVE_APP,
//                WEBVIEW_com.tencent.mm:tools,
//                WEBVIEW_com.tencent.mm:appbrand0,
//                WEBVIEW_com.tencent.mm:toolsmp,
//                WEBVIEW_com.tencent.mm,
//                WEBVIEW_com.android.browser]
        //原生APP切换小程序
        androidDriver.context("WEBVIEW_com.tencent.mm:appbrand0");
        //切换小程序中的windows
        Set<String> windowHandles = androidDriver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            if(androidDriver.getTitle().contains("腾讯课堂柠檬班软件测试")) {
                break;
            }else {
                androidDriver.switchTo().window(windowHandle);
            }
        }

        //点击课程按钮
        androidDriver.findElement(MobileBy.xpath("//a[contains(text(),'课程')]")).click();


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


    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        androidDriver.quit();
    }
}
