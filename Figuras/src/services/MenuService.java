package services;

import constants.Messages;
import enums.MenuOptionsEnum;
import enums.TypeFiguresEnum;

import javax.swing.*;

public class MenuService {
    public static void menu() {
        MenuOptionsEnum[] menuOptions = MenuOptionsEnum.values();
        TypeFiguresEnum[] typeFiguresEnums;
        StringBuilder stringBuilder = optionMenu(menuOptions);
        System.out.println(stringBuilder.toString());
        JOptionPane.showMessageDialog(null,stringBuilder);
    }

    public static StringBuilder optionMenu(MenuOptionsEnum[] menuOptions) {
        StringBuilder stringBuilder = new StringBuilder(Messages.MENU_OPTION);
        for(MenuOptionsEnum f : menuOptions) {
            stringBuilder.append(String.format(Messages.FORMAT_OPTIONS, f.getOption(),f.getName()));
        }
        return stringBuilder;
    }
    
}
