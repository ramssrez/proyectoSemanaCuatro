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
        return (Math.sqrt(3) * side) / 2;
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
    public String reedAttributes() {
        return String.format(Messages.EQUILATERAL_TRIANGLE_PROPERTIES,this.height,this.side);
    }

    @Override
    public String toString() {
        return "EquilateralTriangle{" +
                "height=" + height +
                ", side=" + side +
                '}';
    }
}
