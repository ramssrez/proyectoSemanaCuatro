package domain;

public class Dir {
    private int option;
    private String name;

    public Dir(int option, String name) {
        this.option = option;
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Prueba{");
        sb.append("option=").append(option);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public int getOption() {
        return option;
    }

    public String getName() {
        return name;
    }
}
