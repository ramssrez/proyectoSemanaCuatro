package services;

import constants.Messages;
import constants.MessagesError;
import constants.ValidateInputs;
import domain.Dir;
import enums.TypeFiguresEnum;
import exepctions.ExeptionAplication;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

public class FileReaderService {
    public void openFiles() throws ExeptionAplication {
        ValidateInputs validateInputs = new  ValidateInputs();
        StringBuilder builder = new StringBuilder("Directorios de la carpeta calculos");
        ManageFilesService filesService = new ManageFilesService();
        List<Dir> listDir = filesService.showDir();
        if (listDir.isEmpty()) throw new  ExeptionAplication(MessagesError.MESSAGE_EMPTY_DIR);
        for (Dir dir: listDir) {
            builder.append(String.format(Messages.FORMAT_OPTIONS,dir.getOption(),dir.getName()));
            System.out.println("Opcion " + dir.getOption() + "Nombre: " + dir.getName());
        }
        System.out.println(builder.toString());
        int option = validateInputs.inputInteger();

    }
    public TypeFiguresEnum getDir(int option){
        return Stream.of(this.typeFiguresEnums)
                .filter(f->f.getOption() == option)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }
}
