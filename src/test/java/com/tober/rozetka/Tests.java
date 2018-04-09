package com.tober.rozetka;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.ArrayList;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;


class Tests {

    @BeforeAll
    static void setUp() {
        Configuration.browser = "chrome";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void t0() throws InterruptedException {
        int random;

        open("https://rozetka.ua");
//        MainPage mainPage = new MainPage();
//        mainPage.goToRandomMenu();
        ArrayList<String> mainMenuList = new ArrayList<>($$(byName("m-main-i")).texts());
        random = (int) (Math.random() * (mainMenuList.size() - 2));
        $(byText(mainMenuList.get(random))).hover().$(byXpath("//div[@name='second_menu']")).shouldBe(appear);

//        mainPage.selectRandomGroup();

        ArrayList<String> menuList = new ArrayList<>($$(byClassName("f-menu-sub-l-i")).texts());
        random = (int) (Math.random() * menuList.size());
        $(byText(menuList.get(random))).click();

//        GoodsPage goodsPage = new GoodsPage();
//        goodsPage.selectRandomGoods();

        ArrayList<String> goodsList = new ArrayList<>($$(byClassName("g-i-tile-i-title")).texts());
        random = (int) (Math.random() * goodsList.size());
        $(byText(goodsList.get(random))).scrollTo().hover().click();


        $(byName("topurchases")).shouldBe(visible).click();
        String etalon = $(byClassName("detail-title")).getText();

        try {
            $(byId("cart-popup")).shouldBe(appear);
            $(byLinkText("Продолжить покупки")).shouldBe(appear).click();
            $(byId("cart-popup")).shouldBe(disappear);
        } catch (Throwable t) {
            $(byLinkText("Продолжить покупки")).shouldBe(visible).click();
            $(byId("cart-popup")).shouldNotBe(visible);
        }

        $(byText("Корзина")).click();

        $(byClassName("cart-i-title")).shouldHave(text(etalon));

    }
}