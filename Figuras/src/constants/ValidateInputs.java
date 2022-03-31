package constants;

import exepctions.ExeptionAplication;
import java.util.Scanner;

public class ValidateInputs {
    public ValidateInputs() {
    }
    public double ValidateInputDouble(String argumento, Scanner scanner) throws ExeptionAplication {
        double valor  = 0.0;
        boolean bandera = false;
        while (!bandera) {
            try {
                System.out.print(argumento);
                valor = Double.parseDouble(scanner.nextLine());
                bandera = true;
            } catch (NumberFormatException |NullPointerException e) {
                throw new ExeptionAplication(MessagesError.MESSAGE_INPUT_ERROR);
            }
            System.out.println(" ");
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
                throw new ExeptionAplication(MessagesError.MESSAGE_INPUT_ERROR);
            }
            System.out.println(" ");
        }
        return valor;
    }
}
