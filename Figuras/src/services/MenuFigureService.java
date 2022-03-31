package services;

import constants.Messages;
import constants.MessagesError;
import constants.ValidateInputs;
import domain.*;
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
        CreateFiguresService figuresService = new CreateFiguresService();
        IFigure figure = null;

        boolean flag = false;
        while (!flag){
            System.out.println(stringBuilder.toString());
            Scanner scanner = new Scanner(System.in);
            try {
                int opcion = validateInputs.inputInteger(Messages.OPTION,scanner);
                typeFiguresEnum = menus.getNameFigure(opcion);
                switch (typeFiguresEnum){
                    case CIRCLE:
                        figure = figuresService.createCircule();
                        break;
                    case SQUARE:
                        figure = figuresService.createSquare();
                        break;
                    case RECTANGLE:
                        figure = figuresService.createRectangle();
                        break;
                    case EQUILATERAL_TRIANGLE:
                        figure = figuresService.createEquilateralTriangle();
                        break;
                    case ISOSCELES_TRIANGLE:
                        figure = figuresService.createIsoscelesTriangle();
                        break;
                }
                if (figure != null){
                    System.out.println(typeFiguresEnum.getName() + " " + figure.readAttributes() + " Perimetro: " + figure.calculatePerimeter() + " Area: " + figure.calculateArea());
                    flag = true;
                }

            }catch (NoSuchElementException e){
                System.err.println(MessagesError.MESSAGE_INPUT_MENU);
            } catch (ExeptionAplication exeptionAplication) {
                System.err.println(exeptionAplication.getMessage());
            }
            System.out.println(" ");
        }
    }
}
