package enums;

public class Prueba {
    private Integer option;
    private String name;

    public Prueba(Integer option, String name) {
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
}
