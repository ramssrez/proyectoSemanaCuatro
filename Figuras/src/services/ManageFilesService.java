package services;

import constants.Messages;
import constants.ValidateInputs;
import exepctions.ExeptionAplication;

import java.io.*;
import java.time.LocalDate;

public class ManageFilesService {

    public static void creteDir(String datesFigure) {
        createCarpetGeneral();
        LocalDate localDate = LocalDate.now();
        StringBuilder builder = new StringBuilder(Messages.PATH);
        builder.append(localDate.toString());
        File dateDir  = new File(builder.toString());
        if (dateDir.mkdir()) System.out.println(String.format(Messages.NAME_DATE_DIR,localDate.toString()));

        ValidateInputs validateInputs = new ValidateInputs();

        boolean bandera = false;
        while (!bandera) {
            String nombre;
            try {
                nombre = validateInputs.inputString(Messages.NAME_FILE);
                if (!dateDir.exists()){
                    bandera = crearArchivo(nombre,dateDir,datesFigure);
                }else if (dateDir.exists()){
                    bandera = crearArchivo(nombre,dateDir,datesFigure);
                }
            } catch (ExeptionAplication e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static void createCarpetGeneral() {
        File crearCarpet = new File(Messages.PATH);
        if (crearCarpet.mkdir()) System.out.println(String.format(Messages.NAME_DATE_DIR,Messages.PATH));
    }

    public static boolean crearArchivo(String name,File path, String promp){
        boolean bandera = false;
        ValidateInputs validateInputs = new ValidateInputs();
        try {
            StringBuilder builder = new StringBuilder(name);
            builder.append(Messages.TYPE);
            File file = new File(path,builder.toString());
            if (file.exists()){
                System.out.println(Messages.OPTIONS_UPDATE);
                int valor = validateInputs.inputInteger(Messages.OPTION);
                if(valor == 1){
                    updateFile(builder.toString(),path,promp);
                    System.out.println(String.format(Messages.FILE_UPDATE,builder.toString()));
                    bandera = true;
                }else{
                    System.out.println(Messages.RETURN);
                }
            }else {
                if(file.createNewFile()){
                    writeFile(builder.toString(),path, promp);
                    System.out.println(String.format(Messages.PATH_FILE,file.toString()));
                    bandera = true;
                }
            }
        } catch (IOException | ExeptionAplication e) {
            System.out.println(e.getMessage());
        }
        return bandera;
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
