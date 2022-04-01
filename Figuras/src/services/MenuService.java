package services;

import constants.Messages;
import constants.MessagesError;
import constants.ValidateInputs;
import enums.MenuOptionsEnum;
import exepctions.ExeptionAplication;
import utils.Menus;
import java.util.NoSuchElementException;

public class MenuService {
    public static void menu() {
        Menus menus = new Menus();
        MenuOptionsEnum menuOptionsEnum;
        StringBuilder stringBuilder = menus.menuOptions();
        ValidateInputs validateInputs = new ValidateInputs();

        boolean flag = false;
        while (!flag){
            System.out.println(stringBuilder.toString());
            try {
                int opcion = validateInputs.inputInteger(Messages.OPTION);
                menuOptionsEnum = menus.getNameMenu(opcion);
                switch (menuOptionsEnum){
                    case REGISTER:
                        //System.out.println("Selecciona una figura");
                        MenuFigureService menuFigureService = new MenuFigureService();
                        menuFigureService.menuFigures();
                        break;
                    case OPEN:
                        System.out.println("Selecciona un archivo");
                        break;
                    case GOOUT:
                        System.out.println(Messages.GO_OUT_APP);
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
    }

}
