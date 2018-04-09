package com.tober.rozetka;

import java.util.ArrayList;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    private int random;

    public MainPage() {
        open("https://rozetka.ua");
    }

    void goToRandomMenu(){
        ArrayList<String> mainMenuList = new ArrayList<>($$(byName("m-main-i")).texts());
        random = (int) (Math.random() * (mainMenuList.size() - 2));
        $(byText(mainMenuList.get(random))).hover().$(byXpath("//div[@name='second_menu']")).shouldBe(appear);
    }

    void selectRandomGroup(){
        ArrayList<String> menuList = new ArrayList<>($$(byClassName("f-menu-sub-l-i")).texts());
        random = (int) (Math.random() * menuList.size());
        $(byText(menuList.get(random))).click();
    }
}
