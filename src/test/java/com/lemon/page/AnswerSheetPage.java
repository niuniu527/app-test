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
 * @Create: 2020-10-17 11:13
 * @Desc： 答题卡页面
 **/
public class AnswerSheetPage extends BasePage {

    private By switchBtnBy = MobileBy.id("com.lemon.lemonban:id/switch_button");
    private By tvBodyBy = MobileBy.id("com.lemon.lemonban:id/tvBody");

    public AnswerSheetPage(AndroidDriver androidDriver) {
        super(androidDriver);
    }

    public void clickShowAnswerBtn() {
        click(switchBtnBy);
    }

    public boolean answerDisplay() {
        try {
            return waitElementVisible(tvBodyBy).isDisplayed();
        }catch (Exception e) {
            return false;
        }
    }
}
