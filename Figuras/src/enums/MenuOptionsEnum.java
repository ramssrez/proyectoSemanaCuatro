package enums;

import constants.Messages;

public enum MenuOptionsEnum {
    REGISTER(1,Messages.REGISTER_FIGURE),
    OPEN(2,Messages.OPEN_FILE),
    GOOUT(3,Messages.GO_OUT);

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
