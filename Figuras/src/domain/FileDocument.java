package domain;

public class FileDocument {
    private int option;
    private String name;

    public FileDocument(int option, String name) {
        this.option = option;
        this.name = name;
    }
    public int getOption() {
        return option;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FileDocument{");
        sb.append("option=").append(option);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
    public String getName() {
        return name;
    }
}
