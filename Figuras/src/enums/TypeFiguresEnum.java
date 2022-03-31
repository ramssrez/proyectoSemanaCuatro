package enums;

import constants.Messages;

public enum TypeFiguresEnum {
    CIRCLE(Messages.CIRCLE,1),
    SQUARE(Messages.SQUARE, 2),
    RECTANGLE(Messages.RECTANGLE, 3),
    EQUILATERAL_TRIANGLE(Messages.EQUILATERAL_TRIANGLE, 4),
    ISOSCELES_TRIANGLE(Messages.ISOSCELES_TRIANGLE, 5);

    private final String name;
    private final int option;

    TypeFiguresEnum(String name, int option) {
        this.name = name;
        this.option = option;
    }

    public String getName() {
        return name;
    }

    public int getOption() {
        return option;
    }
}
