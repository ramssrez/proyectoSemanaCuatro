package services;

import constants.Messages;
import constants.MessagesError;
import constants.ValidateInputs;
import enums.TypeFiguresEnum;
import exepctions.ExeptionAplication;
import interfaces.IFigure;
import utils.Menus;
import java.util.NoSuchElementException;

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
            try {
                int opcion = validateInputs.inputInteger(Messages.OPTION);
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
                    System.out.println(formatString(figure,typeFiguresEnum));
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

    private String formatString(IFigure figure,TypeFiguresEnum typeFiguresEnum){
        StringBuilder builder = new StringBuilder(typeFiguresEnum.getName());
        builder.append(figure.readAttributes());
        builder.append(String.format(Messages.PERIMETER,figure.calculatePerimeter(),Messages.MEASUREMENT_UNITS));
        builder.append(String.format(Messages.AREA,figure.calculateArea(),Messages.MEASUREMENT_UNITS_SQUARE));
        return builder.toString();
    }
}
