import constants.Messages;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Prueba {
    public static void main(String[] args) {
        crearCarpeta();

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.toString());
        String pathCarpet = Messages.PATH + localDate.toString();
        File carpetaNueva  = new File(pathCarpet);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa solo el nombre del archivo: ");
        String nombre = scanner.nextLine() + Messages.TYPE;
        if (!carpetaNueva.exists()){
            boolean carpetaCreada = carpetaNueva.mkdir();
            System.out.println("carpetaCreada = " + carpetaCreada);
            File crearArchivo = new File(carpetaNueva,nombre);
            try {
                crearArchivo.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if (carpetaNueva.exists()){
            try {
                File crearArchivo = new File(carpetaNueva,nombre);
                crearArchivo.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /*
        File nuevaCarpeta = new File(Messages.PATH);

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.toString());
        String pathCarpet = Messages.PATH + localDate.toString();
        File carpetaNueva  = new File(pathCarpet);
        System.out.println(carpetaNueva.toString());
        String nombreArchivo = "Hola.txt";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa solo el nombre del archivo: ");
        String nombre = scanner.nextLine() + Messages.TYPE;

        if (!carpetaNueva.exists()){
            boolean carpetaCreada = carpetaNueva.mkdir();
            System.out.println("carpetaCreada = " + carpetaCreada);
            File crearArchivo = new File(carpetaNueva,nombre);
            try {
                crearArchivo.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if (carpetaNueva.exists()){
            try {
                File crearArchivo = new File(carpetaNueva,nombre);
                crearArchivo.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


/*
        if (!nuevaCarpeta.exists()) {
            boolean carpetaCreada = nuevaCarpeta.mkdir();
            System.out.println("carpetaCreada = " + carpetaCreada);

            File crearArchivo = new File(nuevaCarpeta,"Hola Mundo.txt");
            try {
                crearArchivo.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Archivo creado = " + crearArchivo);
        }

        File directorio = new File("./");

        String[] archivos = directorio.list();

        for(String archivo : archivos) {
            System.out.println("archivo = " + archivo);
        }
*/

    }

    public static void crearCarpeta() {
        File carpetaNueva = new File(Messages.PATH);
        System.out.println(carpetaNueva.toString());
        boolean mkdir = carpetaNueva.mkdir();
        System.out.println("mkdir = " + mkdir);
    }
}
