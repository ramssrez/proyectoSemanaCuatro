package services;

import constants.Messages;
import constants.MessagesError;
import constants.ValidateInputs;
import domain.Dir;
import exepctions.ExeptionAplication;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class FileReaderService {
    private Dir dir;
    private List<Dir> listDir = new ArrayList<>();
    private ValidateInputs validateInputs;
    private StringBuilder stringBuilder;
    private ManageFilesService filesService;

    public FileReaderService() throws ExeptionAplication {
        this.validateInputs = new ValidateInputs();
        this.filesService = new ManageFilesService();
        listDir = filesService.showDir();
        if (listDir.isEmpty()) throw new  ExeptionAplication(MessagesError.MESSAGE_EMPTY_DIR);
    }

    public void openFiles() {
        printList();
        if (!listDir.isEmpty()){
            int opcion = 0;
            try {
                opcion = validateInputs.inputInteger(Messages.OPTION);
                this.dir = getDir(opcion);
            } catch (ExeptionAplication e) {
                System.err.println(e.getMessage());;
            }
            System.out.println(dir.getOption() + " " + dir.getName());
        }
    }

    public void printList()  {
        this.stringBuilder = new StringBuilder("Directorios de la carpeta calculos");
        for (Dir dir: listDir) {
            this.stringBuilder.append(String.format(Messages.FORMAT_OPTIONS,dir.getOption(),dir.getName()));
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
}
