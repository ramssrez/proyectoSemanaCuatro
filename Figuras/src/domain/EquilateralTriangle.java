package domain;

import abstracts.Triangle;
import constants.Messages;

public class EquilateralTriangle extends Triangle {
    private double side;

    public EquilateralTriangle(double side) {
        this.side = side;
        this.height = calculateHeight();
    }

    @Override
    public double calculateHeight() {
        return (Math.sqrt(3) * this.side) / 2;
    }

    @Override
    public double calculatePerimeter() {
        return this.side * 3;
    }

    @Override
    public double calculateArea() {
        return (this.side * this.height) / 2;
    }

    @Override
    public String readAttributes() {
        return String.format(Messages.EQUILATERAL_TRIANGLE_PROPERTIES,this.height,Messages.MEASUREMENT_UNITS ,this.side,Messages.MEASUREMENT_UNITS);
    }

    @Override
    public String toString() {
        return "EquilateralTriangle{" +
                "height=" + height +
                ", side=" + side +
                '}';
    }
}
