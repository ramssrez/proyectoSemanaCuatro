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
        IFigure figure = null;
        double valueGeneral = 0.0;
        double valueGeneralTwo = 0.0;

        boolean flag = false;
        while (!flag){
            System.out.println(stringBuilder.toString());
            Scanner scanner = new Scanner(System.in);
            try {
                int opcion = validateInputs.inputInteger(Messages.OPTION,scanner);
                typeFiguresEnum = menus.getNameFigure(opcion);
                switch (typeFiguresEnum){
                    case CIRCLE:
                        //valueGeneral = validateInputs.validateInputDouble("Ingresa el radio: ",scanner);
                        figure = createCircule(scanner,validateInputs);
                        break;
                    case SQUARE:
                        //valueGeneral = validateInputs.validateInputDouble("Ingresa el lado: " ,scanner);
                        figure = createSquare(scanner,validateInputs);
                        break;
                    case RECTANGLE:
                        valueGeneral = validateInputs.validateInputDouble("Ingresa la base: " ,scanner);
                        valueGeneralTwo = validateInputs.validateInputDouble("Ingresa la altura: ",scanner);
                        figure = new Rectangle(valueGeneral,valueGeneralTwo);
                        break;
                    case EQUILATERAL_TRIANGLE:
                        valueGeneral = validateInputs.validateInputDouble("Ingresa la base: " ,scanner);
                        figure = new EquilateralTriangle(valueGeneral);
                        break;
                    case ISOSCELES_TRIANGLE:
                        valueGeneral = validateInputs.validateInputDouble("Ingresa la base: ",scanner);
                        valueGeneralTwo = validateInputs.validateInputDouble("Ingresa el lado: " , scanner);
                        figure = new IsoscelesTriangle(valueGeneralTwo,valueGeneral);
                        flag = true;
                        break;
                }
                if (figure != null){
                    System.out.println(typeFiguresEnum.getName() + figure.readAttributes() + " Perimetro: " + figure.calculatePerimeter() + " Area: " + figure.calculateArea());
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
    private IFigure createCircule(Scanner scanner, ValidateInputs validateInputs) throws ExeptionAplication {
        double radio = validateInputs.validateInputDouble(Messages.IN_RADIO,scanner);
        return new Circle(radio);
    }

    private IFigure createSquare(Scanner scanner, ValidateInputs validateInputs) throws ExeptionAplication {
        double side = validateInputs.validateInputDouble(Messages.IN_SIDE ,scanner);
        return new Square(side);
    }

    private IFigure createRectangle(Scanner scanner, ValidateInputs validateInputs) throws ExeptionAplication {
        double base = validateInputs.validateInputDouble(Messages.IN_BASE ,scanner);
        double height = validateInputs.validateInputDouble(Messages.IN_HEIGHT ,scanner);
        return new Rectangle(base,height);
    }

    private IFigure createEquilateralTriangle(Scanner scanner, ValidateInputs validateInputs) throws ExeptionAplication {
        double side = validateInputs.validateInputDouble(Messages.IN_SIDE ,scanner);
        return new EquilateralTriangle(side);
    }

    private IFigure createIsoscelesTriangle(Scanner scanner, ValidateInputs validateInputs) throws ExeptionAplication {
        double base = validateInputs.validateInputDouble(Messages.IN_BASE ,scanner);
        double side = validateInputs.validateInputDouble(Messages.IN_SIDE ,scanner);
        return new IsoscelesTriangle(side,base);
    }
}
