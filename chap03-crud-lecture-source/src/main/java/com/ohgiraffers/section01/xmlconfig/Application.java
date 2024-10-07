package com.ohgiraffers.section01.xmlconfig;

import com.ohgiraffers.section01.xmlconfig.view.MenuView;

public class Application {

    public static void main(String[] args) {

        // App -> View -> Controller -> Service -> DAO -> DB 로 데이터 수정 및 검증 후
        // DAO -> Service -> Controller -> View -> App 데이터 반환

        MenuView view = new MenuView();
        view.display();


    }

}
