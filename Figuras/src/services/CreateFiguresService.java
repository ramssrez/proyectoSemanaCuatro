package services;

import constants.Messages;
import constants.ValidateInputs;
import domain.*;
import exepctions.ExeptionAplication;
import interfaces.IFigure;

import java.util.Scanner;

public class CreateFiguresService {
    private ValidateInputs validateInputs;
    private Scanner scanner;

    public CreateFiguresService() {
        this.validateInputs = new ValidateInputs();
        this.scanner = new Scanner(System.in);
    }

    public IFigure createEquilateralTriangle() throws ExeptionAplication {
        double side = this.validateInputs.validateInputDouble(Messages.IN_SIDE ,this.scanner);
        return new EquilateralTriangle(side);
    }

    public IFigure createCircule() throws ExeptionAplication {
        double radio = this.validateInputs.validateInputDouble(Messages.IN_RADIO,this.scanner);
        return new Circle(radio);
    }

    public IFigure createSquare() throws ExeptionAplication {
        double side = this.validateInputs.validateInputDouble(Messages.IN_SIDE ,this.scanner);
        return new Square(side);
    }

    public IFigure createRectangle() throws ExeptionAplication {
        double base = this.validateInputs.validateInputDouble(Messages.IN_BASE ,this.scanner);
        double height = this.validateInputs.validateInputDouble(Messages.IN_HEIGHT ,this.scanner);
        return new Rectangle(base,height);
    }

    public IFigure createIsoscelesTriangle() throws ExeptionAplication {
        double base = this.validateInputs.validateInputDouble(Messages.IN_BASE ,this.scanner);
        double side = this.validateInputs.validateInputDouble(Messages.IN_SIDE ,this.scanner);
        return new IsoscelesTriangle(side,base);
    }

    public ValidateInputs getValidateInputs() {
        return validateInputs;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setValidateInputs(ValidateInputs validateInputs) {
        this.validateInputs = validateInputs;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}
