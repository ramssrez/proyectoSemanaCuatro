package domain;

import constants.Messages;
import interfaces.IFigure;

public class Square implements IFigure {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double calculatePerimeter() {
        return this.side * 4;
    }

    @Override
    public double calculateArea() {
        return Math.pow(this.side,2);
    }

    @Override
    public String reedAttributes() {
        return String.format(Messages.SQUARE_PROPERTIES,this.side);
    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                '}';
    }
}
