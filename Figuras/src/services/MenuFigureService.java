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
                        valueGeneral = validateInputs.validateInputDouble("Ingresa el radio: ",scanner);
                        figure = new Circle(valueGeneral);
                        break;
                    case SQUARE:
                        valueGeneral = validateInputs.validateInputDouble("Ingresa el lado: " ,scanner);
                        figure = new Square(valueGeneral);
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
                    case ISOSCELES_ISOSCELES:
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
    private IFigure createCircule(double value){
        return new Circle(value);
    }
}
