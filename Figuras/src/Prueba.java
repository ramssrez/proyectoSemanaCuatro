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
        String pruebas = "Circulo sdfjsldfjlsdf";

        boolean bandera = false;
        while (!bandera) {
            String nombre;
            try {
                nombre = validateInputs.inputString("Ingresa el nombre del archivo: ");
                if (!fechaCarpeta.exists()){
                    bandera = crearArchivo(nombre,fechaCarpeta,pruebas);
                }else if (fechaCarpeta.exists()){
                    bandera = crearArchivo(nombre,fechaCarpeta,pruebas);
                }
            } catch (ExeptionAplication e) {
                System.err.println(e.getMessage());
            }

        }

    }

    public static void createCarpetGeneral() {
        File crearCarpet = new File(Messages.PATH);
        if (crearCarpet.mkdir()) System.out.println("Se ha creado la carpeta Calculos");
    }

    public static boolean crearArchivo(String name,File path, String promp){
        boolean bandera = false;
        ValidateInputs validateInputs = new ValidateInputs();
        try {
            StringBuilder builder = new StringBuilder(name);
            builder.append(Messages.TYPE);
            File file = new File(path,builder.toString());
            if (file.exists()){
                System.out.println("Este nombre ya existe, deseas escribir en el \n 1.-Si \n 2.-No");
                int valor = validateInputs.inputInteger("Ingresa el valor: ");
                if(valor == 1){
                    updateFile(builder.toString(),path,promp);
                    System.out.println("Se ha actualizado el archivo " + builder.toString());
                    bandera = true;
                }else{
                    System.out.println("Retornando.....");
                }
            }else {
                if(file.createNewFile()){
                    writeFile(builder.toString(),path, promp);
                    System.out.println("El archivo a sido creado en: " + file.toString());
                    bandera = true;
                }
            }
        } catch (IOException | ExeptionAplication e) {
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
            //System.out.println("Se ha escrito el archivo");
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
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
}
