package intership.agile.banco;

import intership.agile.banco.handler.PropertyHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Principal {
    // Buena práctica de programación: Almacenar nombres de llaves en constantes estáticas
    private static final String PROP_USERNAME = "internship.agile.banco.username";
    private static final String PROP_PASSWORD = "internship.agile.banco.password";
    private static final String DEFAULT_PROPERTIES = "/application-default.properties";
    private static final String APPLICATIONS_PROPERTIES = "application.properties";
    private static final byte TRY_LIMIT = 3;
    private static List<Cliente> clientes = new ArrayList<>();
    private  static AdministradorCliente administradorCliente = new AdministradorCliente();

    public static void main(String[] args) {
        try {
            PropertyHandler.load(DEFAULT_PROPERTIES, APPLICATIONS_PROPERTIES);
            String username, password;
            System.out.println("Inicio de sesión...");

            boolean isLoggedIn = false;
            byte tryCount = 0;
            do {
                System.out.print("Usuario: ");
                username = System.console().readLine();
                System.out.print("Contraseña: ");
                // Se usa System.console() para tener la habilidad de ocultar el password.
                // El uso de System.console() puede tener resultados impredecibles en la terminal del IDE
                // Se recomienda ejecutar la aplicación desde una terminal real.
                password = new String(System.console().readPassword());
                if(Objects.equals(username, PropertyHandler.getStringProperty(PROP_USERNAME)) &&
                        Objects.equals(password, PropertyHandler.getStringProperty(PROP_PASSWORD)))
                    isLoggedIn = true;
                else
                    System.err.println("Usuario y contraseña incorrectos\n\n");
                tryCount++;
            } while (!isLoggedIn && tryCount < TRY_LIMIT);

            if(isLoggedIn) {
                System.out.printf("Bienvenido %s%n", username);
                runCommandListener();
            }
            else{
                System.err.println("Haz rebasado el límite para iniciar sesión, intentalo mas tarde");
            }
            PropertyHandler.persist();
            System.out.println("Programa finalizado");
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
                case "crear-cliente":
                    crearCliente();
                    break;
                case "lista-cliente":
                    //printPath();
                    listaCliente();
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
                    System.err.printf("\"%s\" No es un comando%n", command);
            }
        } while(!"exit".equalsIgnoreCase(command));
    }
    private static void printHelp() {
        System.out.println("Lista de comandos disponibles ");
        System.out.println("- ayuda\n" +
                "- crear-cliente\n" +
                "- lista-cliente\n" +
                "- print-java-home\n" +
                "- sys-username\n" +
                "- divide-double\n" +
                "- divide-integer\n" +
                "- exit");
    }
    private static void crearCliente(){
        Cliente cliente = new Cliente();
        cliente.setNombre(validarString("Nombre Cliente: "));
        cliente.setIngresoMensual(validarDouble("Ingresa el sueldo mensual: "));
        agregarCliente(cliente);
    }
    private static void listaCliente(){
        if (clientes != null){
            clientes = administradorCliente.listaClientes();
            System.out.println(clientes);
        }else{
            System.out.println("No se cuenta con registro de clientes");
        }

    }
    private static void agregarCliente(Cliente cliente){
        administradorCliente.agregarCliente(cliente);
    }
    private static double validarDouble(String argumento){
        double valor  = 0.0;
        boolean bandera = false;
        while (!bandera){
            try {
                System.out.print(argumento);
                valor = Double.parseDouble(System.console().readLine());
                bandera = true;
            }catch (Exception e){
                System.out.println("Valor incorrecto, se espera un double");
            }
        }
        return valor;
    }
    private static String validarString(String argumento){
        boolean bandera = false;
        String string = "";
        while (!bandera){
            try {
                System.out.print(argumento);
                string = System.console().readLine();
                if (!soloLetras(string) || string.isEmpty()){
                    System.err.println("Nombre incorrecto, intenta de nuevo");
                }else {
                    bandera = true;
                }
            }catch (Exception e){
                System.out.println("Valor incorrecto, se espera un string");
            }
        }
        return string;
    }
    public static boolean soloLetras(String cadena) {
        for (int x = 0; x < cadena.length(); x++) {
            char c = cadena.charAt(x);
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ')) {
                return false;
            }
        }
        return true;
    }
}
