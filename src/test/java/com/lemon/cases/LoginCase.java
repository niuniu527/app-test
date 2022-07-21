package com.lemon.cases;

import com.lemon.common.BaseCase;
import com.lemon.page.HomePage;
import com.lemon.page.IndexPage;
import com.lemon.page.LoginPage;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

/**
 * @Project: auto_app
 * @Site: http://www.lemonban.com
 * @Forum: http://testingpai.com
 * @Copyright: 2020 版权所有 湖南省零檬信息技术有限公司
 * @Author: luojie
 * @Create: 2020-10-15 20:10
 * @Desc： 登录用例
 **/
public class LoginCase extends BaseCase {

    @BeforeTest
    public void setUp() throws MalformedURLException {
        openApp();
    }

    @Test
    public void loginFailed() {
        //创建出页面
        LoginPage loginPage = new LoginPage(androidDriver);
        try {
            //登录流程
            loginPage.loginFailedFLow("13323234545", "123456","错误的账号信息");
        }finally {
            loginPage.pressBack();
        }
    }

    @Test(priority = 1)
    public void loginSuccess() {
        //创建出页面
        LoginPage loginPage = new LoginPage(androidDriver);
        try {
            //登录流程
            loginPage.loginSuccessFLow("13323234545", "234545","歪歪");
        }finally {
//            loginPage.pressBack();
        }
    }

    @Test(dataProvider = "datas")
    public void loginFailed02(String mobile,String password,String toastExpected) {
        //创建出页面
        LoginPage loginPage = new LoginPage(androidDriver);
        try {
            //登录流程
            loginPage.loginFailedFLow(mobile, password, toastExpected);
        }finally {
            loginPage.pressBack();
        }
    }

    @DataProvider
    public Object[][] datas() {
        Object[][] datas = {
                {"","","手机号码或密码不能为空1"},
                {"13213123","123123","手机号码格式不正确"},
                {"13323234545","","手机号码或密码不能为空"},
                {"","123123123","手机号码或密码不能为空"}
        };
        return datas;
    }





    @AfterTest
    public void tearDown() {
        quit();
    }
}
