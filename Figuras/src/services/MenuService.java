package services;

import utils.Menus;

public class MenuService {
    public static void menu() {
        Menus menus = new Menus();

        StringBuilder stringBuilder = menus.menuOptions();
        System.out.println(stringBuilder.toString());
        stringBuilder = menus.figureOptions();
        System.out.println(stringBuilder.toString());
    }

}
