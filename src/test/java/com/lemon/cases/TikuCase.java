package com.lemon.cases;

import com.lemon.common.BaseCase;
import com.lemon.page.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

/**
 * @Project: auto_app
 * @Site: http://www.lemonban.com
 * @Forum: http://testingpai.com
 * @Copyright: 2020 版权所有 湖南省零檬信息技术有限公司
 * @Author: luojie
 * @Create: 2020-10-17 09:48
 * @Desc： 题库用例
 **/
public class TikuCase extends BaseCase {

    @BeforeTest
    public void setUp() throws MalformedURLException {
        openApp();
//        //1、登录（只需做一次）
//        LoginPage loginPage = new LoginPage(androidDriver);
//        loginPage.loginSuccessFLow("13323234545", "234545","歪歪");
    }

    @Test
    public void testShowAnswer() {
        TikuPage tikuPage = new TikuPage(androidDriver);
        DifficultyLevelPage difficultyLevelPage = new DifficultyLevelPage(androidDriver);
        PaperPage paperPage = new PaperPage(androidDriver);
        AnswerSheetPage answerSheetPage = new AnswerSheetPage(androidDriver);
        //1、点击题库按钮
        tikuPage.clickTiku();
        //2、随机选择分类
        tikuPage.randomClickCategory();
        //3、随机选择难度
        difficultyLevelPage.randomClickLevel();
        //4、随机选择套题列表
        paperPage.randomClickPaper();
        //5、点击显示答案按钮
        answerSheetPage.clickShowAnswerBtn();
        //6、断言 答案是否显示
        boolean flag = answerSheetPage.answerDisplay();
        Assert.assertTrue(flag);
        //7、向左滑动一次
        answerSheetPage.swipeLeft(1000);
        //7.1、点击显示答案按钮
        answerSheetPage.clickShowAnswerBtn();
        //7.2、断言 答案是否显示
        flag = answerSheetPage.answerDisplay();
        Assert.assertTrue(flag);
        //8、向左滑动一次
        answerSheetPage.swipeLeft(1000);
        //8.1、点击显示答案按钮
        answerSheetPage.clickShowAnswerBtn();
        //8.2、断言 答案是否显示
        flag = answerSheetPage.answerDisplay();
        Assert.assertTrue(flag);
    }

    @Test
    public void testFavorites() {
        TikuPage tikuPage = new TikuPage(androidDriver);
        DifficultyLevelPage difficultyLevelPage = new DifficultyLevelPage(androidDriver);
        PaperPage paperPage = new PaperPage(androidDriver);
        AnswerSheetPage answerSheetPage = new AnswerSheetPage(androidDriver);
        HomePage homePage = new HomePage(androidDriver);
        IndexPage indexPage = new IndexPage(androidDriver);
        //1、home页面获取收藏数
        String beforeFavorites = homePage.getFavorites();
        //2、取收藏题目
        //2.1、点击题库按钮
        tikuPage.clickTiku();
        //2.2、随机选择分类
        tikuPage.randomClickCategory();
        //2.3、随机选择难度
        difficultyLevelPage.randomClickLevel();
        //2.4、随机选择套题列表
        paperPage.randomClickPaper();
        //2.4、点击收藏按钮
        paperPage.clickFavouriteBtn();
        //3、toast断言
        String toastText = paperPage.getToastText("收藏成功");
        Assert.assertEquals("收藏成功",toastText);
        //4、三次返回，推到主页，再次到home页面获取收藏数
        paperPage.pressBack();
        paperPage.pressBack();
        paperPage.pressBack();
        indexPage.clickHome();
        //5、after - before = 1
        String afterFavorites = homePage.getFavorites();
        int actual = Integer.parseInt(afterFavorites) - Integer.parseInt(beforeFavorites);
        Assert.assertEquals(actual,1);
    }





    @AfterTest
    public void tearDown() {
        quit();
    }

}
