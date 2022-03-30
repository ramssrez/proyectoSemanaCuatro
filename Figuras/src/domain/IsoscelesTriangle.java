package domain;

import abstracts.Triangle;
import constants.Messages;

public class IsoscelesTriangle extends Triangle {
    private double side;
    private double base;

    public IsoscelesTriangle(double side, double base) {
        this.side = side;
        this.base = base;
        this.height = calculateHeight();
    }

    @Override
    public double calculateHeight() {
        double sideToDouble = Math.pow(this.side,2);
        double baseToDouble = Math.pow(this.base,2);
        double insideRaiz = sideToDouble-(baseToDouble/4);
        return Math.sqrt(insideRaiz);
    }

    @Override
    public double calculatePerimeter() {
        return this.base + (2 * this.side);
    }

    @Override
    public double calculateArea() {
        return (this.side * this.height) / 2;
    }

    @Override
    public String readAttributes() {
        return String.format(Messages.ISOSCELES_TRIANGLE_PROPERTIES,this.height,Messages.MEASUREMENT_UNITS,this.side,Messages.MEASUREMENT_UNITS,this.base,Messages.MEASUREMENT_UNITS);
    }

    @Override
    public String toString() {
        return "IsoscelesTriangle{" +
                "height=" + height +
                ", side=" + side +
                ", base=" + base +
                '}';
    }
}
