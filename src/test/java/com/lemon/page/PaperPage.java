package com.lemon.page;

import com.lemon.common.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

/**
 * @Project: auto_app
 * @Site: http://www.lemonban.com
 * @Forum: http://testingpai.com
 * @Copyright: 2020 版权所有 湖南省零檬信息技术有限公司
 * @Author: luojie
 * @Create: 2020-10-17 11:05
 * @Desc： 套题页面
 **/
public class PaperPage extends BasePage {
    private By arrowBy = MobileBy.id("com.lemon.lemonban:id/suit_subject_arrow");
    private By favouriteBtnBy = MobileBy.id("com.lemon.lemonban:id/action_favourite");

    public PaperPage(AndroidDriver androidDriver) {
        super(androidDriver);
    }

    public void randomClickPaper() {
        //1、等待页面第一个箭头元素可见
        waitElementClickable(arrowBy);
        //2、获取所有的箭头元素
        List<WebElement> elements = androidDriver.findElements(arrowBy);
        Random random = new Random();
        int index = random.nextInt(elements.size());//0-2
        //3、随机获取一个箭头并点击
        WebElement element = elements.get(index);
        element.click();
    }

    public void clickFavouriteBtn() {
        click(favouriteBtnBy);
    }
}
