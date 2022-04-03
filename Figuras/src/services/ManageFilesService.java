package services;

import constants.Messages;
import domain.Dir;
import domain.FileDocument;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
            System.err.println(e.getMessage());
        }
    }

    private void updateFile(String name, File path, String content){
        File file = new File(path,name);
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(file,true));
            writer.println(content);
            writer.close();
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
    public List<Dir> showDir(){
        File file = new File(Messages.PATH);
        String [] list =file.list();
        List<Dir> dirList = new ArrayList<>();
        try {
            for (int i = 0; i<list.length;i++){
                Dir prueba = new Dir((i+1),list[i]);
                dirList.add(prueba);
            }
        }catch (NullPointerException e){
            System.err.println("");
        }
        return dirList;
    }

    public List<FileDocument> showFile(String s){
        File file = new File(Messages.PATH + s);
        String [] list =file.list();
        List<FileDocument> fileList = new ArrayList<>();
        try {
            for (int i = 0; i<list.length;i++){
                FileDocument  fileDocument= new FileDocument((i+1),list[i]);
                fileList.add(fileDocument);
            }
        }catch (NullPointerException e){
            System.err.println("");
        }
        return fileList;
    }
    public void openFile(String dateDir, String nameFile){
        try {
            InputStream ins = new FileInputStream(Messages.PATH+dateDir+"/"+nameFile);
            Scanner scanner = new Scanner(ins);
            while (scanner.hasNextLine())
                System.out.println(scanner.nextLine());
            ins.close();
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
