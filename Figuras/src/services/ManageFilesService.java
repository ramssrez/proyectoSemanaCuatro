package services;

import constants.Messages;
import java.io.*;
import java.time.LocalDate;
import java.util.Arrays;

public class ManageFilesService{

    public ManageFilesService() {
    }

    public void creteDir(String datesFigure, String name) {
        createCarpetGeneral();
        LocalDate localDate = LocalDate.now();
        StringBuilder builder = new StringBuilder(Messages.PATH);
        builder.append(localDate.toString());
        File dateDir  = new File(builder.toString());
        if (dateDir.mkdir()) System.out.println(String.format(Messages.NAME_DATE_DIR,localDate.toString()));
        if (!dateDir.exists()){
            createFile(name,dateDir,datesFigure);
        }else if (dateDir.exists()){
            createFile(name,dateDir,datesFigure);
        }
    }

    private void createCarpetGeneral() {
        File crearCarpet = new File(Messages.PATH);
        if (crearCarpet.mkdir()) System.out.println(String.format(Messages.NAME_DATE_DIR,Messages.PATH));
    }

    private void createFile(String name, File path, String promp){
        try {
            StringBuilder builder = new StringBuilder(name);
            builder.append(Messages.TYPE);
            File file = new File(path,builder.toString());
            if (file.exists()){
                updateFile(builder.toString(),path,promp);
                System.out.println(String.format(Messages.FILE_UPDATE,builder.toString()));
            }else {
                if(file.createNewFile()){
                    writeFile(builder.toString(),path, promp);
                    System.out.println(String.format(Messages.PATH_FILE,file.toString()));
                    //bandera = true;
                }
            }
        } catch (IOException  e) {
            System.err.println(e.getMessage());
        }
    }

    private void writeFile(String name, File path, String content){
        File file = new File(path,name);
        try {
            PrintWriter writer = new PrintWriter(file);
            writer.println(content);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        }
    }

    private void updateFile(String name, File path, String content){
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
    public void showDir(){
        File file = new File(Messages.PATH);
        String [] list =file.list();
        Arrays.sort(list);
        for (int i = 0; i<list.length;i++){
            System.out.println(list[i]);
        }
    }
}
