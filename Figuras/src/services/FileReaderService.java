package services;

import constants.Messages;
import constants.MessagesError;
import constants.ValidateInputs;
import domain.Dir;
import domain.FileDocument;
import exepctions.ExeptionAplication;
import java.util.List;
import java.util.NoSuchElementException;

public class FileReaderService {
    private Dir dir;
    private List<Dir> listDir;
    private ValidateInputs validateInputs;
    private StringBuilder stringBuilder;
    private ManageFilesService filesService;

    public FileReaderService() throws ExeptionAplication {
        this.validateInputs = new ValidateInputs();
        this.filesService = new ManageFilesService();
        listDir = filesService.showDir();
        if (listDir.isEmpty()) throw new  ExeptionAplication(MessagesError.MESSAGE_EMPTY_DIR);
    }

    public void openDirs() {
        printList();
        if (!listDir.isEmpty()){
            try {
                int opcion = validateInputs.inputInteger(Messages.OPTION);
                openFiles(opcion);
            } catch (ExeptionAplication e) {
                System.err.println(e.getMessage());;
            }
        }
    }

    public void openFiles(int opcion) throws ExeptionAplication {
        this.dir = getDir(opcion);
        List<FileDocument> list = filesService.showFile(dir.getName());
        if (list.isEmpty()) throw new ExeptionAplication(MessagesError.MESSAGE_EMPTY_FILES);
        if (!list.isEmpty()){
            printListFile(list);
            try {
                int opcionFile = validateInputs.inputInteger(Messages.OPTION);
                FileDocument fileDocument = getDir(opcionFile,list);
                Thread thread = new Thread(new ThreadFileService(dir.getName(),fileDocument.getName()));
                thread.start();
            }catch (ExeptionAplication e) {
                System.err.println(e.getMessage());;
            }
        }
    }

    public void printList() {
        this.stringBuilder = new StringBuilder(Messages.OPTION_DIR);
        for (Dir dir: listDir) {
            this.stringBuilder.append(String.format(Messages.FORMAT_OPTIONS,dir.getOption(),dir.getName()));
        }
        System.out.println(stringBuilder.toString());
    }

    public void printListFile(List <FileDocument> list) {
        this.stringBuilder = new StringBuilder(Messages.OPTION_DIR);
        for (FileDocument fileDocument: list) {
            this.stringBuilder.append(String.format(Messages.FORMAT_OPTIONS,fileDocument.getOption(),fileDocument.getName()));
        }
        System.out.println(stringBuilder.toString());
    }

    public Dir getDir(int option){
        return listDir
                .stream()
                .filter(f-> f.getOption() == option)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }
    public FileDocument getDir(int option, List<FileDocument> list){
        return list
                .stream()
                .filter(f-> f.getOption() == option)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }
}
