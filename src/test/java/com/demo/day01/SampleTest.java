package com.demo.day01;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SampleTest {

  private AndroidDriver driver;

  @BeforeTest
  public void setUp() throws MalformedURLException {
    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    desiredCapabilities.setCapability("platformName", "Android");
    desiredCapabilities.setCapability("deviceName", "127.0.0.1:62001");
    desiredCapabilities.setCapability("appPackage", "com.lemon.lemonban");
    desiredCapabilities.setCapability("appActivity", "com.lemon.lemonban.activity.WelcomeActivity");

    URL remoteUrl = new URL("http://localhost:4723/wd/hub");

    driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    //隐式等待
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @Test
  public void sampleTest() {
//    MobileElement els1 = (MobileElement) driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.EditText\n");
    MobileElement el3 = (MobileElement) driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"我的柠檬\"]/android.widget.ImageView");
    el3.click();
    MobileElement el4 = (MobileElement) driver.findElementById("com.lemon.lemonban:id/fragment_my_lemon_avatar_title");
    el4.click();
    MobileElement el5 = (MobileElement) driver.findElementById("com.lemon.lemonban:id/et_mobile");
    el5.sendKeys("13223234545");
    MobileElement el6 = (MobileElement) driver.findElementById("com.lemon.lemonban:id/et_password");
    el6.sendKeys("123456");
    MobileElement el7 = (MobileElement) driver.findElementById("com.lemon.lemonban:id/btn_login");
    el7.click();
  }

  @AfterTest
  public void tearDown() {
    driver.quit();
  }
}
