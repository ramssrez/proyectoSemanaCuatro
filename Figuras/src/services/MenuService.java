package services;

import domain.Circle;
import interfaces.IFigure;
import utils.Menus;

import javax.swing.*;

public class MenuService {
    public static void menu() {
        Menus menus = new Menus();
        StringBuilder stringBuilder = menus.menuOptions();
        System.out.println(stringBuilder.toString());
        stringBuilder = menus.figureOptions();
        System.out.println(stringBuilder.toString());
        IFigure iFigure = null;
        iFigure = new Circle(3);
        JOptionPane.showMessageDialog(null,iFigure.readAttributes());
        //iFigure.reedAttributes();
    }

}
