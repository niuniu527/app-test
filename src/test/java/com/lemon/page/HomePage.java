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
 * @Create: 2020-10-15 20:32
 * @Desc： 我的柠檬页面
 **/
public class HomePage extends BasePage {

    //com.lemon.lemonban:id/fragment_my_lemon_avatar_title
    //com.lemon.lemonban:id/fragment_my_lemon_avatar_title


    private By nickNameBy = MobileBy.id("com.lemon.lemonban:id/fragment_my_lemon_avatar_title");
                                          //com.lemon.lemonban:id/fragment_my_lemon_collection_count
    private By favoritesBy = MobileBy.id("com.lemon.lemonban:id/fragment_my_lemon_collection_count");

    public HomePage(AndroidDriver androidDriver) {
        super(androidDriver);
    }

    public void clickNickName() {
        click(nickNameBy);
    }

    public String getNickName() {
       return getText(nickNameBy);
    }

    public String getFavorites() {
        return getText(favoritesBy);
    }

}
