package intership.agile.banco;

import intership.agile.banco.handler.PropertyHandler;

import java.io.IOException;
import java.util.Objects;

public class Principal {
    // Buena práctica de programación: Almacenar nombres de llaves en constantes estáticas
    private static final String PROP_USERNAME = "internship.agile.banco.username";
    private static final String PROP_PASSWORD = "internship.agile.banco.password";
    private static final String DEFAULT_PROPERTIES = "/application-default.properties";
    private static final String APPLICATIONS_PROPERTIES = "application.properties";
    private static final byte TRY_LIMIT = 3;

    public static void main(String[] args) {
        try {
            PropertyHandler.load(DEFAULT_PROPERTIES, APPLICATIONS_PROPERTIES);
            String username, password;
            System.out.println("Login...");

            boolean isLoggedIn = false;
            byte tryCount = 0;
            do {
                System.out.print("username: ");
                username = System.console().readLine();
                System.out.print("password: ");
                // Se usa System.console() para tener la habilidad de ocultar el password.
                // El uso de System.console() puede tener resultados impredecibles en la terminal del IDE
                // Se recomienda ejecutar la aplicación desde una terminal real.
                password = new String(System.console().readPassword());
                if(Objects.equals(username, PropertyHandler.getStringProperty(PROP_USERNAME)) &&
                        Objects.equals(password, PropertyHandler.getStringProperty(PROP_PASSWORD)))
                    isLoggedIn = true;
                else
                    System.err.println("Incorrect username or password\n\n");
                tryCount++;
            } while (!isLoggedIn && tryCount < TRY_LIMIT);

            if(isLoggedIn) {
                System.out.printf("Successfully logged in as %s%n", username);
                runCommandListener();
            }
            else
                System.err.println("You have reached your attempts limit");

            PropertyHandler.persist();
            System.out.println("PROGRAM END");
        } catch (IOException e) {
            //e.printStackTrace();
            System.err.printf("%s: %s%n", e.getClass().getName(), e.getMessage());
        }
    }
    private static void runCommandListener() {
        String command;
        do {
            System.out.print("$ ");
            command = System.console().readLine();
            // Buena práctica de programación: Encapsular la lógica de cada case en un una función separada
            switch (command) {
                case "ayuda":
                    printHelp();
                    break;
                case "chg-pass":
                    //changePassword();
                    break;
                case "print-path":
                    //printPath();
                    break;
                case "print-java-home":
                    //printJavaHome();
                    break;
                case "sys-username":
                    //printSystemUsername();
                    break;
                case "divide-double":
                    //divisionDouble();
                    break;
                case "divide-integer":
                    //divisionEntera();
                    break;
                case "exit":
                    // No recomendado: En la mayoría de los casos, no se recomienda invocar a System.exit(int)
                    //System.exit(0);
                    break;
                default:
                    System.err.printf("\"%s\" is not a recognized command%n", command);
            }
        } while(!"exit".equalsIgnoreCase(command));
    }
    private static void printHelp() {
        System.out.println("- ayuda\n" +
                "- chg-pass\n" +
                "- print-path\n" +
                "- print-java-home\n" +
                "- sys-username\n" +
                "- divide-double\n" +
                "- divide-integer\n" +
                "- exit");
    }
}
