package com.lemon.page;

import com.lemon.common.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @Project: auto_app
 * @Site: http://www.lemonban.com
 * @Forum: http://testingpai.com
 * @Copyright: 2020 版权所有 湖南省零檬信息技术有限公司
 * @Author: luojie
 * @Create: 2020-10-17 10:10
 * @Desc： 题库页面
 **/
public class TikuPage extends BasePage {

    //题库按钮
    private By tikuBy =
            MobileBy.xpath("//*[@resource-id='com.lemon.lemonban:id/smallLabel' and @text='题库']");
    //分类图片
    private By categoryImageBy = MobileBy.id("com.lemon.lemonban:id/fragment_category_cover");

    public TikuPage(AndroidDriver androidDriver) {
        super(androidDriver);
    }

    public void clickTiku() {
        click(tikuBy);
    }

    public void randomClickCategory() {
        waitElementVisible(categoryImageBy);
        List<WebElement> elements = androidDriver.findElements(categoryImageBy);
        //随机获取集合中一个元素，然后点击
        //1、随机一个索引
//        Random random = new Random();
//        int index = random.nextInt(elements.size());//0-9
//        WebElement element = elements.get(index);
        //2、打乱集合的顺序，取第一个。
        Collections.shuffle(elements);
        WebElement element = elements.get(0);
        element.click();
    }

}
