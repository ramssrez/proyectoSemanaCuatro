package domain;

import constants.Messages;
import interfaces.IFigure;

public class Circle implements IFigure{
    private double radio;

    public Circle(double radio) {
        this.radio = radio;
    }

    @Override
    public double calculatePerimeter() {
        return Math.PI * this.radio * 2;
    }

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(this.radio, 2);
    }

    @Override
    public String reedAttributes() {
        return String.format(Messages.CIRCLE_PROPERTIES,this.radio);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radio=" + radio +
                '}';
    }
}
