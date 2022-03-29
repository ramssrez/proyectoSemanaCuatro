package enums;

import constants.Messages;

public enum TypeFiguresEnum {
    CIRCULO(Messages.CIRCLE,1),
    CUADRADO(Messages.SQUARE, 2),
    RECTANGULO(Messages.RECTANGLE, 3),
    TRIANGULO_EQUILATERO(Messages.EQUILATERAL_TRIANGLE, 4),
    TRIANGULO_ISOSCELES(Messages.ISOSCELES_ISOSCELES, 5);

    private final String name;
    private final int option;

    TypeFiguresEnum(String nombre, int opcion) {
        this.name = nombre;
        this.option = opcion;
    }

    public String getName() {
        return name;
    }

    public int getOption() {
        return option;
    }
}
