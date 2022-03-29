package enums;

import constants.Messages;

public enum TypeFiguresEnum {
    CIRCULO(Messages.CIRCULO,1),
    CUADRADO(Messages.CUADRADO, 2),
    RECTANGULO(Messages.RECTANGULO, 3),
    TRIANGULO_EQUILATERO(Messages.TRIANGULO_EQUILATERO, 4),
    TRIANGULO_ISOSCELES(Messages.TRIANGULO_ISOSCELES, 5);

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
