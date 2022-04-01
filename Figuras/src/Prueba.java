import constants.Messages;
import constants.ValidateInputs;
import exepctions.ExeptionAplication;

import java.io.*;
import java.time.LocalDate;

public class Prueba {
    public static void main(String[] args) {
        createCarpetGeneral();
        LocalDate localDate = LocalDate.now();
        StringBuilder builder = new StringBuilder(Messages.PATH);
        builder.append(localDate.toString());
        File fechaCarpeta  = new File(builder.toString());
        if (fechaCarpeta.mkdir()) System.out.println("Carpeta " + localDate.toString() + " creada");

        ValidateInputs validateInputs = new ValidateInputs();

        boolean bandera = false;
        while (!bandera) {
            String nombre = null;
            try {
                nombre = validateInputs.inputString("Ingresa el nombre del archivo: ");
                if (!fechaCarpeta.exists()){
                    bandera = crearArchivo(nombre,fechaCarpeta);
                }else if (fechaCarpeta.exists()){
                    bandera = crearArchivo(nombre,fechaCarpeta);
                }
            } catch (ExeptionAplication e) {
                System.err.println(e.getMessage());
                //e.printStackTrace();
            }

        }

    }

    public static void createCarpetGeneral() {
        File crearCarpet = new File(Messages.PATH);
        if (crearCarpet.mkdir()) System.out.println("Se ha creado la carpeta Calculos");
    }

    public static boolean crearArchivo(String s,File path){
        boolean bandera = false;
        try {
            StringBuilder builder = new StringBuilder(s);
            builder.append(Messages.TYPE);
            File file = new File(path,builder.toString());
            if (file.exists()){
                System.out.println("Este nombre ya existe, deseas escribir en el ");
                System.out.println();
            }else {
                if(file.createNewFile()){
                    writeFile(builder.toString(),path, "Esto es una prueba");
                    //System.out.println("El archivo a sido creado en: " + file.toString());
                    bandera = true;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return bandera;
    }

    public static void createFile(String name, File path){
        File file = new File(path,name);
        try {
            PrintWriter writer = new PrintWriter(file);
            writer.close();
            System.out.println("Se ha creado el archivo");
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        }
    }

    public static void writeFile(String name, File path, String content){
        File file = new File(path,name);
        try {
            PrintWriter writer = new PrintWriter(file);
            writer.println(content);
            writer.close();
            System.out.println("Se ha escrito el archivo");
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        }
    }

    public static void updateFile(String name, File path, String content){
        File file = new File(path,name);
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(file,true));
            writer.println(content);
            writer.close();
            System.out.println("Se ha escrito el archivo");
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
    // static void
}
