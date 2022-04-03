package services;

import constants.Messages;
import constants.MessagesError;
import constants.ValidateInputs;
import domain.Dir;
import enums.MenuOptionsEnum;
import enums.TypeFiguresEnum;
import exepctions.ExeptionAplication;
import utils.Menus;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

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
                        MenuFigureService menuFigureService = new MenuFigureService();
                        menuFigureService.menuFigures();
                        break;
                    case OPEN:
                        openFiles();

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
    public static void openFiles() throws ExeptionAplication {
        ValidateInputs validateInputs = new  ValidateInputs();
        StringBuilder builder = new StringBuilder("Directorios de la carpeta calculos");
        ManageFilesService filesService = new ManageFilesService();
        List<Dir> listDir = filesService.showDir();
        if (listDir.isEmpty()) throw new  ExeptionAplication(MessagesError.MESSAGE_EMPTY_DIR);
        for (Dir dir: listDir) {
            builder.append(String.format(Messages.FORMAT_OPTIONS,dir.getOption(),dir.getName()));
            //System.out.println("Opcion " + dir.getOption() + "Nombre: " + dir.getName());
        }
        System.out.println(builder.toString());
        int option = validateInputs.inputInteger();

    }
    public TypeFiguresEnum getNameFigure(int option){
        return Stream.of(this.typeFiguresEnums)
                .filter(f->f.getOption() == option)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

}
