package intership.agile.banco;

import intership.agile.banco.handler.PropertyHandler;

import java.io.IOException;
import java.util.Objects;

public class Principal {
    // Buena práctica de programación: Almacenar nombres de llaves en constantes estáticas
    private static final String PROP_USERNAME = "internship.agile.banco.username";
    private static final String PROP_PASSWORD = "internship.agile.banco.password";
    private static final byte TRY_LIMIT = 3;

    public static void main(String[] args) {
        try {
            PropertyHandler.load("/application-default.properties", "application.properties");
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
                //runCommandListener();

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
}
