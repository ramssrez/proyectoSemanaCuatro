package services;

import domain.*;
import enums.MenuOptionsEnum;
import enums.TypeFiguresEnum;
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

        StringBuilder stringBuilder = menus.menuOptions();
        boolean flag = false;
        while (!flag){
            System.out.println(stringBuilder.toString());
            System.out.print("Opción: ");
            Scanner scanner = new Scanner(System.in);
            try {
                int opcion = Integer.parseInt(scanner.nextLine());
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
                        System.exit(0);
                }
            }catch (NullPointerException | NoSuchElementException e){
                System.err.println("No ha ingresado un valor correcto");
            }catch (NumberFormatException e){
                System.err.println("Ingresa un valor adecuado");
            }

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
