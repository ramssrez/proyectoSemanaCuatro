package intership.agile.banco;

import intership.agile.banco.administradors.AdministradorCliente;
import intership.agile.banco.administradors.AdministradorProducto;
import intership.agile.banco.classhelp.Configuracion;
import intership.agile.banco.classhelp.Validacion;
import intership.agile.banco.handler.PropertyHandler;
import intership.agile.banco.model.Cliente;

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
    private static AdministradorCliente administradorCliente = new AdministradorCliente();
    private static AdministradorProducto administradorProducto;

    public static void main(String[] args) {
        clientes = administradorCliente.listaClientes();
        //Configuracion configuracion = new Configuracion();
        //configuracion.setMaxLineaCreditoPorIngresoMensual(4.0);
        //administradorProducto = new AdministradorProducto(configuracion);
        //administradorProducto.
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
                case "lista-clientes":
                    //printPath();
                    listaClientes();
                    break;
                case "buscar-cliente":
                    buscarCliente();
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
        System.out.println("- ayuda: Muestra los comandos disponibles en la aplicación\n" +
                "- crear-cliente: Crea un nuevo cliente.\n" +
                "- lista-clientes: Muestra los clientes con los que se cuenta.\n" +
                "- buscar-cliente: Busca a los usuarios con el id del cliente.\n" +
                "- producto-cliente: Crea un producto financiero del cliente\n" +
                "- divide-double\n" +
                "- divide-integer\n" +
                "- exit");
    }

    private static void buscarCliente(){
        int entero = Validacion.validarEntero("Ingresa el id del cliente: ");
        Cliente cliente = administradorCliente.getCliente(entero,clientes);
        if (cliente != null){
            System.out.println(cliente.toString());
        }else{
            System.out.println("No se ha encontrado un cliente");
        }
    }
    private static void crearCliente(){
        Cliente cliente = new Cliente();
        cliente.setNombre(Validacion.validarString("Ingresa el nombre: "));
        cliente.setIngresoMensual(Validacion.validarDouble("Ingresa el sueldo mensual: "));
        agregarCliente(cliente);
    }
    private static void listaClientes(){
        if (!clientes.isEmpty()){
            impresionCliente();
        }else{
            System.out.println("No se cuenta con registro de clientes");
        }
    }
    public static void impresionCliente(){
        System.out.println("ID : Nombre"  );
        for (Cliente cliente : clientes){
            System.out.println(cliente.getIdCliente() + " : " + cliente.getNombre());
        }
    }
    private static void agregarCliente(Cliente cliente){
        administradorCliente.agregarCliente(cliente);
    }
}
