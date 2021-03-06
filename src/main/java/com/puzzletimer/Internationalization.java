package com.puzzletimer;

import java.util.ResourceBundle;

public class Internationalization {
    private static final ResourceBundle resourceBundle;

    static {
        resourceBundle = ResourceBundle.getBundle("i18n.messages");
    }

    public static String __(String key) {
        if (resourceBundle.containsKey(key)) {
            return resourceBundle.getString(key);
        }

        return "*** " + key + " ***";
    }
}
