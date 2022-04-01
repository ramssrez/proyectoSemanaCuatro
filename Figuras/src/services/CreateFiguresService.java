package services;

import constants.Messages;
import constants.ValidateInputs;
import domain.*;
import exepctions.ExeptionAplication;
import interfaces.IFigure;

public class CreateFiguresService {
    private ValidateInputs validateInputs;

    public CreateFiguresService() {
        this.validateInputs = new ValidateInputs();
    }

    public IFigure createEquilateralTriangle() throws ExeptionAplication {
        double side = this.validateInputs.validateInputDouble(Messages.IN_SIDE );
        return new EquilateralTriangle(side);
    }

    public IFigure createCircule() throws ExeptionAplication {
        double radio = this.validateInputs.validateInputDouble(Messages.IN_RADIO);
        return new Circle(radio);
    }

    public IFigure createSquare() throws ExeptionAplication {
        double side = this.validateInputs.validateInputDouble(Messages.IN_SIDE);
        return new Square(side);
    }

    public IFigure createRectangle() throws ExeptionAplication {
        double base = this.validateInputs.validateInputDouble(Messages.IN_BASE);
        double height = this.validateInputs.validateInputDouble(Messages.IN_HEIGHT);
        return new Rectangle(base,height);
    }

    public IFigure createIsoscelesTriangle() throws ExeptionAplication {
        double base = this.validateInputs.validateInputDouble(Messages.IN_BASE);
        double side = this.validateInputs.validateInputDouble(Messages.IN_SIDE);
        return new IsoscelesTriangle(side,base);
    }

    public ValidateInputs getValidateInputs() {
        return validateInputs;
    }

    public void setValidateInputs(ValidateInputs validateInputs) {
        this.validateInputs = validateInputs;
    }

}
