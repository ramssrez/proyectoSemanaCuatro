package constants;

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
    public int inputInteger(String argumento, Scanner scanner){
        int valor = 0;
        boolean bandera = false;
        while (!bandera) {
            try {
                System.out.println(" ");
                System.out.print(argumento);
                valor = Integer.parseInt(scanner.nextLine());
                bandera = true;
            } catch (NumberFormatException |NullPointerException e) {
                System.out.println(" ");
                System.err.println("No ha ingresado un valor correcto");
            }
        }
        return valor;
    }
}
