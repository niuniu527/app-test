package com.lemon.page;

import com.lemon.common.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Project: auto_app
 * @Site: http://www.lemonban.com
 * @Forum: http://testingpai.com
 * @Copyright: 2020 版权所有 湖南省零檬信息技术有限公司
 * @Author: luojie
 * @Create: 2020-10-17 10:55
 * @Desc： 难度级别页面
 **/
public class DifficultyLevelPage extends BasePage {
    private By level1By = MobileBy.id("com.lemon.lemonban:id/first_level");
    private By level2By = MobileBy.id("com.lemon.lemonban:id/second_level");
    private By level3By = MobileBy.id("com.lemon.lemonban:id/third_level");

    public DifficultyLevelPage(AndroidDriver androidDriver) {
        super(androidDriver);
    }

    public void randomClickLevel() {
        //0-2 if(0==i) level1
        //level1 2 3 in list  random
        //1、把3个难度按钮定位信息放入list集合
        List<By> levelByList = new ArrayList<>();
        levelByList.add(level1By);
        levelByList.add(level2By);
        levelByList.add(level3By);
        //2、随机获取0-2索引
        Random random = new Random();
        int index = random.nextInt(levelByList.size());//0-2
        By levelBy = levelByList.get(index);
        //3、点击随机索引对应按钮
        click(levelBy);
    }

}
