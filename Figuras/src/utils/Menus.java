package utils;

import constants.Messages;
import enums.MenuOptionsEnum;
import enums.TypeFiguresEnum;

import java.util.NoSuchElementException;
import java.util.stream.Stream;

public class Menus {
    private TypeFiguresEnum[] typeFiguresEnums;
    private MenuOptionsEnum[] menuOptionsEnums;

    public Menus() {
        typeFiguresEnums = TypeFiguresEnum.values();
        menuOptionsEnums = MenuOptionsEnum.values();
    }

    public TypeFiguresEnum[] getTypeFiguresEnums() {
        return typeFiguresEnums;
    }

    public void setTypeFiguresEnums(TypeFiguresEnum[] typeFiguresEnums) {
        this.typeFiguresEnums = typeFiguresEnums;
    }

    public MenuOptionsEnum[] getMenuOptionsEnums() {
        return menuOptionsEnums;
    }

    public void setMenuOptionsEnums(MenuOptionsEnum[] menuOptionsEnums) {
        this.menuOptionsEnums = menuOptionsEnums;
    }

    public StringBuilder menuOptions() {
        StringBuilder stringBuilder = new StringBuilder(Messages.MENU_OPTION);
        for(MenuOptionsEnum f : this.menuOptionsEnums) {
            stringBuilder.append(String.format(Messages.FORMAT_OPTIONS, f.getOption(),f.getName()));
        }
        return stringBuilder;
    }

    public StringBuilder figureOptions() {
        StringBuilder stringBuilder = new StringBuilder(Messages.FIGURE_OPTION);
        for(TypeFiguresEnum f : this.typeFiguresEnums) {
            stringBuilder.append(String.format(Messages.FORMAT_OPTIONS, f.getOption(),f.getName()));
        }
        return stringBuilder;
    }

    public MenuOptionsEnum getNameMenu(int option){
        return Stream.of(menuOptionsEnums)
                .filter(f->f.getOption() == option)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    public TypeFiguresEnum getNameFigure(int option){
        return Stream.of(typeFiguresEnums)
                .filter(f->f.getOption() == option)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }
}
