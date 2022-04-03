package services;

public class ThreadFileService implements Runnable{
    private String dateDir;
    private String nameFile;
    private ManageFilesService manageFilesService;


    public ThreadFileService(String dateDir, String nameFile) {
        this.manageFilesService = new ManageFilesService();
        this.dateDir = dateDir;
        this.nameFile = nameFile;
    }

    @Override
    public void run() {
        manageFilesService.openFile(this.dateDir,this.nameFile);
    }
}
