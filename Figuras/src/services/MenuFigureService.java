package services;

import constants.Messages;
import constants.MessagesError;
import constants.ValidateInputs;
import enums.TypeFiguresEnum;
import exepctions.ExeptionAplication;
import interfaces.IFigure;
import utils.Menus;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class MenuFigureService {

    public MenuFigureService() {
    }

    public void menuFigures() {
        Menus menus = new Menus();
        TypeFiguresEnum typeFiguresEnum;
        StringBuilder stringBuilder = menus.figureOptions();
        ValidateInputs validateInputs = new ValidateInputs();
        IFigure figure = null;

        boolean flag = false;
        while (!flag){
            System.out.println(stringBuilder.toString());
            Scanner scanner = new Scanner(System.in);
            try {
                int opcion = validateInputs.inputInteger(Messages.OPTION,scanner);
                typeFiguresEnum = menus.getNameFigure(opcion);
                //menuOptionsEnum = menus.getNameMenu(opcion);
                switch (typeFiguresEnum){
                    case CIRCLE:
                        System.out.println("Esto es un circulo");
                        break;
                    case SQUARE:
                        System.out.println("Esto es un cuadrado");
                        break;
                    case RECTANGLE:
                        System.out.println("Esto es un rectangulo");
                        break;
                    case EQUILATERAL_TRIANGLE:
                        System.out.println("Esto es un trinagulo equilatero");
                        break;
                    case ISOSCELES_ISOSCELES:
                        System.out.println("Esto es un triangulo isosceles");
                        flag = true;
                        break;
                }
                //if (figure != null) flag = true;

            }catch (NoSuchElementException e){
                System.err.println(MessagesError.MESSAGE_INPUT_MENU);
            } catch (ExeptionAplication exeptionAplication) {
                System.err.println(exeptionAplication.getMessage());
            }
            System.out.println(" ");
        }
    }
}
