package constants;

import exepctions.ExeptionAplication;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class ValidateInputs {
    public ValidateInputs() {
    }
    public double ValidateInputDouble(String argumento){
        double valor  = 0.0;
        boolean bandera = false;
        while (!bandera) {
            try {
                //System.out.print(argumento);
                valor = Double.parseDouble(argumento);
                bandera = true;
            } catch (NumberFormatException |NullPointerException e) {
                System.err.println("No ha ingresado un valor correcto");
            }
        }
        return valor;
    }
    public int inputInteger(String argumento, Scanner scanner) throws ExeptionAplication {
        int valor = 0;
        boolean bandera = false;
        while (!bandera) {
            System.out.println(" ");
            try {
                System.out.print(argumento);
                valor = Integer.parseInt(scanner.nextLine());
                bandera = true;
            } catch (NumberFormatException |NullPointerException e) {
                //System.err.println("No ha ingresado un valor correcto");
                throw new ExeptionAplication(MessagesError.MESSAGE_INPUT_ERROR);
            }
            System.out.println(" ");
        }
        return valor;
    }
}
