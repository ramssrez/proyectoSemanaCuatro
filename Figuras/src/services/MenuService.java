package services;

import constants.MessagesError;
import constants.ValidateInputs;
import enums.MenuOptionsEnum;
import enums.TypeFiguresEnum;
import exepctions.ExeptionAplication;
import interfaces.IFigure;
import utils.Menus;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class MenuService {
    public static void menu() {
        Menus menus = new Menus();
        IFigure figure = null;
        MenuOptionsEnum menuOptionsEnum;
        TypeFiguresEnum typeFiguresEnum;
        ValidateInputs validateInputs = new ValidateInputs();
        StringBuilder stringBuilder = menus.menuOptions();
        //JOptionPane.showInputDialog(stringBuilder.toString());

        boolean flag = false;
        while (!flag){
            System.out.println(stringBuilder.toString());
            Scanner scanner = new Scanner(System.in);
            try {
                int opcion = validateInputs.inputInteger("Ingresa una opción: ",scanner);
                menuOptionsEnum = menus.getNameMenu(opcion);
                switch (menuOptionsEnum){
                    case REGISTRAR:
                        System.out.println("Selecciona una figura");
                        break;
                    case ABRIR:
                        System.out.println("Selecciona un archivo");
                        break;
                    case SALIR:
                        System.out.println("Saliendo del programa");
                        flag = true;
                        System.exit(0);
                }
            }catch (NoSuchElementException e){
                System.err.println(MessagesError.MESSAGE_INPUT_MENU);
            } catch (ExeptionAplication exeptionAplication) {
                System.err.println(exeptionAplication.getMessage());
            }
            System.out.println(" ");
        }


        /*
        IFigure iFigure = null;
        iFigure = new Circle(3);
        //System.out.println("Area: " + iFigure.calculateArea() + "Perimetro: " + iFigure.calculatePerimeter() + iFigure.getClass().getName()+iFigure.readAttributes());
        JOptionPane.showMessageDialog(null,iFigure.readAttributes());
        //iFigure.reedAttributes();
        iFigure = new EquilateralTriangle(3);
        JOptionPane.showMessageDialog(null,iFigure.readAttributes());
        iFigure = new IsoscelesTriangle(3,3);
        JOptionPane.showMessageDialog(null,iFigure.readAttributes());
        iFigure = new Rectangle(3,2);
        JOptionPane.showMessageDialog(null,iFigure.readAttributes());
        iFigure = new Square(3);
        JOptionPane.showMessageDialog(null,iFigure.readAttributes());
         */
    }

}
