package com.lemon.page;

import com.lemon.common.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * @Project: auto_app
 * @Site: http://www.lemonban.com
 * @Forum: http://testingpai.com
 * @Copyright: 2020 版权所有 湖南省零檬信息技术有限公司
 * @Author: luojie
 * @Create: 2020-10-15 20:30
 * @Desc： 登录页面
 **/
public class LoginPage extends BasePage {

    private By mobileBy = MobileBy.id("com.lemon.lemonban:id/et_mobile");
    private By passwordBy = MobileBy.id("com.lemon.lemonban:id/et_password");
    private By loginBtnBy = MobileBy.id("com.lemon.lemonban:id/btn_login");

    //属性 定位信息
    //方法 行为 点击，发送，获取文档...
    public LoginPage(AndroidDriver androidDriver) {
        super(androidDriver);
    }

    public void inputMobile(String mobile) {
        input(mobileBy,mobile);
    }

    public void inputPassword(String password) {
        input(passwordBy,password);
    }

    public void clickLoginBtn() {
        click(loginBtnBy);
    }

    /**
     * 登录流程
     * @param mobile
     * @param password
     * @param assertText
     */
    public void loginSuccessFLow(String mobile,String password,String assertText) {
        IndexPage indexPage = new IndexPage(androidDriver);
        HomePage homePage = new HomePage(androidDriver);
        LoginPage loginPage = new LoginPage(androidDriver);
        //调用行为
        indexPage.clickHome();
        homePage.clickNickName();
        loginPage.inputMobile(mobile);
        loginPage.inputPassword(password);
        loginPage.clickLoginBtn();
        //断言
        String actual = homePage.getNickName();
        Assert.assertEquals(actual,assertText);
    }

    public void loginFailedFLow(String mobile,String password,String assertText) {
        IndexPage indexPage = new IndexPage(androidDriver);
        HomePage homePage = new HomePage(androidDriver);
        LoginPage loginPage = new LoginPage(androidDriver);
        //调用行为
        indexPage.clickHome();
        homePage.clickNickName();
        loginPage.inputMobile(mobile);
        loginPage.inputPassword(password);
        loginPage.clickLoginBtn();
        //断言
        String actual = loginPage.getToastText(assertText);
        Assert.assertEquals(actual, assertText);
    }



}
