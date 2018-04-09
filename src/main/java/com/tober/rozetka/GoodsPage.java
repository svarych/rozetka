package com.tober.rozetka;

import java.util.ArrayList;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GoodsPage {

    void selectRandomGoods(){
        ArrayList<String> goodsList = new ArrayList<>($$(byClassName("g-i-tile-i-title")).texts());
        int random = (int) (Math.random() * goodsList.size());
        $(byText(goodsList.get(random))).scrollTo().hover().click();
    }
}
