package services;

public class ThreadService implements Runnable{
    private String name;
    private String datesFigure;
    private ManageFilesService manageFilesService;

    public ThreadService(String datesFigure, String name) {
        this.manageFilesService = new ManageFilesService();
        this.name = name;
        this.datesFigure = datesFigure;
    }

    @Override
    public void run() {
        manageFilesService.creteDir(this.datesFigure,this.name);
    }
}
