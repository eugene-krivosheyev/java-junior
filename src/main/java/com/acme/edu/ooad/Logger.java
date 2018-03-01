package com.acme.edu.ooad;

public class Logger {
    private Filter filter = new MessageFilter();
    private CommonBehaviorSaver saver = new ConsoleSaver();

    public void log(Message message) {
        switch (message.getPrexidCode()) {
            case PrefixCode.PRIMITIVE_PRFIX: "gfgfg"
        }

        PrefixCode.PRIMITIVE_PRFIX.getOrdinal()

        if (filter.filter(message)) {
            saver.save(
                    message.getPrefix() + message.getText()
            );
            System.out.println(Color.RED);
        }

        Color.BLUE.ordinal()
    }
}

final class PrefixCode {
    public static final PrefixCode PRIMITIVE_PRFIX = new PrefixCode(1);
    public static final PrefixCode STR_PRF = new PrefixCode(2);

    private int ordinal;

    private PrefixCode(int ordinal) {
        this.ordinal = ordinal;
    }

    public int getOrdinal() {
        return ordinal;
    }

    PrefixCode[] values() {
        return null;
    }
}

enum Color {
    RED("superman"), GREEN("fonar"), BLUE("america");

    private String nickname;
    Color(String name) {
        this.nickname = name;
    }
}