package services;

public class ThreadService implements Runnable{
    private String name;
    private ManageFilesService manageFilesService;

    public ThreadService(String name) {
        this.manageFilesService = new ManageFilesService();
        this.name = name;
    }

    @Override
    public void run() {
        manageFilesService.creteDir(this.name);
    }
}
