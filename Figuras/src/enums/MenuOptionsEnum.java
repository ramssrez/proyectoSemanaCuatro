package enums;

import constants.Messages;

public enum MenuOptionsEnum {
    REGISTRAR(1,Messages.REGISTER_FIGURE),
    ABRIR(2,Messages.OPEN_FILE),
    SALIR(3,Messages.GO_OUT);
    private final Integer option;
    private final String name;

    MenuOptionsEnum(Integer option, String name) {
        this.option = option;
        this.name = name;
    }

    public Integer getOption() {
        return option;
    }

    public String getName() {
        return name;
    }
}
