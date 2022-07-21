package com.lemon.page;

import com.lemon.common.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * @Project: auto_app
 * @Site: http://www.lemonban.com
 * @Forum: http://testingpai.com
 * @Copyright: 2020 版权所有 湖南省零檬信息技术有限公司
 * @Author: luojie
 * @Create: 2020-10-15 20:33
 * @Desc： 首页
 **/
public class IndexPage extends BasePage {
    private By homeBy = MobileBy.xpath("//*[@content-desc=\"我的柠檬\"]");

    public IndexPage(AndroidDriver androidDriver) {
        super(androidDriver);
    }

    public void clickHome() {
        click(homeBy);
    }
}
