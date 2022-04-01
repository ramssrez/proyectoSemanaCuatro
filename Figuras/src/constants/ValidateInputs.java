package constants;

import exepctions.ExeptionAplication;
import java.util.Scanner;

public class ValidateInputs {

    public ValidateInputs() {
    }

    public double validateInputDouble(String s, Scanner scanner) throws ExeptionAplication {
        double value  = 0.0;
        boolean flag = false;
        while (!flag) {
            System.out.println(" ");
            try {
                System.out.print(s);
                value = Double.parseDouble(scanner.nextLine());
                flag = true;
            } catch (NumberFormatException |NullPointerException e) {
                throw new ExeptionAplication(MessagesError.MESSAGE_INPUT_ERROR);
            }
            System.out.println(" ");
        }
        return value;
    }

    public int inputInteger(String s, Scanner scanner) throws ExeptionAplication {
        int value = 0;
        boolean flag = false;
        while (!flag) {
            System.out.println(" ");
            try {
                System.out.print(s);
                value = Integer.parseInt(scanner.nextLine());
                flag = true;
            } catch (NumberFormatException |NullPointerException e) {
                throw new ExeptionAplication(MessagesError.MESSAGE_INPUT_ERROR);
            }
            System.out.println(" ");
        }
        return value;
    }
    public String inputString(String s, Scanner scanner) throws ExeptionAplication {
        String string = null;
        boolean flag = false;
        while (!flag) {
            System.out.println(" ");
            System.out.print(s);
            string = scanner.nextLine();
            if (string == null || string.isEmpty()){
                throw  new ExeptionAplication(MessagesError.MESSAGE_EMPTY);
            }else {
                flag = true;
            }
            System.out.println(" ");
        }
        return string;
    }
}
